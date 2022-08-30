<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container {
	width: 2000px;
	height: 1000px;
	background-color: yellow;
	margin : 0 auto;
	display : flex;
	justify-content: space-between;
}

#left_div {
	width: 900px;
	height: 100%;
	background-color: pink;

}

#right_div {
	width: 900px;
	height: 100%;
	background-color: blue;
	margin: 0 auto;

}

#ranking_div {
	width: 500px;
	height: 300px;
	background-color: green;
	margin: 0 auto;
	margin-bottom: 100px;
}

#menu_list_div {
	width: 500px;
	height: 600px;
	background-color: red;
	margin: 0 auto;
}

#right_div_inner_table {
	width: 70%;
	height: 70%;
	margin: 0 auto;
	margin-top: 10%;
	background-color: white;
	border: 1px solid black;
}

tr, td {
	border: 1px solid black;
	background-color: grey;
}
</style>
<script>
function event1(){
	location.href="test.ca";
}
</script>
</head>
<body>
<c:set var="menu" value="${cafe}"/>
<!-- 컨테이너 div 시작 -->
<div id='container'>
	<!-- left div 시작 --> 
	<div id='left_div'>
		<div id='ranking_div'>
		
		</div>
		<div id='menu_list_div'>
			<h3>${menu}</h3>
			<input type="button" value="button" onclick="event1()"></input>
			<img src="./assets/images/black_honey_tea.jpg" width="70px" height="70px">
		</div>
	</div>
	<div id='right_div'>
		<table id='right_div_inner_table'>
			<tr>
				<td>
					
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>