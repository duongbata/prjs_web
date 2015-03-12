$(document).ready(function(){
	$('.btnAddProp').click(function(){
		addProperty();
	});
});

$(document).on('click','.btnDelProp',function(){
	var numRow = $('#tbodyProp').children().length;
	
	var id = $(this).prop('id');
	var idx = parseInt(id.split('_')[1]);
	if (idx == (numRow - 1)) {
		$(this).closest('tr').remove();
		return;
	}
	for (var i = (idx+1); i < numRow;i++) {
		var nextId = i + "_prop";
		var nextRow = $('#'+nextId);
		var txtPropName = nextRow.find('.txtPropName');
		txtPropName.attr('name','listProperty['+(i-1)+'].propertyName');
		
		var txtPropValue = nextRow.find('.txtPropValue');
		txtPropValue.attr('name','listProperty['+(i-1)+'].propertyValue');
		
		var btnDel = nextRow.find('.btnDelProp');
		btnDel.attr('id','btnDel_'+(i-1));
		nextRow.attr('id',(i-1)+'_prop');
	}
	$(this).closest('tr').remove();
});

function validateInsert(){
	
}

function addProperty() {
	var numRow = $('#tbodyProp').children().length;
	
	var row = $('<tr id="'+numRow+'_prop"></tr>');
	
	var cellName = $('<td style="text-align:center"></td>');
	var txtName = $('<input type="text" class="form-control txtPropName" name="listProperty['+numRow+'].propertyName"/>');
	cellName.append(txtName);
	row.append(cellName);
	
	var cellValue = $('<td style="text-align:center"></td>');
	var txtValue = $('<input type="text" class="form-control txtPropValue" name="listProperty['+numRow+'].propertyValue"/>');
	cellValue.append(txtValue);
	row.append(cellValue);
	
	var cellBtnDel = $('<td style="text-align:center; vertical-align:middle;"></td>');
	var btnDel = $('<input type="button" class="btn btn-default btn-xs btn-primary btnDelProp" id="btnDel_'+numRow+'" value="Delete"/>');
	cellBtnDel.append(btnDel);
	row.append(cellBtnDel);
	
	$('#tbodyProp').append(row);
}