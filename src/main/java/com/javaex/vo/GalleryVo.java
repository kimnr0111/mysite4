package com.javaex.vo;

public class GalleryVo {
	
	private int no;
	private int userNo;
	private String comments;
	private String filePath;
	private String saveName;
	private String orgName;
	private long fileSize;
	private String name;
	
	
	public GalleryVo() {}




	public GalleryVo(int no, int userNo, String comments, String filePath, String saveName, String orgName,
			long fileSize, String name) {
		this.no = no;
		this.userNo = userNo;
		this.comments = comments;
		this.filePath = filePath;
		this.saveName = saveName;
		this.orgName = orgName;
		this.fileSize = fileSize;
		this.name = name;
	}




	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", userNo=" + userNo + ", comments=" + comments + ", filePath=" + filePath
				+ ", saveName=" + saveName + ", orgName=" + orgName + ", fileSize=" + fileSize + ", name=" + name + "]";
	}

	
	
}
