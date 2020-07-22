package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class FileUploadDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVo> getGalleryList() {
		System.out.println("FileUploadDao:getGalleryList");
		List<GalleryVo> gList = sqlSession.selectList("gallery.selectList");
		System.out.println(gList.toString());
		
		return gList;
	}
	
	public int restore(GalleryVo galleryVo) {
		System.out.println("FileUploadDao:restore");
		System.out.println(galleryVo.toString());
		
		return sqlSession.insert("gallery.galleryInsert", galleryVo);
		
	}
	
	public GalleryVo getGallery(int no) {
		System.out.println("FileUploadDao:getGallery");
		GalleryVo galleryVo = sqlSession.selectOne("gallery.selectGallery", no);
		System.out.println(galleryVo.toString());
		
		return galleryVo;
	}
	
	public int deleteGallery(int no) {
		System.out.println("FileUploadDao:deleteGallery");
		
		return sqlSession.delete("gallery.deleteGallery", no);
	}

}
