package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("upload") // @GetMapping에 들어있는 upload가 파일경로이다. =>  classpath:/templates/upload.html 이렇게 만들어야 함 
	public void getUploadPage() {} // void는 경로가 파일경로와 같을경우 사용 
		
	@PostMapping("formUpload") // 컨트롤러에서 해당 값을 받을 때 사용
	public String formUploadFile(@RequestPart MultipartFile[] images) { //@RequestPart = 파라미터 처리 어노테이션
		for(MultipartFile image : images) {
			if(image.getContentType().startsWith("image")== false) {
				System.out.println("No Image");
				return null;
			}
			String originalName = image.getOriginalFilename();
			System.out.println("original : "+ originalName);
			String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
			System.out.println("fileName : " + fileName);
			
			String uploadPath = "C:\\upload";
			String saveName = uploadPath + File.separator + fileName;// File.separator = 자바가 인식하는 경로 구분자
			System.out.println("saveName: " + saveName);

			Path savePath = Paths.get(saveName); // 실제 경로로 변환하는 작업
			
			
			try {
				image.transferTo(savePath); //transferTo = 실제 파일 저장하는 메서드
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "upload";
	}
}
