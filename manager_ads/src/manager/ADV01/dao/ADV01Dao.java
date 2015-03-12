package manager.ADV01.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manager.ADV01.bean.AdsBean;
import manager.common.dao.OsResultHandler;
import manager.common.dao.ResultHandlerImpl;

@Repository
public class ADV01Dao {
	private static final String LIST_ADS ="listAds";
	
	private static final String GET_ADS_BY_ID = "getAdsById";
	
	private static final String GET_ALL_OS = "getAllOs";
	
	private static final String GET_ALL_STATUS = "getAllStatus";
	
	private static final String GET_ALL_ADNETWORK = "getAllAdNetwork";
	
	private static final String UPDATE_ADS = "updateAds";
	
	private static final String DELETE_ADS_PUB_APP = "delAdsPubApp";
	
	private static final String INSERT_ADS_APP = "insertAdsApp";
	
	private static final String INSERT_ADS_APP_MORE_INFO = "insertAdsAppMoreInfo";
	
	private static final String INSERT_ADS_APP_NETWORK = "insertAdsAppNetwork";
	
	private static final String INSERT_ADS_PUBLISHER_APP = "insertAdsPublisherApp";
	
	@Autowired
	private SqlSessionTemplate managerAppsSqlSession;
	
	private String namespace;
	
	public ADV01Dao() {
		setNamespace("manager.ADV01.dao.ADV01Dao");
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public List<AdsBean> listAds(int userId) {
		String query = namespace + "." + LIST_ADS;
		return managerAppsSqlSession.selectList(query, userId);
	}
	
	public AdsBean getAdsById(String appId) {
		String query = namespace + "." + GET_ADS_BY_ID;
		return managerAppsSqlSession.selectOne(query, appId);
	}
	
	public Map<Integer, String> getAllOs(){
		String query = namespace + "." +GET_ALL_OS;
		ResultHandlerImpl<Integer, String> rhImpl = new ResultHandlerImpl<Integer,String>("os", "value");
		managerAppsSqlSession.select(query, rhImpl);
		Map<Integer, String> inMap = rhImpl.getInMap();
		return inMap;
	}
	
	public Map<Integer, String> getAllStatus() {
		String query = namespace + "." + GET_ALL_STATUS;
		ResultHandlerImpl<Integer, String> rhImpl = new ResultHandlerImpl<Integer,String>("status", "value");
		managerAppsSqlSession.select(query, rhImpl);
		Map<Integer, String> inMap = rhImpl.getInMap();
		return inMap;
	}
	
	public Map<Integer, String> getAllAdNetwork(){
		String query = namespace + "." +GET_ALL_ADNETWORK;
		ResultHandlerImpl<Integer, String> rhImpl = new ResultHandlerImpl<Integer,String>("adnetwork_id", "name");
		managerAppsSqlSession.select(query, rhImpl);
		Map<Integer, String> inMap = rhImpl.getInMap();
		return inMap;
	}
	
	public void updateAds(AdsBean adsBean) {
		String query = namespace + "." +UPDATE_ADS;
		managerAppsSqlSession.update(query, adsBean);
	}
	
	public void delAdsPubApp(String appId) {
		String query = namespace + "." + DELETE_ADS_PUB_APP;
		managerAppsSqlSession.delete(query, appId);
	}
	
	public void insertAdsApp(AdsBean adsBean) {
		String query = namespace + "." + INSERT_ADS_APP;
		managerAppsSqlSession.insert(query, adsBean);
	}
	
	public void insertAdsAppMoreInfo(AdsBean adsBean) {
		String query = namespace + "." + INSERT_ADS_APP_MORE_INFO;
		managerAppsSqlSession.insert(query, adsBean);
	}
	
	public void insertAdsAppNetwork(AdsBean adsBean) {
		String query = namespace + "." + INSERT_ADS_APP_NETWORK;
		managerAppsSqlSession.insert(query, adsBean);
	}
	
	public void insertAdsPublisherApp(Map<String, Object> map){
		String query = namespace + "." + INSERT_ADS_PUBLISHER_APP;
		managerAppsSqlSession.insert(query, map);
	}
} 
