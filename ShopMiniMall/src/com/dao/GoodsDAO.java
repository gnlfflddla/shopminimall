package com.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.dto.PageDTO;

public class GoodsDAO {
	public int totalCount(SqlSession session ,String gcategory) {
		return session.selectOne("GoodsMapper.TotalCount",gcategory);
	}
	public int totalAllCount(SqlSession session) {
		return session.selectOne("GoodsMapper.TotalAllCount");
	}
	public GoodsDTO goodsRetrieve(SqlSession session, String gCode){
		GoodsDTO dto = new GoodsDTO();
		dto= session.selectOne("GoodsMapper.goodsRetrieve", gCode);
		return dto;
	}
	public List<GoodsDTO> goodsList(SqlSession session, String gcategory){
		List<GoodsDTO> list= new ArrayList<>();
		list= session.selectList("GoodsMapper.goodsList", gcategory);
		return list;
	 }
	public PageDTO selectAllPageGoods(SqlSession session,String gcategory, int curPage, int perPage) {

		PageDTO pDTO = new PageDTO();

		int offset = (curPage - 1) * perPage;
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsList", gcategory, new RowBounds(offset, perPage));

		pDTO.setCurPage(curPage);
		pDTO.setPerPage(perPage);
		pDTO.setList(list);
		pDTO.setTotalCount(totalCount(session,gcategory));
		return pDTO;
}
	public PageDTO selectrAllPageGoods(SqlSession session, int curPage, int perPage) {
		// TODO Auto-generated method stub
		PageDTO pDTO = new PageDTO();

		int offset = (curPage - 1) * perPage;
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsAllList", null, new RowBounds(offset, perPage));

		pDTO.setCurPage(curPage);
		pDTO.setPerPage(perPage);
		pDTO.setList(list);
		pDTO.setTotalCount(totalAllCount(session));
		return pDTO;
	}
}
