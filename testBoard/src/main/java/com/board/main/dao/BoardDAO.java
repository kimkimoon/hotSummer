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
	
	protected Log log = LogFactory.getLog(BoardDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t: " + queryId);
		}
	}

	@SuppressWarnings("rawtypes")
	public List selectList() {
		return sqlSession.selectList("boardMapper.selBoardList");
	}

	@Transactional
	public int insertBoard(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardMapper.inBoard",params);
	}
	
	
	
}
