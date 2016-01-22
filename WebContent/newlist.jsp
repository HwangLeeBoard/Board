<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="java.io.IOException" %>
<%@page import="java.util.ArrayList" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="hjh.board.db.BoardDAO" %>
<%@page import="hjh.board.db.BoardDTO" %>
<%@page import="hjh.command.controll.Forward" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
BoardDAO dao = new BoardDAO();
list = dao.list();
request.setAttribute("indexlistDTO", list);

%>
	<body style="padding:30px">
	<h3>최신글</h3>
	<div style="background-color: #ffffff">
<table class="table">
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>등록일</th>
</tr>

<c:forEach items="${indexlistDTO }" var="list">
<tr>
<td>${list.idx }</td>
<td><a href="View.do?idx=${list.idx }&board_code=${list.board_code}">${list.title }</a></td>
<td>${list.writer }</td>
<td>${list.dateTime }</td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>