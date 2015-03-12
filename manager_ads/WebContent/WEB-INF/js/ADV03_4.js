$(document).ready(function(){
	$('.datetimepicker').datetimepicker();
    $('#btnAdd').click(function(){
    	addCampaign();
    });
});

$(document).on('click','.filterable .btn-filter',function(){
	if ($('.filters input').prop('disabled') == true) {
    	$('.filters input').attr('disabled', false);
    	$('.filters input').first().focus();
    } else {
    	$('.filters input').val('');
    	$('.filters input').attr('disabled', true);
        $('.table tbody').find('.no-result').remove();
        $('.table tbody').find('tr').show();
    }
});

$(document).on('keyup','.filterable .filters input',function(e){
	/* Ignore tab key */
    var code = e.keyCode || e.which;
    if (code == '9') return;
    /* Useful DOM data and selectors */
    var $input = $(this),
    inputContent = $input.val().toLowerCase(),
    $panel = $input.parents('.filterable'),
    column = $panel.find('.filters th').index($input.parents('th')),
    $table = $panel.find('.table'),
    $rows = $table.find('tbody tr');
    /* Dirtiest filter function ever ;) */
    /* Clean previous no-result if exist */
    $table.find('tbody .no-result').remove();
    var $filteredRows = $rows.filter(function(){
    	var arrInput = $(this).find('td').eq(column).find('.forSearch');
    	if (arrInput.length != 0) {
    		var value =  $(this).find('td').eq(column).find('.forSearch').val().toLowerCase();
        	return value.indexOf(inputContent) === -1;
    	} else {
    		var value = $(this).find('td').eq(column).text().toLowerCase();
    		return value.indexOf(inputContent) === -1;
    	}
    });
    
    /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
    $rows.show();
    $filteredRows.hide();
    /* Prepend no-result row if all rows are filtered */
    if ($filteredRows.length === $rows.length) {
        $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="'+ $table.find('.filters th').length +'">Không có kết quả</td></tr>'));
    }
});

function addCampaign() {
	var isDisableSave = $('#btnSave').attr('disabled');
	if(isDisableSave) {
		$('#btnSave').removeAttr('disabled');
	}
	var numCamp = $('#listCamp').children().length;
	var tr = $('<tr></tr>');
	
	var tdId = $('<td></td>');
	tdId.append('<label>'+(numCamp+1)+'</label>');
	tr.append(tdId);
	
	var tdId = $('<td></td>');
	tdId.append('<input type="text" name="listCampaign['+numCamp+'].campaignId" class="form-control formSearch"/>');
	tr.append(tdId);
	
	var tdName = $('<td></td>');
	tdName.append('<input type="text" name="listCampaign['+numCamp+'].campaignName" class="form-control formSearch"/>');
	tr.append(tdName);
	
	var tdDes = $('<td></td>');
	tdDes.append('<input type="text" name="listCampaign['+numCamp+'].description" class="form-control formSearch"/>');
	tr.append(tdDes);
	
	var divDate = $('<div class="input-group date datetimepicker"></div>');
	var spanDate = $('<span class="input-group-addon"><span class="glyphicon-calendar glyphicon"></span></span>');
	divDate.append(spanDate);
	
	var tdStartTime = $('<td style="width:200px"></td>');
	divDate.append('<input type="text" name="listCampaign['+numCamp+'].startTime" class="form-control formSearch"/>');
	tdStartTime.append(divDate);
	tr.append(tdStartTime);
	
	var divDate2 = $('<div class="input-group date datetimepicker"></div>');
	var spanDate2 = $('<span class="input-group-addon"><span class="glyphicon-calendar glyphicon"></span></span>');
	divDate2.append(spanDate2);
	
	var tdStopTime = $('<td style="width:200px"></td>');
	divDate2.append('<input type="text" name="listCampaign['+numCamp+'].stopTime" class="form-control formSearch"/>');
	tdStopTime.append(divDate2);
	tr.append(tdStopTime);
	
	var tdEdit = $('<td></td>');
	tr.append(tdEdit);
	
	var tdDel = $('<td></td>');
	tr.append(tdDel);
	
	$('#listCamp').append(tr);
	$('.datetimepicker').datetimepicker();
}