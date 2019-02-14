package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.configuration.MySqlSesstionFactory;
import com.dao.GoodsDAO;
import com.dto.GoodsDTO;
import com.dto.PageDTO;

public class GoodsService {
	
	public GoodsDTO goodsRetrieve(String gCode) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		GoodsDTO dto = new GoodsDTO();
		try {
			GoodsDAO dao = new GoodsDAO();
			dto = dao.goodsRetrieve(session, gCode);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return dto;
	}
	public List<GoodsDTO> goodsList(String gcategory) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		List<GoodsDTO> list = new ArrayList<>();
		try {
			GoodsDAO dao = new GoodsDAO();
			list = dao.goodsList(session, gcategory);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return list;
	}
	public PageDTO selectAllPageGoods(String gcategory,int curPage,int perPage){
	 	SqlSession session = MySqlSesstionFactory.getSesstion();
		PageDTO pDTO = null;
		try {
			GoodsDAO dao = new GoodsDAO();
			pDTO = dao.selectAllPageGoods(session, gcategory, curPage ,perPage);
		}finally {
			session.close();
		}
		 return pDTO;
}
	public PageDTO selectrAllPageGoods(int curPage,int perPage){
		SqlSession session = MySqlSesstionFactory.getSesstion();
		PageDTO pDTO = null;
		try {
			GoodsDAO dao = new GoodsDAO();
			pDTO = dao.selectrAllPageGoods(session, curPage ,perPage);
		}finally {
			session.close();
		}
		return pDTO;
	}
	
}
