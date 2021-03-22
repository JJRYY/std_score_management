package std_score_management.ui.exception;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {

	public InvalidCheckException() {
		super("공백이 존재합니다");
		JOptionPane.showMessageDialog(null, "공백이 존재합니다");
	}

	public InvalidCheckException(Throwable cause) {
		super("공백이 존재합니다", cause);
	}

}
