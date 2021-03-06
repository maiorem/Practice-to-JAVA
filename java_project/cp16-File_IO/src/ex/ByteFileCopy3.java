package ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy3 {

	public static void main(String[] args)  {

		//원본 파일의 데이터를 프로그램 안으로 가져와야 한다.
		//=> InputStream 인스턴스 생성
		InputStream in= null;


		//새로운 파일을 생성
		// => OutputStream 인스턴스 생성
		OutputStream out= null;
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		int copyByte = 0;
		int readLen;
		
		try {
			in = new FileInputStream("git.exe");
			out = new FileOutputStream("git_copy3.exe");
			
			
			//필터스트림 생성
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);
			

			while(true) {

				readLen = bin.read();
				if(readLen==-1) {
					break;
				}
				bout.write(readLen);
				copyByte++;

			} 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bin.close();
				bout.close();
				
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("복사된 바이트 크기 : "+copyByte);
	}


}





