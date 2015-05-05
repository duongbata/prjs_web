package app.rest;


import manager.common.bean.UserBean;

import com.opensymphony.xwork2.ModelDriven;

public class UserController implements ModelDriven<UserBean>{
	private String id;
	private UserBean model = new UserBean();
	
	public String update() {
		System.out.println(id);
		return "update";
	}
	
	@Override
	public UserBean getModel() {
		model = new UserBean();
		model.setId("1");
		model.setName("duongbata");
		return model;
	}
	
	public String getId() {
		
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
