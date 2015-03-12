package manager.common.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import manager.common.bean.InfoValue;

public class MessageAction {
	private InfoValue info;
	@Action(value="/message"
			,interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={
				@Result(name="success",location="MESSAGE",type="tiles")
			})
	public String message() {
		String message = info.getMessage();
		info.setMessage("Hello "+message);
		return "success";
	}
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}
}
