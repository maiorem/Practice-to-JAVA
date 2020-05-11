package user.exception;

public class OutOfRange extends Exception {

	public OutOfRange() {
		super("생년월일 8자리를 입력해주세요.");	
	}
}
