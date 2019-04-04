package com.board.main.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.VO.BoardVO;

public interface Controllers {

	public String selectBoardList(int page,Model model);
	public void writeBoard(@RequestBody Map<String,Object> datas, HttpServletResponse response);
	public void hitUp(int No);
	public void modifyBoard(@RequestBody Map<String,Object> datas, HttpServletResponse response);
	public void replyBoard(@RequestBody Map<String,Object> datas, HttpServletResponse response);
}
