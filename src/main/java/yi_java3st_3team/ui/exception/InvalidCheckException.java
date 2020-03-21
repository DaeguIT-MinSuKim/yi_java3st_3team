package yi_java3st_3team.ui.exception;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {
	public InvalidCheckException() {
		JOptionPane.showMessageDialog(null, "작성되지 않은 내용이 있습니다.");
	}

}
