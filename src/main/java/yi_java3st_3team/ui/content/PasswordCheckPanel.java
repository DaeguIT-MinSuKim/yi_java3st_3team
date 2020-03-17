package yi_java3st_3team.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.ui.MainFrame_user;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PasswordCheckPanel extends JPanel implements ActionListener {
	private JPasswordField pfPassword;
	private JButton btnCheck;
	private MainFrame_user userFrame;
	/**
	 * Create the panel.
	 */
	public PasswordCheckPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(0, 1, 0, 30));
		
		JLabel lblPass = new JLabel("비밀번호 재확인");
		lblPass.setFont(new Font("굴림", Font.BOLD, 20));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPass);
		
		pfPassword = new JPasswordField();
		pfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword.setFont(new Font("굴림", Font.PLAIN, 20));
		add(pfPassword);
		
		btnCheck = new JButton("확인");
		btnCheck.addActionListener(this);
		btnCheck.setFont(new Font("굴림", Font.PLAIN, 20));
		add(btnCheck);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheck) {
			btnCheckActionPerformed(e);
		}
	}
	protected void btnCheckActionPerformed(ActionEvent e) {
		
	}
}
