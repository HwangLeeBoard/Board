<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${clist }" var="r">
----------------------------------------------------------<br>
${r.writer } <br>
${r.content }<br>

</c:forEach>


<br><br>
	<form action="CommentInsert.do" method="post">
	<input type="hidden" name="num" value="${BoardDto.idx }">
			작성자<input
			
			type="text" name="cWriter" value=""> <br>
		내용<br>
		<textarea rows="3" cols="30" name="cContent">  </textarea>
		<input type="submit" value="쓰기">
	</form>

