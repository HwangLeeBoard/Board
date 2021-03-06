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
</head>
<body style="padding:30px;">

<form action="Insert.do" method="post"  enctype="multipart/form-data">

<input type="hidden" name="board_code" value="${board_code }">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="categorys" value="${categorys }">

${bConfigDTO }

	<div class="form-group">
   	 	<label for="exampleInputEmail1">작성자</label>
		<input type="text" name="writer" class="form-control" value="${mem.name }">
  	</div>
  	<div class="form-group">
   	 	<label for="exampleInputEmail1">제목</label>
		<input type="text" name="title" class="form-control">
  	</div>
  	<div class="form-group">
  	<c:if test="${bConfigDTO.is_file eq 'y' and bConfigDTO.file_cnt ne 0}">
   	 	<label for="exampleInputEmail1">파일</label>
   	 	<c:forEach var="x" varStatus="i" begin="1" end="${bConfigDTO.file_cnt }">
		<input type = "file" name = "file${i.index }" class="form-control" multiple="multiple">
   	 	</c:forEach>
		</c:if>
  	</div>
  	<div class="form-group">
   	 	<textarea name="content" class="form-control" 
						style="width: 100%; height: 200px"></textarea>
  	</div>
  <input type="submit" class="btn btn-success" value="등록">
	

	</form>
</body>
</html>
