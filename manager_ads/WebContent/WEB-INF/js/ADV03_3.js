$(document).ready(function(){
	$('#btnOk').click(function(){
		ajaxInsertBanner();
	});
});

function ajaxInsertBanner(){
	var banner = new Object();
	banner.bannerId = $('#id').val();
	banner.bannerName = $('#name').val();
	banner.bannerDescription = $('#description').val();
	banner.campaignId = $('#campaignId').val();
	banner.startTime = $('#startTime').val() + ':00';
	banner.stopTime = $('#stopTime').val() + ':00';
	banner.statusId = $('#statusId').val();
	banner.image1 = $('#image1').val();
	banner.image2 = $('#image2').val();
	banner.url = $('#url').val();
	banner.bannerType = $('#bannerType').val();
	var allOs = {};
	$('.cssOs').each(function(){
		var key = $(this).attr('id');
		if($(this).prop('checked')) {
			allOs[key] = true;
		} 
		/*else {
			allOs[key] = false;
		}*/
	});
	banner.allOs = allOs;
	var link = CONTEXT_PATH + '/ADV03_insertBanner';
	$.ajax({
		type : "POST",
		url : link,
		data : "banner="+JSON.stringify(banner),
		dataType : 'json',
		success : function(result) {
			try {
		        window.opener.getBanner();
		    }
		    catch (err) {}
		    window.opener.focus();
		    window.close();
		},
		error : function(e) {
			alert ('Lỗi trong quá trình insert');
		}
	});
}