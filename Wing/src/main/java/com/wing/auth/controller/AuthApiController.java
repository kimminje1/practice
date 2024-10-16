package com.wing.auth.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wing.auth.domain.AuthVo;
import com.wing.auth.service.AuthService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth") 
public class AuthApiController {

	private Logger log = LoggerFactory.getLogger(AuthApiController.class);
	private final String logTitleMsg = "==AuthApiController==";

	@Autowired
	private AuthService authService;

	 @PostMapping("/signin")
	  public ResponseEntity<?> signin(@RequestParam Map<String, String> userInfo) {
	    Map<String, String> result = new HashMap<>();

	    try {
	      result.put("status", "success");
	      result.put("message", "로그인에 성공했습니다.");

	      return ResponseEntity.ok().body(result);
	    } catch (Exception e) {
	      result.put("status", "failed");
	      result.put("message", "서버 오류로 인해 로그인이 처리되지 못했습니다. 다시 한 번 시도해주세요.");
	      return ResponseEntity.internalServerError().body(result);
	    }
	  }

	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		log.info("logout");

		session.invalidate(); // 세션 무효화
		return ResponseEntity.ok().body("Logged out successfully"); // 200 OK 응답
	}

	// 회원 추가 화면으로
	// 회원 추가 db
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody AuthVo authVo) {
	    // 결과를 담을 map
	    Map<String, String> result = new HashMap<>();

	    try {
	    
	        authVo.setGrade("회원");  // 회원 등급 설정
	        
	        // DB에 insert
	        authService.memberInsertOne(authVo);

	        result.put("status", "success");
	        result.put("message", "회원가입에 성공했습니다.");

	        return ResponseEntity.ok().body(result);
	    } catch (Exception e) {
	        log.error("회원가입 중 오류 발생: ", e);
	        result.put("status", "failed");
	        result.put("message", "서버 오류로 인해 회원가입이 처리되지 못했습니다. 다시 시도해주세요.");
	        return ResponseEntity.internalServerError().body(result);
	    }
	}
	@PostMapping("/check-email")
	public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> request) {
		String email = request.get("email");
	    Map<String, String> result = new HashMap<>();
	    log.info("Checking for existing email: {}", email); // 로그 추가
	    try {
	    	
	    	
	        // 이메일 중복 체크
	    	Integer existingEmailCount  = authService.findByEmail(email);
	        if (existingEmailCount != null && existingEmailCount > 0) {
	            result.put("status", "failed");
	            result.put("message", "이미 존재하는 이메일입니다.");
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	        }

	        result.put("status", "success");
	        result.put("message", "사용 가능한 이메일입니다.");
	        return ResponseEntity.ok(result);
	        
	    } catch (Exception e) {
	    	 log.error("이메일 검증 중 오류 발생: {}, 이메일: {}", e.getMessage(), email, e);
	        result.put("status", "failed");
	        result.put("message", "서버 오류로 인해 이메일 검증이 처리되지 못했습니다. 다시 시도해주세요.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result); // 500 Internal Server Error 상태 코드
	  
	    }
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

//	
//	
//	
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
