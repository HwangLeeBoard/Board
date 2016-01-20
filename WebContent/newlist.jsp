<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
	<body style="padding:30px">
<table class="table">
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>등록일</th>
</tr>
<c:forEach items="${listDTO }" var="list">
<tr>
<td>${list.idx }</td>
<td><a href="View.do?num=${list.idx }">${list.title }</a></td>
<td>${list.writer }</td>
<td>${list.dateTime }</td>
</tr>
</c:forEach>
</table>

</body>
</html>