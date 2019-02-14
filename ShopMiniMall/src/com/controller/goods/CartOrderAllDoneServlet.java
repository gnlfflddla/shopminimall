package com.controller.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@WebServlet("/CartOrderAllDoneServlet")
public class CartOrderAllDoneServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {
			String [] gcode = request.getParameterValues("gCode");
			String [] gcolor = request.getParameterValues("gColor");
			String [] gname = request.getParameterValues("gName");
			String [] gsize = request.getParameterValues("gSize");
			String [] gimage = request.getParameterValues("gImage");
			String [] gamount = request.getParameterValues("gAmount");
			String [] gprice =request.getParameterValues("gPrice");
			String [] num = request.getParameterValues("num");
			String userid = dto.getUserid();
			String orderName=request.getParameter("orderName");
			String post=request.getParameter("post");
			String addr1=request.getParameter("addr1");
			String addr2=request.getParameter("addr2");
			String phone=request.getParameter("phone");
			String paymethod=request.getParameter("payMethod");
			List<OrderDTO> list = new ArrayList<OrderDTO>();
			for (int i =0 ; i<gcode.length; i++) {
				OrderDTO order = new OrderDTO(0, gcode[i], gcolor[i], gname[i], gimage[i], gsize[i], Integer.parseInt(gamount[i]), Integer.parseInt(gprice[i]), userid, orderName, post, addr1, addr2, phone, paymethod,null);
				list.add(order);
			}
			List<String> numlist = Arrays.asList(num);
			CartService service = new CartService();
			int result = service.orderAllDone(list, numlist);
			session.setAttribute("orderAllDTO", list);
			nextPage="OrderAllDone.jsp";
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		response.sendRedirect(nextPage);
		//RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		//dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
