package app.action;

import javax.servlet.http.HttpServletRequest;

import manager.common.bean.InfoValue;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import app.bean.PointBean;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Namespace("/")
@InterceptorRefs({
	@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
	, @InterceptorRef("basicStack")
})
public class OrdersAction implements ModelDriven<PointBean>{
	private InfoValue info;
	
	private PointBean point = new PointBean();
	
	private String id;
	
	private String name;
	
	@Action(value="order_init-*-*"
			, params = {"id","{1}","name","{2}"}
			, results={
				@Result(name="success",location="ORDER",type="tiles")
				, @Result(name="failure",location="ORDER", type="tiles")
			})
	public String init(){
		System.out.println(id);
		return "success";
	}
	
	@Action(value="/order_submit"
			, results={
				@Result(name="success",location="ORDER",type="tiles")
				, @Result(name="failure",location="ORDER", type="tiles")
				, @Result(name="invalid.token",location="INVALID_TOKEN", type="tiles")
			})
	public String submit(){
		/*System.out.println(point.getA() + ":" +point.getB() + ":" + point.getC());*/
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		System.out.println(a + ":" + b);
		return "success";
	}
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}
	
	@Override
	public PointBean getModel() {
		point = new PointBean("aa", "bbb", "c");
		return point;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
