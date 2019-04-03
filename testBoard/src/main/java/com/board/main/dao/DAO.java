package com.board.main.dao;

import java.util.List;
import java.util.Map;

public interface DAO {

	public List selectList();
	public int insertBoard(Map<String, Object> params);
}
