package app.bean;

import java.util.List;

public class AppConfigBean {
	private String nameConfig;
	
	private List<FieldBean> listFieldBean;
	
	private List<AppConfigBean> listConfigBean;
	
//	private String parentName;

	public List<FieldBean> getListFieldBean() {
		return listFieldBean;
	}

	public void setListFieldBean(List<FieldBean> listFieldBean) {
		this.listFieldBean = listFieldBean;
	}

	public List<AppConfigBean> getListConfigBean() {
		return listConfigBean;
	}
	
	public void setListConfigBean(List<AppConfigBean> listConfigBean) {
		this.listConfigBean = listConfigBean;
	}

	public String getNameConfig() {
		return nameConfig;
	}

	public void setNameConfig(String nameConfig) {
		this.nameConfig = nameConfig;
	}
/*
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}*/
}
