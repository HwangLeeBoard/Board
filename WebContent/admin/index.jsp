<%@page import="java.util.ArrayList"%>
<%@page import="hjh.member.db.MemberDTO"%>
<%@page import="hjh.member.db.MemberDAO"%>
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
<%
if(session.getAttribute("mm")==null){
	
}
%>

<frameset rows="94,*" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="../admin/main_top.jsp" name="top" frameborder="no" scrolling="no" id="top">
  <frame src="../admin/board_admin.jsp" name="body_frame" frameborder="no" id="mainframe">
 </frameset>
 
 