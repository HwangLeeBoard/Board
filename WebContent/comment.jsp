<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<br><br>
<span style="color:#e51e00;font-size:17px;padding-top:10px;font-weight:bold;margin: 10px">댓글</span>
<div style="border-top:2px solid #c7c7c7;margin: 10px">
<c:forEach items="${clist }" var="r">

<li style="    position: relative;   padding:5px;border-bottom: 1px solid #eeeeec; vertical-align: top;    list-style: none;">
<div style="font-size:11px;">${r.writer }</div>
<div style="font-size:15px;">${r.content }</div>
</li>
</c:forEach>
</div>

<br><br>


	<form action="CommentInsert.do" method="post" style="border:1px solid #c7c7c7;padding:10px">
	<input type="hidden" name="num" value="${BoardDto.idx }">

<input type="hidden" name="board_code" value="${board_code }">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="categorys" value="${categorys }">
	
			작성자<input
			
			type="text" name="cWriter" value="" class="form-control"> <br>
		내용<br>
		<textarea rows="3" cols="30" name="cContent" class="form-control">  </textarea>
		<br>
		<input type="submit" value="쓰기" class="btn btn-primary">
	</form>

