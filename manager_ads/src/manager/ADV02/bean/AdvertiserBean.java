package manager.ADV02.bean;

public class AdvertiserBean {
	private String adnetworkName;
	
	/*private List<GroupAdsBean> listAdsBanner;
	
	private List<GroupAdsBean> listAdsPopup;
	
	private List<GroupAdsBean> listAdsOpen;
	
	private List<GroupAdsBean> listAdsExit;*/
	
	public String getAdnetworkName() {
		return adnetworkName;
	}

	public void setAdnetworkName(String adnetworkName) {
		this.adnetworkName = adnetworkName;
	}

	public String getPerForAdmob() {
		return perForAdmob;
	}

	public void setPerForAdmob(String perForAdmob) {
		this.perForAdmob = perForAdmob;
	}

	private String perForAdmob;
}
