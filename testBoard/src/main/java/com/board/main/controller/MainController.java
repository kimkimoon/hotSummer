package com.board.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.main.service.BoardService;

@Controller
public class MainController {

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
		return "boardList";
	}
}
