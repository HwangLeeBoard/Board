<%@page import="java.util.ArrayList"%>
<%@page import="hjh.board.db.BoardConfigDAO"%>
<%@page import="hjh.board.db.BoardConfigDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	BoardConfigDTO dto = new BoardConfigDTO();
	BoardConfigDAO dao = new BoardConfigDAO();
	ArrayList<BoardConfigDTO> array= new ArrayList<BoardConfigDTO>();
	//array = dao.list();
	request.setAttribute("list", array);
	
	%>
	<h3 style="color: red;">잡담</h3><br>	
	<c:forEach begin="0" step="1" end="10" items="list" var="x">	
	<ul><li><a href="list.do?page=1&board_code=${x.board_code }">${x.board_name } </a></li></ul><br>
	</c:forEach>
	<h3 style="color: red;">자료공유</h3><br>	
	<c:forEach begin="10" step="1" items="list" var="x">
	value="${x.board_name }" class="btn btn-primary"> <br>
	<ul><li><a href="list.do?page=1&board_code=${x.board_code }">${x.board_name } </a></li></ul><br>
	</c:forEach>
</body>
</html>