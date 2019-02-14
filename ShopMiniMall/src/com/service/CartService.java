package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.configuration.MySqlSesstionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartService {

	public int orderDone(OrderDTO dto,String num) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			CartDAO dao = new CartDAO();
			result=dao.orderDone(session, dto);
			result=dao.cartDel(session, num);
			session.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.rollback();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;
		
	}
	public List<CartDTO> orderAllConfirm(List<String> list) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		List<CartDTO> rlist = null;
		try {
			CartDAO dao = new CartDAO();
			rlist=dao.orderAllConfirm(session, list);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return rlist;
		
	}
	public int cartAllDel(List<String> list) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			CartDAO dao = new CartDAO();
			result=dao.cartAllDel(session, list);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;
		
	}
	public int cartDel(String num) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			CartDAO dao = new CartDAO();
			result=dao.cartDel(session, num);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;
		
	}
	public int cartAdd(CartDTO cart) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			CartDAO dao = new CartDAO();
			result=dao.cartAdd(session, cart);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;

	}
	public List<CartDTO> cartList(String userid) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		List<CartDTO> list=new ArrayList<>();
		try {
			CartDAO dao = new CartDAO();
			list=dao.cartList(session, userid);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return list;
		
	}
	public CartDTO cartOrder(String num) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		CartDTO dto = new CartDTO();
		try {
			CartDAO dao = new CartDAO();
			dto=dao.cartOrder(session, num);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return dto;
		
	}
	public int cartMod(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			CartDAO dao = new CartDAO();
			result=dao.cartMod(session, map);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;
	}
	public int orderAllDone(List<OrderDTO> list, List<String> numlist) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			CartDAO dao = new CartDAO();
			result=dao.orderAllDone(session, list);
			result=dao.cartAllDel(session, numlist);
			session.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.rollback();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;
	}
	
}
