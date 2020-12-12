<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script> 
<script>
// $(선택자).이벤트함수(실행할코드)
// $(document).ready(function() { // 로딩이 되면 이 펑션을 실행
// {"name":"냉장고", "price":500000} 
$(function(){
	$.ajax({
		type: "post", 	// 포스트방식
		url: "background.do", 	// 이 주소로 전달
		success: function(result){ 	// 처리가 완료된 후에 이 평션을 실행 (콜백함수)
			console.log("test: " + result); 	// 콘솔에 넘어온 값을 출력
			$("#result").html("상품명: " + result.name + ", 가격: " + result.price); //id가 result인 태그에 html형식으로 내부영역에 이 값을 채워라
		}
	});
});
</script>
</head>
<body>

<jsp:include page="../include/menu.jsp" /> 
<div id="result"></div> <!-- 출력을 할 곳(아이디가 result) -->

</body>
</html>