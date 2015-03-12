package manager.common.bean;

import java.util.List;

import manager.ADV02.bean.GroupAdsBean;

public class UserBean {
	private int id;
	
	private String password;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String phone;
	
	private String email;
	
	private List<GroupAdsBean> listAdsBanner;
	
	private List<String> listRoleName;
	
	private boolean flgSelected;
	
	public int getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Integer.valueOf(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<GroupAdsBean> getListAdsBanner() {
		return listAdsBanner;
	}

	public void setListAdsBanner(List<GroupAdsBean> listAdsBanner) {
		this.listAdsBanner = listAdsBanner;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getListRoleName() {
		return listRoleName;
	}

	public void setListRoleName(List<String> listRoleName) {
		this.listRoleName = listRoleName;
	}

	public boolean getFlgSelected() {
		return flgSelected;
	}

	public void setFlgSelected(boolean flgSelected) {
		this.flgSelected = flgSelected;
	}
}
