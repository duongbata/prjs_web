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
public class CustomerAction {
	private InfoValue info;
	private String name;
	
	@Action(value="/customer-init"
			, results={
				@Result(name="success",location="CUSTOMER",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		return "success";
	}
	
	@Action(value="/insert-name"
			, interceptorRefs = {
				@InterceptorRef("tokenStack")
			}
			, results={
				@Result(name="success",location="APP01",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
				/*, @Result(name="invalid.token",location="INVALID_TOKEN", type="tiles")*/
			})
	public String insert() {
		System.out.println(name);
		return "success";
	}
	
	@Action(value="/update-name"
			, interceptorRefs = {
				@InterceptorRef("tokenStack")
			}
			, results={
				@Result(name="success",location="CUSTOMER",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
				/*, @Result(name="invalid.token",location="INVALID_TOKEN", type="tiles")*/
			})
	public String update() {
		System.out.println(name);
		return "success";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}
}
