package app.action;

import manager.common.bean.InfoValue;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Controller
@Namespace("/")
@InterceptorRefs({
	@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
	, @InterceptorRef("basicStack")
})
public class APP03Action {
	private InfoValue info;
	@Action(value="/APP03_init"
			, results={
				@Result(name="success",location="APP03",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
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
