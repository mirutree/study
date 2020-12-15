<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원목록</h2>
<input type="button" value="회원등록" onclick="location.href='/member/write.do'">
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
		<td>
			<!-- 이름을 클릭하면 아이디를 넘김 -->
			<a href="${path}/member/view.do?userid=${row.userid}">${row.name}</a>
		</td>
		<td>${row.email}</td>
		<td>
		<!-- formatDate value="날짜값" pattern="출력형식" -->
		<fmt:formatDate value="${row.join_date}" pattern="yyyy-MM-dd HH:mm:ss" />
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>