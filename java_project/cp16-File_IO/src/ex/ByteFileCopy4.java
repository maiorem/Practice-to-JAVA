package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy4 {

	public static void main(String[] args)  {

		//원본 파일의 데이터를 프로그램 안으로 가져와야 한다.
		//=> InputStream 인스턴스 생성
		InputStream in= null;


		//새로운 파일을 생성
		// => OutputStream 인스턴스 생성
		OutputStream out= null;

		int copyByte = 0;
		int readLen;
		byte[] buf = new byte[1024];
		try {
			in = new FileInputStream("git.exe");
			out = new FileOutputStream("git_copy.exe");

			while(true) {

				readLen = in.read(buf);
				if(readLen==-1) {
					break;
				}
				out.write(buf, 0, readLen);
				copyByte+=readLen;

			} 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("복사된 바이트 크기 : "+copyByte);
	}


}





