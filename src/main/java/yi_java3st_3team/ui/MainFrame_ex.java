package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame_ex extends JFrame {
	private JPanel contentPane;
	private JPanel pSouthMenuPanel;
	private JLabel lblHome;
	private JLabel lblBookMgn;
	private JLabel lblMemMgn;
	private JLabel lblChkOutRtn;
	private JLabel lblEmpMgn;
	private JLabel lblStatistic;
	private JLabel lblLogOut;
	private JPanel pHome;
	private JPanel pBookMgn;
	private JPanel pMemMgn;
	private JPanel pChkOutRtn;
	private JPanel pEmpMgn;
	private JPanel pStatistic;
	private JPanel pLogout;
	private JPanel pWest;
	private JPanel pCenter;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// select Look and Feel
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

					MainFrame_ex frame = new MainFrame_ex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame_ex() {
		initialize();
	}

	private void initialize() {
		MouseAdapter menuAdapter = getMouseAdapter();
		setTitle("도서관 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 960);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		pSouthMenuPanel = new JPanel();
		pSouthMenuPanel.setBackground(new Color(255, 255, 255));
		pNorth.add(pSouthMenuPanel, BorderLayout.SOUTH);
		pSouthMenuPanel.setLayout(new GridLayout(0, 10, 0, 0));
		
		pHome = new JPanel();
		pHome.setBackground(new Color(12,160,174));
		pHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pHome);
		pHome.setLayout(new BorderLayout(0, 0));
		
		lblHome = new JLabel("HOME");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("굴림", Font.BOLD, 15));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		pHome.add(lblHome, BorderLayout.CENTER);
		
		pBookMgn = new JPanel();
		pBookMgn.setBackground(Color.WHITE);
		pBookMgn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pBookMgn);
		pBookMgn.setLayout(new BorderLayout(0, 0));
		
		lblBookMgn = new JLabel("도서관리");
		lblBookMgn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookMgn.setFont(new Font("굴림", Font.PLAIN, 15));
		pBookMgn.add(lblBookMgn, BorderLayout.NORTH);
		
		pMemMgn = new JPanel();
		pMemMgn.setBackground(Color.WHITE);
		pMemMgn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pMemMgn);
		pMemMgn.setLayout(new BorderLayout(0, 0));
		
		lblMemMgn = new JLabel("회원관리");
		lblMemMgn.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemMgn.setFont(new Font("굴림", Font.PLAIN, 15));
		pMemMgn.add(lblMemMgn, BorderLayout.NORTH);
		
		pChkOutRtn = new JPanel();
		pChkOutRtn.setBackground(Color.WHITE);
		pChkOutRtn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pChkOutRtn);
		pChkOutRtn.setLayout(new BorderLayout(0, 0));
		
		lblChkOutRtn = new JLabel("대여/반납");
		lblChkOutRtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblChkOutRtn.setFont(new Font("굴림", Font.PLAIN, 15));
		pChkOutRtn.add(lblChkOutRtn, BorderLayout.NORTH);
		
		pEmpMgn = new JPanel();
		pEmpMgn.setBackground(Color.WHITE);
		pEmpMgn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pEmpMgn);
		pEmpMgn.setLayout(new BorderLayout(0, 0));
		
		lblEmpMgn = new JLabel("직원관리");
		lblEmpMgn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpMgn.setFont(new Font("굴림", Font.PLAIN, 15));
		pEmpMgn.add(lblEmpMgn, BorderLayout.NORTH);
		
		pStatistic = new JPanel();
		pStatistic.setBackground(Color.WHITE);
		pStatistic.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pStatistic);
		pStatistic.setLayout(new BorderLayout(0, 0));
		
		lblStatistic = new JLabel("통계조회");
		lblStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistic.setFont(new Font("굴림", Font.PLAIN, 15));
		pStatistic.add(lblStatistic, BorderLayout.NORTH);
		
		JPanel pDummy1 = new JPanel();
		pDummy1.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pDummy1);
		
		JPanel pDummy2 = new JPanel();
		pDummy2.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pDummy2);
		
		JPanel pDummy3 = new JPanel();
		pDummy3.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pDummy3);
		
		pLogout = new JPanel();
		pLogout.setBorder(new EmptyBorder(5, 5, 5, 5));
		pLogout.setBackground(Color.ORANGE);
		pSouthMenuPanel.add(pLogout);
		pLogout.setLayout(new BorderLayout(0, 0));
		
		lblLogOut = new JLabel("로그아웃");
		lblLogOut.setForeground(Color.WHITE);
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setFont(new Font("굴림", Font.BOLD, 15));
		pLogout.add(lblLogOut, BorderLayout.NORTH);
		
		JPanel pMain = new JPanel();
		pMain.setBackground(new Color(1,78,158));
		pNorth.add(pMain, BorderLayout.NORTH);
		pMain.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		String imgPath = System.getProperty("user.dir") + "\\images\\mainLogo.png";
		lblNewLabel.setIcon(new ImageIcon(imgPath));
		pMain.add(lblNewLabel);
		
		pCenter = getHomeMenuPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		
		pWest = new JPanel();
		contentPane.add(pWest, BorderLayout.WEST);
		pWest.setLayout(new BorderLayout(0, 0));
		
		pHome.addMouseListener(menuAdapter);
		pBookMgn.addMouseListener(menuAdapter);
		pMemMgn.addMouseListener(menuAdapter);
		pChkOutRtn.addMouseListener(menuAdapter);
		pEmpMgn.addMouseListener(menuAdapter);
		pStatistic.addMouseListener(menuAdapter);
	}

	private JPanel getHomeMenuPanel() {
		//HomeMenu를 만드는 패널을 리턴
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(50, 50, 50, 50));
		JLabel lblGreeting = new JLabel("박인선님 환영합니다");
		lblGreeting.setFont(new Font("굴림", Font.BOLD, 65));
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGreeting, BorderLayout.CENTER);
		return panel;
	}

	private MouseAdapter getMouseAdapter() {
		MouseAdapter menuAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] menuPanels = new JPanel[] {pHome,pBookMgn,pMemMgn,pChkOutRtn,pEmpMgn,pStatistic};
				JLabel[] menuLabels = new JLabel[] {lblHome,lblBookMgn,lblMemMgn,lblChkOutRtn,lblEmpMgn,lblStatistic};
				//Menu panel,label 초기화
				for(JPanel p : menuPanels) {
					p.setBackground(Color.white);
				}
				for(JLabel label : menuLabels) {
					label.setFont(new Font("굴림", Font.PLAIN, 15));
					label.setForeground(Color.black);
				}
				//mouse가 눌린 menu panel 및 menu label 판별 및 클릭
				JPanel chkPanel = (JPanel)e.getSource();
				for(JPanel p : menuPanels) {
					if(p.equals(chkPanel)) {
						p.setBackground(new Color(12,160,174));
						JLabel label = (JLabel)p.getComponent(0);
						label.setFont(new Font("굴림", Font.BOLD, 15));
						label.setForeground(Color.white);
					}
				}
				JLabel label = (JLabel)chkPanel.getComponent(0);
				switch(label.getText()) {
				case "HOME":
					contentPane.remove(pCenter);
					contentPane.remove(pWest);
					pCenter = getHomeMenuPanel();
					contentPane.add(pCenter,BorderLayout.CENTER);
					repaint();
					revalidate();
					break;
				case "도서관리":
					break;
				case "회원관리":
					break;
				case "대여/반납":
					break;
				case "직원관리":
					break;
				case "통계조회":
					contentPane.remove(pWest);
					contentPane.remove(pCenter);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestStatisticPanel();
					JPanel[] panels = ((WestStatisticPanel) pWest).getPanels();
					for(JPanel panel : panels) {
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for(JPanel panel : panels) {
									JLabel label = (JLabel)panel.getComponent(0);
									panel.setBackground(new Color(240,240,240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel)e.getSource();
								JLabel chkLabel = (JLabel)chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52,147,221));
								chkLabel.setForeground(Color.white);
								switch(chkLabel.getText()) {
								case "대여/반납 통계":
									break;
								case "도서보유현황":
									break;
								case "이용자 현황":
									break;
								}
							}
						});
					}
					contentPane.add(pCenter,BorderLayout.CENTER);
					contentPane.add(pWest,BorderLayout.WEST);
					repaint();
					revalidate();
					break;
				}
			}	
		};
		return menuAdapter;
	}
}
