package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getBoardList(String search, int startRnum, int endRnum) {
		System.out.println("BoardDao:getBoardList");
		System.out.println("search=" + search);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		
		if("".equals(search)) {
			System.out.println("기본");
			List<BoardVo> boardList = sqlSession.selectList("board.selectList", map);
			return boardList;
		} else {
			System.out.println("검색");
			List<BoardVo> boardList = sqlSession.selectList("board.searchList", search);
			return boardList;
		}
	}
	
	public BoardVo getBoard(int no) {
		System.out.println("BoardDao.getBoard");
		System.out.println(no);
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
		
		if("".equals(boardVo.getTitle()) || "".equals(boardVo.getContent())) {
			System.out.println("다시 입력");
		} else {
			if(boardVo.getGroupNo() == 0) {
				sqlSession.insert("board.boardInsert", boardVo);
			} else {
				sqlSession.insert("board.replyboardInsert", boardVo);
			}
			System.out.println(boardVo.toString());
		}
		
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

	
	public int getList() {
		System.out.println("boardDao:getList");
			
		return sqlSession.selectOne("board.getListCnt");
	}
	

}
