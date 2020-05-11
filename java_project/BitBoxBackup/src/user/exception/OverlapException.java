package user.exception;

public class OverlapException extends Exception{

	public OverlapException() {
		super("이미 존재하는 id입니다.\n다른 id를 입력해주세요.");
	}


	
}
