package std_score_management.ui.exception;

@SuppressWarnings("serial")
public class NotExistException extends RuntimeException {

	public NotExistException() {
		super("입력된 정보가 없습니다.");
	}

}
