package app.bean;

import manager.common.bean.DataTransIF;

public class App01DataTrans implements DataTransIF{
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
