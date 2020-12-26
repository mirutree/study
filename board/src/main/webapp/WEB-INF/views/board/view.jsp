<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>
<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>
	<label>제목</label>
	<input type="text" name="title" value="${viewview.title}"/><br />
		
	<label>작성자</label>
	<input type="text" name="writer" value="${viewview.writer}" /><br />
		
	<label>내용</label>
	<input type="text" name="content" value="${viewview.content}" /><br />
	
	<div>
	<a href="/board/modify?bno=${viewview.bno}">게시물 수정</a>
	</div>
	
	<div>
	<a href="/board/list">게시물 목록</a>
	</div>

</body>
</html>