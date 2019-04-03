package com.board.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.VO.BoardVO;

public interface Controllers {

	public String selectBoardList(Model model);
	public int writeBoard(Map<String,Object> params);
}
