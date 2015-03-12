package manager.ADV02.bean;

import java.util.List;

public class Parent {
	private String name;
	
	private List<Child> listSon;
	
	private List<Child> listDaughter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getListSon() {
		return listSon;
	}

	public void setListSon(List<Child> listSon) {
		this.listSon = listSon;
	}

	public List<Child> getListDaughter() {
		return listDaughter;
	}

	public void setListDaughter(List<Child> listDaughter) {
		this.listDaughter = listDaughter;
	}
}
