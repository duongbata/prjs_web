package manager.ADV03.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import manager.ADV01.bean.AdsBean;
import manager.ADV03.bean.BannerBean;
import manager.ADV03.bean.CampaignBean;
import manager.ADV03.logic.ADV03LogicIF;
import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class ADV03Action{
	
	private InfoValue info;
	
	private List<BannerBean> listBanner = new ArrayList<BannerBean>();
	
	private List<BannerBean> listSampleBanner = new ArrayList<BannerBean>();
	
	private BannerBean bannerEdit;
	
	private BannerBean bannerInsert;
	
	private Map<Integer, String> allCampaign = new HashMap<Integer, String>();
	
	private Map<Integer, String> allBannerStatus = new HashMap<Integer, String>();
	
	private Map<Integer, String> allBannerType = new HashMap<Integer, String>();
	
	private List<CampaignBean> listCampaign = new ArrayList<CampaignBean>();
	
	private String message;
	
	private int campaignId;
	
	@Autowired
	private ADV03LogicIF adv03Logic;
	
	@Action(value="/ADV03_init"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV03",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("campaignId");
		int campaignId = Integer.valueOf(id);
		setCampaignId(campaignId);
		int userId = info.getUser().getId();
		CampaignBean campaign = new CampaignBean();
		campaign.setCampaignId(campaignId);
		campaign.setUserId(userId);
		listBanner = adv03Logic.getListBanner(campaign);
		return "success";
	}
	
	@Action(value="/ADV03_moreInfo"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV03_2",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String moreInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String strBannerId = request.getParameter("bannerId");
		int bannerId;
		try { 
			bannerId = Integer.valueOf(strBannerId);
		} catch (NumberFormatException ex) {
			return "failure";
		}
		bannerEdit = adv03Logic.getBannerById(bannerId);
		if (bannerEdit == null) {
			return "failure";
		}
		return "success";
	}
	
	@Action(value="/ADV03_editBanner"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={@Result(name="success",type="json")})
	public String editBanner() throws JsonParseException, JsonMappingException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String json = request.getParameter("banner");
		BannerBean bannerEdit = new ObjectMapper().readValue(json, BannerBean.class);
		bannerEdit.setUserId(info.getUser().getId());
		adv03Logic.editBanner(bannerEdit);
		return "success";
	}
	
	@Action(value="/ADV03_initCreate"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV03_3",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String initCreate() {
		return "success";
	}
	
	@Action(value="/ADV03_insertBannerSample"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={
				@Result(name="success",location="MANAGER.ADV03_3",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")}
			)
	public String insertBannerSample() throws JsonParseException, JsonMappingException, IOException{
		/*HttpServletRequest request = ServletActionContext.getRequest();
		String json = request.getParameter("banner");
		BannerBean bannerInsert = new ObjectMapper().readValue(json, BannerBean.class);*/
		if(bannerInsert != null) {
			bannerInsert.setUserId(info.getUser().getId());
			adv03Logic.insertSampleBanner(bannerInsert);
			message = "Insert banner thành công";
		}
		
		bannerInsert = null;
		return "success";
	}
	
	@Action(value="/ADV03_deleteBanner"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={@Result(name="success",type="json")})
	public String deleteBanner() throws JsonParseException, JsonMappingException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String json = request.getParameter("banner");
		BannerBean banner= new ObjectMapper().readValue(json, BannerBean.class);
		banner.setUserId(info.getUser().getId());
		adv03Logic.deleteBanner(banner);
		return "success";
	}
	
	@Action(value="/ADV03_initCampaign"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV03_4",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String initCampaign() {
		int userId = info.getUser().getId();
		listCampaign = adv03Logic.listCampaignOfUser(userId);
		return "success";
	}
	
	@Action(value="/ADV03_listMoreBanner"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV03_5",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String listMoreBanner(){
		String userId = ServletActionContext.getRequest().getParameter("uid");
		String campaignId = ServletActionContext.getRequest().getParameter("campaignid");
		this.campaignId = Integer.valueOf(campaignId);
		BannerBean banner = new BannerBean();
		banner.setCampaignId(Integer.valueOf(campaignId));
		banner.setUserId(Integer.valueOf(userId));
		listSampleBanner = adv03Logic.listSampleBannerOfUser(banner);
		return "success";
	}
	
	@Action(value="/ADV03_insertBannerToCampaign"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV03_5",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String insertBannerToCampaign() {
		List<BannerBean> listBannerSelected = new ArrayList<BannerBean>();
		if (listSampleBanner != null && listSampleBanner.size() >0){
			for (BannerBean banner : listSampleBanner) {
				if (banner.getFlagSelected()) {
					listBannerSelected.add(banner);
				}
			}
		}
		adv03Logic.insertBannerToCampaign(listBannerSelected, campaignId, info.getUser().getId());
		
		return "success";
	}
	
	@Action(value="/ADV03_editBannerConfig"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={@Result(name="success",type="json")})
	public String editBannerConfig() throws JsonParseException, JsonMappingException, IOException{
		String json = ServletActionContext.getRequest().getParameter("bannerBean");
		BannerBean banner = new ObjectMapper().readValue(json, BannerBean.class);
		banner.setUserId(info.getUser().getId());
		adv03Logic.updateBannerConfig(banner);
		return "success";
	}
	
	@Action(value="/ADV03_saveListCampaign"
			, interceptorRefs={
			@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
			, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="MANAGER.ADV03_4",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String saveListCampaign() throws JsonParseException, JsonMappingException, IOException{
		String oldSize = ServletActionContext.getRequest().getParameter("oldSize");
		int oldS = Integer.parseInt(oldSize);
		List<CampaignBean> listCampNew = new ArrayList<CampaignBean>();
		if(listCampaign.size() > oldS) {
			for (int i = oldS; i < listCampaign.size();i++){
				listCampNew.add(listCampaign.get(i));
			}
		}
		adv03Logic.saveNewCampaign(listCampNew, info.getUser().getId());
		return "success";
	}
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}

	public List<BannerBean> getListBanner() {
		return listBanner;
	}

	public void setListBanner(List<BannerBean> listBanner) {
		this.listBanner = listBanner;
	}

	public BannerBean getBannerEdit() {
		return bannerEdit;
	}

	public void setBannerEdit(BannerBean bannerEdit) {
		this.bannerEdit = bannerEdit;
	}

	public Map<Integer, String> getAllCampaign() {
		allCampaign = adv03Logic.getAllCampaign();
		return allCampaign;
	}

	public void setAllCampaign(Map<Integer, String> allCampaign) {
		this.allCampaign = allCampaign;
	}

	public Map<Integer, String> getAllBannerStatus() {
		allBannerStatus = adv03Logic.getAllBannerStatus();
		return allBannerStatus;
	}

	public void setAllBannerStatus(Map<Integer, String> allBannerStatus) {
		this.allBannerStatus = allBannerStatus;
	}

	public Map<Integer, String> getAllBannerType() {
		allBannerType = adv03Logic.getAllBannerType();
		return allBannerType;
	}

	public void setAllBannerType(Map<Integer, String> allBannerType) {
		this.allBannerType = allBannerType;
	}

	public BannerBean getBannerInsert() {
		return bannerInsert;
	}

	public void setBannerInsert(BannerBean bannerInsert) {
		this.bannerInsert = bannerInsert;
	}

	public List<CampaignBean> getListCampaign() {
		return listCampaign;
	}

	public void setListCampaign(List<CampaignBean> listCampaign) {
		this.listCampaign = listCampaign;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<BannerBean> getListSampleBanner() {
		return listSampleBanner;
	}

	public void setListSampleBanner(List<BannerBean> listSampleBanner) {
		this.listSampleBanner = listSampleBanner;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
}
