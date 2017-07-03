<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>무제 문서</title>
<style>
#slide_main { /* 슬라이드 div설정 */
	height: 400px; /* 높이 */
	width: 100%; /* 폭  => 화면에서 꽉차게 */
	background-color: #CF3;
}

#wrap { 
	height: 2000px;
	width: 1200px;
	margin-top:10px;
	margin-right: auto;
	margin-left: auto;
}
#event_main {
	height: 30%;
	width: 100%;
	background-color: #6F3;
}

#best_main {
	height: 30%;
	width: 100%;
	background-color: #C96;	
}
#review_main {
	background-color: #CCC;
	height: 30%;
	width: 100%;
}

</style>
</head>

<body>
<div id="slide_main"><img src="./resources/file/img/Slide4.jpg" width="100%" height="400px"/></div>
<div id="wrap">
  <div id="best_main">best상품</div>
  <div id="event_main">event메인</div>
  <div id="review_main">review메인</div>
</div>
</body>
</html>