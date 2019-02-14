package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberIdFindServlet")
public class MemberIdFindServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		MemberDTO dto = new MemberDTO(username, phone1, phone2, phone3);
		MemberService service = new MemberService();
		String id = service.findId(dto);
		String nextPage=null;

		
		if(id!=null) {
			nextPage="LoginForm.jsp";
			String m="아이디는 "+id+" 입니다.";
			request.setAttribute("mesg", m);
		}else {
			
			nextPage="IdFindForm.jsp";
			request.setAttribute("mesg", "아이디가 존재하지 않습니다.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
