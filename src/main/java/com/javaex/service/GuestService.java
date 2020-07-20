package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	
	@Autowired
	GuestDao guestDao;
	
	public List<GuestVo> getGuestList() {
		System.out.println("GuestService:getGuestList");
		
		List<GuestVo> guestList = guestDao.getGuestList();
		
		return guestList;
	}
	
	public int contentsInsert(GuestVo guestVo) {
		System.out.println("GuestService:contentsInsert");
		
		return guestDao.contentsInsert(guestVo);
	}
	
	public int contentsDelete(GuestVo guestVo) {
		System.out.println("GuestService:contentsDelete");
		
		return guestDao.contentsDelete(guestVo);
	}
	
	//방명록 글 저장(ajax)
	public GuestVo ajaxContentsInsert(GuestVo guestVo) {
		System.out.println("GuestService:ajaxContentsInsert");
		guestDao.insertSelectKey(guestVo);
		int no = guestVo.getNo();
		System.out.println(no);
		
		GuestVo vo = guestDao.selectByNo(no);
		
		return vo;

	}

}
