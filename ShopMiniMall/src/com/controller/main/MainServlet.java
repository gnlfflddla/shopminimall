package com.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.dto.PageDTO;
import com.service.GoodsService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*GoodsService service = new GoodsService();
		List<GoodsDTO> list = service.goodsList("top");
		request.setAttribute("goodsList", list);*/
		int curPage = 1; 
		
		HttpSession session = request.getSession();
		session.setAttribute("gCategory", "all");
		GoodsService service = new GoodsService();
		PageDTO gPage = service.selectrAllPageGoods(curPage,5);
		session.setAttribute("goodsPage", gPage);
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
