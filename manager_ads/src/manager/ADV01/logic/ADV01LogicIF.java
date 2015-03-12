package manager.ADV01.logic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import manager.ADV01.bean.AdsBean;
import manager.common.bean.UserBean;

public interface ADV01LogicIF {
	List<AdsBean> listAds(UserBean user);
	
	AdsBean getAdsById(String appId);
	
	Map<Integer, String> getAllOs();
	
	Map<Integer, String> getAllStatus();
	
	Map<Integer, String> getAllAdNetwork();
	
	void updateAds(AdsBean adsBean);
	
	void delAdsPubApp(String appId);
	
	void insertAdsApp(AdsBean adsBean, UserBean user);
	
	List<AdsBean> listAdsFromRedis()throws IOException;
}
