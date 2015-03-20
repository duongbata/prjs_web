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

import app.bean.App01DataTrans;
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
		App01DataTrans app01DataTrans = new App01DataTrans();
		app01DataTrans.setMessage("Hello" + info.getUser().getId());
		info.setDataTrans(app01DataTrans);
		return "success";
	}
	
	
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}

}
