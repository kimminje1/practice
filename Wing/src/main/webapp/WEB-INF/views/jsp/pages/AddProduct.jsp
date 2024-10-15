<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>AddProduct</title>
    <link rel="stylesheet" href="/css/addProduct.css" />
    <script defer src="/js/addProduct.js"></script>
  </head>
  <body>
    <div class="user-input">
      <div class="input-container size__s">
        <label for="category">구분</label>
        <input id="category" name="category" type="text" class="u--i u--i__s" />
      </div>

      <div class="input-container size__l">
        <label for="content">세부 내용</label>
        <input id="content" name="content" type="text" class="u--i u--i__l" />
      </div>

      <div class="input-container size__m">
        <label for="percentage">할인율(금액)</label>
        <input
          id="percentage"
          name="percentage"
          type="text"
          class="u--i u--i__s"
        />
      </div>

      <button id="addProduct" class="btn">추가</button>
    </div>

    <form id="card-add-form" class="submit-form">
      <div id="service">
        <ul class="service-content">
          <li class="service-li size__s">구분</li>
          <li class="service-li size__l">세부내용</li>
          <li class="service-li size__m">할인율(금액)</li>
          <li class="service-li size__s">비고</li>
        </ul>
      </div>
    </form>
  </body>
</html>
