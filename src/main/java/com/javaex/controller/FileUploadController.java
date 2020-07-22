package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;
import com.javaex.vo.GalleryVo;

@Controller
@RequestMapping("fileupload")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/gallery")
	public String gallery(Model model) {
		System.out.println("fileupload/gallery");
		
		List<GalleryVo> gList = fileUploadService.getGalleryList();
		model.addAttribute("gList", gList);
		
		return "gallery/list";
	}
	
	@ResponseBody
	@RequestMapping("/getGallery")
	public GalleryVo getGallery(@RequestParam("no") int no) {
		System.out.println("fileupload/getGallery");
		System.out.println("no: " + no);
		
		GalleryVo galleryVo = fileUploadService.getGallery(no);
		
		
		return galleryVo;
	}
	
	
	@RequestMapping("/form")
	public String form() {
		System.out.println("fileupload/form");
		
		return "fileupload/form";
	}
	
	
	@RequestMapping("/upload")
	public String upload(Model model, 
						 @RequestParam("file") MultipartFile file,
						 @RequestParam("userNo") int userNo,
						 @RequestParam("comments") String comments) {
		System.out.println("fileupload/upload");
		System.out.println(file.getOriginalFilename());
		
		String saveName = fileUploadService.restore(file, userNo, comments);
		
		model.addAttribute("saveName", saveName);
		
		
		return "redirect:/fileupload/gallery";
	}
	
	@ResponseBody
	@RequestMapping("/deleteGallery")
	public int deleteGallery(@RequestParam("no") int no) {
		System.out.println("fileupload/deleteGallery");
		
		return fileUploadService.deleteGallery(no);
	}

}
