$(document).ready(function(){
	loadPoint();
	check();
});
var arr = [];
function check(){
	$("#myTable").tablesorter({
		headers : {
			0 : {
				sorter : false
			}
		}
	});
}
function loadPoint() {
	$('#graphdiv').empty();
	var obj = new Object();
	obj.id = '1';
	obj.name = 'bata';
	var link = CONTEXT_PATH + '/APP01_loadPoint';
	$.ajax({
		type : "POST",
		data : {'obj' : obj},
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
	// Change the selector if needed
	var $table = $('table.scroll'),
	    $bodyCells = $table.find('tbody tr:first').children(),
	    colWidth;

	// Adjust the width of thead cells when window resizes
	$(window).resize(function() {
	    // Get the tbody columns width array
	    colWidth = $bodyCells.map(function() {
	        return $(this).width();
	    }).get();
	    
	    // Set the width of thead columns
	    $table.find('thead tr').children().each(function(i, v) {
	        $(v).width(colWidth[i]);
	    });    
	}).resize(); // Trigger resize handler
}