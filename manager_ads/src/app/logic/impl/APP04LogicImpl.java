package app.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import manager.common.bean.RedisConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import app.bean.PropertyAppBean;
import app.logic.APP04LogicIF;

@Service
public class APP04LogicImpl implements APP04LogicIF{
	@Autowired
	private StringRedisTemplate template;
	
	@Override
	public void insertAdmobConfig(List<PropertyAppBean> listProp) {
		String query = RedisConstant.DB_ADS_ADMOB;
		//Delete key not exist
		Set<Object> keys = template.opsForHash().keys(query);
		if (keys != null && keys.size() > 0) {
			for (Object key : keys) {
				boolean isExist = false;
				for (PropertyAppBean prop : listProp) {
					if (prop.getPropertyName().equals(key.toString())) {
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					template.opsForHash().delete(query, key);
				}
			}
		}
		//Update
		if (listProp != null && listProp.size() > 0) {
			for (PropertyAppBean prop : listProp) {
				template.opsForHash().put(query, prop.getPropertyName(), prop.getPropertyValue());
			}
		}
	}
	
	@Override
	public List<PropertyAppBean> getListPropConfig() {
		List<PropertyAppBean> listProp = new ArrayList<PropertyAppBean>();
		String query = RedisConstant.DB_ADS_ADMOB;
		Set<Object> keys = template.opsForHash().keys(query);
		if (keys != null && keys.size() > 0) {
			for(Object key : keys) {
				Object value = template.opsForHash().get(query, key.toString());
				PropertyAppBean prop = new PropertyAppBean(key.toString(), value.toString());
				listProp.add(prop);
			}
		}
		return listProp;
	}
	
	@Override
	public String validateProp(List<PropertyAppBean> listProp) {
		int i = 0;
		for (PropertyAppBean prop : listProp) {
			if (prop == null || prop.getPropertyName() == null || "".equals(prop.getPropertyName().trim())) {
				return "Hãy điền Name ở dòng " + (i+1);
			}
			i++;
		}
		return null;
	}
}
