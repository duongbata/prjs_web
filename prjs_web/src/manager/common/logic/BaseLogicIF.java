package manager.common.logic;

import manager.common.bean.UserBean;

public interface BaseLogicIF {
	String getMessage();
	
	UserBean getUser(UserBean userLogin);
	
	boolean signonUser(UserBean user);
}
