package com.wing.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wing.member.dao.MemberDao;
import com.wing.member.domain.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	public MemberDao memberDao;
	
	

	@Override
	public MemberVo memberExist(String email, String password) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(email, password);
	}
	
//	@Override
//	public int memberInsertOne(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//		return memberDao.memberInsertOne(memberVo);
//	}
//
//	@Override
//	public MemberVo memberSelectOne(int no) {
//		// TODO Auto-generated method stub
//		return memberDao.memberSelectOne(no);
//	}
//
//	@Override
//	public int memberUpdateOne(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//		return memberDao.memberUpdateOne(memberVo);
//	}
//	
//	@Override
//	public int memberDeleteOne(int no) {
//		// TODO Auto-generated method stub
//		return memberDao.memberDeleteOne(no);
//	}
//
//	public List<MemberVo> memberSelectList(String searchOption, String keyword, String orderBy, String sortDirection) {
//	    Map<String, Object> searchMap = new HashMap<>();
//	    searchMap.put("keyword", keyword);
//	    searchMap.put("searchOption", searchOption);
//	    searchMap.put("orderBy", orderBy);           // 정렬 기준 추가
//	    searchMap.put("sortDirection", sortDirection); // 정렬 방향 추가
//
//	    return memberDao.memberSelectList(searchMap);
//	}
//	public List<MemberVo> memberSelectList(String searchOption, String keyword) {
//	    // 검색만 처리하는 메서드
//	    Map<String, Object> searchMap = new HashMap<>();
//	    searchMap.put("keyword", keyword);
//	    searchMap.put("searchOption", searchOption);
//
//	    return memberDao.memberSelectList(searchMap);
//	}
//	
}
