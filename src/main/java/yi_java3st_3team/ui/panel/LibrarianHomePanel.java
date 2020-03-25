package yi_java3st_3team.ui.panel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LibrarianHomePanel extends JPanel {

	public LibrarianHomePanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblName = new JLabel("");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName);

		JLabel lblWelcome = new JLabel("환영합니다.");
		lblWelcome.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWelcome);
	}

}
