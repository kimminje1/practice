<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SignIn</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/signin.css" />
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous">
</script>

</head>
<body>
	<div class="title-container">
		<div class="title text__navy">WING_</div>
	</div>
	<!-- form container -->
	<div class="form-container">
		<div class="subject-container bg__red">
			<h2 class="subject text__white">슬기롭게 소비 생활하기</h2>
		</div>

		<form id="signinForm" class="signin-form" action="">
			<div class="signin-container">
				<div class="label-container">
					<label for="email" class="text__white">이메일</label>
				</div>
				<div class="input-container email-check-porision">
					<input id="email" name="email" type="email" required
						pattern="[a-z0-9_]+@[a-z0-9.\-]+\.[a-z]{2,}$"
						placeholder="이메일을 작성해 주세요." maxlength="36"
						class="signin--input__m" autocomplete="username" />
				</div>
			</div>

			<div class="signin-container">
				<div class="label-container">
					<label for="pwd" class="text__white">패스워드</label>
				</div>
				<div class="input-container">
					<input id="pwd" name="password" type="password"
						placeholder="비밀번호를 작성해 주세요." required minlength="8" maxlength="21"
						class="signin--input__m" autocomplete="current-password" />
				</div>
			</div>

			<div class="submit-container">
				<input type="submit" class="btn__sign text__white" value="SignIn" />
			</div>
		</form>

		<div class="sub-container">
			<div class="find-container">
				<a href="#" class="text__white">아이디 찾기</a>
			</div>
			<div class="find-container">
				<a href="#" class="text__white">비밀번호 찾기</a>
			</div>
			<div class="signup-container">
				<a href="${pageContext.request.contextPath}/auth/signUp" class="text__white">회원가입</a>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/auth/SignIn.js"></script>
</html>