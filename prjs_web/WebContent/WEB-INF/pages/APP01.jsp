<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP01.js"></script>
<script type="text/javascript" src="resources/js/dygraph-combined.js"></script>
<script type="text/javascript" src="resources/js/dygraph-combined-dev.js"></script>
<script type="text/javascript" src="resources/js/jquery.tablesorter.min.js"></script>
<div id="graphdiv"></div>
<style>
	table.scroll {
    /* width: 100%; */ /* Optional */
    /* border-collapse: collapse; */
    border-spacing: 0;
    border: 2px solid black;
}

table.scroll tbody,
table.scroll thead { display: block; }

thead tr th { 
    height: 30px;
    line-height: 30px;
    /* text-align: left; */
}

table.scroll tbody {
    height: 100px;
    overflow-y: auto;
    overflow-x: hidden;
}

tbody { border-top: 2px solid black; }

tbody td, thead th {
    /* width: 20%; */ /* Optional */
    border-right: 1px solid black;
    /* white-space: nowrap; */
}

tbody td:last-child, thead th:last-child {
    border-right: none;
}
</style>
<%-- <script type="text/javascript">
  
  g = new Dygraph(document.getElementById("graphdiv"),
	        [
	          [1,10,100],
	          [2,20,80],
	          [3,50,60],
	          [4,70,80]
	        ],
	        {
	          labels: [ "x", "A", "B" ]
	        });
</script> --%>
<div class="container">
	<div class="row">
		<s:form action="App01_insertData">
			<s:textfield name="name" value="%{name}"></s:textfield> <br/>
			<s:submit value="Submit"/>
		</s:form>
	</div>
</div>
<div class="container">
	<table class="scroll">
    <thead>
        <tr>
            <th>Head 1</th>
            <th>Head 2</th>
            <th>Head 3</th>
            <th>Head 4</th>
            <th>Head 5</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
        <tr>
            <td>Content 1</td>
            <td>Lorem ipsum dolor sit amet.</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
        <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
        <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
        <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
        <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
        <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
    </tbody>
	</table>
</div>
<div class="container">
	<input type="button" value="OK" id="btnClock">
	<div class="row">
		<table id="myTable" class="table tablesorter table-bordered">
<thead>
<tr>
<th class="info">Row ID</th>
<th class="info">Order ID</th>
<th class="info">Order Date</th>
<th class="info">Order Priority</th>
<th class="info">Order Quantity</th>
</tr>
</thead>
<tbody> 
 <tr><td>1</td><td>3</td><td>13-10-2010</td><td>Low</td><td>6</td></tr>
 <tr><td>49</td><td>293</td><td>1-10-2012</td><td>High</td><td>49</td></tr>
 <tr><td>50</td><td>293</td><td>1-10-2012</td><td>High</td><td>27</td></tr>
 <tr><td>80</td><td>483</td><td>10-7-2011</td><td>High</td><td>30</td></tr>
 <tr><td>85</td><td>515</td><td>28-8-2010</td><td>Not Specified</td><td>19</td></tr>
 <tr><td>86</td><td>515</td><td>28-8-2010</td><td>Not Specified</td><td>21</td></tr>
 <tr><td>97</td><td>613</td><td>17-6-2011</td><td>High</td><td>12</td></tr>
</tbody>
</table>
	</div>
</div>
