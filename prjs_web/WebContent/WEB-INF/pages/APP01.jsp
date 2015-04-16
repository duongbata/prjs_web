<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP01.js"></script>
<script type="text/javascript" src="resources/js/dygraph-combined.js"></script>
<script type="text/javascript" src="resources/js/dygraph-combined-dev.js"></script>
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
			<s:token/>
		</s:form>
	</div>
</div>
</script> --%>
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