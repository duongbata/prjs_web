package app.dao;

import manager.ADV03.bean.BannerBean;
import manager.common.bean.UserBean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class APP02Dao {
	private String namespace;
	
	private static final String UPDATE_URL_OF_BANNER = "updateUrlOfBanner";
	
	private static final String GET_USER_BY_ID = "getUserById";
	
	@Autowired
	private SqlSessionTemplate managerAppsSqlSession;
	
	public APP02Dao() {
		setNamespace("app.dao.APP02Dao");
	}
	
	public boolean updateUrlOfBanner(BannerBean banner) {
		String query = namespace + "." + UPDATE_URL_OF_BANNER;
		Integer result = managerAppsSqlSession.update(query,banner);
		if (result != null && result != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public UserBean getUserById(String userId) {
		String query = namespace + "." + GET_USER_BY_ID;
		return managerAppsSqlSession.selectOne(query, userId);
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
