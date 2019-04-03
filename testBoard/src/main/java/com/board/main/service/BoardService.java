package com.board.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.main.dao.BoardDAO;
//import com.board.mapper.BoardMapper;

@Service
public class BoardService implements ServiceBoard {

	@Autowired
	BoardDAO boardDAO;
	
	public List<Map<String,Object>>selectBoardList(){
		List<Map<String,Object>> resultList = boardDAO.selectList();
		return resultList;
	}

	public int writeBoard(Map<String, Object> params) {
		int result = 0;
		result = boardDAO.insertBoard(params);
		return result;
	}
	
	
}
