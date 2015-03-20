package manager.common.bean;

public class InfoValue {
	private String message;
	
	private UserBean user;
	
	private DataTransIF dataTrans;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public UserBean getUser() {
		return user;
	}
	
	public void setUser(UserBean user) {
		this.user = user;
	}

	public DataTransIF getDataTrans() {
		return dataTrans;
	}

	public void setDataTrans(DataTransIF dataTrans) {
		this.dataTrans = dataTrans;
	}
}
