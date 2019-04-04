package com.board.main.service;

import java.util.List;
import java.util.Map;

public interface ServiceBoard {

	public List<Map<String,Object>>selectBoardList(int page);
	
	public int writeBoard(Map<String, Object> datas);
	public void hitUP(int NO);
	public void modifyBoard(Map<String, Object> datas);
	public void replyBoard(Map<String, Object> datas); 
}
