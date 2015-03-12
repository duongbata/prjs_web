package app.bean;

import manager.common.bean.BaseInfoValue;
import manager.common.bean.InfoValue;
import manager.common.bean.InfoValueIF;

public class APP01Infovalue extends BaseInfoValue implements InfoValueIF{
	private String name;
	
	public APP01Infovalue() {
		
	}
	
	public APP01Infovalue(InfoValue info) {
		setInfo(info);
	}
	
	private GroupAppBean groupAppInsert = new GroupAppBean();

	public GroupAppBean getGroupAppInsert() {
		return groupAppInsert;
	}

	public void setGroupAppInsert(GroupAppBean groupAppInsert) {
		this.groupAppInsert = groupAppInsert;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
