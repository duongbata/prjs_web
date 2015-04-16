package app.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import app.bean.APP02DataTrans;
import app.bean.PointBean;

@Controller
public class APP02Action implements ModelDriven<APP02DataTrans>{
	private APP02DataTrans app02DataTrans;
	/*private PointBean point = new PointBean();
	
	private PointBean p;*/
	
	private String message;
	
	private String msg;
	
	@Action(value="/APP02_init"
			, results={
				@Result(name="success",location="APP02",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		message = "{\"aps\":{\"alert\":\"Chúc bạn một ngày soi cầu may mắn\",\"sound\":\"default\",\"content-available\":1}}";
		msg = "Dortmund";
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
	public String updatePoint() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String body = getStringFromInputStream(request.getInputStream());
		APP02DataTrans app02DataTrans = getModel();
		PointBean p = app02DataTrans.getPoint();
		System.out.println(p == null);
		return "success";
	}
	
	public static String getStringFromInputStream(InputStream is) {
		  BufferedReader br = null;
		  StringBuilder sb = new StringBuilder();
		  try {
		   br = new BufferedReader(new InputStreamReader(is));
		   String line;
		   while ((line = br.readLine()) != null) {
		    sb.append(line);
		   }
		  } catch (IOException localIOException) {
		   if (br != null)
		    try {
		     br.close();
		    } catch (IOException localIOException1) {
		    }
		  } finally {
		   if (br != null)
		    try {
		     br.close();
		    } catch (IOException localIOException2) {
		    }
		  }
		  return sb.toString();
		 }
	
	/*public PointBean getPoint() {
		return point;
	}
	
	public void setPoint(PointBean point) {
		this.point = point;
	}*/
	
	@Override
	public APP02DataTrans getModel() {
		return app02DataTrans;
	}
	
	public APP02DataTrans getApp02DataTrans() {
		return app02DataTrans;
	}
	
	public void setApp02DataTrans(APP02DataTrans app02DataTrans) {
		this.app02DataTrans = app02DataTrans;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
