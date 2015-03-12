package manager.ADV01.logic.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import manager.ADV01.bean.AdsBean;
import manager.ADV01.dao.ADV01Dao;
import manager.ADV01.logic.ADV01LogicIF;
import manager.common.bean.ConstantBean;
import manager.common.bean.UserBean;

@Service
public class ADV01LogicImpl implements ADV01LogicIF{
	@Autowired
	private ADV01Dao adv01Dao;
	
	@Autowired
	private StringRedisTemplate template;
	
	@Override
	public List<AdsBean> listAds(UserBean user) {
		return adv01Dao.listAds(user.getId());
	}
	
	@Override
	public AdsBean getAdsById(String appId) {
		return adv01Dao.getAdsById(appId);
	}
	
	@Override
	public Map<Integer, String> getAllOs() {
		return adv01Dao.getAllOs();
	}
	
	@Override
	public Map<Integer, String> getAllStatus() {
		return adv01Dao.getAllStatus();
	}
	
	@Override
	public Map<Integer, String> getAllAdNetwork() {
		return adv01Dao.getAllAdNetwork();
	}
	
	@Override
	public void updateAds(AdsBean adsBean) {
		adv01Dao.updateAds(adsBean);
	}
	
	@Override
	public void delAdsPubApp(String appId) {
		adv01Dao.delAdsPubApp(appId);
	}
	
	@Override
	public void insertAdsApp(AdsBean adsBean, UserBean user) {
		adv01Dao.insertAdsApp(adsBean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getId());
		map.put("appId", adsBean.getId());
		adv01Dao.insertAdsPublisherApp(map);
		adv01Dao.insertAdsAppMoreInfo(adsBean);
		adv01Dao.insertAdsAppNetwork(adsBean);
	}
	
	@Override
	public List<AdsBean> listAdsFromRedis() throws IOException{
		List<AdsBean> listAds = new ArrayList<AdsBean>();
		Set<String> setId = template.opsForZSet().range(ConstantBean.DB_ADS_APPS, 0, -1);
		for (String id : setId) {
			AdsBean adsAndroid = getAdsBeanWithOS(id, "android");
			adsAndroid.setOs("Android");
			adsAndroid.setOsId(1);
			listAds.add(adsAndroid);
			AdsBean adsIos = getAdsBeanWithOS(id, "ios");
			adsIos.setOs("IOS");
			adsIos.setOsId(2);
			listAds.add(adsIos);
			AdsBean adsWindows = getAdsBeanWithOS(id, "windows");
			adsWindows.setOs("WinPhone");
			adsWindows.setOsId(3);
			listAds.add(adsWindows);
		}
		return listAds;
	}
	
	public AdsBean getAdsBeanWithOS(String id, String os) throws IOException {
		String redisInfo = ConstantBean.DB_ADS_APPS + ":" + id;
	
		AdsBean ads = new AdsBean();
		ObjectMapper mapper = new ObjectMapper();
		
		ads.setId(template.opsForHash().get(redisInfo, "appID").toString());
		ads.setName(template.opsForHash().get(redisInfo, "appName").toString());
		ads.setDescription(template.opsForHash().get(redisInfo, "appDescription").toString());
		ads.setUrl(template.opsForHash().get(redisInfo, os+"_URL").toString());
		
		String redisInfoConfig = redisInfo + ":config";
		String json = template.opsForHash().get(redisInfoConfig, os).toString();
		JsonNode node = mapper.readTree(json);
		ads.setMessage(node.get("update").get("message").asText());
		ads.setPage(node.get("fb").get("page").asText());
		ads.setAdsAdnetworkId(node.get("admodID_banner").asText());
		ads.setAdsAdnetworkIdBk(node.get("admodID_popup").asText());
		return ads;
	}
}
