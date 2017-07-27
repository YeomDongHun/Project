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
public class FaqImageUtils {

	private static final String filePath = "C:\\java\\SGFinal\\SGproject\\src\\main\\webapp\\resources\\file\\faqFile\\";

	// FAQ 이미지등록
	public Map<String, Object> faqImageInsert(Map<String, Object> map, HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

		if (multipartHttpServletRequest.getFile("FAQ_IMAGE") != null) {
			System.out.println("실행시작");
			MultipartFile file = multipartHttpServletRequest.getFile("FAQ_IMAGE");
			String fileName = "FAQ_" +System.currentTimeMillis()+"_"+ map.get("FAQ_NO").toString();

			String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			File uploadFile = new File(filePath + fileName + IMAGEExtension);

			try {
				file.transferTo(uploadFile);
			} catch (Exception e) {

			}
			System.out.println(fileName + IMAGEExtension);
			map.put("FAQ_IMAGE", fileName + IMAGEExtension);
		}
		return map;
	}


	// FAQ 이미지 수정
	public Map<String, Object> faqImageUpdate(Map<String, Object> map, HttpServletRequest request)
			throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartHttpServletRequest.getFile("FAQ_IMAGE");

		String fileName = "FAQ_" +System.currentTimeMillis()+"_"+ map.get("FAQ_NO").toString();

		String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

		File uploadFile = new File(filePath + fileName + IMAGEExtension);

		
		//기존 파일이 있을경우 삭제 
		if (map.get("ORIIGINAL_FAQ_IMAGE") != null) {
			String orgFileName = (String) map.get("ORIGINAL_FAQ_IMAGE");
			File removeFile = new File(filePath + orgFileName);
			removeFile.delete();
		}

		try {
			file.transferTo(uploadFile);
		} catch (Exception e) {
		}

		map.put("FAQ_IMAGE", fileName + IMAGEExtension);

		System.out.println("FAQ이미지 수정완료");
		return map;
	}

	// FAQ이미지 삭제
	public void faqImageDelete(Map<String, Object> map) throws Exception {

		if (map.get("FAQ_IMAGE") != null) {
			File removeFile = new File(filePath + map.get("FAQ_IMAGE"));
			removeFile.delete();
		}

	}
	

}