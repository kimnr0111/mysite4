package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(UserVo userVo) {
		System.out.println("userDao:insert");
		
		int count = sqlSession.insert("user.insert", userVo);
		
		return count;
	}
	
	public UserVo selectUser(UserVo userVo) {
		System.out.println("userDao:login");
		
		return sqlSession.selectOne("user.selectUser", userVo);
	}
	
	public int modify(UserVo userVo) {
		System.out.println("userDao:modify");
		
		return sqlSession.update("user.modify", userVo);
	}
	
	public UserVo selectId(int no) {
		System.out.println("UserDao:selectId");

		return sqlSession.selectOne("user.selectId", no);
	}

}
