package manager.ADV02.logic;

import java.util.List;

import manager.ADV01.bean.AdsBean;
import manager.ADV02.bean.AdsAdnetworkBean;
import manager.ADV02.bean.GroupAdsBean;

public interface ADV02LogicIF {
	List<AdsAdnetworkBean> listAdnetworkBeans();
	
	List<GroupAdsBean> listGroupAds();
	
	String validateListAdnetwork(List<AdsAdnetworkBean> listAdnetwork);
	
	boolean saveListAdnetworkToRedis(List<AdsAdnetworkBean> listAdnetwork);
}
