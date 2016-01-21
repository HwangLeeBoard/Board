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
<title>후니후니</title>
<body style="padding:30px">
  <table height="54" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="200" style="cursor:pointer" onmouseover="" 
        onclick="javascript:void(top.body_frame.location='../admin/board_admin.jsp')">
            <div id="admin_td_0" align="center">
                <font color=""><strong>게시판</strong>
                </font>
            </div>
        </td>
     
        <td width="200" style="cursor:pointer" onmouseover="" 
        onclick="javascript:void(top.body_frame.location='../admin/member_admin.jsp')">
            <div id="admin_td_1" align="center">
                <font color=""><strong>회원</strong>
                </font>
            </div>
        </td>



    </tr>
    </table>
</body>
</html>