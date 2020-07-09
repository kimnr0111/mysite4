package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping("gb")
public class GuestbookController {
	
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("/gb/list");
		
		List<GuestVo> gList = guestService.getGuestList();
		System.out.println(gList.toString());
		
		model.addAttribute("gList", gList);
		
		return "guestbook/addList";
	}
	
	@RequestMapping(value="add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestVo guestVo) {
		System.out.println("/gb/add");
		System.out.println(guestVo.toString());
		guestService.contentsInsert(guestVo);
		
		return "redirect:/gb/list";
	}
	
	@RequestMapping(value="deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(Model model, @RequestParam("no")int no) {
		System.out.println("/gb/deleteForm");
		
		model.addAttribute("no", no);
		
		return "guestbook/deleteForm";
	}
	
	@RequestMapping(value="delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		System.out.println("/gb/delete");
		
		guestService.contentsDelete(guestVo);
		
		return "redirect:/gb/list";
	}
	

}
