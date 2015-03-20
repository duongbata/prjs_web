package manager.common.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;
import manager.common.dao.GenericDao;
import manager.common.logic.BaseLogicIF;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller
public class DetailAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2787456428410904207L;

	@Autowired
	private BaseLogicIF baseLogic;
	
	@Autowired
	private GenericDao genericDao;
	
	private InfoValue info;
	
	private String name;
	
	/*Upload file*/
	private File file;
	
	private String contentType;
	
	private String fileName;
	
	//spring security
	private String username;
	
	private String password;
	
	/*Upload multiple file*/
	private List<File> files = new ArrayList<File>();
	
	private List<String> contents = new ArrayList<String>();
	
	private List<String> names = new ArrayList<String>();
	
	private List<UserBean> listUser = new ArrayList<UserBean>();
	
	private UserBean userBean = new UserBean();

	@Action(value="/detail"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
				
			}
			,results={
				@Result(name="success",location="DETAIL",type="tiles")
			})
	public String detail(){
		info = new InfoValue();
		info.setMessage("trung");
		listUser = genericDao.listUser();
		return "success";
	}
	
	@Action(value="/callAjax",results={@Result(name="success",type="json")})
	public String callAjax() throws IOException {
		String name = getName();
		setName("Hello nguyen thanh trung");
		return "success";
	}
	
	@Action(value="/newRow"
			,results={
					@Result(name="success",location="DETAIL",type="tiles")
			})
	public String newRow() {
		List<UserBean> list = getListUser();
		System.out.println(list.size());
		return "success";
	}
	
	@Action(value="/doUpload"
			,interceptorRefs={
					@InterceptorRef(value="fileUpload", params={"allowedTypes","image/jpeg,image/gif,image/png","maximumSize","5120000"})
					, @InterceptorRef("basicStack")
			}
			, results={
					@Result(name="success",location="DETAIL",type="tiles")
			})
	public String uploadFile(){
		String path = "D:\\upload\\struts2\\";
		File destFile = new File(path, fileName);
		try {
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@Action(value="/doMultiUpload"
			, interceptorRefs={
					@InterceptorRef(value="fileUpload", params={"allowedTypes","image/jpeg,image/gif,image/png","maximumSize","5120000"})
					, @InterceptorRef("basicStack")
			}
			, results={
					@Result(name="success",location="DETAIL",type="tiles")
			})
	public String uploadMultiFile() {
		List<File> files = this.files;
		List<String> names = this.names;
		System.out.println(files.size()+":"+names.size());
		return "success";
	}
	
	@Action(value="/confirms"
			, results={
					@Result(name="success",location="DETAIL",type="tiles")
			})
	public String confirm() {
		return "success";
	}
	
	//spring security
	@Action(value="/dangnhap"
			, results={
					@Result(name="success",location="DANGNHAP",type="tiles")
			})
	public String dangnhap() {
		
		return "success";
	}
	
	@Action(value="/admin"
			, results={
					@Result(name="success",location="ADMIN",type="tiles")
			})
	public String admin() {
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println((user.getUsername()));
		System.out.println(user.getPassword());
		return "success";
	}
	
	public InfoValue getInfo() {
		return info;
	}

	public void setInfo(InfoValue info) {
		this.info = info;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<UserBean> getListUser() {
		return listUser;
	}
	
	public void setListUser(List<UserBean> listUser) {
		this.listUser = listUser;
	}
	/*public void setBaseLogic(BaseLogicIF baseLogic) {
		this.baseLogic = baseLogic;
	}*/

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	 public void setUpload(File file) {
         this.file = file;
    }
 
      public void setUploadContentType(String contentType) {
         this.contentType = contentType;
      }
 
      public void setUploadFileName(String filename) {
         this.fileName = filename;
      }
      
    public void setUploads(List<File> files) {
    	this.files = files;
    }
    
    public void setUploadsContentType(List<String> contents) {
    	this.contents = contents;
    }
    
    public void setUploadsFileName(List<String> names) {
    	this.names = names;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
