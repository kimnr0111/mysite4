package com.javaex.vo;

public class BoardVo {
	
	private int no;
	private String title;
	private String content;
	private int hit;
	private String boarddate;
	private int userNo;
	private String name;
	private int groupNo;
	private int orderNo;
	private int depth;
	
	public BoardVo() {}
	
	

	public BoardVo(int no, String title, String content, int hit, String boarddate, int userNo, String name,
			int groupNo, int orderNo, int depth) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.boarddate = boarddate;
		this.userNo = userNo;
		this.name = name;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
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

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}



	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", boarddate="
				+ boarddate + ", userNo=" + userNo + ", name=" + name + ", groupNo=" + groupNo + ", orderNo=" + orderNo
				+ ", depth=" + depth + "]";
	}

	

}
