package ex;

import java.io.File;

public class FileTest1 {

	public static void main(String[] args) {
		
		//File myFile=new File("C:\\myJava\\test.txt");
		//File myFile=new File("C:\\myJava","test.txt");
		File myFile=new File("C:"+File.separator+"myJava"+File.separator+"test.txt");
				
		
		// 파일 존재 유무 확인
		if(myFile.exists()==false) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		} 
		
		// 새로운 폴더 경로 생성
		File reDir=new File("C:\\YourJava");
		reDir.mkdir(); // 디렉토리 생성
		
		//새로운 파일 경로 생성
		File reFile = new File(reDir, "new.txt");
		myFile.renameTo(reFile);
		if (reFile.exists()) {
			System.out.println("파일 이동 성공");
		} else {
			System.out.println("파일 이동 실패");
		}
		

	}

}
