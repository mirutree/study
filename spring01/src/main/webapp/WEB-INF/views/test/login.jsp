<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(function(){ //페이지가 로딩되면 자동 실행	
	$("#btnLogin").click(function(){		// id가 btnLiogin인 버튼을 누르면 다음 펑션을 실행
		id=$("#id").val(); 							// 태그아이디가 id인 태그에 입력한 값
		pw=$("#pw").val(); 						// 태그아이디가 pw인 태그에 입력한 값을
		param={"id":id, "pw":pw}; 			// 자바스크립트 객체 형식
		$.ajax({ 		// ajax를 이용한 비동기식 호출
			type: "post", 		
			url: "login_result.do", 		
			data: param,		// data에 id와 pw를 보냄
			success: function(result) { // 성공하면 result에 넘어옴
				$("#result").html(result);	//id가 result인 태그에 출력해라
				}
			});
		});
});
</script>
</head>
<body>

id: <input type="text" id="id">
pw: <input type="password" id="pw">
<input type="button" id="btnLogin" value="로그인">

<div id="result"></div>

</body>
</html>