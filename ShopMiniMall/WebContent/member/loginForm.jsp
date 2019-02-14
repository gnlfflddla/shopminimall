<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String mesg = (String)session.getAttribute("mesg");
	if(mesg!=null){
		%>
		<script>
			alert('<%=mesg%>');
		</script>
		
		<%
	}
	session.removeAttribute("mesg");
%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("form").submit(function(event) {
			var flag=true;
			
			if ($("#userid").val().length == 0) {
				alert("id");
			}else if($("#passwd").val().length == 0){
				alert("passwd");
			}else{
				flag=false;
			}
			if(flag){
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body>
<form action="LoginServlet" method="get">
	아이디 : <input type="text" name="userid" id="userid"><span id="idcheck"></span><br>
	비밀번호 : <input type="text" name="passwd" id="passwd"><br>	
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
</form>
	<a href="MemberIdFindUIServlet">아이디 찾기</a>
	<a href="MemberPwdFindUIServlet">비밀번호 찾기</a>
</body>
</html>