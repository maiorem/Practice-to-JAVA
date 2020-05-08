package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy2 {

	public static void main(String[] args) throws IOException  {

		//원본 파일의 데이터를 프로그램 안으로 가져와야 한다.
		//=> InputStream 인스턴스 생성
		InputStream in= new FileInputStream("git.exe");


		//새로운 파일을 생성
		// => OutputStream 인스턴스 생성
		OutputStream out= new FileOutputStream("git_copy.exe");

		int copyByte = 0;
		int bData;



		while(true) {



			bData = in.read();
			if(bData==-1) {
				break;
			}
			out.write(bData);
			copyByte++;


			in.close();
			out.close();


		}
		System.out.println("복사된 바이트 크기 : "+copyByte);

	}
	

}


