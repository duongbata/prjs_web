package app.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.bean.App01DataTrans;
import app.bean.PointBean;
import app.logic.App01LogicIF;

@Controller
public class APP01Action{
	public static final String USER_DEFAULT_ID = "-1";
	
	public static final String OS_IOS_ID = "1"; 
			
	public static final String OS_ANDROID_ID = "2";
	
	public static final String OS_WINDOWS_ID = "3";
	
	public List<PointBean> listPoint;
	
	public String name;
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2796501846906521989L;

	private InfoValue info = new InfoValue();
	
	
	@Autowired
	private App01LogicIF app01Logic;
	
	@Action(value="/APP01_init"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="APP01",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		name = "Dortmund";
		App01DataTrans app01DataTrans = new App01DataTrans();
		app01DataTrans.setMessage("Hello" + info.getUser().getId());
		info.setDataTrans(app01DataTrans);
		return "success";
	}
	
	@Action(value="/App01_insertData"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("token")
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",location="APP02_init",type="redirectAction")
				, @Result(name="failure",location="ERROR", type="tiles")
				, @Result(name="invalid.token",location="InvalidToken_init", type="redirectAction")
			})
	public String insertData() {
		App01DataTrans app01DataTrans = new App01DataTrans();
		app01DataTrans.setMessage("Hello" + info.getUser().getId());
		info.setDataTrans(app01DataTrans);
		return "success";
	}
	
	@Action(value="/APP01_loadPoint"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			, results={
				@Result(name="success",type="json",params={"root","listPoint"})
				
			})
	public String loadPoint() {
		listPoint = new ArrayList<PointBean>();
		Random ran = new Random();
		for (int i = 1; i<50;i ++) {
			PointBean p = new PointBean(String.valueOf(ran.nextInt(i) + 1),String.valueOf(ran.nextInt(i)+2),String.valueOf(ran.nextInt(i)+3));
			listPoint.add(p);
		}
		return "success";
	}
	
	public InfoValue getInfo() {
		return info;
	}
	
	public void setInfo(InfoValue info) {
		this.info = info;
	}

	public List<PointBean> getListPoint() {
		return listPoint;
	}

	public void setListPoint(List<PointBean> listPoint) {
		this.listPoint = listPoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
