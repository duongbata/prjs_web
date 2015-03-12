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