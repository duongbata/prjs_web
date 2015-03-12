package app.bean;

import org.codehaus.jackson.annotate.JsonIgnore;

public class OSConfigBean {
	private String admodIdBanner;
	
	private String admodIdPopup;
	
	private String uid;
	
	private String osId;
	
	public OSConfigBean() {
		// TODO Auto-generated constructor stub
	}
	
	public OSConfigBean(String admodIdBanner, String admodIdPopup, String uid,
			String osId) {
		this.admodIdBanner = admodIdBanner;
		this.admodIdPopup = admodIdPopup;
		this.uid = uid;
		this.osId = osId;
	}



	public String getAdmodIdBanner() {
		return admodIdBanner;
	}

	public void setAdmodIdBanner(String admodIdBanner) {
		this.admodIdBanner = admodIdBanner;
	}

	public String getAdmodIdPopup() {
		return admodIdPopup;
	}

	public void setAdmodIdPopup(String admodIdPopup) {
		this.admodIdPopup = admodIdPopup;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@JsonIgnore
	public String getOsId() {
		return osId;
	}

	public void setOsId(String osId) {
		this.osId = osId;
	}
}
