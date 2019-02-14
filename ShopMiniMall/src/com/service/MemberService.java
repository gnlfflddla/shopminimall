package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.configuration.MySqlSesstionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	public int memberUpdate(MemberDTO member) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			MemberDAO dao = new MemberDAO();
			result=dao.memberUpdate(session, member);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;
		
	}
	public int memberAdd(MemberDTO member) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			MemberDAO dao = new MemberDAO();
			result=dao.memberAdd(session, member);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;

	}
	public int checkId(String id) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			MemberDAO dao = new MemberDAO();
			result=dao.checkId(session, id);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;

	}
	public MemberDTO login(HashMap<String, String> map) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		MemberDTO dto = new MemberDTO();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.login(session, map);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return dto;
	}
	public MemberDTO mypage(String userid) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		MemberDTO dto = new MemberDTO();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.mypage(session, userid);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return dto;
	}
	public String findId(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSesstionFactory.getSesstion();
		String result=null;
		try {
			MemberDAO dao = new MemberDAO();
			result = dao.findId(session, dto);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return result;
	}
	public String findPwd(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSesstionFactory.getSesstion();
		String result=null;
		try {
			MemberDAO dao = new MemberDAO();
			result = dao.findPwd(session, dto);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return result;
	}
}
