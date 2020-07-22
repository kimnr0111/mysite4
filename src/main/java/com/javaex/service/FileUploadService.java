package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileUploadDao;
import com.javaex.vo.GalleryVo;

@Service
public class FileUploadService {
	
	@Autowired
	FileUploadDao fileUploadDao;
	
	public List<GalleryVo> getGalleryList() {
		
		List<GalleryVo> gList = fileUploadDao.getGalleryList();
		
		return gList;
		
	}
	
	public GalleryVo getGallery(int no) {
		System.out.println("FileUploadService:getGallery");
		
		GalleryVo galleryVo = fileUploadDao.getGallery(no);
		
		return galleryVo;
	}
	
	public int deleteGallery(int no) {
		System.out.println("FileUploadService:deleteGallery");
		
		return fileUploadDao.deleteGallery(no);
	}
	
	public String restore(MultipartFile file, int userNo, String comments) {
		System.out.println("FileUploadService:restore");
		//파일카피////////////////////////////////////////
		String saveDir = "C:\\javaStudy\\upload";
		
		//받아온 값 체크
		System.out.println("userNo:" + userNo + "\ncomments:" + comments);
		
		//원파일이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:" + orgName);
		
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName:" + exName);
		
		//저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName:" + saveName);
		
		//파일경로
		String filePath = saveDir + "\\" + saveName;
		System.out.println(filePath);
		
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
		
		//파일 서버에 복사///////////////////////////////////
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패");
		}
		
		GalleryVo galleryVo = new GalleryVo(0, userNo, comments, filePath, saveName, orgName, fileSize, "");
		
		fileUploadDao.restore(galleryVo);
		
		
		return saveName;
		
		//파일-->필요한정보추출-->DB에 저장
//		no(next.val)
//		orgName: Gangho-dong.jpg
//		saveName: 1595320593164144404bf-7ccb-4022-a547-a0e3cbafac55
//		filePath: C:\\javaStudy\\upload\\1595320593164144404bf-7ccb-4022-a547-a0e3cbafac55.jpg
//		fileSize: 49876
		//위와같은 형식으로 db에 저장
		
		
	}

}
