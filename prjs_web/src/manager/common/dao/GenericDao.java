package manager.common.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manager.common.bean.UserBean;

@Repository
public class GenericDao {
	private static final String LIST_USER = "listUser";
	
	private static final String GET_USER = "getUser";
	
	private static final String LIST_ROLE_NAME_BY_UID = "getRoleNameByUid";
	
	private static final String GET_USER_BY_ID = "getUserById";
	
	private static final String INSERT_USER = "insertUser";
	
	private static final String INSERT_ROLE_CUSTOMER = "insertRoleCustomer";
	
	private static final String GET_MAX_ROLE_ID = "getMaxRoleId";
	
	private  String namespace;
	
	@Autowired
	private SqlSessionTemplate managerAppsSqlSession;
	
	public GenericDao() {
		setNamespace("manager.common.dao.GenericDao");
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public List<UserBean> listUser() {
		String query = namespace + "." + LIST_USER;
		return managerAppsSqlSession.selectList(query, null);
	}
	
	public UserBean getUser(UserBean user) {
		String query = namespace +"."+GET_USER;
		return managerAppsSqlSession.selectOne(query, user);
	}
	
	public List<String> getRoleNameByUid(int id) {
		String query = namespace + "." +LIST_ROLE_NAME_BY_UID;
		return managerAppsSqlSession.selectList(query, id);
	}
	
	public UserBean getUserById(int id) {
		String query = namespace + "." + GET_USER_BY_ID;
		return managerAppsSqlSession.selectOne(query, id);
	}
	
	public int getMaxRoleId() {
		String query = namespace + "." + GET_MAX_ROLE_ID;
		try {
			return managerAppsSqlSession.selectOne(query, null);
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public boolean insertUser(UserBean user) {
		String query = namespace + "." + INSERT_USER;
		int result = managerAppsSqlSession.insert(query, user);
		if(result == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean insertRoleCustomer(Map<String, Object> map) {
		String query = namespace + "." + INSERT_ROLE_CUSTOMER;
		int result = managerAppsSqlSession.insert(query, map);
		if(result == 0) {
			return false;
		} else {
			return true;
		}
	}
}
