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
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

@WebServlet("/MemberPswFindServlet")
public class MemberPswFindServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		MemberDTO dto =new MemberDTO();
		dto.setUserid(userid);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		MemberService service = new MemberService();
		String passwd = service.findPwd(dto);
		String nextPage=null;
		request.setAttribute("passwd", passwd);
		
		if(passwd!=null) {
			nextPage="SendMailServlet";
			
		}else {
			
			nextPage="PwdFindForm.jsp";
			request.setAttribute("mesg", "실패했습니다.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
