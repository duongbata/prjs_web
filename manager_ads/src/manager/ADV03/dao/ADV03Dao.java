package manager.ADV03.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manager.ADV03.bean.BannerBean;
import manager.ADV03.bean.CampaignBean;
import manager.common.dao.ResultHandlerImpl;

@Repository
public class ADV03Dao {
	private static final String LIST_BANNER = "getListBanner";
	
	private static final String GET_BANNER_BY_ID = "getBannerById";
	
	private static final String GET_ALL_CAMPAIGN = "getAllCampaign";
	
	private static final String GET_ALL_BANNER_STATUS ="getAllBannerStatus";
	
	private static final String GET_ALL_BANNER_TYPE = "getAllBannerType";
	
	private static final String EDIT_BANNER = "editBanner";
	
	private static final String INSERT_SAMPLE_BANNER = "insertSampleBanner";
	
	private static final String DELETE_BANNER = "deleteBanner";
	
	private static final String LIST_CAMPAIGN_OF_USER = "selectListCampaignOfUser";
	
	private static final String LIST_SAMPLE_BANNER = "selectListSampleBanner";
	
	private static final String GET_SAMPLE_BANNER_BY_ID = "getSampleBannerById";
	
	private static final String GET_MAX_BANNER_ID = "getMaxIdOfBanner";
	
	private static final String INSERT_BANNER_TO_CAMPAIGN = "insertBannerToCampaign";
	
	private static final String UPDATE_BANNER_CONFIG = "updateBannerBeanConfig";
	
	private static final String GET_MAX_CAMPAIGN_ID = "getMaxIdOfCampign";
	
	private static final String INSERT_CAMPAIGN = "insertCampaign";
	
	private static final String GET_BANNER_TYPE_NAME_BY_ID = "getBannerTypeNameById";
	
	private static final String GET_BANNER_STATUS_NAME_BY_ID = "getStatusNameById";
	
	private String namespace;
	
	@Autowired
	private SqlSessionTemplate managerAppsSqlSession;
	
	public ADV03Dao() {
		setNamespace("manager.ADV03.dao.ADV03Dao");
	}
	
	public List<BannerBean> getListBanner(CampaignBean campaign) {
		String query = namespace + "." + LIST_BANNER;
		return managerAppsSqlSession.selectList(query, campaign); 
	}
	
	public BannerBean getBannerById(int bannerId) {
		String query = namespace + "." + GET_BANNER_BY_ID;
		return managerAppsSqlSession.selectOne(query, bannerId);
	}
	
	public Map<Integer, String> getAllCampaign() {
		String query = namespace + "." + GET_ALL_CAMPAIGN;
		ResultHandlerImpl<Integer, String> rhImpl = new ResultHandlerImpl<Integer,String>("campaign_id", "campaign_name");
		managerAppsSqlSession.select(query, rhImpl);
		Map<Integer, String> inMap = rhImpl.getInMap();
		return inMap;
	}
	
	public Map<Integer, String> getAllBannerStatus() {
		String query = namespace + "." + GET_ALL_BANNER_STATUS;
		ResultHandlerImpl<Integer, String> rhImpl = new ResultHandlerImpl<Integer,String>("status", "value");
		managerAppsSqlSession.select(query, rhImpl);
		Map<Integer, String> inMap = rhImpl.getInMap();
		return inMap;
	}
	
	public Map<Integer, String> getAllBannerType() {
		String query = namespace + "." + GET_ALL_BANNER_TYPE;
		ResultHandlerImpl<Integer, String> rhImpl = new ResultHandlerImpl<Integer,String>("bannerType", "value");
		managerAppsSqlSession.select(query, rhImpl);
		Map<Integer, String> inMap = rhImpl.getInMap();
		return inMap;
	}
	
	public void editBanner(BannerBean bannerEdit) {
		String query = namespace + "." + EDIT_BANNER;
		managerAppsSqlSession.update(query, bannerEdit);
	}
	
	public void insertSampleBanner(BannerBean bannerInsert) {
		String query = namespace + "." + INSERT_SAMPLE_BANNER;
		managerAppsSqlSession.insert(query, bannerInsert);
	}
	
	public void deleteBanner(int bannerId) {
		String query = namespace + "." + DELETE_BANNER;
		managerAppsSqlSession.delete(query, bannerId);
	}
	
	public List<CampaignBean> listCampaignOfUser(int userId) {
		String query = namespace + "." + LIST_CAMPAIGN_OF_USER;
		return managerAppsSqlSession.selectList(query, userId);
	}
	
	public List<BannerBean> listSampleBannerOfUser(BannerBean banner) {
		String query = namespace + "." + LIST_SAMPLE_BANNER;
		return managerAppsSqlSession.selectList(query, banner);
	}
	
	public BannerBean getSampleBannerById(BannerBean banner) {
		String query = namespace +"." +GET_SAMPLE_BANNER_BY_ID;
		return managerAppsSqlSession.selectOne(query, banner);
	}
	
	public int getMaxIdOfBanner() {
		String query = namespace + "." + GET_MAX_BANNER_ID;
		try {
			return managerAppsSqlSession.selectOne(query, null);
		} catch(Exception ex) {
			return 0;
		}
	}
	
	public void insertBannerToCampaign(BannerBean banner) {
		String query = namespace + "." + INSERT_BANNER_TO_CAMPAIGN;
		managerAppsSqlSession.insert(query, banner);
	}
	
	public void updateBannerBeanConfig(BannerBean banner) {
		String query = namespace + "." + UPDATE_BANNER_CONFIG;
		managerAppsSqlSession.update(query, banner);
	}
	
	public int getMaxIdOfCampign() {
		String query = namespace + "." + GET_MAX_CAMPAIGN_ID;
		try {
			return managerAppsSqlSession.selectOne(query, null);
		} catch (Exception ex) {
			return 0;
		}
	}
	
	public void insertCampaign(CampaignBean campaign) {
		String query = namespace + "." + INSERT_CAMPAIGN;
		managerAppsSqlSession.insert(query, campaign);
	}
	
	public String getBannerTypeNameById(int bannerType) {
		String query = namespace + "." + GET_BANNER_TYPE_NAME_BY_ID;
		return managerAppsSqlSession.selectOne(query, bannerType);
	}
	
	public String getStatusNameById(int statusId) {
		String query = namespace + "." + GET_BANNER_STATUS_NAME_BY_ID;
		return managerAppsSqlSession.selectOne(query, statusId);
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
