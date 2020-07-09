package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public List<BoardVo> getBoardList() {
		System.out.println("BoardService:getBoardList");
				
		return boardDao.getBoardList();
	}
	
	public BoardVo getBoard(int no) {
		System.out.println("BoardService:getBoard");
		
		return boardDao.getBoard(no);
	}
	
	public int addHit(int no) {
		
		return boardDao.addHit(no);
	}
	
	public int boardInsert(BoardVo boardVo) {
		System.out.println("boardService:boardInsert");
		
		boardDao.boardInsert(boardVo);
		
		return 0;
	}
	
	public int boardDelete(int no) {
		System.out.println("boardService:boardDelete");
		
		boardDao.boardDelete(no);
		
		return 0;
	}
	
	public int boardUpdate(BoardVo boardVo) {
		System.out.println("boardService:boardUpdate");
		
		boardDao.boardUpdate(boardVo);
		
		return 0;
	}

}
