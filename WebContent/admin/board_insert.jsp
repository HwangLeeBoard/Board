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
<body>
<body style="padding:30px;">
<%
	BoardConfigDAO bcDAO = new BoardConfigDAO();
	BoardConfigDTO bcDTO = new BoardConfigDTO();
	ArrayList<BoardConfigDTO> list = bcDAO.list();
	
	pageContext.setAttribute("list", list);
	
%>
<form action="../BoardConfigInsert.do" method="post"  >

	<div class="form-group">
   	 	<label>���̺��</label>
		<input type="text" name="board_name" class="form-control" value="">
  	</div>
  	<div class="form-group">
   	 	<label>���̺� �ڵ�</label><br>
   	 	<c:forEach var="x" items="${list }" varStatus="s">
		${x.board_name }:  <span style="font-weight:bold">${x.board_code }</span>&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
		<input type="text" name="board_code" class="form-control" value="">
		
  	</div>
  	<div class="form-group">
   	 	<label>���Ͼ��ε�</label>
		<input type="radio" name="is_file" value="Y" checked="checked"> Y 
		<input type="radio" name="is_file" value="N"> N
  	</div>
  	<div class="form-group">
   	 	<label>���ϰ���</label>
		<select name="file_cnt">
		<c:forEach var="x" begin="1" end="10" varStatus="s">
		<option value="${s.index-1 }" >1</option>
		</c:forEach>
		</select>
  	</div>
  	<div class="form-group">
   	 	<label>�б�����</label>
		<input type="radio" name="is_readonly" value="Y" checked="checked"> Y 
		<input type="radio" name="is_readonly" value="N"> N
  	</div>
  	<div class="form-group">
   	 	<label>ī��Ʈ����</label>
		<input type="radio" name="is_viewcnt" value="Y" checked="checked"> Y 
		<input type="radio" name="is_viewcnt" value="N"> N
  	</div>
  	<div class="form-group">
   	 	<label>��б�</label>
		<input type="radio" name="is_lock" value="Y" checked="checked"> Y 
		<input type="radio" name="is_lock" value="N"> N
  	</div>
  	<div class="form-group">
   	 	<label>�������</label>
		<input type="radio" name="is_notice" value="Y" checked="checked"> Y 
		<input type="radio" name="is_notice" value="N"> N
  	</div>
  
  <input type="submit" class="btn btn-success" value="���">

	</form>
</body>

</body>
</html>