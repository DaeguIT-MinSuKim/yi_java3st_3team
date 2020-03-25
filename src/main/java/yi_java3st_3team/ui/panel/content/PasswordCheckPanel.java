package yi_java3st_3team.ui.panel.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.LoginFrame;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.MainFrame_mgr;
import yi_java3st_3team.ui.MainFrame_lib;
import yi_java3st_3team.ui.MainFrame_user;
import yi_java3st_3team.ui.panel.LibrarianProfileModifyPanel;
import yi_java3st_3team.ui.panel.MemberProfileModifyPanel;
import yi_java3st_3team.ui.panel.submenu.WestMemberProfileMenuPanel;

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
	private Member member;
	private Librarian lib;
	private MainFrame_mgr mainFrame_ex;
	private MainFrame_user mainFrame_user;
	private MainFrame_lib mainFrame_lib;
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
		lblPass.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPass);
		
		pfPassword = new JPasswordField();
		pfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		add(pfPassword);
		
		btnCheck = new JButton("확인");
		btnCheck.addActionListener(this);
		btnCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		add(btnCheck);
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Librarian getLib() {
		return lib;
	}
	public void setLib(Librarian lib) {
		this.lib = lib;
	}
	public MainFrame_mgr getMainFrame_ex() {
		return mainFrame_ex;
	}
	public void setMainFrame_ex(MainFrame_mgr mainFrame_ex) {
		this.mainFrame_ex = mainFrame_ex;
	}
	public MainFrame_lib getMainFrame_lib() {
		return mainFrame_lib;
	}
	public void setMainFrame_lib(MainFrame_lib mainFrame_lib) {
		this.mainFrame_lib = mainFrame_lib;
	}
	public MainFrame_user getMainFrame_user() {
		return mainFrame_user;
	}
	public void setMainFrame_user(MainFrame_user mainFrame_user) {
		this.mainFrame_user = mainFrame_user;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheck) {
			btnCheckActionPerformed(e);
		}
	}
	protected void btnCheckActionPerformed(ActionEvent e) {
		if(member!=null) {
			String password = new String(pfPassword.getPassword());
			if(password.equals(member.getMberPass())) {
				mainFrame_user.getContentPane().remove(mainFrame_user.getpCenter());
				MemberProfileModifyPanel pCenter = new MemberProfileModifyPanel();
				pCenter.initTf(member);
				mainFrame_user.setpCenter(pCenter);
				mainFrame_user.getContentPane().add(mainFrame_user.getpCenter(),BorderLayout.CENTER);
				mainFrame_user.repaint();
				mainFrame_user.revalidate();
				mainFrame_user = null;
			}
			else {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다 다시 입력해주세요");
			}
		}
		else {
			if(lib.getTitle().getTitleNo()==0) {
				String password = new String(pfPassword.getPassword());
				if(password.equals(lib.getLbPass())) {
					mainFrame_ex.getContentPane().remove(mainFrame_ex.getpCenter());
					LibrarianProfileModifyPanel pCenter = new LibrarianProfileModifyPanel();
					pCenter.initTf(lib);
					mainFrame_ex.setpCenter(pCenter);
					mainFrame_ex.getContentPane().add(mainFrame_ex.getpCenter(),BorderLayout.CENTER);
					mainFrame_ex.repaint();
					mainFrame_ex.revalidate();
					mainFrame_ex = null;
				}
				else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다 다시 입력해주세요");
				}
			}
			else {
				String password = new String(pfPassword.getPassword());
				if(password.equals(lib.getLbPass())) {
					mainFrame_lib.getContentPane().remove(mainFrame_lib.getpCenter());
					LibrarianProfileModifyPanel pCenter = new LibrarianProfileModifyPanel();
					pCenter.initTf(lib);
					mainFrame_lib.setpCenter(pCenter);
					mainFrame_lib.getContentPane().add(mainFrame_lib.getpCenter(),BorderLayout.CENTER);
					mainFrame_lib.repaint();
					mainFrame_lib.revalidate();
					mainFrame_lib = null;
				}
				else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다 다시 입력해주세요");
				}
			}
			
		}
	}
}
