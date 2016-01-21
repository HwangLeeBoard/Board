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
<title>�Ĵ��Ĵ�</title>

 
<body style="padding:30px">
<%
	BoardConfigDAO bcDAO = new BoardConfigDAO();
	BoardConfigDTO bcDTO = new BoardConfigDTO();
	ArrayList<BoardConfigDTO> list = bcDAO.list();
	
	pageContext.setAttribute("list", list);
	
%>
<input type="button" onclick="location.href='./BoardConfigWrite.do'"
				class="btn btn-primary" value="�Խ��� �߰�">
				<br>	<br>
<table class="table">
<tr>
<th>�ڵ�</th>
<th>���̺���</th>
<th style="text-align:center">����</th>
<th style="text-align:center">�ڸ�Ʈ</th>
<th style="text-align:center">����</th>
<th style="text-align:center">���ϰ���</th>
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