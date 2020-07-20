package com.javaex.controller;

import java.lang.reflect.Parameter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, @RequestParam(value="search", required=false, defaultValue="") String search,
									@RequestParam(value="page", required=false, defaultValue="1") int curPage) {
		System.out.println("/board/list");
		int listCnt = boardService.getList();
		System.out.println(listCnt);
		List<BoardVo> bList = boardService.getBoardList(search, curPage);
		System.out.println(bList.toString());
		model.addAttribute("bList", bList);
		model.addAttribute("listCnt", listCnt);
		
		return "board/list";
	}
	
	@RequestMapping(value="read", method = {RequestMethod.GET, RequestMethod.POST})
	public String read(Model model, @RequestParam("no") int no) {
		System.out.println("/board/read");
		
		boardService.addHit(no);
		BoardVo boardVo = boardService.getBoard(no);
		System.out.println(boardVo.toString());
		
		model.addAttribute("vo", boardVo);
		
		return "board/read";
	}
	
	@RequestMapping(value="writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(Model model, @RequestParam(value="groupno", required=false, defaultValue="0") int groupNo,
										 @RequestParam(value="orderno", required=false, defaultValue="0") int orderNo,
										 @RequestParam(value="depth", required=false, defaultValue="0") int depth) {
		System.out.println("/board/writeForm");
		
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("orderNo", orderNo);
		model.addAttribute("depth", depth);
		
		return "board/writeForm";
	}
	
	@RequestMapping(value="write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("/board/write");
		System.out.println(boardVo.toString());
		boardService.boardInsert(boardVo);
		
		return "redirect:/board/list";
	}

	@RequestMapping(value="delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println("/board/delete");
		
		boardService.boardDelete(no);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, @RequestParam("no") int no) {
		System.out.println("/board/modifyForm");
		
		BoardVo boardVo = boardService.getBoard(no);
		System.out.println(boardVo.toString());
		
		model.addAttribute("vo", boardVo);
		
		return "board/modifyForm";
	}
	
	@RequestMapping(value="modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("/board/modify");
		System.out.println(boardVo.toString());
		boardService.boardUpdate(boardVo);

		
		return "redirect:/board/list";
	}


}
