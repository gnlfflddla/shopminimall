<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
<%
	String mesg = (String)session.getAttribute("mesg");
	if(mesg!=null){
%>
<script type="text/javascript">
	alert('<%=mesg %>');
</script>

<% }
	session.removeAttribute("mesg");
%>
<h1>전체주문 화면</h1>
<jsp:include page="common/top.jsp" flush="true"></jsp:include><br><!-- 로그인,회원가입 ,,  -->
<jsp:include page="common/menu.jsp" flush="true"></jsp:include>
<hr>
<jsp:include page="order/orderAllConfirm2.jsp" flush="true"></jsp:include>
</body>
</html>