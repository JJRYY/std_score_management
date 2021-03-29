package std_score_management.ui.exception;

@SuppressWarnings("serial")
public class StdNotExistException extends RuntimeException {

	public StdNotExistException() {
		super("해당 학번 학생이 없습니다.");
	}

}
