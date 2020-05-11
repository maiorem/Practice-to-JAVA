package ex;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("소켓 서버가 준비되었습니다.");
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//클라이언트에서 소켓 연결 요청이 올때까지 대기
		while (true) {
			System.out.println("연결 요청을 기다립니다.");
			
			//요청이 들어오면 연결 소켓 생성
			try {
				Socket socket = serverSocket.accept(); //요청이 들어올 때까지 대기
				System.out.println(socket.getInetAddress()+"로 부터 연결요청이 들어왔습니다.");
				
				//출력 스트림을 소켓으로부터 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//클라이언트 소켓으로 데이터를 전송한다.
				dos.writeUTF("[Notice] Test Message from Server");
				System.out.println("데이터를 전송했습니다.");
				
				dos.close();
				socket.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
