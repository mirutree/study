<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(function(){
	$("#button1").click(function(){ //#button1을 클릭하면 펑션 실행
		dan=$("#dan").val();					// #dan에 입력한 값을 가져와서
		param={"dan":dan};					// 보내줌 변수명 "dna" 
		$.ajax({										// 비동기식으로
			type: "post",		
			url: "ajax_gugu_result.do",	// 이주소로
			data: param,							// data를 보냄
			success: function(result) {	// 완료후 가져와서
				$("#result").html(result);	// #result에다가 html형식으로 출력
				}
			});
		});
});
</script>
</head>
<body>
	<h2>구구단 계산</h2>
	단을 입력하세요 <input type="number" id="dan" value="3">
	<input type="button" id="button1" value="확인">
	<div id="result"></div>
</body>
</html>