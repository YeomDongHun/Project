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

@Component("goodsImageUtils")
public class GoodsImageUtils {

	private static final String filePath = "C:\\java\\SGproject\\SGproject\\src\\main\\webapp\\resources\\file\\goodsFile\\"; //파일저장경로

	//썸네일 이미지등록
	public Map<String, Object> goodsThumbnail(Map<String, Object> map, HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request; //request타입을 MultiParHttpServletRequest로

		if (multipartHttpServletRequest.getFile("GOODS_THUMBNAIL") != null) { //File의 이름 중 GOODS_THUMBNAIL이 있다면
			MultipartFile file = multipartHttpServletRequest.getFile("GOODS_THUMBNAIL"); //GOOS_THUMBNAIL이름을 가진 파일을 꺼내서 저장.
			String fileName = "SG_Thumbnail_" +System.currentTimeMillis()+"_"+ map.get("GOODS_NO").toString(); //파일이름을 SG_Thumbnail_ + 상품번호로

			String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); //해당 파일의 '.확장자' 가져옴 (substring메서드는 매개인자로 주어지는 값을 통해 문자열 반환) lastIndexOf메서드는 해당 문자열의 위치 반환 

			File uploadFile = new File(filePath + fileName + IMAGEExtension);//File객체 생성

			try {
				file.transferTo(uploadFile);//transferTo메서드는 파일을 저장하는 메서드
			} catch (Exception e) {

			}

			map.put("GOODS_THUMBNAIL", fileName + IMAGEExtension); //map에 저장
		}
		return map;//map리턴
	}

	//상품이미지
	public List<Map<String, Object>> parseInsertFileInfo(Map<String, Object> map, HttpServletRequest request)
			throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;

		if (multipartHttpServletRequest.getFiles("IMAGE_IMAGE") != null) {
			List<MultipartFile> imageFile = multipartHttpServletRequest.getFiles("IMAGE_IMAGE");

			// System.out.println("IMAGE : "+imageFile);
			// Iterator<String> iterator =
			// multipartHttpServletRequest.getFileNames();

			// MultipartFile multipartFile = null;
			String IMAGE = null;
			String IMAGEExtension = null;

			String GOODS_NO = map.get("GOODS_NO").toString();

			File file = new File(filePath);
			if (file.exists() == false) {
				file.mkdirs(); // 폴더가 없다면 폴더생성
			}

			for (MultipartFile multipartFile : imageFile) {
				// System.out.println("IMAGE File : "+multipartFile);
				if (multipartFile.isEmpty() == false) {
					IMAGEExtension = multipartFile.getOriginalFilename()
							.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
					IMAGE = "SG_IMAGE_" + GOODS_NO + "_" + System.currentTimeMillis() + IMAGEExtension;

					file = new File(filePath + IMAGE);
					multipartFile.transferTo(file);

					listMap = new HashMap<String, Object>();
					listMap.put("IMAGE_IMAGE", IMAGE);

					listMap.put("GOODS_NO", map.get("GOODS_NOs"));
					list.add(listMap);

				}

			}

			return list;
		} else {
			return list;
		}

	}

	// 썸네일이미지수정
	public Map<String, Object> parseUpdateThumbImage(Map<String, Object> map, HttpServletRequest request)
			throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartHttpServletRequest.getFile("GOODS_THUMBNAIL");

		String fileName = "SG_Thumbnail_" +System.currentTimeMillis()+"_"+ map.get("GOODS_NO").toString();

		String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

		File uploadFile = new File(filePath + fileName + IMAGEExtension);

		if (map.get("ORIGINAL_GOODS_THUMBNAIL") != null) {
			String orgFileName = (String) map.get("ORIGINAL_GOODS_THUMBNAIL");
			File removeFile = new File(filePath + orgFileName);
			removeFile.delete();
		}

		try {
			file.transferTo(uploadFile);
		} catch (Exception e) {
		}

		map.put("GOODS_THUMBNAIL", fileName + IMAGEExtension);

		return map;
	}
	
	
	//이미지 수정
	public Map<String, Object> goodsImageModify(Map<String, Object> map, HttpServletRequest request)
			throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartHttpServletRequest.getFile("IMAGE_IMAGE");

		String fileName = "SG_IMAGE_" +System.currentTimeMillis()+"_"+ map.get("GOODS_NO").toString();

		String IMAGEExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

		File uploadFile = new File(filePath + fileName + IMAGEExtension);

		if (map.get("ORIGINAL_IMAGE_IMAGE") != null) {
			String orgFileName = (String) map.get("ORIGINAL_IMAGE_IMAGE");
			File removeFile = new File(filePath + orgFileName);
			removeFile.delete(); //기존 파일 삭제 
		}

		try {
			file.transferTo(uploadFile); //새 파일 등록
		} catch (Exception e) {
		}

		map.put("IMAGE_IMAGE", fileName + IMAGEExtension); //새 파일이름  Map에 담음.
		map.put("GOODS_NO", map.get("GOODS_NO"));

		return map;
	}


	// 썸네일 이미지 삭제 
	public void parseDeleteThumbnail(Map<String, Object> map) throws Exception {

		if (map.get("GOODS_THUMBNAIL") != null) {//이미지 파일이 있다면 
			File removeFile = new File(filePath + map.get("GOODS_THUMBNAIL"));
			removeFile.delete();
		}

	}
	
	
	//이미지 삭제 
	public void parseDeleteImages(Map<String, Object> map) throws Exception {

		if (map.get("IMAGE_IMAGE") != null) { //이미지 파일이 있다면 
				File removeFile = new File(filePath + map.get("IMAGE_IMAGE"));
				removeFile.delete();
			}
		
	}

}
