package com.wing.member.domain;


import java.util.Date;

import jakarta.persistence.Id;

import lombok.Data;



@Data 
public class MemberVo {
    
    @Id
    private int memberNo;      			  // 회원번호 (기본키)
    
    private String email;                // 이메일
    private String password;             // 비밀번호
    private String memberName;           // 성명
    private String phone;                // 휴대폰 번호
    private String grade;                // 등급
    private int yearlySalary;            // 연봉
    private int monthlySalary;           // 월급
    private Date   createdDate;          // 가입일자
    private Date   modifiedDate;         // 수정일자
    private String quitApply;            // 탈퇴신청 여부
    private String productPurchase;      // 상품구매 여부
}
