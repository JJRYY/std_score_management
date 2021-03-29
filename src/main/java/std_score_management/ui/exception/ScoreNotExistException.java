package std_score_management.ui.exception;

@SuppressWarnings("serial")
public class ScoreNotExistException extends RuntimeException {

	public ScoreNotExistException() {
		super("입력된 점수가 없습니다.");
	}

}
