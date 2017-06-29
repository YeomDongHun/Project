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
   </style>
</head>
<body>

 <div style="background-color:#D9E5FF; height:20%;">
<tiles:insertAttribute name="header" />
</div>


<div style="background-color:#FFD8D8; height:70%;">
 
<tiles:insertAttribute name="body" />
</div>

<div style="background-color:#CEFBC9; height:10%;">

<tiles:insertAttribute name="footer" />
</div>
</body>
</html>