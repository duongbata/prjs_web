package app.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.bean.App01DataTrans;
import app.bean.PointBean;
import app.logic.App01LogicIF;

@Controller
@Namespace("/")
@InterceptorRefs({
	@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
	, @InterceptorRef("basicStack")
})
public class APP01Action{
	public static final String USER_DEFAULT_ID = "-1";
	
	public static final String OS_IOS_ID = "1"; 
			
	public static final String OS_ANDROID_ID = "2";
	
	public static final String OS_WINDOWS_ID = "3";
	
	public List<PointBean> listPoint;
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2796501846906521989L;

	private InfoValue info = new InfoValue();
	
	
	@Autowired
	private App01LogicIF app01Logic;
	
	@Action(value="/APP01_init"
			, results={
				@Result(name="success",location="APP01",type="tiles")
				, @Result(name="failure",location="ERROR", type="tiles")
			})
	public String init() {
		
		App01DataTrans app01DataTrans = new App01DataTrans();
		listPoint = new ArrayList<PointBean>();
		PointBean p1 = new PointBean("2", "2014-01-03", "anh hung");
		PointBean p2 = new PointBean("1", "2015-01-03", "dai dao");
		PointBean p3 = new PointBean("3", "2015-02-03", "tieu ngao");
		app01DataTrans.setMessage("Hello" + info.getUser().getId());
		info.setDataTrans(app01DataTrans);
		return "success";
	}
	
	@Action(value="/APP01_loadPoint"
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

}
