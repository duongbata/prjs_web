package app.bean;

import java.util.List;

public class App03DataTrans implements DataTransIF{
	private List<AppBean> listAppBean;
	
	private AppBean appDetail;

	public List<AppBean> getListAppBean() {
		return listAppBean;
	}

	public void setListAppBean(List<AppBean> listAppBean) {
		this.listAppBean = listAppBean;
	}

	public AppBean getAppDetail() {
		return appDetail;
	}

	public void setAppDetail(AppBean appDetail) {
		this.appDetail = appDetail;
	}
}
