<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project | ★ bucks</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style>

p , h1 , h2 , h3 {
	font-family: 'Do Hyeon', sans-serif;
}

p {
	font-size: 22px;
}

#container {
	width: 2000px;
	height: 1000px;
	background-color: ;
	background: transparent;
	margin: 0 auto;
	display: flex;
	justify-content: space-between;
}

#left_div {
	width: 900px;
	height: 100%;
	padding-left: 200px;
	background-color: ;
	background: transparent;
}

#right_div {
	width: 630px;
	height: 100%;
	background-color: ;
	background: transparent;
	margin: 0 auto;
	padding-top: 3%;
}

#ranking_div {
	width: 500px;
	height: 300px;
	background-color: ;
	background: transparent;
	padding-top: 5%;
	margin: 0 auto;
	margin-bottom: 100px;
}

#menu_list_div {
	width: 500px;
	height: 600px;
	background-color: ;
	background: transparent;
	margin: 0 auto;
}

#right_div_inner_table {
	width: 70%;
	height: 70%;
	margin: 0 auto;
	/*margin-top: 10%;*/
	background-color: white;
	background: transparent;
	border: 1px solid black;
}

tr, td {
	border: 1px solid black;
	background-color: white;
	background: transparent;
}

#menu_list_div {
	width: 100%;
	height: 100%;
	display: grid;
	grid-template-columns: 33% 33% 33%;
	grid-column-gap: 10px;
	grid-row-gap: 1em;
	text-align: center;
}

#menu_list_div p {
	/*width: 181px;
	padding-left: 56px;*/
	width: 200px;
    padding-left: 50px;
}

#menu_div {
	margin: 20px;
}
</style>
<script>
	function viewPurchasePage(element) {
		var option = "width=600px, height=800px";

		window.open("/Toy_Project/purchasePage.ca?imageURL="
				+ element.children[0].src + "&product_name="
				+ element.children[1].innerText + "&product_price="
				+ element.children[2].innerText, "구매페이지", option);
	}
</script>
</head>
<body>
	<c:set var="cafeLeft" value="${cafeLeft}" />
	<c:set var="cafeRight" value="${cafeRight}" />
	<c:set var="cafeTopLeft" value="${cafeTopLeft}" />
	<!-- 컨테이너 div 시작 -->
	<div id='container'>
		<!-- left div 시작 -->
		<div id='left_div'>
			<!-- ranking div 시작 -->
			<div id='ranking_div'>
				<h1>메뉴인기순위</h1>
				<c:forEach var="rank" items="${cafeTopLeft}" varStatus="status">
					<p>${status.index+1}위　${rank.getProduct_name()}</p>
				</c:forEach>
			</div>
			<!-- ranking div 끝 -->
			<h1 style="width: 220px; text-align: center;">메뉴판</h1>			
			<!-- menu list div 끝 -->
			<div id='menu_list_div'>
				<c:forEach var="list" items="${cafeLeft}">
					<div id='list_div' onclick='viewPurchasePage(this)'>
						<img src="${list.getProduct_img()}" width="150px" height="150px">
						<p>${list.getProduct_name()}</p>
						<p>${list.getProduct_price()}원</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- left div 끝 -->
		<!-- right div 시작 -->
		<div id='right_div'>
			<h1 style="width: 260px; text-align: center;">주문수</h1>
			<table id='right_div_inner_table'>
				<c:forEach var="view" items="${cafeRight}">
					<tr>
						<td>
							<p>　${view.getProduct_name()}</p>
						</td>
						<td style="text-align: center;">
							<p>${view.getProduct_cnt()}개</p>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<!-- right div 끝 -->
	</div>
	<!-- 컨테이너 div 끝 -->
	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>
</html>