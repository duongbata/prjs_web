package app.bean;

public class FieldBean {
	private String name;
	
	private String value;
	
	private String parentName;
	
	public FieldBean() {
		// TODO Auto-generated constructor stub
	}
	
	public FieldBean(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getParentName() {
		return parentName;
	}
	
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
