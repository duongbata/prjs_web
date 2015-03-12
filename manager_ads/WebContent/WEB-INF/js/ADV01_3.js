$(document).ready(function(){
	$('#btnOk').click(function(){
		ajaxAddAds();
	});
});

function ajaxAddAds(){
	var ads = new Object();
	ads.id = $('#id').val();
	if (ads.id == null || ads.id == '') {
		alert('Hãy điền id của app');
		return;
	}
	ads.name = $('#name').val();
	ads.description = $('#description').val();
	ads.osId = $('#osId').val();
	ads.url = $('#url').val();
	ads.statusId = $('#statusId').val();
	ads.message = $('#message').val();
	ads.page = $('#page').val();
	ads.adsAdnetworkId = $('#adsAdnetworkId').val();
	ads.adsAdnetworkIdBk = $('#adsAdnetworkIdBk').val();
	ads.networkId = $('#networkId').val();
	var link = CONTEXT_PATH + '/ADV01_addAds';
	$.ajax({
		type : "POST",
		url : link,
		data : "ads="+JSON.stringify(ads),
		dataType : 'json',
		success : function(result) {
			try {
		        window.opener.getAds();
		    }
		    catch (err) {}
		    window.opener.focus();
		    window.close();
		},
		error : function(e) {
			alert ('Lỗi trong quá trình add');
		}
	});
}