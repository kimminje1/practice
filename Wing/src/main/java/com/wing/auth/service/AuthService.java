package com.wing.auth.service;

import java.util.List;

import com.wing.auth.domain.AuthVo;

public interface AuthService {

	
	public AuthVo memberExist(String email, String password);
	public int memberInsertOne(AuthVo authVo);
//	public AuthVo memberSelectOne(int no);
//	public int memberUpdateOne(AuthVo memberVo);
//	public int memberDeleteOne(int no);

}
