package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.PageDTO;
import com.service.GoodsService;

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int curPage = 1;
		if (request.getParameter("curPage") != null) { // 클릭한 번호의 값이 있으면 가져와서 넣어준다
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		HttpSession session = request.getSession();
		String gcategory = request.getParameter("gCategory");
		if(gcategory != null) {
			session.setAttribute("gCategory", gcategory);
		}
		String gCategory = (String)session.getAttribute("gCategory");
		if (gCategory.equals("all")) {
			GoodsService service = new GoodsService();
			PageDTO gPage = service.selectrAllPageGoods(curPage, 5);
			session.setAttribute("goodsPage", gPage);
			RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
			dis.forward(request, response);
		} else {
			GoodsService service = new GoodsService();
			PageDTO gPage = service.selectAllPageGoods(gCategory, curPage, 5);
			session.setAttribute("goodsPage", gPage);
			RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
			dis.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
