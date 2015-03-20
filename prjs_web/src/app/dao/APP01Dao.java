package app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manager.common.bean.UserBean;

@Repository
public class APP01Dao {
	private String SELECT_ALL_DEV = "selectAllDev";
	
	private String namespace;
	
	@Autowired
	private SqlSessionTemplate managerAppsSqlSession;
	
	public APP01Dao() {
		setNamespace("app.dao.APP01Dao");
	}
	
	public List<UserBean> selectAllDev() {
		String query = namespace + "." + SELECT_ALL_DEV;
		return managerAppsSqlSession.selectList(query);
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
