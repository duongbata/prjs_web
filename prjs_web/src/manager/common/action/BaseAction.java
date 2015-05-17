package manager.common.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware{
	protected Map<String, Object> session;
	
	public void setSession(Map<String,Object> session) {
		this.session = session;
	};
}
