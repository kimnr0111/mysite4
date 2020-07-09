package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestVo> getGuestList() {
		
		List<GuestVo> guestList = sqlSession.selectList("guest.selectList");
		
		return guestList;
		
	}
	
	public int contentsInsert(GuestVo guestVo) {
		
		System.out.println("GuestDao:contentsInsert");
		
		return sqlSession.insert("guest.insert", guestVo);
	}
	
	public int contentsDelete(GuestVo guestVo) {
		
		System.out.println("GuestDao.contentsDelete");
		
		sqlSession.delete("guest.delete", guestVo);
		
		return 0;
	}

}
