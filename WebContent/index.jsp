
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" charset="euc-kr">
<title></title>

<style type="text/css">
.purple{background-color:#ff00FF;
color: white;
}
</style>
<style type="text/css">
.red{background-color:#ff0033;
color: white;
}
</style>

</head>
<body style="background-image: url('img/IQ.jpg');">
<br><h1 style="color: purple;"><center>�Ĵ��� Ȩ�������� ���Ű��� ȯ���մϴ�!!</center></h1>

<input type="button"  onclick="location.href='LoginForm.do'" class="purple" value="LogIn">
<br><br><br><br>
<h3 style="color: red;">���</h3>
<input type="button"  onclick="location.href='List.do?page=1&board_code=1&categorys=1'" class="btn btn-primary" value="�Ĵ� �����Խ��� �̵�"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<input type="button"  onclick="location.href='List.do?page=1&board_code=2&categorys=1'" class="btn btn-primary" value="�Ĵ� ���ӰԽ��� �̵�"><br><br>
<input type="button"  onclick="location.href='List.do?page=1&board_code=3&categorys=1'" class="btn btn-primary" value="�Ĵ� �Ҽ���õ �Խ��� �̵�">
<input type="button"  onclick="location.href='List.do?page=1&board_code=4&categorys=1'" class="btn btn-primary" value="�Ĵ� �̵���õ �Խ��� �̵�">

<br><br><br><br>
<h3 style="color: red;">�ڷ����</h3>
<input type="button"  onclick="location.href='List.do?page=1&board_code=5&categorys=1'" class="btn btn-primary" value="��ȭ">
<input type="button"  onclick="location.href='List.do?page=1&board_code=6&categorys=1'" class="btn btn-primary" value="���">
<input type="button"  onclick="location.href='List.do?page=1&board_code=7&categorys=1'" class="btn btn-primary" value="��ƿ">
<input type="button"  onclick="location.href='List.do?page=1&board_code=8&categorys=1'" class="btn btn-primary" value="����">


</body>
</html>