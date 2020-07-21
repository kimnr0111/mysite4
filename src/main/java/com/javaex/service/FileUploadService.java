package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	public String restore(MultipartFile file) {
		System.out.println("FileUploadService:restore");
		//파일카피////////////////////////////////////////
		String saveDir = "C:\\javaStudy\\upload";
		
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
