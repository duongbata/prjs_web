package manager.ADV02.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import manager.ADV01.bean.AdsBean;
import manager.ADV02.bean.AdsAdnetworkBean;
import manager.ADV02.bean.AdvertiserBean;
import manager.ADV02.bean.GroupAdsBean;
import manager.ADV02.bean.Parent;
import manager.ADV02.logic.ADV02LogicIF;
import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;
import manager.common.dao.GenericDao;

@Controller
public class ADV02Action {
	private InfoValue info = new InfoValue();
	
	private List<AdsAdnetworkBean> listAdnetwork = new ArrayList<AdsAdnetworkBean>();
	
	private List<GroupAdsBean> listGroupAds = new ArrayList<GroupAdsBean>();
	
	private String msgError;
	
	@Autowired
	private GenericDao genericDao;
	
	@Autowired
	private ADV02LogicIF adv02Logic;
	
	@Action(value="/ADV02_init"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV02",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		listAdnetwork = adv02Logic.listAdnetworkBeans();
		return "success";
	}
	
	@Action(value="/ADV02_confirm"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="ADV02_init",type="redirectAction")
				, @Result(name="failure",location="MANAGER.ADV02",type="tiles")
			})
	public String confirm() {
		setMsgError(null);
		info.setMessage(null);
		String msg = adv02Logic.validateListAdnetwork(getListAdnetwork());
		if (msg != null) {
			this.msgError = msg;
			return "failure";
		} else {
			this.msgError = null;
		}
		boolean isSaved = adv02Logic.saveListAdnetworkToRedis(getListAdnetwork());
		if (!isSaved) {
			this.msgError = "Lỗi trong quá trình ghi";
			return "failure";
		}
		this.info.setMessage("Save thành công !");
		return "success";
	}
	
	@Action(value="/ADV02_listApp"
			, results={
				@Result(name="success",location="MANAGER.ADV02_2",type="tiles")
			})
	public String listApp() {
		listGroupAds = adv02Logic.listGroupAds();
		return "success";
	}
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}

	public List<AdsAdnetworkBean> getListAdnetwork() {
		return listAdnetwork;
	}

	public void setListAdnetwork(List<AdsAdnetworkBean> listAdnetwork) {
		this.listAdnetwork = listAdnetwork;
	}

	public List<GroupAdsBean> getListGroupAds() {
		return listGroupAds;
	}

	public void setListGroupAds(List<GroupAdsBean> listGroupAds) {
		this.listGroupAds = listGroupAds;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	
}
