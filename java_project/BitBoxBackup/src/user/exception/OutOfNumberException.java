package user.exception;

public class OutOfNumberException extends Exception {

	public OutOfNumberException() {
		super("존재하지 않는 메뉴입니다.\n다시 선택해주세요.");	
	}

	
}
