package app.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import app.bean.APP02DataTrans;
import app.bean.PointBean;

@Controller
public class APP02Action extends ActionSupport implements Preparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3557786159678372458L;
	private APP02DataTrans app02DataTrans;
	/*private PointBean point = new PointBean();
	
	private PointBean p;*/
	
	@Action(value="/APP02_init"
			, results={
				@Result(name="success",location="APP02",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		APP02DataTrans app02DataTrans = new APP02DataTrans();
		PointBean p = new PointBean();
		p.setA("a");
		p.setB("b");
		app02DataTrans.setPoint(p);
		app02DataTrans.setMessage("Hello World");
		setApp02DataTrans(app02DataTrans);
		return "success";
	}
	
	@Action(value = "/APP02_callAjax"
			, interceptorRefs = {
				@InterceptorRef("paramsPrepareParamsStack")
			}
			, results = {
				@Result(name="success", type="json", params={"root","point"})
	})
	public String callAjax() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String a = request.getParameter("point_a");
		APP02DataTrans app02DataTrans = getApp02DataTrans();
		PointBean p = app02DataTrans.getPoint();
		p.setA(a + " xxx2");
		
		return "success";
	}
	
	@Action(value="/APP02_updatePoint"
			, results={
				@Result(name="success",location="APP02",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String updatePoint() {
		PointBean p = app02DataTrans.getPoint();
		System.out.println(p == null);
		return "success";
	}
	
	/*public PointBean getPoint() {
		return point;
	}
	
	public void setPoint(PointBean point) {
		this.point = point;
	}*/
	
	public void prepare() throws Exception {
		System.out.println(app02DataTrans == null);
	}
	
	
	public APP02DataTrans getApp02DataTrans() {
		return app02DataTrans;
	}
	
	public void setApp02DataTrans(APP02DataTrans app02DataTrans) {
		this.app02DataTrans = app02DataTrans;
	}
}
