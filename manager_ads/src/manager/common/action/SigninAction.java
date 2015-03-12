package manager.common.action;

import manager.common.bean.UserBean;
import manager.common.logic.BaseLogicIF;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SigninAction {
	private UserBean user = new UserBean();
	
	private String message;
	
	@Autowired
	private BaseLogicIF baseLogic;
	
	@Action(value="/signin"
			,results={
				@Result(name="success",location="SIGNIN",type="tiles")
			})
	public String signin() {
		return "success";
	}
	
	@Action(value="/signon"
			,results={
				@Result(name="success",location="SIGNIN",type="tiles")
				, @Result(name="failure",location="SIGNIN", type="tiles")
			})
	public String signon() {
		boolean isCreate = baseLogic.signonUser(user);
		if(!isCreate) {
			message = "Thông tin đăng kí không hợp lý";
			return "failure";
		}
		message = "Đăng kí thành công";
		return "success";
	}
	
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
