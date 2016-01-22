<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" charset="utf-8">
<title>게시판</title>
<style type="text/css">
.viewbox{
padding:20px;
border: 1px solid #e5e5e5;
margin-bottom:10px
}
.title{
font-size:15px;
font-weight: bold;

}
.content{
font-size:15px;

}
</style>
</head>
<body style="padding:30px">
<div class="viewbox">
	<span class="title" >${BoardDto.title }</span>
	<div style="border-bottom: 4px dotted #e5e5e5;padding:5px"></div>
	<br> ${BoardDto.content }
	
	<br><br>
		파일 :
	<c:forEach items="${Filelist }" var="f">
	 <a href="FileDown.do?filename=${f.filename }">${f.filename }</a> 
		<br>
		<!-- <img src="file1/${f.filename }" width="150"> -->
	</c:forEach>
</div>
<%
int nowPage= Integer.parseInt(request.getParameter("page"));
request.setAttribute("page", nowPage);
%>
	<input type="button"
		onclick="location.href='ReplyView.do?idx=${BoardDto.idx}&page=${page }'"  class="btn btn-primary" value="답변">
	<input type="button"
		onclick="location.href='UpdateView.do?idx=${BoardDto.idx}'" class="btn btn-primary" value="수정">
	<input type="button"
		onclick="location.href='Delete.do?idx=${BoardDto.idx}&board_code=${board_code }'" class="btn btn-primary" value="삭제">
	<input type="button" onclick="location.href='List.do?board_code=${board_code}'" class="btn btn-primary" value="리스트">
	
	<input type="button" onclick="location.href='IsLike.do?idx=${BoardDto.idx}&like=Y'" class="btn btn-primary" value="좋아요">
	<input type="button" onclick="location.href='IsLike.do?idx=${BoardDto.idx}&like=N'" class="btn btn-primary" value="싫어요">
	<br>
	
	
	
	<%@include file="comment.jsp" %>
	
</body>
</html>