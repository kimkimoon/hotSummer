package com.board.main.service;

import java.util.List;
import java.util.Map;

public interface ServiceBoard {

	public List<Map<String,Object>>selectBoardList();
	
	public int writeBoard(Map<String, Object> params);
}
