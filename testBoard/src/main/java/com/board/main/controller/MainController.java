package com.board.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.VO.BoardVO;
import com.board.main.service.BoardService;

@Controller
public class MainController implements Controllers {

	@RequestMapping("/index")
	public String mainController() {
		return "index";
	}
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String selectBoardList(@RequestParam(defaultValue = "1") int page ,Model model) {
		List<Map<String,Object>>resultList = boardService.selectBoardList(page);
		model.addAttribute("list",resultList);
		//System.out.println(resultList);
		return "board/boardList";
	}
	
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void writeBoard(@RequestBody Map<String,Object> datas, HttpServletResponse response) {
		try {
			boardService.writeBoard(datas);
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}


	@RequestMapping(value="/board/hit", method=RequestMethod.POST)
	public void hitUp(@RequestParam int NO) {
		boardService.hitUP(NO);		
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void modifyBoard(@RequestBody Map<String,Object> datas, HttpServletResponse response) {
		try {
			boardService.modifyBoard(datas);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}


	@RequestMapping(value="/board/reply", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void replyBoard(@RequestBody Map<String, Object> datas, HttpServletResponse response) {
		try {
			boardService.replyBoard(datas);
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
}
