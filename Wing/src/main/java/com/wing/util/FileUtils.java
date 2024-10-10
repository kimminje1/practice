package com.wing.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")	
public class FileUtils {

	private static final String FILE_PATH = "C:\\upload";
	
	public List<Map<String, Object>> parseInsertFileInfo
	(int parentId, MultipartHttpServletRequest mhr) throws Exception{
		
		Iterator <String> iterator = mhr.getFileNames();
		MultipartFile multipartFile =null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName =null;
		
		List<Map<String, Object>> fileList= 
				new ArrayList <Map<String, Object>>(); //여러건의데이터다루는기본
		Map<String, Object> fileInfoMap = null;
		
		
		File file = new File(FILE_PATH);
		
		if (file.exists() == false) {
			file.mkdir(); //디렉토리생성
		}
		while (iterator.hasNext()) { //파일개수만큼 파일처리
			multipartFile = mhr.getFile(iterator.next());
			
			if (multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName
						.substring(originalFileName.lastIndexOf(".")); //확장자분리
				storedFileName = CommonUtils.getRandomString()+ 
						originalFileExtension;
				file = new File(FILE_PATH, storedFileName);
				multipartFile.transferTo(file); //실제 파일이 생성
				
				
				fileInfoMap = new HashMap<>();
				fileInfoMap.put("parentId",parentId);
				fileInfoMap.put("originalFileName",originalFileName );
				fileInfoMap.put("storedFileName",storedFileName );
				fileInfoMap.put("fileSize", multipartFile.getSize());
				
				fileList.add(fileInfoMap);		
				
			}
			
			
		}
		
		
		return fileList;
	}

	public void parseDeleteFileInfo(List<Map<String, Object>> tempFileList) 
	throws Exception{
		// TODO Auto-generated method stub
		for (Map<String, Object> tempFileMap : tempFileList) {
			String storedFileName = (String) tempFileMap.get("STORED_FILE_NAME");
			
			File file = new File(FILE_PATH + "/" +storedFileName);
			if (file.exists()) {
				file.delete();
			} else {
				System.err.println("파일이 존재하지 않습니다.");
			}
		}
	}
	
	
	
	
	
}
