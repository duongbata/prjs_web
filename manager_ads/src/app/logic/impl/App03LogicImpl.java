package app.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import manager.common.bean.RedisConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import app.bean.AppBean;
import app.bean.PropertyAppBean;
import app.logic.App03LogicIF;

@Service
public class App03LogicImpl implements App03LogicIF{
	@Autowired
	private StringRedisTemplate template;
	
	@Override
	public List<AppBean> getListAppOfUser(String userId) {
		List<AppBean> listApps = new ArrayList<AppBean>();
		
		List<String> listOs = new ArrayList<String>();
		listOs.add("android");
		listOs.add("ios");
		listOs.add("windows");
		for (String os : listOs) {
			String queryGroups = RedisConstant.DB_ADS_DEV + ":uid:" + userId + ":os:"+os+":groups";
			Set<String> setGroup = template.opsForSet().members(queryGroups);
			if (setGroup != null && setGroup.size() > 0) {
				for (String groupId : setGroup) {
					String queryApps = RedisConstant.DB_ADS_DEV + ":uid:" + userId + ":group:" + groupId + ":apps";
					Set<String> setApp = template.opsForSet().members(queryApps);
					for (String appId : setApp) {
						AppBean appBean = new AppBean();
						List<PropertyAppBean> listPropertyApp = new ArrayList<PropertyAppBean>();
						String queryDetailApp = RedisConstant.DB_ADS_DEV + ":uid:" +userId + ":group:"+groupId + ":app:"+appId;
						Set<Object> keys = template.opsForHash().keys(queryDetailApp);
						for (Object key : keys) {
							String strKey = key.toString();
							Object value = template.opsForHash().get(queryDetailApp, key.toString());
							String strValue = value.toString();
							if ("appId".equals(strKey)) {
								appBean.setAppId(strValue);
							} else if ("osId".equals(strKey)) {
								appBean.setOsId(strValue);
							} else if ("config".equals(strKey)) {
								appBean.setConfig(strValue);
							} else if ("version".equals(strKey)) {
								appBean.setVersion(strValue);
							} else if ("url".equals(strKey)) {
								appBean.setUrl(strValue);
							} else {
								PropertyAppBean propertyApp = new PropertyAppBean();
								propertyApp.setPropertyName(strKey);
								propertyApp.setPropertyValue(strValue);
								listPropertyApp.add(propertyApp);
							}
						}
						appBean.setListProperty(listPropertyApp);
						appBean.setGroupId(groupId);
						if(os.equals(appBean.getOsId())) {
							listApps.add(appBean);
						}
						
					}
				}
			}
			
		}
		
		return listApps;
	}
	
	@Override
	public boolean updateApp(AppBean appUpdate,String userId) {
		String queryDetail = RedisConstant.DB_ADS_DEV + ":uid:"+userId + ":group:"+appUpdate.getGroupId() + ":app:"+appUpdate.getAppId();
		if (!template.hasKey(queryDetail)) {
			return false;
		}
		try {
			template.opsForHash().put(queryDetail, "url", appUpdate.getUrl());
			template.opsForHash().put(queryDetail, "version", appUpdate.getVersion());
			template.opsForHash().put(queryDetail, "config", appUpdate.getConfig());
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
