package app.logic;

import java.util.List;

import app.bean.AppBean;

public interface App03LogicIF {
	List<AppBean> getListAppOfUser(String userId);
	
	boolean updateApp(AppBean appUpdate, String userId);
}
