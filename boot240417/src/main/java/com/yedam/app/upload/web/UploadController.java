package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@Value("${file.upload.path}")
	private String uploadPath;

	@GetMapping("upload") // @GetMapping에 들어있는 upload가 파일경로이다. => classpath:/templates/upload.html 이렇게
							// 만들어야 함
	public void getUploadPage() {
	} // void는 경로가 파일경로와 같을경우 사용

	@PostMapping("formUpload") // 컨트롤러에서 해당 값을 받을 때 사용
	public String formUploadFile(@RequestPart MultipartFile[] images) { // @RequestPart = 파라미터 처리 어노테이션
		for (MultipartFile image : images) {
			if (image.getContentType().startsWith("image") == false) {
				System.out.println("No Image");
				return null;
			}
			String originalName = image.getOriginalFilename();
			System.out.println("original : " + originalName);
			String fileName = originalName.substring(originalName.lastIndexOf("//") + 1);
			System.out.println("fileName : " + fileName);

			// String uploadPath = "C:\\upload"; == @Value("${file.upload.path}") private
			// String uploadPath;

			String saveName = uploadPath + File.separator + fileName;// File.separator = 자바가 인식하는 경로 구분자
			System.out.println("saveName: " + saveName);

			Path savePath = Paths.get(saveName); // 실제 경로로 변환하는 작업

			try {
				image.transferTo(savePath); // transferTo = 실제 파일 저장하는 메서드
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "upload";
	}
	
// 아작스 부분
	@PostMapping("/uploadsAjax")
	@ResponseBody // 아작스에서 쓴다 ResponseBody
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) {

		List<String> imageList = new ArrayList<>(); // 배열 생성

			// 파일 타입이 맞는지 확인한다.
		for (MultipartFile uploadFile : uploadFiles) {
			if (uploadFile.getContentType().startsWith("image") == false) {
				System.err.println("this file is not image type");
				return null;
			}
			
			// 파일이름 가져오기
			String originalName = uploadFile.getOriginalFilename();
			String fileName = originalName.substring(originalName.lastIndexOf("//") + 1);

			System.out.println("fileName : " + fileName);
			 
			
			
			// 날짜 폴더 생성
			String folderPath = makeFolder();
			
			// UUID = 유니크한 값 /시간을 기준으로 랜덤한 값
			String uuid = UUID.randomUUID().toString();

			// 저장할 파일 이름 중간에 "_"를 이용하여 구분
			String uploadFileName = folderPath + File.separator + uuid + "_" + fileName;

			String saveName = uploadPath + File.separator + uploadFileName;

			Path savePath = Paths.get(saveName);

			// Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
			System.out.println("path : " + saveName);
			try {
				uploadFile.transferTo(savePath);
			
				// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
			} catch (IOException e) {
				e.printStackTrace();
			}
			//미리보기 방식?
			// DB에 해당 경로 저장
			// 1) 사용자가 업로드할 때 사용한 파일명
			// 2) 실제 서버에 업로드할 때 사용한 경로
			imageList.add(setImagePath(uploadFileName));
		}

		return imageList;
	}

	private String makeFolder() {
		// LocalDate를 문자열로 포멧
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
		String folderPath = str.replace("/", File.separator);
		
		// File newFile= new File(dir,"파일명");
		File uploadPathFoler = new File(uploadPath, folderPath);
		
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}

		return folderPath;
	}

	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}

}
