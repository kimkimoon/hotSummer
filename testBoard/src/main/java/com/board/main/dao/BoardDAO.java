package com.board.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("boardMapper")
public class BoardDAO implements DAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;


	@SuppressWarnings("rawtypes")
	public List selectList(int page) {
		return sqlSession.selectList("boardMapper.selectBoardList",page);
	}

	@Transactional
	public int insertBoard(Map<String, Object> datas) {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardMapper.inBoard",datas);
	}

	public int hitUP(int NO) {
		// TODO Auto-generated method stub
		return sqlSession.update("boardMapper.hitUp",NO);
	}

	public int modifyBoard(Map<String, Object> datas) {
		// TODO Auto-generated method stub
		return sqlSession.update("boardMapper.modifyQuery",datas);
	}

	public int replyBoard(Map<String, Object> datas) {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardMapper.replyInsert",datas);
	}
	
	
	
}
