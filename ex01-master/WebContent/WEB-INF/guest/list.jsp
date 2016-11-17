<%@page import="java.util.ArrayList"%>
<%@page import="com.hb.guest.model.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/ex01/css/grid.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
ArrayList list = (ArrayList) request.getAttribute("alist");
for(int i=0; i<list.size(); i++ ){
	GuestDto dto=(GuestDto)list.get(i);
	%>
	<p>
	<%=dto.getSabun()%>/<%=dto.getName()%>/<%=dto.getNalja()%>/<%=dto.getPay()%>
	</p>
	<%
	}
%>
<hr/>
<p><a href="./add.do">add</a></p>
<hr/>
<div class="container">
<c:forEach items="${alist }" var="dto">
	<a href="./detail.do?idx=${dto.sabun}">
	<div class="row">
		<div class="grid3"> ${dto.sabun} </div>
		<div class="grid3"> ${dto.name } </div>
		<div class="grid3"> ${dto.nalja } </div>
		<div class="grid3"> ${dto.pay } </p>
	</div>
	</a>
</c:forEach>
</div>
</body>
</html>









