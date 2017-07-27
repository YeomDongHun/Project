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

@Component("toppingImageUtils")
public class ToppingImageUtils {

	private static final String filePath = "C:\\java\\SGFinal\\SGproject\\src\\main\\webapp\\resources\\file\\goodsFile\\"; //파일저장경로

	//토핑 이미지등록
	public Map<String, Object> toppingImageInsert(Map<String, Object> map, HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request; //request타입을 MultiParHttpServletRequest로

		if (multipartHttpServletRequest.getFile("TOPPING_IMG") != null) { //File의 이름 중 GOODS_THUMBNAIL이 있다면
			MultipartFile file = multipartHttpServletRequest.getFile("TOPPING_IMG"); //GOOS_THUMBNAIL이름을 가진 파일을 꺼내서 저장.
			String fileName = "SG_TOPPING_" + map.get("TOPPING_NO").toString(); //파일이름을 SG_Thumbnail_ + 상품번호로

			String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); //해당 파일의 '.확장자' 가져옴 (substring메서드는 매개인자로 주어지는 값을 통해 문자열 반환) lastIndexOf메서드는 해당 문자열의 위치 반환 

			File uploadFile = new File(filePath + fileName + IMAGEExtension);//File객체 생성

			try {
				file.transferTo(uploadFile);//transferTo메서드는 파일을 저장하는 메서드
			} catch (Exception e) {

			}

			map.put("TOPPING_IMG", fileName + IMAGEExtension); //map에 저장
		}
		return map;//map리턴
	}

	// 토핑이미지수정
	public Map<String, Object> toppingImageUpdate(Map<String, Object> map, HttpServletRequest request)
			throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartHttpServletRequest.getFile("TOPPING_IMG");

		String fileName = "SG_TOPPING_" +System.currentTimeMillis()+"_"+map.get("TOPPING_NO").toString();

		String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

		File uploadFile = new File(filePath + fileName + IMAGEExtension);

		if (map.get("ORIGINAL_TOPPING_IMG") != null) {
			String orgFileName = (String) map.get("ORIGINAL_TOPPING_IMG");
			File removeFile = new File(filePath + orgFileName);
			removeFile.delete();
		}

		try {
			file.transferTo(uploadFile);
		} catch (Exception e) {
		}

		map.put("TOPPING_IMG", fileName + IMAGEExtension);

		return map;
	}


	// 토핑 이미지 삭제 
	public void toppingImageDelete(Map<String, Object> map) throws Exception {

		if (map.get("TOPPING_IMG") != null) {//이미지 파일이 있다면 
			File removeFile = new File(filePath + map.get("TOPPING_IMG"));
			removeFile.delete();
		}

	}
	
}
