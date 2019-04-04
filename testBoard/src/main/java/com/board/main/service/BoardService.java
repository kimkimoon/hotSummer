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
	
	public List<Map<String,Object>>selectBoardList(int page){
		List<Map<String,Object>> resultList = boardDAO.selectList(page);
		return resultList;
	}

	public int writeBoard(Map<String, Object> datas) {
		int result = 0;
		result = boardDAO.insertBoard(datas);
		return result;
	}

	public void hitUP(int NO) {
		// TODO Auto-generated method stub
		boardDAO.hitUP(NO);
	}

	public void modifyBoard(Map<String, Object> datas) {
		// TODO Auto-generated method stub
		boardDAO.modifyBoard(datas);
	}

	public void replyBoard(Map<String, Object> datas) {
		// TODO Auto-generated method stub
		boardDAO.replyBoard(datas);
	}
	
	
}
