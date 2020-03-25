package yi_java3st_3team.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import yi_java3st_3team.LoginFrame;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberNewJoinUIPanel extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JPanel pSouthMenuPanel;
	private JLabel lblHome;
	private JPanel pHome;
	private JPanel pCenter;
	private MemberJoinPanel lblGreeting;
	private MemberNewJoinUIPanel mainFrame;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnCancel;
	private MemberUIService service;
	private LoginFrame loginFrame;


	public MemberNewJoinUIPanel() {
		service = new MemberUIService();
		initialize();
	}
	
	private void initialize() {
		setTitle("도서관 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 960);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		pNorth.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pNorth.setBackground(Color.WHITE);
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		

		pSouthMenuPanel = new JPanel();
		pSouthMenuPanel.setBackground(new Color(255, 255, 255));
		pNorth.add(pSouthMenuPanel, BorderLayout.SOUTH);
		pSouthMenuPanel.setLayout(new GridLayout(0, 10, 0, 0));
		

		pHome = new JPanel();
		pHome.setBackground(new Color(12, 160, 174));
		pHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pHome);
		pHome.setLayout(new BorderLayout(0, 0));

		lblHome = new JLabel("회원가입");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("굴림", Font.BOLD, 15));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		pHome.add(lblHome, BorderLayout.CENTER);
		
		JPanel pMain = new JPanel();
		pMain.setBackground(new Color(1, 78, 158));
		pNorth.add(pMain, BorderLayout.NORTH);
		pMain.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		String imgPath = System.getProperty("user.dir") + "\\images\\mainLogo.png";
		lblNewLabel.setIcon(new ImageIcon(imgPath));
		pMain.add(lblNewLabel);

		pCenter = getHomeMenuPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		mainFrame = this;
		
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				setVisible(false);
				loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			}
			
		});
		
		pBtns = new JPanel();
		pBtns.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) pBtns.getLayout();
		flowLayout.setHgap(50);
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("가입");
		btnAdd.addActionListener(this);
		btnAdd.setPreferredSize(new Dimension(90, 40));
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setPreferredSize(new Dimension(90, 40));
		pBtns.add(btnCancel);
		

	}

	public MemberJoinPanel getLblGreeting() {
		return lblGreeting;
	}

	private JPanel getHomeMenuPanel() {
		// HomeMenu를 만드는 패널을 리턴
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(50, 50, 50, 50));
		lblGreeting = new MemberJoinPanel();
		lblGreeting.setBackground(Color.WHITE);
		lblGreeting.setBorder(new EmptyBorder(0, 0, 0, 50));
		lblGreeting.setFont(new Font("굴림", Font.BOLD, 65));
		panel.add(lblGreeting, BorderLayout.CENTER);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
		
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		if(lblGreeting.getLblPWCheck().getText().equals("비밀번호 불일치") || lblGreeting.getPfPW2().getPassword().length==0) {
			JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
			return;
		}else {
			try {
				Member newMem = lblGreeting.getItem();
				service.addMember(newMem);
				JOptionPane.showMessageDialog(null, String.format("[ %s ] 님 회원가입이 완료되었습니다.", newMem.getMberName()));
				mainFrame.setVisible(false);
				loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		setVisible(false);
		loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}
}
