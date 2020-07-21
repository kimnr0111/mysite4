package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/api/gb")
public class ApiGuestbookController {
	
	@Autowired
	private GuestService guestService;
	
	@ResponseBody
	@RequestMapping(value="/list", method = {RequestMethod.POST})
	public List<GuestVo> list() {
		System.out.println("/api/gb/list");
		List<GuestVo> guestbookList = guestService.getGuestList();
		
		return guestbookList;
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method = {RequestMethod.POST})
	public GuestVo add(@RequestBody GuestVo guestbookVo) {
		System.out.println("/api/gb/add");
		GuestVo vo = guestService.ajaxContentsInsert(guestbookVo);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method = {RequestMethod.POST})
	public int delete(@RequestBody GuestVo guestbookVo) {
		System.out.println("/api/gb/delete");
		System.out.println(guestbookVo.toString());
		return guestService.contentsDelete(guestbookVo);
	}
}
