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
<form action="Update.do" method="post"  enctype="multipart/form-data" id="form1">
<input type="hidden" name="id" value="${mem.id }">
<input type="hidden" name="idx" value="${BoardDto.idx }">
<input type="hidden" name="board_code" value="${BoardDto.board_code }">
<input type="hidden" name="categorys" value="${BoardDto.categorys }">


	<div class="form-group">
   	 	<label>작성자</label>
		<input type="text" name="writer" class="form-control" value="${BoardDto.writer }">
  	</div>
  	<div class="form-group">
   	 	<label for="exampleInputEmail1">제목</label>
		<input type="text" name="title" class="form-control" value="${BoardDto.title }">
  	</div>
  	<div class="form-group">
   	 	<label for="exampleInputEmail1">파일</label>
		
	<c:forEach items="${Filelist }" var="f">
	 <a href="FileDown.do?filename=${f.filename }">${f.filename }</a> 
		<br>
		<!-- <img src="file1/${f.filename }" width="150"> -->
	</c:forEach>
  	</div>
  	<div class="form-group">
   	 	<textarea name="content" class="form-control" 
						style="width: 100%; height: 200px">${BoardDto.content }</textarea>
  	</div>
 
	

	</form>
	
	<input type="button"
		onclick="$('#form1').submit()" class="btn btn-primary" value="수정">
	<input type="button"
		onclick="history.back()" class="btn btn-primary" value="취소">
	
	<br>
	

	
</body>
</html>