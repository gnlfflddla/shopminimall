package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;

@WebServlet("/GoodsCartServlet")
public class GoodsCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {
		
			String gImage = request.getParameter("gImage");
			String gCode = request.getParameter("gCode");
			String gName = request.getParameter("gName");
			String gPrice = request.getParameter("gPrice").trim();
			String gSize = request.getParameter("GOODS_SIZE");
			String gColor = request.getParameter("GOODS_COLOR");
			String gAmount = request.getParameter("GOODS_AMOUNT").trim();
			String userid = dto.getUserid();
			
			CartDTO cart = new CartDTO();
			cart.setgImage(gImage);
			cart.setgCode(gCode);
			cart.setgName(gName);
			cart.setgPrice(Integer.parseInt(gPrice));
			cart.setgSize(gSize);
			cart.setgColor(gColor);
			cart.setgAmount(Integer.parseInt(gAmount));
			cart.setUserid(userid);
			CartService service = new CartService();
			int result = service.cartAdd(cart);
			nextPage="GoodsRetrieveServlet?gCode="+gCode;
			session.setAttribute("mesg", "장바구니 담기 성공");
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		response.sendRedirect(nextPage);
		/*RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
