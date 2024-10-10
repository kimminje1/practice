package com.wing.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wing.member.domain.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.wing.member.";
	
	

	@Override
	public MemberVo memberExist(String email, String password) {
		// TODO Auto-generated method stub
		HashMap<String, Object> paramMap = new HashMap();
		paramMap.put("email", email);
		paramMap.put("pwd", password);
		
		return sqlSession.selectOne(namespace + "memberExist", paramMap);
	}

//	@Override
//	public int memberInsertOne(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//		
//		return sqlSession.insert(namespace + "memberInsertOne", memberVo);
//		
//	}
//
//	@Override
//	public MemberVo memberSelectOne(int no) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectOne(namespace + "memberSelectOne", no);
//	}
//	
//	@Override
//	public int memberUpdateOne(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//		return sqlSession.update(namespace + "memberUpdateOne", memberVo);
//	}
//	
//	@Override
//	public int memberDeleteOne(int no) {
//		// TODO Auto-generated method stub
//		return sqlSession.delete(namespace + "memberDeleteOne", no);
//	}
//
//	@Override
//	public List<MemberVo> memberSelectList(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectList(namespace+"memberSelectList",map);
//	}
//	
}
