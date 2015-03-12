package app.action;

import java.util.ArrayList;
import java.util.List;

import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.bean.GroupAppBean;
import app.bean.OSConfigBean;
import app.logic.App01LogicIF;

@Controller
public class APP01Action{
	public static final String USER_DEFAULT_ID = "-1";
	
	public static final String OS_IOS_ID = "1"; 
			
	public static final String OS_ANDROID_ID = "2";
	
	public static final String OS_WINDOWS_ID = "3";
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2796501846906521989L;

	private InfoValue info = new InfoValue();
	
	private GroupAppBean groupAppInsert;
	
	private List<UserBean> listDev;
	
	@Autowired
	private App01LogicIF app01Logic;
	
	@Action(value="/APP01_init"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="APP01",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		/*info.setMessage(null);*/
		groupAppInsert = new GroupAppBean();
		List<OSConfigBean> listOsConfig = new ArrayList<OSConfigBean>();
		OSConfigBean iosConfig = new OSConfigBean(null, null, null, OS_IOS_ID);
		listOsConfig.add(iosConfig);
		OSConfigBean androidConfig = new OSConfigBean(null, null, null, OS_ANDROID_ID);
		listOsConfig.add(androidConfig);
		OSConfigBean windowsConfig = new OSConfigBean(null, null, null, OS_WINDOWS_ID);
		listOsConfig.add(windowsConfig);
		groupAppInsert.setListOsConfig(listOsConfig);
		listDev = new ArrayList<UserBean>();
		UserBean userDefault = new UserBean();
		userDefault.setId(USER_DEFAULT_ID);
		userDefault.setName("");
		listDev.add(userDefault);
		listDev.addAll(app01Logic.getAllDev());
		
		return "success";
	}
	
	@Action(value="/APP01_insertGroup"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="APP01_init",type="redirectAction")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String insertGroup() throws Throwable{
		GroupAppBean groupApp = groupAppInsert;
		
		app01Logic.insertGroupApp(groupApp,info.getUser().getId());
		info.setMessage("Thêm thành công");
		return "success";
	}
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}

	public GroupAppBean getGroupAppInsert() {
		return groupAppInsert;
	}

	public void setGroupAppInsert(GroupAppBean groupAppInsert) {
		this.groupAppInsert = groupAppInsert;
	}

	public List<UserBean> getListDev() {
		return listDev;
	}

	public void setListDev(List<UserBean> listDev) {
		this.listDev = listDev;
	}
}
