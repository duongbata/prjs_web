package manager.ADV01.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import manager.ADV01.bean.AdsBean;
import manager.ADV01.logic.ADV01LogicIF;
import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;

@Controller
public class ADV01Action {
	private List<AdsBean> listAds = new ArrayList<AdsBean>();
	
	private AdsBean adsEdit = new AdsBean();
	
	private AdsBean adsAdd = new AdsBean();
	
	private InfoValue info = new InfoValue();
	
	private Map<Integer, String> allOs;
	
	private Map<Integer, String> allStatus;
	
	private Map<Integer, String> allAdNetwork;
	
	@Autowired
	private ADV01LogicIF adv01Logic;
	
	@Action(value="/ADV01_init"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV01",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init()throws IOException{
		UserBean user = info.getUser();
		if (user.getId() == 3) {
			listAds = adv01Logic.listAdsFromRedis();
		} else {
			listAds = adv01Logic.listAds(user);
		}
		
		return "success";
	}
	
	@Action(value="/ADV01_moreInfo"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV01_2",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String moreInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String appId = request.getParameter("appId");
		adsEdit = adv01Logic.getAdsById(appId);
		return "success";
	}
	
	@Action(value="/ADV01_editAds"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={@Result(name="success",type="json")})
	public String editAds() throws JsonParseException, JsonMappingException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String json = request.getParameter("ads");
		AdsBean ads = new ObjectMapper().readValue(json, AdsBean.class);
		adv01Logic.updateAds(ads);
		return "success";
	}
	
	@Action(value="/ADV01_delAdsPubApp"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={@Result(name="success",type="json")})
	public String delAdsPubApp() throws JsonParseException, JsonMappingException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String json = request.getParameter("appId");
		String appId = new ObjectMapper().readValue(json, String.class);
		adv01Logic.delAdsPubApp(appId);
		return "success";
	}
	
	@Action(value="/ADV01_initAddAds"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV01_3",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String initAddAds(){
		return "success";
	}
	
	@Action(value="/ADV01_addAds"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={@Result(name="success",type="json")})
	public String addAds() throws JsonParseException, JsonMappingException, IOException {
		UserBean user = info.getUser();
		HttpServletRequest request = ServletActionContext.getRequest();
		String json = request.getParameter("ads");
		AdsBean ads = new ObjectMapper().readValue(json, AdsBean.class);
		adv01Logic.insertAdsApp(ads, user);
		return "success";
	}

	public List<AdsBean> getListAds() {
		return listAds;
	}

	public void setListAds(List<AdsBean> listAds) {
		this.listAds = listAds;
	}

	public InfoValue getInfo() {
		return info;
	}

	public void setInfo(InfoValue info) {
		this.info = info;
	}
	
	public AdsBean getAdsEdit() {
		return adsEdit;
	}
	
	public void setAdsEdit(AdsBean adsEdit) {
		this.adsEdit = adsEdit;
	}

	public Map<Integer, String> getAllOs() {
		allOs = adv01Logic.getAllOs();
		return allOs;
	}

	public void setAllOs(Map<Integer, String> allOs) {
		this.allOs = allOs;
	}

	public Map<Integer, String> getAllStatus() {
		allStatus = adv01Logic.getAllStatus();
		return allStatus;
	}

	public void setAllStatus(Map<Integer, String> allStatus) {
		this.allStatus = allStatus;
	}

	public Map<Integer, String> getAllAdNetwork() {
		allAdNetwork = adv01Logic.getAllAdNetwork();
		return allAdNetwork;
	}

	public void setAllAdNetwork(Map<Integer, String> allAdNetwork) {
		this.allAdNetwork = allAdNetwork;
	}

	public AdsBean getAdsAdd() {
		return adsAdd;
	}

	public void setAdsAdd(AdsBean adsAdd) {
		this.adsAdd = adsAdd;
	}
}
