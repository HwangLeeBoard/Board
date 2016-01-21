
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"
	charset="euc-kr">
<title>후니후니</title>

<style type="text/css">
.purple {
	background-color: #ff00FF;
	color: white;
}
</style>
<style type="text/css">
.red {
	background-color: #ff0033;
	color: white;
}
</style>

</head>
<body style="background-image: url('img/IQ.jpg');">
	<br>
	<h1 style="color: purple;">
		<center>후니의 홈페이지에 오신것을 환영합니다!!</center>
	</h1>


	<%
		HttpSession sess = request.getSession();
		if (sess.getAttribute("mem") == null) {
	%>
	<input type="button" value="회원가입" class="btn btn-primary"
		onclick="location.href='JoinForm.do'">
	<input type="button" onclick="location.href='LoginForm.do'"
		class="purple" value="LogIn">
	<%
		} else {
	%>
	<input type="button" value="로그아웃" class="btn btn-primary"
		onclick="location.href='Logout.do'">
	<%
		}
		String block = "&nbsp;";
		
	%>



	<table>
	<tr>
		<jsp:include page="indexmenu.jsp"></jsp:include>
			<td><c:forEach   begin="1" step="1" end="30">
	&nbsp;
	</c:forEach></td>
			<td><jsp:include page="newlist.jsp"></jsp:include> 
			<%-- 		<%@include file="newlist.jsp" %>
		--%></td>
		</tr>
	


	</table>
</body>
</html>