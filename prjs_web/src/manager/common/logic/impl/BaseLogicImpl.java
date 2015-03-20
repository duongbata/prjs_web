package manager.common.logic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import manager.common.bean.RedisConstant;
import manager.common.bean.UserBean;
import manager.common.dao.GenericDao;
import manager.common.logic.BaseLogicIF;

@Service
public class BaseLogicImpl implements BaseLogicIF{
	@Autowired
	private GenericDao genericDao;
	
	@Autowired
	private StringRedisTemplate template;
	
	@Override
	public String getMessage() {
		return "Hello world";
	}
	
	@Override
	public UserBean getUser(UserBean userLogin) {
//		UserBean user = genericDao.getUser(userLogin);
		UserBean user = genericDao.getUserById(userLogin.getId());
		if(user == null) {
			return null;
		}
		List<String> listRoleName = genericDao.getRoleNameByUid(user.getId());
		user.setListRoleName(listRoleName);
		return user;
	}
	
	@Override
	public boolean signonUser(UserBean user) {
		boolean isCreateUser = genericDao.insertUser(user);
		if(!isCreateUser) {
			return false;
		}
		int maxRoleId= genericDao.getMaxRoleId() + 1;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", maxRoleId);
		map.put("userId", user.getId());
		boolean isCreateRole = genericDao.insertRoleCustomer(map);
		if(!isCreateRole) {
			return false;
		}
		//To redis
		String query = RedisConstant.DB_ADS_CUSTOMER + ":" +"uids";
		template.opsForSet().add(query, String.valueOf(user.getId()));
		return true;
	}
}
