<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>

	<label>제목</label>
	<input type="text" name="title" value="${viewview.title}"/><br />
		
	<label>작성자</label>
	<input type="text" name="writer" value="${viewview.writer}" /><br />
		
	<label>내용</label>
	<input type="text" name="content" value="${viewview.content}" /><br />

</body>
</html>