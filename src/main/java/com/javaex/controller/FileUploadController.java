package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;

@Controller
@RequestMapping("fileupload")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	
	@RequestMapping("/form")
	public String form() {
		System.out.println("fileupload/form");
		
		return "fileupload/form";
	}
	
	@RequestMapping("/upload")
	public String upload(Model model, @RequestParam("file") MultipartFile file) {
		System.out.println("fileupload/upload");
		System.out.println(file.getOriginalFilename());
		
		String saveName = fileUploadService.restore(file);
		
		model.addAttribute("saveName", saveName);
		
		return "fileupload/result";
	}

}
