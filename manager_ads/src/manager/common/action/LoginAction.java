package manager.common.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import manager.common.bean.ConstantBean;
import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;
import manager.common.dao.GenericDao;
import manager.common.logic.BaseLogicIF;

@Controller
public class LoginAction {
	@Autowired
	private BaseLogicIF baseLogic;
	
	@Autowired
	private GenericDao genericDao;
	
	private InfoValue info = new InfoValue();
	
	private UserBean user = new UserBean();
	
	@Action(value="/login"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={
				@Result(name="success",location="LOGIN",type="tiles")
				, @Result(name="failure",location="LOGIN", type="tiles")
			})
	public String login() {
		info = new InfoValue();
		return "success";
	}
	
	@Action(value="/logon"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={
				@Result(name="foward_admin",location="APP04_init",type="redirectAction")
				, @Result(name="foward_dev",location="APP03_init",type="redirectAction")
				, @Result(name="foward_user",location="ADV03_initCampaign",type="redirectAction")
				, @Result(name="failure",location="LOGIN", type="tiles")
			})
	public String logon(){
		UserDetails userX = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = userX.getUsername();
		if (id == null) {
			return "failure";
		}
		UserBean userLogin = new UserBean();
		userLogin.setId(id);
		UserBean userLogon = baseLogic.getUser(userLogin);
		if (userLogon == null) {
			info.setMessage("Thông tin đăng nhập không đúng");
			return "failure";
		} else {
			info.setUser(userLogon);
			if (userLogon.getListRoleName().contains(ConstantBean.ROLE_ADMIN)) {
				return "foward_admin";
			} else if (userLogon.getListRoleName().contains(ConstantBean.ROLE_DEV)) {
				return "foward_dev";
			} else if (userLogon.getListRoleName().contains(ConstantBean.ROLE_USER)) {
				return "foward_user";
			}
			return "failure";
		}
	}

	public InfoValue getInfo() {
		return info;
	}

	public void setInfo(InfoValue info) {
		this.info = info;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
}
