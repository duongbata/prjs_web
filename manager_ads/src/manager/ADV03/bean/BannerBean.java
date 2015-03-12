package manager.ADV03.bean;

import java.util.Date;
import java.util.Map;

import manager.common.util.CustomerJsonDateDeserialize;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class BannerBean {
	private int bannerId;
	
	private int campaignId;
	
	private String campaignName;
	
	private String bannerName;
	
	private String bannerDescription;
	
	private int bannerType;
	
	private String typeName;
	
	private Date startTime;
	
	private Date stopTime;
	
	private int bannerStatus;
	
	private String statusName;
	
	private int statusId;
	
	private String image1;
	
	private String image2;
	
	private String androidUrl;
	
	private String iosUrl;
	
	private String windowsUrl;
	
	private String maxClick;
	
	private String maxView;
	
	private String realClick;
	
	private String realView;
	
	private int userId;
	
	private String osTarget;
	
	private boolean flagSelected;
	
	private String bannerTypeName;
	
	private String maxClickPerDay;
	
	private String maxViewPerDay;
	
	public int getBannerId() {
		return bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getBannerDescription() {
		return bannerDescription;
	}

	public void setBannerDescription(String bannerDescription) {
		this.bannerDescription = bannerDescription;
	}
	
	public int getBannerType() {
		return bannerType;
	}

	public void setBannerType(int bannerType) {
		this.bannerType = bannerType;
	}

	public int getBannerStatus() {
		return bannerStatus;
	}

	public void setBannerStatus(int bannerStatus) {
		this.bannerStatus = bannerStatus;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public Date getStartTime() {
		return startTime;
	}
	
	@JsonDeserialize(using=CustomerJsonDateDeserialize.class)
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}
	
	@JsonDeserialize(using=CustomerJsonDateDeserialize.class)
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/*public List<String> getListOs() {
		return listOs;
	}

	public void setListOs(List<String> listOs) {
		this.listOs = listOs;
	}*/

	public String getOsTarget() {
		return osTarget;
	}

	public void setOsTarget(String osTarget) {
		this.osTarget = osTarget;
	}

	public String getMaxClick() {
		return maxClick;
	}

	public void setMaxClick(String maxClick) {
		this.maxClick = maxClick;
	}

	public String getMaxView() {
		return maxView;
	}

	public void setMaxView(String maxView) {
		this.maxView = maxView;
	}

	public String getRealClick() {
		return realClick;
	}

	public void setRealClick(String realClick) {
		this.realClick = realClick;
	}

	public String getRealView() {
		return realView;
	}

	public void setRealView(String realView) {
		this.realView = realView;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getFlagSelected() {
		return flagSelected;
	}

	public void setFlagSelected(boolean flagSelected) {
		this.flagSelected = flagSelected;
	}

	public String getAndroidUrl() {
		return androidUrl;
	}

	public void setAndroidUrl(String androidUrl) {
		this.androidUrl = androidUrl;
	}

	public String getIosUrl() {
		return iosUrl;
	}

	public void setIosUrl(String iosUrl) {
		this.iosUrl = iosUrl;
	}

	public String getWindowsUrl() {
		return windowsUrl;
	}

	public void setWindowsUrl(String windowsUrl) {
		this.windowsUrl = windowsUrl;
	}

	public String getBannerTypeName() {
		return bannerTypeName;
	}

	public void setBannerTypeName(String bannerTypeName) {
		this.bannerTypeName = bannerTypeName;
	}

	public String getMaxClickPerDay() {
		return maxClickPerDay;
	}

	public void setMaxClickPerDay(String maxClickPerDay) {
		this.maxClickPerDay = maxClickPerDay;
	}

	public String getMaxViewPerDay() {
		return maxViewPerDay;
	}

	public void setMaxViewPerDay(String maxViewPerDay) {
		this.maxViewPerDay = maxViewPerDay;
	}
	
}
