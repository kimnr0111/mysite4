package com.javaex.vo;

public class BoardVo {
	
	private int no;
	private String title;
	private String content;
	private int hit;
	private String boarddate;
	private int userNo;
	private String name;
	
	public BoardVo() {}
	
	public BoardVo(int no, String title, String content, int hit, String boarddate, int userNo, String name) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.boarddate = boarddate;
		this.userNo = userNo;
		this.name = name;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nBoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", boarddate="
				+ boarddate + ", userNo=" + userNo + ", name=" + name + "]";
	}	

}
