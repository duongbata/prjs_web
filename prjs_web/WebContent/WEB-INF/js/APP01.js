$(document).ready(function(){
	loadPoint();
});
var arr = [];
function loadPoint() {
	$('#graphdiv').empty();
	var link = CONTEXT_PATH + '/APP01_loadPoint';
	$.ajax({
		type : "POST",
		url : link,
		dataType : 'json',
		success : function(listPoint) {
			$.each(listPoint,function(key,value){
				var small = [];
				small.push(value.a);
				small.push(value.b);
				small.push(value.c);
				arr.push(small);
			});
			g = new Dygraph(document.getElementById("graphdiv"),
			       arr,
			        {
			          labels: [ "x", "A", "B" ]
			        });
		},
		error : function(e) {
			alert ('Lỗi trong quá trình sửa');
		}
	});
	
}