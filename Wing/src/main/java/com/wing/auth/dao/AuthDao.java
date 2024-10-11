package com.wing.auth.dao;

import java.util.List;
import java.util.Map;

import com.wing.auth.domain.AuthVo;

public interface AuthDao {

//	List<MemberVo> memberSelectList(Map<String, Object> map); 
	
	public AuthVo memberExist(String email, String password);
	public  int memberInsertOne(AuthVo authVo); 
//	public MemberVo memberSelectOne(int no);
//	public int memberUpdateOne(MemberVo memberVo);
//	public int memberDeleteOne(int no);
}
