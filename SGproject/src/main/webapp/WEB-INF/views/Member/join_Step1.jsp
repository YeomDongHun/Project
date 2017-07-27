<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head><link rel="stylesheet" type="text/css" href="/SG/resources/file/css/emailauth.css" /> 
<script type="text/javascript">
function modal_email()
{
	//부모창에서 이동할 경로 설정
	window.name="/SG/joinAgree";
	
	//팝업창(자식창) 경로 설정
	window.open('/SG/modal_email','','toolbar=no,menubar=no,location=no,height=650,width=600'); 
} 
</script>

 <style type="text/css">
.mygrade{
   padding-top:5px;
   padding-bottom:5px;
   left:90px;
   position: absolute;
   top: 5px;
   bottom:9px;
   
  
}


 .container {
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto
}

@media ( min-width :768px) {
	.container {
		width: 750px
	}
}

@media ( min-width :992px) {
	.container {
		width: 970px
	}
}

@media ( min-width :1200px) {
	.container {
		width: 1170px;
	}
}

.container-fluid {
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto
}

.container-fluid>.navbar-collapse, .container-fluid>.navbar-header,
	.container>.navbar-collapse, .container>.navbar-header {
	margin-right: -15px;
	margin-left: -15px
}
 
@media ( min-width :768px) {
	.container-fluid>.navbar-collapse, .container-fluid>.navbar-header,
		.container>.navbar-collapse, .container>.navbar-header {
		margin-right: 0;
		margin-left: 0
	}
}

@media ( min-width :768px) {
	.navbar>.container .navbar-brand, .navbar>.container-fluid .navbar-brand
		{
		margin-left: -15px
	}
}


.container .jumbotron, .container-fluid .jumbotron {
	padding-right: 15px;
	padding-left: 15px;
	border-radius: 6px
}

.jumbotron .container {
	max-width: 100%
}

@media screen and (min-width:768px) {
	.jumbotron {
		padding-top: 48px;
		padding-bottom: 48px
	}
	.container .jumbotron, .container-fluid .jumbotron {
		padding-right: 60px;
		padding-left: 60px
	}
	.jumbotron .h1, .jumbotron h1 {
		font-size: 63px
	}
}

.btn-group-vertical>.btn-group:after, .btn-group-vertical>.btn-group:before,
	.btn-toolbar:after, .btn-toolbar:before, .clearfix:after, .clearfix:before,
	.container-fluid:after, .container-fluid:before, .container:after,
	.container:before, .dl-horizontal dd:after, .dl-horizontal dd:before,
	.form-horizontal .form-group:after, .form-horizontal .form-group:before,
	.modal-footer:after, .modal-footer:before, .modal-header:after,
	.modal-header:before, .nav:after, .nav:before, .navbar-collapse:after,
	.navbar-collapse:before, .navbar-header:after, .navbar-header:before,
	.navbar:after, .navbar:before, .pager:after, .pager:before, .panel-body:after,
	.panel-body:before, .row:after, .row:before {
	display: table;
	content: " "
}

.btn-group-vertical>.btn-group:after, .btn-toolbar:after, .clearfix:after,
	.container-fluid:after, .container:after, .dl-horizontal dd:after,
	.form-horizontal .form-group:after, .modal-footer:after, .modal-header:after,
	.nav:after, .navbar-collapse:after, .navbar-header:after, .navbar:after,
	.pager:after, .panel-body:after, .row:after {
	clear: both
}
</style>
</head>

<body>
<div class="container">
	<div class="contents1" style="margin-bottom:50px;">         
	         
	      <div class="xans-member-joinAgreement">
	         
	         <div class="agreeArea" style="width:1145px; margin-top:20px;">
	            <h3>샐러드 구쁘다 회원가입을 위해 본인인증을 시작합니다.</h3>
	            <div class="agree">
	            <p>이메일 인증을 통하여 본인인증을 진행할 수 있습니다.<br>
			본인인증을 위해 입력하신 개인정보는 회원가입을 위해서 확인하는 것이며,<br>
			수집된 정보는 본인인증 외 어떠한 용도로도 사용되거나 샐러드 구쁘다에 저장되지 않으므로 안심하시기 바랍니다.</p>
			<br>이메일 인증은 따로 정보를 저장하지 않습니다.<br>해당 이메일로 전송받은 인증 번호를 입력해서 인증을 받는 방법입니다.
			</div>
		</div>
		
	</div>
	
	  
	</div>
	<div style="margin-bottom:80px; text-align: center; margin-right: 150px;">
	<a href="javascript:modal_email();" class="effect effect-5" 
	    style="padding: 13px 0px; width:140px;  ">	
		이메일 인증
		</a>
	</div>
</div>



</body>

<ul>
<li><a href="/SG/joinAgree">인증 후 회원가입</a></li>
</ul>


