package com.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartDAO {
	
	public List<CartDTO> orderAllConfirm(SqlSession session, List<String> list) {
		List<CartDTO> rlist=null;
		rlist=session.selectList("CartMapper.orderAllConfirm", list);
		return rlist;
	}
	public int cartAllDel(SqlSession session, List<String> list) {
		int result=0;
		result=session.delete("CartMapper.cartAllDel", list);
		return result;
	}
	public int cartDel(SqlSession session, String num) {
		int result=0;
		System.out.println("DAO del"+num);
		result=session.delete("CartMapper.cartDel", num);
		return result;
	}
	public int cartAdd(SqlSession session, CartDTO cart) {
		int result=0;
		result=session.insert("CartMapper.cartAdd", cart);
		return result;
	}
	public List<CartDTO> cartList(SqlSession session, String userid) {
		List<CartDTO> list=session.selectList("CartMapper.cartList", userid);
		return list;
	}
	public int cartMod(SqlSession session, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		int result =0;
		result = session.update("CartMapper.cartMod", map);
		return result;
	}
	public CartDTO cartOrder(SqlSession session, String num) {
		// TODO Auto-generated method stub
		CartDTO dto = new CartDTO();
		dto = session.selectOne("CartMapper.cartByNum", num);
		return dto;
	}
	public int orderDone(SqlSession session, OrderDTO dto) {
		// TODO Auto-generated method stub
		int result=0;
		result = session.insert("CartMapper.orderDone", dto);
		return result;
	}
	public int orderAllDone(SqlSession session, List<OrderDTO> list) {
		// TODO Auto-generated method stub
		int result=0;
		result=session.insert("CartMapper.orderAllDone", list);
		return result;
	}
	
	
}
