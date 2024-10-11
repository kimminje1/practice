
$(document).ready(function() {
	$('#signinForm').on('submit', function(e) {
		e.preventDefault(); // 기본 폼 제출 방지 로그인용임

		const email = $('input[name="email"]').val();
		const password = $('input[name="password"]').val();

		$.ajax({
			url: 'api/auth/login', // 로그인 API 경로
			method: 'POST',
			contentType: 'application/json', // 기본 폼 데이터 전송
			data: JSON.stringify({
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
