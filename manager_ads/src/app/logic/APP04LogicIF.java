package app.logic;

import java.util.List;

import app.bean.PropertyAppBean;

public interface APP04LogicIF {
	void insertAdmobConfig(List<PropertyAppBean> listProp);
	
	List<PropertyAppBean> getListPropConfig();
	
	String validateProp(List<PropertyAppBean> listProp);
}
