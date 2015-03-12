package manager.common.util;

import java.util.ArrayList;
import java.util.List;

import manager.common.bean.UserBean;
import manager.common.dao.GenericDao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailService implements UserDetailsService{
	private GenericDao genericDao;
	
	@Override
	public UserDetails loadUserByUsername(String id)
			throws UsernameNotFoundException {
		UserBean userBean = genericDao.getUserById(Integer.valueOf(id));
		List<String> roles = genericDao.getRoleNameByUid(Integer.valueOf(id));
		List<GrantedAuthority> authorities = buildUserAuthority(roles);
		return builUserAuthentication(userBean, authorities);
	}
	
	private User builUserAuthentication(UserBean userBean, List<GrantedAuthority> listAuthority) {
		return new User(String.valueOf(userBean.getId()), userBean.getPassword(), true, true, true, true, listAuthority);
	}
	
	private List<GrantedAuthority> buildUserAuthority(List<String> roles) {
		List<GrantedAuthority> listAuthority = new ArrayList<>();
		if (roles.size() > 0) {
			for (String role : roles) {
				listAuthority.add(new SimpleGrantedAuthority(role));
			}
		}
		return listAuthority;
	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
}
