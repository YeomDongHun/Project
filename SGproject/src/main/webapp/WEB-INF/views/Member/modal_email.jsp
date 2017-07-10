<%@ page contentType="text/html; charset=utf-8" %>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">

//이메일 유효성 검증
function email_code()
{
	  
	   var f = document.frm;
	   var email = f.email1.value+"@"+f.email2.value;
	   
	      //이메일 주소를 아예 입력하지 않은경우
	 	  if(email == '@') 
	 	  {
		      alert("이메일을 입력하세요.");
		  }
	      //이메일 주소를 한 부분만 입력한 경우
	 	  else if(f.email1.value=="" || f.email2.value=="")
	 	  {
		      alert("이메일을 정확히 입력하세요.");
		      console.log("로그 내용1");  
		  }
	      //둘다 입력한 경우
	 	  else
	 	  {
	 		  
	    	  $.ajax
	    	  ({
	    	        type: "POST",
	    	        url: "./joinStep1/modal_email_auth",
	    	        data: ({mode:"email_code", email:email}),
	    	        //contentType: "text/plain; charset=euc-kr",
	    	        success: function(checkNum) 
	    	        {
	    	        	
	    	        	if(checkNum != 0)
	    	        	{
	    	        		alert("이미 가입된 이메일입니다.다른이메일을 입력해주세요");
	    	        	}
	    	        	else
	    	        	{
	    	        		alert("인증번호를 요청하신 이메일로 발송했습니다.");
	    	        	}
	    	        	
	    	        	if(checkNum != null)    
	    	        	{
	    	            	console.log("로그 내용2"+data);
	    	            }
	    	        },
	    	        error: function(e)
	    	        {
	    	         alert("error" + e);
	    	        }
	    	    });
	      }
	   
	}
	
//인증번호 유효성 검증
function member_send()
{
	 var f = document.frm;
	
	 var email = f.email1.value+"@"+f.email2.value;

	 if(email == '@') 
	 {
	      alert("이메일을 입력하세요.");
	 }
	 else if(f.email1.value=="" || f.email2.value=="")
	 {
	      alert("이메일을 정확히 입력하세요.");
	      console.log("로그 내용1");  
	 }
	 else
	 {
   		$.ajax
   		({
      	 type: "POST",
       	 url: "./joinStep1/modal_email_auth_success",
      	  //data: ({Id:$("#Id").val(), Pwd:$("#Pwd").val()}),
      	  //contentType: "text/plain; charset=euc-kr",
      	  success: function(data) 
      	  {
        		 /* alert("auth값받음"+data); */
   	     	 console.log("로그 내용1");
        	 //인증번호가 NULL값이 아니면..	 
           	 if(data != null)    
           	 {
           		    
            		if(!f.sing_code.value)
            		{
        				alert("인증번호를 입력해 주세요");
        				f.sing_code.focus();
        			}
            		else if(f.sing_code.value !=  data)
            		{
        				alert("인증번호가 맞지 않습니다.");

        			}
            		else
            		{
        				//alert("인증번호가 맞습니다.");
        				f.action = "./joinAgree";
        				f.submit(); 
        			}
         	   } 
           	    else 
           	    {
          	  	alert("data값없음"+data);
          	  	console.log("로그 내용3");
       	        }
     	   },
     	   error: function(e)
     	   {
     	    alert('error' + e);
   	       }
   	 });
	}
}	
</script>

</head>
<form name="frm" method="post" class="form-horizontal">

<section style="padding:30px 20px;">
	<div class="form-group">
		<label for="inputEmail3" class="col-xs-4 col-lg-4 control-label">이메일</label>
		<div>
			<input name="email1" id="email1" class="form-control" size="10" type="text"> @ 
			<input name="email2" id="email2" class="form-control" size="10" type="text">  
			<a href="javascript:email_code();">인증번호받기</a>		
		</div>
	</div>
 <div class="form-group">
		<label for="inputEmail3" class="col-sm-4 control-label">인증번호</label>
		<div class="col-sm-20">
		     <%--인증번호 입력 --%>
			 <input name="sing_code" class="form-control" type="password">
		</div>
  </div>

	<div class="text-center" style="padding-top:10px">
		 <a href="javascript:member_send();" class="btn btn-default">회원가입하기</a> 
	</div> 

</section>
</form>

<div class="modal-foot">
</div>
