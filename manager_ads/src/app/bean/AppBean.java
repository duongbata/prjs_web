package app.bean;

import java.util.List;

public class AppBean {
	private String appId;
	
	private String url;
	
	private String version;
	
	private String groupId;
	
	private String osId;
	
	private String config;
	
	private String uid;
	
	private List<PropertyAppBean> listProperty;
	
//	private AppConfigBean appConfig;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOsId() {
		return osId;
	}
	
	public void setOsId(String osId) {
		this.osId = osId;
	}
	
	public String getGroupId() {
		return groupId;
	}
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<PropertyAppBean> getListProperty() {
		return listProperty;
	}

	public void setListProperty(List<PropertyAppBean> listProperty) {
		this.listProperty = listProperty;
	}
	
	/*public AppConfigBean getAppConfig() {
		return appConfig;
	}
	
	public void setAppConfig(AppConfigBean appConfig) {
		this.appConfig = appConfig;
	}*/
}
