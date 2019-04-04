package com.board.main.dao;

import java.util.List;
import java.util.Map;

public interface DAO {

	public List selectList(int page);
	public int insertBoard(Map<String, Object> datas);
	public int hitUP(int NO);
	public int modifyBoard(Map<String, Object> datas);
	public int replyBoard(Map<String, Object> datas);
}
