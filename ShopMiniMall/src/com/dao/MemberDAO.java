package com.dao;


import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	public int memberUpdate(SqlSession session, MemberDTO member) {
		int result=0;
		result=session.update("MemberMapper.memberUpdate", member);
		return result;
	}
	public int memberAdd(SqlSession session, MemberDTO member) {
		int result=0;
		result=session.insert("MemberMapper.memberAdd", member);
		return result;
	}
	public int checkId(SqlSession session, String id) {
		int result=0;
		result=session.selectOne("MemberMapper.checkId", id);
		
		return result;
	}
	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto= new MemberDTO();
		dto=session.selectOne("MemberMapper.login", map);
		return dto;
	}
	public MemberDTO mypage(SqlSession session,String userid) {
		MemberDTO dto= new MemberDTO();
		dto=session.selectOne("MemberMapper.mypage", userid);
		return dto;
	}
	public String findId(SqlSession session, MemberDTO dto) {
		// TODO Auto-generated method stub
		String result=null;
		result = session.selectOne("MemberMapper.findId", dto);
		return result;
	}
	public String findPwd(SqlSession session, MemberDTO dto) {
		// TODO Auto-generated method stub
		String result=null;
		result = session.selectOne("MemberMapper.findPwd", dto);
		return result;
	}
	
}
