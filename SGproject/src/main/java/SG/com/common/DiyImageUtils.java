package SG.com.common;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class DiyImageUtils {

	private static final String filePath = "C:\\java\\SGproject\\SGproject\\src\\main\\webapp\\resources\\file\\diyFile\\";

	// DIY게시판 이미지등록
	public Map<String, Object> diyImageInsert(Map<String, Object> map, HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

		if (multipartHttpServletRequest.getFile("DIY_IMAGE") != null) {
			System.out.println("실행시작");
			MultipartFile file = multipartHttpServletRequest.getFile("DIY_IMAGE");
			String fileName = "DIY_" +System.currentTimeMillis()+"_"+ map.get("DIY_NO").toString();

			String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			File uploadFile = new File(filePath + fileName + IMAGEExtension);

			try {
				file.transferTo(uploadFile);
			} catch (Exception e) {

			}
			System.out.println(fileName + IMAGEExtension);
			map.put("DIY_IMAGE", fileName + IMAGEExtension);
		}
		return map;
		
	}
	
	
	// DIY게시판 이미지 수정
	public Map<String, Object> diyImageUpdate(Map<String, Object> map, HttpServletRequest request)
			throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartHttpServletRequest.getFile("DIY_IMAGE");
		
		System.out.println(file.getOriginalFilename());//TEST
		
		String fileName = "DIY_"+System.currentTimeMillis()+"_" + map.get("DIY_NO").toString();

		String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		File uploadFile = new File(filePath + fileName + IMAGEExtension);

		if (map.get("ORIGINAL_DIY_IMAGE") != null) {
			String orgFileName = (String) map.get("ORIGINAL_DIY_IMAGE");
			File removeFile = new File(filePath + orgFileName);
			removeFile.delete();
		}

		try {
			file.transferTo(uploadFile);
		} catch (Exception e) {
		}

		map.put("DIY_IMAGE", fileName + IMAGEExtension);

		System.out.println("diy이미지 수정완료");
		
		return map;
	}

	// DIY게시판 이미지  삭제
	public void diyImageDelete(Map<String, Object> map) throws Exception {

		if (map.get("DIY_IMAGE") != null) {
			File removeFile = new File(filePath + map.get("DIY_IMAGE"));
			removeFile.delete();
		}

	}
	
	

}