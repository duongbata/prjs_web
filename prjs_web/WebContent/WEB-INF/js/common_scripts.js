$(document).ready(function(){
	$('#btnClick').click(function(){
		callAjax();
	});
});

function callAjax() {
	var obj = "trung";
	var link = '/manager_ads/callAjax';
	$.ajax({
		type : "POST",
		url : link,
		data : "name="+JSON.stringify(obj),
		dataType : 'json',
		success : function(result) {
			alert(result.name);
		},
		error : function(e) {
			alert('Error Result');
		}
	});
}

//Alert manual
function callAlert(header,body) {
	var myModal = $('#myModal');
	var modalHeader = myModal.find('.modal-header');
	modalHeader.empty();
	modalHeader.append('<p>'+header+'</p>');
	var modalBody = myModal.find('.modal-body');
	modalBody.empty();
	modalBody.append('<p>'+body+'</p>');
	$('#myModal').modal('show');
}