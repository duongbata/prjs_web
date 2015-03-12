package manager.ADV02.logic.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import manager.ADV02.bean.AdsAdnetworkBean;
import manager.ADV02.bean.GroupAdsBean;
import manager.ADV02.logic.ADV02LogicIF;
import manager.common.bean.ConstantBean;

@Service
public class ADV02LogicImpl implements ADV02LogicIF{
	@Autowired
	private StringRedisTemplate template;
	
	/*
	 * Read ads from redis 
	 */
	@Override
	public List<AdsAdnetworkBean> listAdnetworkBeans() {
		List<AdsAdnetworkBean> listAdnet = new ArrayList<AdsAdnetworkBean>();
		//Admob
		AdsAdnetworkBean admob = new AdsAdnetworkBean(ConstantBean.ADMOB);
		String perAdmob = template.opsForValue().get(ConstantBean.DB_ADS_ADMOB);
		admob.setPerForAdmob(perAdmob);
		listAdnet.add(admob);
		//5play
		AdsAdnetworkBean _5play = new AdsAdnetworkBean(ConstantBean._5PLAY);
		List<GroupAdsBean> listAdsBanner = new ArrayList<GroupAdsBean>();
		List<GroupAdsBean> listAdsPopup = new ArrayList<GroupAdsBean>();
		List<GroupAdsBean> listAdsOpen = new ArrayList<GroupAdsBean>();
		List<GroupAdsBean> listAdsExit = new ArrayList<GroupAdsBean>();
		Set<String> setAppId = template.opsForZSet().range(ConstantBean.DB_ADS_5PLAY, 0, -1);
		for (String id : setAppId) {
			getForLocation(listAdsBanner, ConstantBean.BANNER, id);
			getForLocation(listAdsPopup, ConstantBean.POPUP, id);
			getForLocation(listAdsOpen, ConstantBean.APP_OPEN, id);
			getForLocation(listAdsExit, ConstantBean.APP_EXIT, id);
		}
		_5play.setListAdsBanner(listAdsBanner);
		_5play.setListAdsPopup(listAdsPopup);
		_5play.setListAdsOpen(listAdsOpen);
		_5play.setListAdsExit(listAdsExit);
		listAdnet.add(_5play);
		/*AdsAdnetworkBean ctv = new AdsAdnetworkBean("ctv");
		ctv.setListAdsBanner(listAdsBanner);
		ctv.setListAdsPopup(listAdsPopup);
		ctv.setListAdsOpen(listAdsOpen);
		ctv.setListAdsExit(listAdsExit);
		listAdnet.add(ctv);*/
		return listAdnet;
	}
	
	public String getPerAds(String location, String os, String id) {
		String query = ConstantBean.DB_ADS_5PLAY_EVENT+ ":" + location + ":"+os;
		boolean hasKey = template.opsForHash().hasKey(query, id);
		if (!hasKey) {
			return "";
		}
		String per = (String) template.opsForHash().get(query, id);
		if (per == null) {
			per = "";
		}
		return per;
	}
	
	public void getForLocation(List<GroupAdsBean> listAdsLocation, String location, String id) {
		String perAndroid = getPerAds(location, ConstantBean.ANDROID, id);
		String perIos = getPerAds(location, ConstantBean.IOS, id);
		String perWindow = getPerAds(location, ConstantBean.WINDOWS, id);
		if (!"".equals(perAndroid) || !"".equals(perIos) || !"".equals(perWindow)) {
			GroupAdsBean groupAds = new GroupAdsBean();
			groupAds.setId(id);
			String urlImg = (String) template.opsForHash().get(ConstantBean.DB_ADS_APPS+":"+id, "appIcon");
			groupAds.setUrlImage(urlImg);
			groupAds.setPerAndroid(perAndroid);
			groupAds.setPerIos(perIos);
			groupAds.setPerWindow(perWindow);
			listAdsLocation.add(groupAds);
		}
	}
	
	/*
	 * list app for popup 
	 */
	@Override
	public List<GroupAdsBean> listGroupAds() {
		List<GroupAdsBean> listGroupAds = new ArrayList<GroupAdsBean>();
		Set<String> setId = template.opsForZSet().range(ConstantBean.DB_ADS_APPS, 0, -1);
		for (String id : setId) {
			String redisInfo = ConstantBean.DB_ADS_APPS + ":" + id;
			GroupAdsBean groupAds = new GroupAdsBean();
			groupAds.setId(template.opsForHash().get(redisInfo, "appID").toString());
			groupAds.setName(template.opsForHash().get(redisInfo, "appName").toString());
			groupAds.setUrlImage(template.opsForHash().get(redisInfo, "appIcon").toString());
			listGroupAds.add(groupAds);
		}
		return listGroupAds;
	}
	
	/*
	 * validate ads receive
	 */
	@Override
	public String validateListAdnetwork(List<AdsAdnetworkBean> listAdnetwork) {
		for (AdsAdnetworkBean adnetwork : listAdnetwork) {
			String adnetName = adnetwork.getAdnetworkName();
			if("admob".equals(adnetName)){
				String perForAdmob = adnetwork.getPerForAdmob();
				double perAdmob = -1;
				try {  
					perAdmob = Double.parseDouble(perForAdmob);  
				}  
				  catch(NumberFormatException nfe){  
				    return "Tỷ lệ của admob phải là số";  
				}  
				if (perAdmob < 0) {
					return "Tỷ lệ của admob không được nhỏ hơn 0";
				}
				
				if (perAdmob >100) {
					return "Tỷ lệ của admob không được lớn hơn 100";
				}
			} else {
				List<GroupAdsBean> listBanner = adnetwork.getListAdsBanner();
				String msgBanner = validateListAdsFromLocation(listBanner, "Banner", adnetName);
				if (msgBanner != null) {
					return msgBanner;
				}
				List<GroupAdsBean> listPopup = adnetwork.getListAdsPopup();
				String msgPopup = validateListAdsFromLocation(listPopup, "Popup", adnetName);
				if (msgPopup != null) {
					return msgPopup;
				}
				List<GroupAdsBean> listOpen = adnetwork.getListAdsOpen();
				String msgOpen = validateListAdsFromLocation(listOpen, "AppOpen", adnetName);
				if (msgOpen != null) {
					return msgOpen;
				}
				List<GroupAdsBean> listExit = adnetwork.getListAdsExit();
				String msgExit = validateListAdsFromLocation(listExit, "AppExit", adnetName);
				if (msgExit != null) {
					return msgExit;
				}
			}
		}
		return null;
	}
	
	private String validateListAdsFromLocation(List<GroupAdsBean> listGroup, String location, String adnetName) {
		if (listGroup == null || listGroup.size() == 0) {
			return null;
		}
		double perSumAnd = 0;
		double perSumIos = 0;
		double perSumWin = 0;
		Set<String> setAdsId = new HashSet<String>();
		for (GroupAdsBean groupAdsBean : listGroup) {
			String id = groupAdsBean.getId();
			if(setAdsId.contains(id)) {
				return adnetName + ":"+location + ":"+ id + " bị trùng";
			} else {
				setAdsId.add(id);
			}
			String strAnd = groupAdsBean.getPerAndroid();
			double perAnd = converToDouble(strAnd);
			if (perAnd == -1) {
				return adnetName + ":" +location +":"+id+ ": tỷ lệ Android chưa đúng";
			}
			perSumAnd +=perAnd;
			
			String strIos = groupAdsBean.getPerIos();
			double perIos = converToDouble(strIos);
			if (perIos == -1) {
				return adnetName + ":" +location + ":"+id+ ": tỷ lệ Ios chưa đúng";
			}
			perSumIos += perIos;
			
			String strWin = groupAdsBean.getPerWindow();
			double perWin = converToDouble(strWin);
			if (perWin == -1) {
				return adnetName + ":" + location + ":"+id+ ": tỷ lệ Window phone chưa đúng";
			}
			perSumWin +=perWin;
		}
		if (perSumAnd != 100) {
			return adnetName + ":" + location +": tổng tỷ lệ của android không đúng";
		}
		if (perSumIos != 100) {
			return adnetName + ":" + location +": tổng tỷ lệ của Ios không đúng"; 
		}
		if (perSumWin != 100) {
			return adnetName + ":" + location +": tổng tỷ lệ của Window phone không đúng";
		}
		return null;
		
	}
	
	private double converToDouble(String strPer) {
		if (strPer == null || "".equals(strPer)) {
			return 0;
		}
		double per = -1;
		try {
			per = Double.parseDouble(strPer);
		} catch (NumberFormatException ex) {
			return -1;
		}
		if (per < 0) {
			return -1;
		}
		return per;
		
	}
	
	/*
	 * Save to redis
	 */
	@Override
	public boolean saveListAdnetworkToRedis(List<AdsAdnetworkBean> listAdnetwork) {
		//Delete all data old
		deleteAllPer();
		template.opsForZSet().removeRange(ConstantBean.DB_ADS_5PLAY, 0, -1);
		//Set of group_appId is saved
		Set<String> setAppId = new HashSet<String>();
		for (AdsAdnetworkBean adnetwork : listAdnetwork) {
			if (ConstantBean.ADMOB.equals(adnetwork.getAdnetworkName())) {
				template.opsForValue().set(ConstantBean.DB_ADS_ADMOB, adnetwork.getPerForAdmob());
			} else {
				//Banner
				List<GroupAdsBean> listBanner = adnetwork.getListAdsBanner();
				if (listBanner != null) {
					for (GroupAdsBean groupAdsBean : listBanner) {
						if (!setAppId.contains(groupAdsBean.getId())) {
							setAppId.add(groupAdsBean.getId());
						}
						savePerForGroupAdsBean(groupAdsBean, ConstantBean.BANNER);
					}
				}
				
				//Popup
				List<GroupAdsBean> listPopup = adnetwork.getListAdsPopup();
				if (listPopup != null) {
					for (GroupAdsBean groupAdsBean : listPopup) {
						if (!setAppId.contains(groupAdsBean.getId())) {
							setAppId.add(groupAdsBean.getId());
						}
						savePerForGroupAdsBean(groupAdsBean, ConstantBean.POPUP);
					}
				}
				
				//App Open
				List<GroupAdsBean> listOpen = adnetwork.getListAdsOpen();
				if (listOpen != null) {
					for (GroupAdsBean groupAdsBean : listOpen) {
						if (!setAppId.contains(groupAdsBean.getId())) {
							setAppId.add(groupAdsBean.getId());
						}
						savePerForGroupAdsBean(groupAdsBean, ConstantBean.APP_OPEN);
					}
				}
				
				//AppExit
				List<GroupAdsBean> listExit = adnetwork.getListAdsExit();
				if (listExit != null) {
					for (GroupAdsBean groupAdsBean : listExit) {
						if (!setAppId.contains(groupAdsBean.getId())) {
							setAppId.add(groupAdsBean.getId());
						}
						savePerForGroupAdsBean(groupAdsBean, ConstantBean.APP_EXIT);
					}
				}
				
				//re-insert db:ads:5play
				double idx = 1;
				for(String newId : setAppId) {
					template.opsForZSet().add(ConstantBean.DB_ADS_5PLAY, newId, idx);
					idx++;
				}
			}
		}
		return true;
	}
	
	private void deleteAllPer() {
		deleteAllPerByLocationAndOs(ConstantBean.BANNER, ConstantBean.ANDROID);
		deleteAllPerByLocationAndOs(ConstantBean.POPUP, ConstantBean.ANDROID);
		deleteAllPerByLocationAndOs(ConstantBean.APP_OPEN, ConstantBean.ANDROID);
		deleteAllPerByLocationAndOs(ConstantBean.APP_EXIT, ConstantBean.ANDROID);
		deleteAllPerByLocationAndOs(ConstantBean.BANNER, ConstantBean.IOS);
		deleteAllPerByLocationAndOs(ConstantBean.POPUP, ConstantBean.IOS);
		deleteAllPerByLocationAndOs(ConstantBean.APP_OPEN, ConstantBean.IOS);
		deleteAllPerByLocationAndOs(ConstantBean.APP_EXIT, ConstantBean.IOS);
		deleteAllPerByLocationAndOs(ConstantBean.BANNER, ConstantBean.WINDOWS);
		deleteAllPerByLocationAndOs(ConstantBean.POPUP, ConstantBean.WINDOWS);
		deleteAllPerByLocationAndOs(ConstantBean.APP_OPEN, ConstantBean.WINDOWS);
		deleteAllPerByLocationAndOs(ConstantBean.APP_EXIT, ConstantBean.WINDOWS);
	}
	
	private void deleteAllPerByLocationAndOs(String location, String os) {
		String query = ConstantBean.DB_ADS_5PLAY_EVENT + ":" +location + ":" +os;
		template.delete(query);
	} 
	
	private void savePerForGroupAdsBean(GroupAdsBean groupAds, String location) {
		savePerForLocationAndOs(groupAds.getId(), groupAds.getPerAndroid(), location, ConstantBean.ANDROID);
		savePerForLocationAndOs(groupAds.getId(), groupAds.getPerIos(), location, ConstantBean.IOS);
		savePerForLocationAndOs(groupAds.getId(), groupAds.getPerWindow(), location, ConstantBean.WINDOWS);
	}
	
	private void savePerForLocationAndOs(String id,String per, String location, String os){
		String query = ConstantBean.DB_ADS_5PLAY_EVENT + ":"+location + ":" + os;
		template.opsForHash().put(query, id, per);
	}
}
