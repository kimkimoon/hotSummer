package com.board.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping(value="/board/list")
	public String selectBoardList(Model model) {
		List<Map<String,Object>>resultList = boardService.selectBoardList();
		model.addAttribute("list",resultList);
		//System.out.println(resultList);
		return "board/boardList";
	}
	
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	@ResponseBody
	public int writeBoard(@RequestParam Map<String,Object> params) {
		int result = 0;
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			result = boardService.writeBoard(params);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
