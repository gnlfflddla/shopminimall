package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.CartService;
import com.service.MemberService;

@WebServlet("/CartOrderDoneServlet")
public class CartOrderDoneServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {
			String gcode = request.getParameter("gcode");
			String gcolor = request.getParameter("gcolor");
			String gname = request.getParameter("gname");
			String gsize = request.getParameter("gsize");
			String gimage = request.getParameter("gimage");
			int gamount = Integer.parseInt(request.getParameter("gamount"));
			int gprice =Integer.parseInt(request.getParameter("gprice"));
			String num = request.getParameter("num");
			String userid = dto.getUserid();
			String orderName=request.getParameter("orderName");
			String post=request.getParameter("post");
			String addr1=request.getParameter("addr1");
			String addr2=request.getParameter("addr2");
			String phone=request.getParameter("phone");
			String paymethod=request.getParameter("payMethod");
			OrderDTO order = new OrderDTO(0, gcode, gcolor, gname, gimage, gsize, gamount, gprice, userid, orderName, post, addr1, addr2, phone, paymethod,null);
			CartService service = new CartService();
			int result = service.orderDone(order, num);
			session.setAttribute("orderDTO", order);
			nextPage="OrderDone.jsp";
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		//response.sendRedirect(nextPage);
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
