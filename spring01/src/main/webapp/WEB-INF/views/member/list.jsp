<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원목록</h2>
<table border="1" width="700px">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일자</td>
	</tr>
<!-- 코어태그 jstl -->
<c:forEach var="row" items="${items}">
	<tr>
		<td>${row.userid}</td>
		<td>${row.name}</td>
		<td>${row.email}</td>
		<td>${row.join_date}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>