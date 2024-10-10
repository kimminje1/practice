<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SignUp</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
    />
    <link rel="stylesheet" href="/css/common.css" />
    <link rel="stylesheet" href="/css/signup.css" />
    <script defer src="/js/signup.js"></script>
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

      <form id="signupForm" class="signup-form" action="javascript:void(0);">
        <div class="signup-container">
          <div class="label-container">
            <label for="email" class="text__white">이메일</label>
          </div>
          <div class="input-container email-check-porision">
            <input
              id="email"
              name="email"
              type="email"
              required
              pattern="[a-z0-9_]+@[a-z0-9.\-]+\.[a-z]{2,}$"
              placeholder="ex) wing_@gmail.com"
              maxlength="36"
              autocomplete="off"
            />
          </div>
        </div>

        <div class="signup-container">
          <div class="label-container">
            <label for="pwd" class="text__white">패스워드</label>
          </div>
          <div class="input-container">
            <input
              id="pwd"
              name="password"
              type="password"
              placeholder="비밀번호를 작성해 주세요."
              required
              minlength="8"
              maxlength="21"
              autocomplete="off"
            />
          </div>
        </div>

        <div class="signup-container">
          <div class="label-container">
            <label for="user-pwd" class="text__white">패스워드 확인</label>
            <span id="pwdError"></span>
          </div>
          <div class="input-container">
            <input
              id="pwdCheck"
              name="password"
              type="password"
              placeholder="동일한 비밀번호를 작성해 주세요."
              required
              minlength="8"
              maxlength="21"
              autocomplete="off"
            />
          </div>
        </div>

        <div class="signup-container">
          <div class="label-container">
            <label for="userName" class="text__white">성명</label>
          </div>
          <div class="input-container">
            <input
              id="userName"
              name="userName"
              type="text"
              required
              pattern="[가-힣]{2,7}"
              placeholder="ex) 홍길동"
              maxlength="36"
            />
          </div>
        </div>

        <div class="signup-container">
          <div class="label-container">
            <label for="phone" class="text__white"
              >휴대폰 번호<span class="help-text text__gray"
                >(하이픈(-) 없이 숫자만 입력해주세요.)</span
              ></label
            >
          </div>
          <div class="input-container">
            <input
              type="tel"
              id="phone"
              name="phone"
              required
              pattern="^01[016789][0-9]{3,4}[0-9]{4}$"
              placeholder="ex) 01012345678"
              maxlength="12"
            />
          </div>
        </div>

        <div class="signup-container">
          <div class="salary-container">
            <div class="label-container">
              <label for="salary" class="text__white">연봉</label>
            </div>

            <div class="style-container">
              <div class="input-container input-container__s">
                <input
                  type="text"
                  id="salary"
                  name="salary"
                  required
                  placeholder="ex) 4,500"
                  class="input__s"
                />
              </div>
              <span class="text__white">만원</span>
            </div>
          </div>

          <div class="salary-container">
            <div class="label-container">
              <label for="pay" class="text__white">월급</label>
            </div>

            <div class="style-container">
              <div class="input-container input-container__s">
                <input
                  type="text"
                  id="pay"
                  name="pay"
                  required
                  placeholder="ex) 375"
                  class="input__s"
                />
              </div>
              <span class="text__white">만원</span>
            </div>
          </div>
        </div>

        <div class="submit-container">
          <input
            id="submitBtn"
            type="submit"
            class="btn__sign text__white"
            value="SignUp"
          />
        </div>
      </form>
    </div>
  </body>
</html>
