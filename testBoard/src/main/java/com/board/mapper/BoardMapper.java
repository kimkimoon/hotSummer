package com.board.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.board.main.dao.BoardDAO;

@Repository("boardMapper")
public class BoardMapper extends BoardDAO {

	public List<Map<String,Object>>selectBoardList(){
		return(List<Map<String,Object>>)selectList("boardMapper.selBoardList");
	}
}
