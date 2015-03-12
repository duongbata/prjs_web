$(document).ready(function(){
	$('#btnAdd').click(function(){
		var adnetId = window.adnetId;
		var location = window.location_app;
		addApp(adnetId,location);
	});
});

function addApp(adnetId,location) {
	var apps =[];
	$('input[name="checkApp"]:checked').each(function(){
		var app = new Object();
		app.adsId = $(this).closest('tr').find('.adsId').val();
		app.adsName = $(this).closest('tr').find('.adsName').val();
		app.adsImg = $(this).closest('tr').find('.adsImg').val();
		apps.push(app);
	});
	window.opener.getAppFormPopup(adnetId,apps,location);
	window.opener.focus();
    window.close();
}