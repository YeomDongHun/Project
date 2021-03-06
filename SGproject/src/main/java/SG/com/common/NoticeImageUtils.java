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
public class NoticeImageUtils {

	private static final String filePath = "C:\\java\\SGFinal\\SGproject\\src\\main\\webapp\\resources\\file\\noticeFile\\";

	// 공지사항 이미지등록
	public Map<String, Object> noticeImageInsert(Map<String, Object> map, HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

		if (multipartHttpServletRequest.getFile("NOTICE_IMAGE") != null) {
			System.out.println("실행시작");
			
			MultipartFile file = multipartHttpServletRequest.getFile("NOTICE_IMAGE");
			
			String fileName = "NOTICE_" + System.currentTimeMillis()+"_"+map.get("NOTICE_NO").toString();

			String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			File uploadFile = new File(filePath + fileName + IMAGEExtension);

			try {
				file.transferTo(uploadFile);
			} catch (Exception e) {

			}
			System.out.println(fileName + IMAGEExtension);
			map.put("NOTICE_IMAGE", fileName + IMAGEExtension);
		}
		return map;
		
	}
	
	
	// 공지사항 이미지 수정
	public Map<String, Object> noticeImageUpdate(Map<String, Object> map, HttpServletRequest request)
			throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartHttpServletRequest.getFile("NOTICE_IMAGE");
		
		System.out.println(file.getOriginalFilename());//TEST
		
		String fileName = "NOTICE_" +System.currentTimeMillis()+"_"+ map.get("NOTICE_NO").toString();

		String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		File uploadFile = new File(filePath + fileName + IMAGEExtension);

		if (map.get("ORIGINAL_NOTICE_IMAGE") != null) {
			String orgFileName = (String) map.get("ORIGINAL_NOTICE_IMAGE");
			File removeFile = new File(filePath + orgFileName);
			removeFile.delete();
		}

		try {
			file.transferTo(uploadFile);
		} catch (Exception e) {
		}

		map.put("NOTICE_IMAGE", fileName + IMAGEExtension);

		System.out.println("NOTICE이미지 수정완료");
		
		return map;
	}

	// 공지사항 이미지  삭제
	public void noticeImageDelete(Map<String, Object> map) throws Exception {

		if (map.get("NOTICE_IMAGE") != null) {
			File removeFile = new File(filePath + map.get("NOTICE_IMAGE"));
			removeFile.delete();
		}

	}
	

}