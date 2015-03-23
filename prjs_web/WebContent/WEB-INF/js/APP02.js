$(document).ready(function(){
	$('#btnAjax').click(function(){
		var a = $('#p_a').val();
		var link = CONTEXT_PATH + '/APP02_callAjax';
		$.ajax({
			type : "POST",
			url : link,
			data: {"point_a":a},
			dataType : 'json',
			success : function(point) {
				$('#p_a').val(point.a);
			},
			error : function(e) {
				alert ('Error');
			}
		});
	});
});