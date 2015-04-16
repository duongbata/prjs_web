$(document).ready(function(){
	  $('#broadCastScroll').on('scroll',function(e) {
		  /*console.log(($('#broadCast').height()
			         - $(this).height() + 22)
			         + "\t" + $(this).scrollTop());*/
		  console.log($(this).scrollTop());
      });
	  $('#myTab a').click(function(e){
		  e.preventDefault();
		  $(this).tab('show');
	  });
	  
	  $('.a_tool').tooltip({
		  placement:'right',
		  html:true,
		  content:function(){
			  var table = $('<table class="table table-bordered"></table>');
	        	for (var i = 0; i<5;i++) {
	        		var tr = $('<tr></tr>');
	            	var td1 = $('<td class="info">Đại thánh vương'+i+'</td>');
	            	var td2 = $('<td>'+i+'</td>');
	            	tr.append(td1);
	            	tr.append(td2);
	            	table.append(tr);
	        	}
	        	
	        	return table;
		  }
	  });
	  $('#myTable01').fixedHeaderTable({altClass: 'odd'});
	    
//	    $('#myTable01').fixedHeaderTable('show', 1000);
});

$(function () {
    var showPopover = function () {
        $(this).popover('show');
    }
    , hidePopover = function () {
        $(this).popover('hide');
    };
    $('.has-popover').popover({
    	placement : 'right',
    	html : true,
        content: function(){
        	var table = $('<table class="table table-bordered"></table>');
        	for (var i = 0; i<5;i++) {
        		var tr = $('<tr></tr>');
            	var td1 = $('<td class="info">Đại thánh vương'+i+'</td>');
            	var td2 = $('<td>'+i+'</td>');
            	tr.append(td1);
            	tr.append(td2);
            	table.append(tr);
        	}
        	
        	return table;
        },
        trigger: 'manual'
    })
    .focus(showPopover)
    .blur(hidePopover)
    .hover(showPopover, hidePopover);
});