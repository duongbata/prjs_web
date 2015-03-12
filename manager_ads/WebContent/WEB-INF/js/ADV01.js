/*
Please consider that the JS part isn't production ready at all, I just code it to show the concept of merging filters and titles together !
*/
$(document).ready(function(){
    $('.filterable .btn-filter').click(function(){
        /*var $panel = $(this).parents('.filterable');
        $filters = $panel.find('.filters input'),
        $tbody = $panel.find('.table tbody');*/
        if ($('.filters input').attr('disabled') == true) {
        	$('.filters input').attr('disabled', false);
        	$('.filters input').first().focus();
        } else {
        	$('.filters input').val('');
        	$('.filters input').attr('disabled', true);
            $('.table tbody').find('.no-result').remove();
            $('.table tbody').find('tr').show();
        }
    });

    $('.filterable .filters input').keyup(function(e){
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
        var $filteredRows = $rows.filter(function(){
            var value = $(this).find('td').eq(column).text().toLowerCase();
            return value.indexOf(inputContent) === -1;
        });
        /* Clean previous no-result if exist */
        $table.find('tbody .no-result').remove();
        /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
        $rows.show();
        $filteredRows.hide();
        /* Prepend no-result row if all rows are filtered */
        if ($filteredRows.length === $rows.length) {
            $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="'+ $table.find('.filters th').length +'">Không có kết quả</td></tr>'));
        }
    });
    $('.btnMore').click(function(){
    	var tr = $(this).closest('tr');
    	var id = tr.find(':hidden').val();
    	popupMore(id);
    });
    $('.btnDel').click(function(){
    	var tr = $(this).closest('tr');
    	var id = tr.find(':hidden').val();
    	deleteAdsPubApp(id);
    });
    $('#btnAdd').click(function(){
    	popupAdd();
    });
});

function popupAdd(){
	var url = CONTEXT_PATH+'/ADV01_initAddAds.action';
	var w = 600;
	var h = 600;
	var left = (screen.width/2)-(w/2);
	var top = (screen.height/2)-(h/2);
	var childWin = window.open(url, 'Add app', 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
	if(window.focus()) {
		childWin.focus();
	}
}

function popupMore(id){
	var url = CONTEXT_PATH+'/ADV01_moreInfo.action?appId='+id;
	var w = 600;
	var h = 600;
	var left = (screen.width/2)-(w/2);
	var top = (screen.height/2)-(h/2);
	var childWin = window.open(url, 'More Info', 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
	if(window.focus()) {
		childWin.focus();
	}
}

function getAds() {
	$('#listAdsForm').submit();
}

function deleteAdsPubApp(id){
	var isDel = confirm('Xóa dữ liệu ?');
	if(!isDel) {
		return;
	}
	var link = CONTEXT_PATH + '/ADV01_delAdsPubApp';
	$.ajax({
		type : "POST",
		url : link,
		data : "appId="+JSON.stringify(id),
		dataType : 'json',
		success : function(result) {
			alert ('Xóa '+id + ' thành công!');
			$('#listAdsForm').submit();
		},
		error : function(e) {
			alert ('Lỗi trong quá trình xóa');
		}
	});
}