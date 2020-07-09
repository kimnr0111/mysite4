package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getBoardList() {
		System.out.println("BoardDao:getBoardList");
		List<BoardVo> boardList = sqlSession.selectList("board.selectList");
		return boardList;
	}
	
	public BoardVo getBoard(int no) {
		System.out.println("BoardDao.getBoard");
		
		BoardVo boardVo = sqlSession.selectOne("board.select", no);
		System.out.println(boardVo.toString());
		
		return boardVo;
	}
	
	public int addHit(int no) {
		System.out.println("boardDao.addHit");
		
		return sqlSession.update("board.addHit", no);
	}
	
	public int boardInsert(BoardVo boardVo) {
		System.out.println("boardDao.boardInsert");
		
		sqlSession.insert("board.boardInsert", boardVo);
		System.out.println(boardVo.toString());
		
		return 0;
	}
	
	public int boardDelete(int no) {
		System.out.println("boardDao.boardDelete");
		
		sqlSession.delete("board.boardDelete", no);
		
		return 0;
	}
	
	public int boardUpdate(BoardVo boardVo) {
		System.out.println("boardDao.boardUpdate");
		
		sqlSession.update("board.boardUpdate", boardVo);
		
		return 0;
	}
	

}
