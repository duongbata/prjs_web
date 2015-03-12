package manager.ADV02.bean;

import java.util.List;

public class AdsAdnetworkBean {
	private String adnetworkName;
	
	private List<GroupAdsBean> listAdsBanner;
	
	private List<GroupAdsBean> listAdsPopup;
	
	private List<GroupAdsBean> listAdsOpen;
	
	private List<GroupAdsBean> listAdsExit;
	
	private String perForAdmob;
	
	public AdsAdnetworkBean() {
	}
	
	public AdsAdnetworkBean(String adnetworkName) {
		this.adnetworkName = adnetworkName;
	}

	public String getAdnetworkName() {
		return adnetworkName;
	}
	
	public void setAdnetworkName(String adnetworkName) {
		this.adnetworkName = adnetworkName;
	}

	public List<GroupAdsBean> getListAdsBanner() {
		return listAdsBanner;
	}

	public void setListAdsBanner(List<GroupAdsBean> listAdsBanner) {
		this.listAdsBanner = listAdsBanner;
	}

	public List<GroupAdsBean> getListAdsPopup() {
		return listAdsPopup;
	}

	public void setListAdsPopup(List<GroupAdsBean> listAdsPopup) {
		this.listAdsPopup = listAdsPopup;
	}

	public List<GroupAdsBean> getListAdsOpen() {
		return listAdsOpen;
	}

	public void setListAdsOpen(List<GroupAdsBean> listAdsOpen) {
		this.listAdsOpen = listAdsOpen;
	}

	public List<GroupAdsBean> getListAdsExit() {
		return listAdsExit;
	}

	public void setListAdsExit(List<GroupAdsBean> listAdsExit) {
		this.listAdsExit = listAdsExit;
	}

	public String getPerForAdmob() {
		return perForAdmob;
	}

	public void setPerForAdmob(String perForAdmob) {
		this.perForAdmob = perForAdmob;
	}
}
