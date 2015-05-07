<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP02.js"></script>
<link type="text/css" rel="stylesheet" href="resources/css/APP02.css" />
<link type="text/css" rel="stylesheet" href="resources/css/scroll_table/960.css" />
<link type="text/css" rel="stylesheet" href="resources/css/scroll_table/defaultTheme.css" />
<link type="text/css" rel="stylesheet" href="resources/css/scroll_table/myTheme.css" />
<script type="text/javascript" src="resources/js/jquery.fixedheadertable.js"></script>
<div class="container">
	<!-- <input id='no-popover' type='text' />
	<input id='has-popover' type='text' placeholder='hover or focus me' /> -->
	<table class="table table-bordered">
		<tr>
			<td class="info has-popover" width="100px !important"> XXXX</td>
			<td>
				<p class="dataP">data P 1</p>
			</td>
		</tr>
	</table>	
	<div class="row">
		<s:form action="APP02_updatePoint">
			<s:textfield name="message"/>
			<s:submit value="Submit" tabindex="-1"/>
		</s:form>
	</div>
</div>
<div class="container">
	<div class="row">
		<s:textfield name="message"></s:textfield>
		<s:set var="mess" value="%{message}"></s:set>
		<p>${mess}</p>
		<s:i18n name="message"></s:i18n>
	</div>
	<div class="row">
		<div id="broadCastScroll" style="height: 200px; overflow: auto;">
      <table id="broadCast" class="table table-bordered">
      		<tr>
      			<td class="info" style="height:20px">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info" style="height:20px">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      		<tr>
      			<td class="info">
      				XXXXXX
      			</td>
      			<td>
      				YYYYYY
      			</td>
      		</tr>
      </table>
</div>
	</div>
	<div class="row" style="margin-top: 10px!important">
		<div class="bs-example">
		    <ul class="nav nav-tabs" id="myTab">
		    	<li class="active">
		    		<a href="#sectionA">SectionA</a>
		    	</li>
		    	<li>
		    		<a href="#sectionB">SectionB</a>
		    	</li>
		    	<li>
		    		<a href="#sectionC">SectionC</a>
		    	</li>
		    	<li class="dropdown">
		    		<a data-toggle="dropdown" class="dropdown-toggle" href="#">Dropdown <b class="caret"></b></a>
		    		<ul class="dropdown-menu">
		    			<li>
		    				<a href="#dropdown1">Dropdown1</a>
		    				<a href="#dropdown2">Dropdown2</a>
		    			</li>
		    		</ul>
		    	</li>
		    </ul>
		    <div class="tab-content">
		    	<div id="sectionA" class="tab-pane fade in active">
		    		<h2>SectionA</h2>
		    	</div>
		    	<div id="sectionB" class="tab-pane fade">
		    		<h2>SectionB</h2>
		    	</div>
		    	<div id="sectionC" class="tab-pane fade">
		    		<h2>SectionC</h2>
		    	</div>
		    	<div id="dropdown1" class="tab-pane fade">
		    		<h2>Dropdown1</h2>
		    	</div>
		    	<div id="dropdown2" class="tab-pane fade">
		    		<h2>Dropdown2</h2>
		    	</div>
		    </div>
		</div>
	</div>
	<div class="row" style="margin-top: 10px!important">
		<ul class="list-inline">
			<li>
				<a href="#" class="a_tool" data-toggle="tooltip" data-original-title="Default Title">Default</a>
			</li>
			<li>
				<a href="#" class="a_tool" data-toggle="tooltip" data-original-title="Dortmund">Dortmund</a>
			</li>
			<li>
				<a href="#" class="a_tool" data-toggle="tooltip" data-original-title="Next">previous</a>
			</li>
		</ul>
	</div>
</div>
<div class="container_16">
		<div class="grid_12 height250">
    			<table class="fancyTable" id="myTable01">
    			    <thead>
    			        <tr>
    			            <th width="200px;">Browser</th>
    			            <th width="600px;">Visits</th>
    			            <th width="200px;">Pages/Visit</th>
    			        
    			        </tr>
    			    </thead>
    			    <tbody>
    			        <tr>
    			            <td class="has-popover">
    			            	Firefox
    			            </td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			           
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			            
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			           
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			            
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			           
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			            
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			            
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			            
    			        </tr>
    			        <tr>
    			            <td class="has-popover">Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			           
    			        </tr>
    			        <tr>
    			            <td>Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			         
    			        </tr>
    			        <tr>
    			            <td>Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			           
    			        </tr>
    			        <tr>
    			            <td>Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			           
    			        </tr>
    			        <tr>
    			            <td>Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			            
    			        </tr>
    			        <tr>
    			            <td>Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			           
    			        </tr>
    			        <tr>
    			            <td>Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			            
    			        </tr>
    			        <tr>
    			            <td>Firefox</td>
    			            <td>1,990</td>
    			            <td>3.11</td>
    			          
    			        </tr>
    			    </tbody>
    			</table>
    		</div>
    		<div class="clear"></div>
</div>

