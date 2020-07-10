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
	
	public List<BoardVo> getBoardList(String search) {
		System.out.println("BoardService:getBoardList");
				
		return boardDao.getBoardList(search);
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
		
		return boardDao.boardInsert(boardVo);
	}
	
	public int boardDelete(int no) {
		System.out.println("boardService:boardDelete");
		
		return boardDao.boardDelete(no);
	}
	
	public int boardUpdate(BoardVo boardVo) {
		System.out.println("boardService:boardUpdate");
		
		
		return boardDao.boardUpdate(boardVo);
	}

}
