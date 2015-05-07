package manager.common.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import manager.common.bean.UserBean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class Login2Action extends BaseAction{
//	private Map<String, Object> session;
	
	private UserBean user = new UserBean();
	
	private String id;
	
	private String name;
	
	@Action(value="/logon2"
			,results={
				@Result(name="foward_admin",type="redirectAction"
						,params={
							"actionName","order/${id}/${name}"
						})
				, @Result(name="foward_dev",location="APP01_init",type="redirectAction")
				, @Result(name="foward_user",location="APP01_init",type="redirectAction")
				, @Result(name="failure",location="LOGIN", type="tiles")
			})
	public String logon2() {
		UserDetails userX = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = userX.getUsername();
		UserBean userLogon = new UserBean();
		userLogon.setId(id);
		List<String> list = new ArrayList<String>();
		list.add("admin");
		list.add("dev");
		list.add("user");
		userLogon.setListRoleName(list);
		session.put("user", userLogon);
		this.id = id;
		this.name = "abcd";
		return "foward_admin";
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
	
/*	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}*/
	
	
}
