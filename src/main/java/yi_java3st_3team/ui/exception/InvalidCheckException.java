package yi_java3st_3team.ui.exception;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {
	public InvalidCheckException() {
		super("아이디와 패스워드를 입력해주세요.");
	}
	
	public InvalidCheckException(Throwable cause) {
		super("아이디와 패스워드를 입력해주세요.", cause);
	}
}
