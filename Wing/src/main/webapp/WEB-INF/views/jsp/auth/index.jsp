<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" 
   integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" 
   crossorigin="anonymous">
</script>
<style type="text/css">

</style>

<script>
    $(document).ready(function() {
        $('#loginForm').on('submit', function(e) {
            e.preventDefault(); // 기본 폼 제출 방지

            const email = $('input[name="email"]').val();
            const password = $('input[name="password"]').val();

            $.ajax({
                url: '/auth/login', // 로그인 API 경로
                method: 'POST',
                contentType: 'application/json', // 기본 폼 데이터 전송
                data: JSON.stringify ({
                    email: email,
                    password: password
                }),
                success: function(response) {
                    alert('로그인 성공!'); // 성공 메시지
                    // 추가 동작: 메인 페이지로 이동 등
                    window.location.href = '/member/MemberMainPage'; // 메인 페이지로 이동
                },
                error: function(xhr) {
                    alert(xhr.responseText); // 실패 메시지 (invalid email or password)
                }
            });
        });
    });
</script>

</head>

<!-- action="/auth/login" -->
<body>
	<h2>사용자 로그인</h2>
	<form id="loginForm" method="post" > 
		<label>이메일</label>
		<input type="text" name="email" placeholder="ex:hong@test.com" value="">
		<br>
		<label>암호</label> <input type="password" name="password" value="">
		<br>
		<input type="submit" value="로그인">
	</form>
	 <div><a href="/jsp/common/common-scroll.html">scroll event!</a></div>
	 <div><a href="/admin/AdminMainPage.jsp">admin</a></div>
	 <div class="signup-container">
          <a href="/auth/signin" class="text__white">회원가입</a>
        </div>
</body>
</html>