package manager.ADV03.logic;

import java.util.List;
import java.util.Map;

import manager.ADV03.bean.BannerBean;
import manager.ADV03.bean.CampaignBean;

public interface ADV03LogicIF {
	List<BannerBean> getListBanner(CampaignBean campaign);
	
	BannerBean getBannerById(int bannerId);
	
	Map<Integer, String> getAllCampaign();
	
	Map<Integer, String> getAllBannerStatus();
	
	Map<Integer, String> getAllBannerType();
	
	void editBanner(BannerBean bannerEdit);
	
	void insertSampleBanner(BannerBean bannerInsert);
	
	void deleteBanner(BannerBean bannerId);
	
	List<CampaignBean> listCampaignOfUser(int userId);
	
	List<BannerBean> listSampleBannerOfUser(BannerBean banner);
	
	void insertBannerToCampaign(List<BannerBean> listBanner, int campaignId,int userId);
	
	void updateBannerConfig(BannerBean banner);
	
	void saveNewCampaign(List<CampaignBean> listNewCampaign, int userId);
}
