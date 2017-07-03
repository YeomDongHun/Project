<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">
     html, body{width:100%; height:100%; padding:0px; margin:0px;}
     
     .div1{
     	float:left;
     }
     
     .div2{
     	float:left;
     }
     .div3{
     	clear:both;
     }
   </style>
</head>
<body>

 <div style="background-color:#D9E5FF; height:20%;">
<tiles:insertAttribute name="header" />
</div>


<div class="div1" style="background-color:#E8D9FF; height:70%; width:20%;">
 
<tiles:insertAttribute name="body1" />
</div>

<div class="div2" style="background-color:#FFD8D8; height:70%; width:80%;">
 
<tiles:insertAttribute name="body2" />
</div>

<div class="div3" style="background-color:#CEFBC9; height:10%;">

<tiles:insertAttribute name="footer" />
</div>
</body>
</html>