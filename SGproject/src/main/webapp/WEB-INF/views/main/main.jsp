<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Place somewhere in the <head> of your document -->

<link rel="stylesheet" href="resources/flexslider.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="resources/jquery.flexslider.js"></script>



<!-- Place in the <head>, after the three links -->
<script type="text/javascript" charset="utf-8">
  $(window).load(function() {
    $('.flexslider').flexslider({
    	animation: "fade"
    });
  });
</script>
	 
</head>
<body style="overflower-x:hidden;">

<!-- Place somewhere in the <body> of your page -->
<div class="flexslider" style="width: 100%; margin:auto; ">
  <ul class="slides">
    <li>
    <center>
     <iframe width="560" height="315" src="https://www.youtube.com/embed/vwi9Kq7w8Xw" frameborder="0" ></iframe>
    </center></li>
    <li>
                 
    </li>
    <li>
      <img src="resources/images/3.jpg" style="height: 250px"/>
    </li>
  </ul>
</div>
<div>
리스트?


</div>



</body>
</html>