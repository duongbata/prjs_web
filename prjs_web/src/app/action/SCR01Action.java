package app.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import manager.common.action.BaseAction;
import manager.common.bean.UserBean;

@Controller
@Scope("request")
@Namespace("/")
public class SCR01Action extends BaseAction{
	private String id;
	
	private String name;
	
	@Action(value="SCR01_init-*-*"
			, params = {
				"id" , "{1}"
			   ,"name" , "{2}"
			},
			results={
				@Result(name="success",location="SCR01",type="tiles")
				, @Result(name="failure",location="SCR01", type="tiles")
			})
	public String init() {
		UserBean user = (UserBean) session.get("user");
		System.out.println(user.getId());
		System.out.println(id);
		System.out.println(name);
		return "success";
	}
	
	@Action(value="/SCR01_submit"
			,results={
				@Result(name="success",location="SCR01",type="tiles")
				, @Result(name="failure",location="SCR01", type="tiles")
			})
	public String submit() {
		System.out.println(id);
		System.out.println(name);
		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
