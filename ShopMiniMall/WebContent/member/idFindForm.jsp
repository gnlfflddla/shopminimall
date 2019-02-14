<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String mesg = (String)request.getAttribute("mesg");
	if(mesg!=null){
		%>
		<script>
			alert('<%=mesg%>');
		</script>
		
		<%
	}
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
<form action="MemberIdFindServlet" method="get">
	이름 : <input type="text" name="username" id="username">
	전화번호 : <select name="phone1">
		<option value="011" >011</option>
		<option value="010" >010</option>
		<option value="017" >017</option>
	</select>-
	<input type="text" name="phone2">-<input type="text" name="phone3"><br>	
	<input type="submit" value="아이디 찾기">
	<input type="reset" value="취소">
</form>

</body>
</html>