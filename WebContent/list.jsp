<%@page import="hjh.board.db.BoardDAO"%>
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
<body style="padding:30px">
<%
HttpSession sess = request.getSession();
if (sess.getAttribute("mem")==null){ %>
<input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='JoinForm.do'">
<input type="button" value="로그인" class="btn btn-primary" onclick="location.href='LoginForm.do'">
<%}else{ %>
<input type="button" value="로그아웃" class="btn btn-primary" onclick="location.href='Logout.do'">
<%} %>


<table width="100%">
<tr><td width="250"><jsp:include page="indexmenu.jsp"></jsp:include>	</td>


<td align="left" valign="top">


<table class="table">
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>좋아요</th>
<th>싫어요</th>
<th>등록일</th>
</tr>

<c:forEach items="${listDTO }" var="list">
<tr>
<td>${list.idx }</td>
<td>

<c:forEach begin="1" end="${list.levels}">
<%="&nbsp;&nbsp;&nbsp;&nbsp;"%>

</c:forEach>
<c:if test="${list.step>0 }">
	<img src="img/re.gif">
</c:if>
<a href="View.do?idx=${list.idx }&board_code=${board_code}&page=${page}">${list.title }</a> 
	<c:choose>
		<c:when test="${list.is_comment eq 0 }">
		
		</c:when>
		<c:otherwise>
			(${list.is_comment })
		</c:otherwise>
	</c:choose>

 <c:if test="${list.is_comment ne 0 } ">
 (${list.is_comment })
 </c:if>
 </td>
<td align="center">${list.writer }</td>
<td align="center">${list.likecnt }</td>
<td align="center">${list.badcnt }</td>
<td align="center">${list.dateTime }</td>
</tr>
</c:forEach>
</table>
<center>
<c:if test="${page ne 1 }">
<a href="List.do?page=${page-1 }">[이전]</a>
</c:if>
<c:forEach items="${sprayPage }" var="spray" >
<c:if test="${spray ne page}">
<a href="List.do?page=${spray}">${spray}</a> 
</c:if>
<c:if test="${spray eq page}">
${spray }
</c:if>
</c:forEach>
<c:if test="${page ne pageCount }">
<a href="List.do?page=${page+1 }">[다음]</a>
</c:if>
<br>
현재 페이지 ${page }

<hr>

<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='Write.do?board_code=${board_code}&categorys=1&page=${page }'">
</center>
<input type="button" value="main" class="btn btn-primary" onclick="location.href='index.do'">


</td></tr>
</table>	

</body>
</html>