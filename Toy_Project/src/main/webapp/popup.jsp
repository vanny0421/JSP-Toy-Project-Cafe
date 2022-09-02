<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Siren Order</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style>

#container {
	width: 100%;
	height: 100%;
	background: transparent;
	background-color: ;
	text-align: center;
    margin: 0 auto;
    padding-top: 180px;
}

#container input {
    margin: 20px; font-size: 15px;
}

p , h1 , h2 , h3 {
	font-family: 'Do Hyeon', sans-serif;
}

p {
	font-size: 22px;
}

@import url("https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap");


button {
    margin: 20px; font-size: 15px;
}

.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
}

.w-btn-outline {
    position: relative;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
}

.w-btn-indigo {
    background-color: aliceblue;
    color: #1e6b7b;
}

.w-btn-indigo-outline {
    border: 3px solid aliceblue;
    color: #1e6b7b;
}

.w-btn-indigo-outline:hover {
    color: #1e6b7b;
    background: aliceblue;
}

.w-btn-green {
    background-color: #77af9c;
    color: #d7fff1;
}

.w-btn-green-outline {
    border: 3px solid #77af9c;
    color: darkgray;
}

.w-btn-green-outline:hover {
    background-color: #77af9c;
    color: #d7fff1;
}


.w-btn:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn-outline:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn:active {
    transform: scale(1.5);
}

.w-btn-outline:active {
    transform: scale(1.5);
}

.w-btn-gra1 {
    background: linear-gradient(-45deg, #33ccff 0%, #ff99cc 100%);
    color: white;
}

.w-btn-gra2 {
    background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
    color: white;
}

.w-btn-gra3 {
    background: linear-gradient(
        45deg,
        #ff0000,
        #ff7300,
        #fffb00,
        #48ff00,
        #00ffd5,
        #002bff,
        #7a00ff,
        #ff00c8,
        #ff0000
    );
    color: white;
}

</style>
</head>
<body>
	<c:set var="product_img_url" value="${product_img_url}"/>
	<c:set var="product_Name" value="${product_Name}"/>
	<c:set var="product_Price" value="${product_Price}"/>
	<c:set var="product_Info" value="${product_Info}"/>

	<!-- div container 시작 -->
	<div id="container">
		<!-- form 태그 시작 -->
		<form name="submitForm" action="${pageContext.request.contextPath}/starbucksR.ca" method="post">
			<img id="product_img_url" src="${product_img_url}"></img> 
			<input type="hidden" name="product_name" value="${product_Name}">
			<p id="product_name">${product_Name}</p>
			<p id="product_price">${product_Price}</p>

			<input class="w-btn w-btn-indigo" type="button" value="주문하기" onclick="purchase()">
		</form>
		<!-- form 태그 끝 -->
	</div>
	<!-- div container 끝 -->
	<script>
		
		function purchase() {

			document.submitForm.submit();
			
			/*if (window.confirm("결제를 하시겠습니까?")) {
				document.submitForm.submit();
				window.close();
			} else {
				window.close();
			}*/
		};
	</script>
</body>
</html>