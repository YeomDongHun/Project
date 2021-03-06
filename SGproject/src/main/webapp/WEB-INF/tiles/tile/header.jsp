<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <html>
 <head>
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');

#headerWrap{
width:100%;
font-family: PureunJeonnam;
}
#logoWrap{
   width:600px;
   height:200px;
   margin-left:auto;
   margin-right:auto;
}
#loginWrap{

   height:50px;
/*    background-color:blue; */
   font-family: PureunJeonnam;
   
}

#loginWrap ul{
      list-style-type: none;  /* 메인 메뉴 안의 ul 내부의 목록 표시를 없애줌 */
        margin: 0px;            /* 메인 메뉴 안의 ul의 margin을 없앰 */
        padding: 0px;           /* 메인 메뉴 안의 ul의 padding을 없앰 */
}

#loginWrap ul li{
        color: white;               /* 글씨 색을 흰색으로 설정 */
        float: right;                /* 왼쪽으로 나열되도록 설정 */
        line-height: 40px;          /* 텍스트 한 줄의 높이를 30px로 설정 */
        vertical-align: middle;     /* 세로 정렬을 가운데로 설정 */
        text-align: center;         /* 텍스트를 가운데로 정렬 */
        margin-right:10px;
        font-family: PureunJeonnam;
}
.loginLink{
      text-decoration:none;               /* a 태그의 꾸밈 효과 제거 */
      font-size: 15px;                    /* 폰트 사이즈를 12px로 설정 */
        font-weight: bold;                  /* 폰트를 굵게 설정 */
        font-family: PureunJeonnam;
}

.loginname{
      text-decoration:none;               /* a 태그의 꾸밈 효과 제거 */
      font-size: 15px;                    /* 폰트 사이즈를 12px로 설정 */
        font-weight: bold;                  /* 폰트를 굵게 설정 */
        font-family: PureunJeonnam;      
        float : right;
        margin-right:40px;
        margin-top:10px;
}

#topMenu {
            height: 50px;  /* 메인 메뉴의 높이 */
            width:1200px;  /* 메인 메뉴의 넓이 */
            margin-left:auto;
            margin-right:auto;
    }
#topMenu ul {           /* 메인 메뉴 안의 ul을 설정함: 상위메뉴의 ul+하위 메뉴의 ul */
        list-style-type: none;  /* 메인 메뉴 안의 ul 내부의 목록 표시를 없애줌 */
        margin: 0px;            /* 메인 메뉴 안의 ul의 margin을 없앰 */
        padding: 0px;           /* 메인 메뉴 안의 ul의 padding을 없앰 */
    }
#topMenu ul li {            /* 메인 메뉴 안에 ul 태그 안에 있는 li 태그의 스타일 적용(상위/하위메뉴 모두) */
        color: white;               /* 글씨 색을 흰색으로 설정 */
        background-color: #2d2d2d;  /* 배경 색을 RGB(2D2D2D)로 설정 */
        float: left;                /* 왼쪽으로 나열되도록 설정 */
        line-height: 40px;          /* 텍스트 한 줄의 높이를 30px로 설정 */
        vertical-align: middle;     /* 세로 정렬을 가운데로 설정 */
        text-align: center;         /* 텍스트를 가운데로 정렬 */
        position: relative;         /* 해당 li 태그 내부의 top/left 포지션 초기화 */
    }
.menuLink, .submenuLink {           /* 상위 메뉴와 하위 메뉴의 a 태그에 공통으로 설정할 스타일 */
        text-decoration:none;               /* a 태그의 꾸밈 효과 제거 */
        display: block;                     /* a 태그의 클릭 범위를 넓힘 */
        width: 225px;                       /* 기본 넓이를 150px로 설정 */
        font-size: 15px;                    /* 폰트 사이즈를 12px로 설정 */
        font-weight: bold;                  /* 폰트를 굵게 설정 */
        font-family: PureunJeonnam, Dotum;  /* 기본 폰트를 영어/한글 순서대로 설정 */
    }
    
    @media ( min-width :768px) {
	.menuLink, .submenuLink {
		width: 125px
	}
}

@media ( min-width :992px) {
	.menuLink, .submenuLink {
		width: 175px
	}
}

@media ( min-width :1200px) {
	.menuLink, .submenuLink {
		width: 225px;
	}
}
    
    
.menuLink {     /* 상위 메뉴의 글씨색을 흰색으로 설정 */
        color: white;
    }
.topMenuLi:hover .menuLink {    /* 상위 메뉴의 li에 마우스오버 되었을 때 스타일 설정 */
        color: #00CCCF;                 /* 윌포인트색 */
        background-color: #4d4d4d;  /* 배경색을 밝은 회색으로 설정 */
}
.submenuLink {          /* 하위 메뉴의 a 태그 스타일 설정 */
        color: #2d2d2d;             /* 글씨 색을 RGB(2D2D2D)로 설정 */
        background-color: white;    /* 배경색을 흰색으로 설정 */
        border: solid 1px black;    /* 테두리를 설정 */
        margin-top: -1px;           /* 위 칸의 하단 테두리와 아래칸의 상단 테두리가 겹쳐지도록 설덩 */
    }
.longLink {     /* 좀 더 긴 메뉴 스타일 설정 */
        width: 190px;   /* 넓이는 190px로 설정 */
    }
.submenu {              /* 하위 메뉴 스타일 설정 */
        position: absolute;     /* html의 flow에 영향을 미치지 않게 absolute 설정 */
        height: 0px;            /* 초기 높이는 0px로 설정 */
        overflow: hidden;       /* 실 내용이 높이보다 커지면 해당 내용 감춤 */
        transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(기본) */
        -webkit-transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 크롬/사파라ㅣ) */
        -moz-transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 파폭) */
        -o-transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 오페라) */
    }
.topMenuLi:hover .submenu { /* 상위 메뉴에 마우스 모버한 경우 그 안의 하위 메뉴 스타일 설정 */
        height: 100px;           /* 높이를 93px로 설정 */
    }
.submenuLink:hover {        /* 하위 메뉴의 a 태그의 마우스 오버 스타일 설정 */
        color: red;                 /* 글씨색을 빨간색으로 설정 */
        background-color: #dddddd;  /* 배경을 RGB(DDDDDD)로 설정 */
    }
    
@font-face { /* 나눔고딕 Regular */
  font-family: PureunJeonnam;
  font-style: normal;
  font-weight: 400;
  src: url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-Regular.eot);
  src: url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-Regular.eot?#iefix) format('embedded-opentype'),
       url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-Regular.woff2) format('woff2'),
       url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-Regular.woff) format('woff'),
       url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-Regular.ttf) format('truetype');
}
 </style>  


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>  
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>    

<div id="sideBar" style="color: #FFFFFF;">
<jsp:include page="../../views/Goods/Basket/goodsBasket.jsp"></jsp:include>
</div>

<div class="container">
   <div id="loginWrap">
           
          <c:choose>
             
          <c:when test="${(sessionScope.MEMBER_NO) == 0}">
          <ul>      
          <li><a class="loginLink" href="loginForm">로그인</a></li>
          <li><a class="loginLink" href="joinEmail">회원가입</a></li>
            </ul>       
          </c:when>
          
          <c:otherwise>
          <ul>                
          <li><a class="loginLink" href="logout">로그아웃</a></li>
          <li><a class="loginLink" href="mypage">마이페이지</a></li>       
          </ul>
          <div class="loginname">${sessionScope.MEMBER_NAME}님 환영합니다!</div>
          </c:otherwise>
          
          </c:choose>

   </div>
    <div id="logoWrap">
       <a href="main"><img src="./resources/file/img/SG_Logo.jpg" /></a>
    </div>
    
    
    
    
   <div id="topMenu" style="z-index:0;">
      <ul>
           <li class="topMenuLi">
              <a class="menuLink" href="goodsList"> 상품 리스트 </a>
           </li>          
        <li>|</li>  
           <li class="topMenuLi"> 
              <a class="menuLink" href="goodsDIY">DIY</a> 
           </li>
      <li>|</li>    
           <li class="topMenuLi">
              <a class="menuLink" href="memberDiyBoardList">나만의 레시피</a>
           </li>
        <li>|</li>
           <li class="topMenuLi">
              <a class="menuLink" href="memberFaqList">고객 센터</a>
           </li>
      <li>|</li>  
             <li class="topMenuLi">
                <a class="menuLink" href="memberNoticeList">공지 사항</a>
             </li>
      </ul>
   </div>   
</div>
</body>
</html>