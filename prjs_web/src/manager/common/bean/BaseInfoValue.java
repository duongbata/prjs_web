package manager.common.bean;

public class BaseInfoValue implements InfoValueIF{
	private InfoValue info;
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}
}
