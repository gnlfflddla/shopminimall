<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원상세 화면</h1>
<jsp:include page="common/top.jsp" flush="true"></jsp:include><br><!-- 로그인,회원가입 ,,  -->
<jsp:include page="common/menu.jsp" flush="true"></jsp:include><br>
<hr>
<jsp:include page="member/mypage.jsp" flush="true"></jsp:include><br>

</body>
</html>