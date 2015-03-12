$(document).ready(function(){
	$('#btnAddRow').click(function(){
		addRow();
	});
	$('#btnDelRow').click(function(){
		btnDelRow();
	});
});

function addRow(){
	var numRow = $('#tblUser tr').length;
	var tblUser = $('#tblUser');
	
	var row = $('<tr></tr>');
	var cellId = $('<td></td>');
	var txtId = '<input type="text" id="newRow_listUser_'+numRow+'__id" name="listUser['+numRow+'].id">';
	cellId.append(txtId);
	row.append(cellId);
	
	var cellName = $('<td></td>');
	var txtName = '<input type="text" id="newRow_listUser_'+numRow+'__name" name="listUser['+numRow+'].name">';
	cellName.append(txtName);
	row.append(cellName);
	tblUser.append(row);
}

function btnDelRow(){
	var idx = $('#tblUser tr').length - 1;
	var table = document.getElementById('tblUser');
	table.deleteRow(idx);
}