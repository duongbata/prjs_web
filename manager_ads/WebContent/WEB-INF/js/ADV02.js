$(document).ready(function(){
	//Location : Banner, Popup,Open,Exit
	$('.addBanner').click(function(){
		var adnetId = $(this).attr('name');
		popupListApp(adnetId,'Banner');
	});
	$('.addPopup').click(function(){
		var adnetId = $(this).attr('name');
		popupListApp(adnetId,'Popup');
	});
	
	$('.addOpen').click(function(){
		var adnetId = $(this).attr('name');
		popupListApp(adnetId,'Open');
	});
	
	$('.addExit').click(function(){
		var adnetId = $(this).attr('name');
		popupListApp(adnetId,'Exit');
	});
	
/*	$('.btnDel').on('click',function(){
		$(this).closest('tr').remove();
	});*/
});

$(document).on('click','.btnDel',function(){
	var isDel = confirm('Xóa dữ liệu ?');
	if (!isDel) {
		return;
	}
	var name = $(this).attr('name');
	updateRow(name);
	$(this).closest('tr').remove();
});

function popupListApp(adnetId,location) {
	var url = CONTEXT_PATH+'/ADV02_listApp.action';
	var w = 600;
	var h = 600;
	var left = (screen.width/2)-(w/2);
	var top = (screen.height/2)-(h/2);
	var childWin = window.open(url, 'Add app', 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
	childWin.adnetId = adnetId;
	childWin.location_app = location;
	if(window.focus()) {
		childWin.focus();
	}
}

function getAppFormPopup(adnetId,apps,location){
	$(apps).each(function(){
		addRow(adnetId, this,location);
	});
}

function updateRow(name) {
	var arr = name.split("_");
	var adnetId = arr[0];
	var location = arr[1];
	var rowIdx = parseInt(arr[2]);
	var numRow = $('#body'+location+'_'+adnetId).children().length;
	if (rowIdx == (numRow-1)) {
		return;
	}
	var idx = rowIdx+1;
	for(;idx<numRow;idx++){
		var rowUpdate = $('[name="'+adnetId+'_'+location+'_'+idx+'"]').closest('tr');
		rowUpdate.find('.adId').attr('name','listAdnetwork['+adnetId+'].listAds'+location+'['+(idx-1)+'].id');
		rowUpdate.find('.adImg').attr('name','listAdnetwork['+adnetId+'].listAds'+location+'['+(idx-1)+'].urlImage');
		rowUpdate.find('.adAndroid').attr('name','listAdnetwork['+adnetId+'].listAds'+location+'['+(idx-1)+'].perAndroid');
		rowUpdate.find('.adIos').attr('name','listAdnetwork['+adnetId+'].listAds'+location+'['+(idx-1)+'].perIos');
		rowUpdate.find('.adWin').attr('name','listAdnetwork['+adnetId+'].listAds'+location+'['+(idx-1)+'].perWindow');
		rowUpdate.find('.btnDel').attr('name',adnetId+'_'+location+'_'+(idx-1));
	}
}

function addRow(adnetId,app,location) {
	var form = 'ADV02_confirm_';
	var numRow = $('#body'+location+'_'+adnetId).children().length;
	var tblBanner = $('#body'+location+'_'+adnetId);
	
	var row = $('<tr></tr>');
	
	var cellId = $('<td "vertical-align: middle;"></td>');
	cellId.append(app.adsId);
	var hidenId = '<input id="'+form+'listAdnetwork_'+adnetId+'__listAds'+location+'_'+numRow+'__id" type="hidden" value="'+app.adsId+'" name="listAdnetwork['+adnetId+'].listAds'+location+'['+numRow+'].id" class="adId">';
	cellId.append(hidenId);
	row.append(cellId);
	
	var cellImg = $('<td style="vertical-align: middle;text-align: center"></td>');
	if (app.adsImg != null && app.adsImg != '') {
		var img = '<img width="40px" height="50px" src="'+app.adsImg+'">';
		var hidenImg = '<input id="'+form+'listAdnetwork_'+adnetId+'__listAds'+location+'_'+numRow+'__urlImage" type="hidden" value="'+app.adsImg+'" name="listAdnetwork['+adnetId+'].listAds'+location+'['+numRow+'].urlImage" class="adImg">';
		cellImg.append(img);
		cellImg.append(hidenImg);
	}
	
	row.append(cellImg);
	
	var cellPerAnd = $('<td style="vertical-align: middle;text-align: center"></td>');
	var txtPerAnd = '<input id="'+form+'listAdnetwork_'+adnetId+'__listAds'+location+'_'+numRow+'__perAndroid" type="text" value="" name="listAdnetwork['+adnetId+'].listAds'+location+'['+numRow+'].perAndroid" class="adAndroid">';
	cellPerAnd.append(txtPerAnd);
	row.append(cellPerAnd);
	
	var cellPerIos = $('<td style="vertical-align: middle;text-align: center"></td>');
	var txtPerIos = '<input id="'+form+'listAdnetwork_'+adnetId+'__listAds'+location+'_'+numRow+'__perIos" type="text" value="" name="listAdnetwork['+adnetId+'].listAds'+location+'['+numRow+'].perIos" class="adIos">';
	cellPerIos.append(txtPerIos);
	row.append(cellPerIos);
	
	var cellPerWindow = $('<td style="vertical-align: middle;text-align: center"></td>');
	var txtPerWindow = '<input id="'+form+'listAdnetwork_'+adnetId+'__listAds'+location+'_'+numRow+'__perWindow" type="text" value="" name="listAdnetwork['+adnetId+'].listAds'+location+'['+numRow+'].perWindow" class="adWin">';
	cellPerWindow.append(txtPerWindow);
	row.append(cellPerWindow);
	
	var cellDel = $('<td style="vertical-align: middle;text-align: center"></td>');
	var btnDel = '<button class="btn btn-default btn-xs btnDel" type="button" name="'+adnetId+'_'+location+'_'+numRow+'"><span class="glyphicon glyphicon-remove"></span> Del</button>';
	cellDel.append(btnDel);
	row.append(cellDel);
	
	tblBanner.append(row);
}