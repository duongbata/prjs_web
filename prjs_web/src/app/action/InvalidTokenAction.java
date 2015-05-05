package app.action;

import manager.common.bean.InfoValue;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Controller
public class InvalidTokenAction {
	private InfoValue info;
	@Action(value="/InvalidToken_init"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
			@Result(name="success",location="INVALID_TOKEN",type="tiles")
			})
	public String init() {
		return "success";
	}
	public InfoValue getInfo() {
		return info;
	}
	public void setInfo(InfoValue info) {
		this.info = info;
	}
}
