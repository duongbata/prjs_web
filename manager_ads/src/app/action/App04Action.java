package app.action;

import java.util.List;

import manager.common.bean.InfoValue;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.bean.PropertyAppBean;
import app.logic.APP04LogicIF;

@Controller
public class App04Action {
	private InfoValue info;
	
	private List<PropertyAppBean> listProperty;
	
	private String message;
	
	@Autowired
	private APP04LogicIF app04Logic;
	
	@Action(value="/APP04_init"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="APP04",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		listProperty = app04Logic.getListPropConfig();
		
		return "success";
	}
	
	@Action(value="/APP04_saveProperty"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="APP04",type="tiles")
				, @Result(name="failure",location="APP04", type="tiles")
			})
	public String saveProperty() {
		String msg = app04Logic.validateProp(listProperty);
		if (msg != null) {
			message = msg;
			return "failure";
		}
		app04Logic.insertAdmobConfig(listProperty);
		message = "Success";
		return "success";
	}
	
	public List<PropertyAppBean> getListProperty() {
		return listProperty;
	}
	
	public void setListProperty(List<PropertyAppBean> listProperty) {
		this.listProperty = listProperty;
	}

	public InfoValue getInfo() {
		return info;
	}

	public void setInfo(InfoValue info) {
		this.info = info;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
