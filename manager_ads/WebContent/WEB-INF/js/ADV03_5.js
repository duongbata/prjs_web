$(document).ready(function(){
	$('#btnAddBanner').click(function(){
		var campaignId = $('#insertForm_campaignId').val();
		$('#insertForm').submit();
		window.opener.listBannerOfCampaign(campaignId);
		window.opener.focus();
	    window.close();
	});
});