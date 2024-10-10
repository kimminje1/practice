package com.wing.auth.controller;

//auth:로그인,로그아웃,회원가입기능
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wing.auth.service.AuthService;
import com.wing.auth.domain.AuthVo;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private Logger log = LoggerFactory.getLogger(AuthController.class);
	private final String logTitleMsg = "==AuthController==";
	
	@Autowired
	private AuthService authService;
	
	
	
	// 로그인 회원정보 조회 및 검증
	@PostMapping("/login")
	 public ResponseEntity<?> Login( @RequestBody AuthVo authVo, HttpSession session) {
		log.info("Welcome MemberController getLogin! "
	 + authVo.getEmail() + ", " + authVo.getPassword());
		
		   AuthVo existingMember 
		   = authService.memberExist(authVo.getEmail(), authVo.getPassword());
		
		
		
		if(existingMember != null) {
		    session.setAttribute("auth", existingMember);
		    return ResponseEntity.ok().body(existingMember); 
		 // 로그인 성공 시 200 OK와 함께 사용자 정보 반환
		}else {
			// jsp
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password"); // 401 Unauthorized 응답
		}
		
	
	}
	
	@GetMapping("/signin")
	public String showSignUpPage(Model model) {
	    return "/auth/Signin.jsp"; // Signin.jsp 페이지를 반환
	}
	
	 @PostMapping("/logout")
	    public ResponseEntity<String> logout(HttpSession session) {
	        log.info("logout");

	        session.invalidate(); // 세션 무효화
	        return ResponseEntity.ok().body("Logged out successfully"); // 200 OK 응답
	    }
	
	
//	@GetMapping("/list")
//	public String getMemberList(@RequestParam(defaultValue = "all") String searchOption
//			,@RequestParam(defaultValue = "") String keyword
//			 ,@RequestParam(defaultValue = "") String orderBy // 정렬 기준 추가
//		        ,@RequestParam(defaultValue = "") String sortDirection// 정렬 방향 추가
//			,Model model) {
//		log.info(logTitleMsg);
//		 log.info("@GetMapping getMemberList searchOption: {}, keyword: {}, orderBy: {}, sortDirection: {}",
//		            searchOption, keyword, orderBy, sortDirection);
//		
//		List<MemberVo> memberList
//		= memberService.memberSelectList(searchOption,keyword,orderBy,sortDirection);
//		
//		Map<String, Object> searchMap = new HashMap<>();
//		searchMap.put("searchOption",searchOption);
//		searchMap.put("keyword",keyword);
//		searchMap.put("orderBy", orderBy);
////		if (sortDirection == "ASC") {
////	        sortDirection = "DESC";
////	    } else {
////	    	sortDirection = "ASC";
////	    }
//		 searchMap.put("sortDirection", sortDirection);
//		//기존꺼사용
//		 //따로만드는게맞나 아니면?
//	model.addAttribute("memberList", memberList);
//	model.addAttribute("searchMap", searchMap);	
//	
//		
//		return "member/MemberListView";
//	}
	
//	// 회원 추가 화면으로
//	@GetMapping("/add")
//	public String memberAdd(Model model) {
//		log.info(logTitleMsg);
//		log.info("@GetMapping memberAdd");
//
//		return "member/MemberFormView";
//	}
//	
//	// 회원 추가 db
//	@PostMapping("/add")
//	public String memberAdd(MemberVo memberVo, Model model) {
////		public String memberAdd(MemberVo memberVo, 
////			@RequestParam("email2")List<String> email2, Model model) {
//		log.info(logTitleMsg);
//		log.info("@PostMapping memberAdd: {}", memberVo);
////		log.info("email2: {}", email2);
//		
//		memberService.memberInsertOne(memberVo);
//
//		return "redirect:/member/list";
//	}
//	
//	// 회원상세 페이지
//	@GetMapping("/detail")
//	public String memberDetail(@RequestParam int memberNo, Model model) {
//		log.info(logTitleMsg);
//		log.info("@GetMapping memberDetail memberNo: {}", memberNo);
//		
//		MemberVo memberVo = memberService.memberSelectOne(memberNo);
//		
//		model.addAttribute("memberVo", memberVo);
//		
//		return "member/MemberDetailView";
//	}
//	
//	// 회원수정 화면으로
//	@GetMapping("/update")
//	public String memberUpdate(int memberNo, Model model) {
//		log.info(logTitleMsg);
//		log.info("@GetMapping memberUpdate memberNo: {}", memberNo);
//
//		MemberVo memberVo = memberService.memberSelectOne(memberNo);
//		
//		model.addAttribute("memberVo", memberVo);
//
//		return "member/MemberUpdateFormView";
//	}
//	
//	// 회원수정 db
//	@PostMapping(value = "/update")
//	public String memberUpdate(MemberVo memberVo
//		, RedirectAttributes redirectAttributes) {
//		log.info(logTitleMsg);
//		log.info("@PostMapping memberUpdate memberVo: {}", memberVo);
//
//		memberService.memberUpdateOne(memberVo);
//
//		redirectAttributes.addAttribute("memberNo", memberVo.getMemberNo());
//		
//		return "redirect:/member/detail";
//	}
//	
//	// 회원탈퇴
//	@DeleteMapping("/delete/{memberNo}")
//	public ResponseEntity<String> memberDelete(@PathVariable("memberNo") int memberNo)
//	{
//		log.info(logTitleMsg);
//		log.info("@DeleteMapping memberDelete: {}", memberNo);
//
//		memberService.memberDeleteOne(memberNo);
//
//		
//		
//		return ResponseEntity.ok("회원 삭제 성공");
//	}
	
}