$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip({
		placement: 'top',
		template : '<div class="tooltip" role="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner">ABCD</div></div>'
	});
	$('#myTab a').click(function(e){
		e.preventDefault();
		$(this).tab('show');
	});
	$('#demo').click(function(){
		callAlert('Configuration','If you are not the one');
	});
});

$(function(){
	var showPower = function() {
		$(this).popover('show');
	};
	var hidePower = function() {
		$(this).popover('hide');
	};
	
	$('.tagTeam').popover({
		placement : 'bottom',
		html : true,
		content : function() {
			var table = $('<table class="table table-bordered"></table>');
			for (var i = 0;i<5;i++) {
				var tr = $('<tr></tr>');
				var head = $('<td>Info</td>');
				var body = $('<td>Detail</td>');
				tr.append(head);
				tr.append(body);
				table.append(tr);
			}
			
			return table;
		}
	}).focus(showPower)
	.blur(hidePower)
	.hover(showPower,hidePower);
});