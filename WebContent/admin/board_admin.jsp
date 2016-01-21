<%@page import="java.util.ArrayList"%>
<%@page import="hjh.board.db.BoardConfigDTO"%>
<%@page import="hjh.board.db.BoardConfigDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="../js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css"
	charset="euc-kr">
<title>후니후니</title>

 
<body style="padding:30px">
<%
	BoardConfigDAO bcDAO = new BoardConfigDAO();
	BoardConfigDTO bcDTO = new BoardConfigDTO();
	ArrayList<BoardConfigDTO> list = bcDAO.list();
	
	pageContext.setAttribute("list", list);
	
%>
<input type="button" onclick="location.href='./BoardConfigWrite.do'"
				class="btn btn-primary" value="게시판 추가">
				<br>	<br>
<table class="table">
<tr>
<th>코드</th>
<th>테이블명</th>
<th style="text-align:center">리플</th>
<th style="text-align:center">코멘트</th>
<th style="text-align:center">파일</th>
<th style="text-align:center">파일갯수</th>
</tr>
<c:forEach var="list" items="${list }" varStatus="s">

<tr>
<td>${list.board_code }</td>
<td>${list.board_name }</td>
<td align="center">${list.is_reply }</td>
<td align="center">${list.is_comment }</td>
<td align="center">${list.is_file }</td>
<td align="center">${list.file_cnt }</td>
</tr>
</c:forEach>
</table>


		
		


</body>
</html>