package yi_java3st_3team.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.ui.LoginFrame_ex;
import yi_java3st_3team.ui.MainFrame_user;
import yi_java3st_3team.ui.ProfileMenuPanel;
import yi_java3st_3team.ui.ProfileModifyPanel;

import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class PasswordCheckPanel extends JPanel implements ActionListener {
	private JPasswordField pfPassword;
	private JButton btnCheck;
	private LoginFrame_ex loginFrame;
	/**
	 * Create the panel.
	 */
	public PasswordCheckPanel() {
		initialize();
	}
	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(300, 300, 300, 300));
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
	
	public LoginFrame_ex getLoginFrame() {
		return loginFrame;
	}
	public void setLoginFrame(LoginFrame_ex loginFrame) {
		this.loginFrame = loginFrame;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheck) {
			btnCheckActionPerformed(e);
		}
	}
	protected void btnCheckActionPerformed(ActionEvent e) {
		if(String.valueOf((pfPassword.getPassword())).equals(loginFrame.getMemMainFrame().getMember().getMberPass())) {
			loginFrame.getMemMainFrame().getContentPane().remove(loginFrame.getMemMainFrame().getpCenter());
			ProfileModifyPanel modifyPanel = (ProfileModifyPanel) loginFrame.getMemMainFrame().getProfileModifyPanel();
			loginFrame.getMemMainFrame().setpCenter(modifyPanel);
			loginFrame.getMemMainFrame().getContentPane().add(loginFrame.getMemMainFrame().getpCenter(),BorderLayout.CENTER);
			loginFrame.getMemMainFrame().repaint();
			loginFrame.getMemMainFrame().revalidate();
		}
		else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다 다시 입력해주세요");
			pfPassword.setText("");
		}
		
		
	}
}
