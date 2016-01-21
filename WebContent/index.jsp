
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		String block= "&nbsp;";
	
	%>



	<br>
	<br>
	<br>
	<br>
	<table>
		
		<tr>
			<td>
			<h3 style="color: red;">잡담</h3>
			</td>
			<td>
	<c:forEach begin="1" step="1" end="30">
	&nbsp;
	</c:forEach>
			</td>
			<td>
			<jsp:include page="newlist.jsp"></jsp:include>
		<%-- 		<%@include file="newlist.jsp" %>
		--%>
			</td>
		</tr>
		<tr>
		<td>
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=1&categorys=1'"
				class="btn btn-primary" value="후니 자유게시판 이동">
				</td>
				</tr>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=2&categorys=1'"
				class="btn btn-primary" value="후니 유머게시판 이동">
			<br>
			<br>
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=3&categorys=1'"
				class="btn btn-primary" value="후니 소설추천 게시판 이동">
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=4&categorys=1'"
				class="btn btn-primary" value="후니 미드추천 게시판 이동">

			<br>
			<br>
			<br>
			<br>
			<h3 style="color: red;">자료공유</h3>
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=5&categorys=1'"
				class="btn btn-primary" value="영화">
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=6&categorys=1'"
				class="btn btn-primary" value="드라마">
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=7&categorys=1'"
				class="btn btn-primary" value="유틸">
			<input type="button"
				onclick="location.href='List.do?page=1&board_code=8&categorys=1'"
				class="btn btn-primary" value="게임">
			
	</table>
</body>
</html>