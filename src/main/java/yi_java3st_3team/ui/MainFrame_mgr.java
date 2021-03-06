package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import yi_java3st_3team.LoginFrame;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.chart.BookCafeInfoUIPanel;
import yi_java3st_3team.ui.chart.BookInfoCatePanelBarChart;
import yi_java3st_3team.ui.chart.BookInfoPanelBarChart;
import yi_java3st_3team.ui.chart.BookInfoUIPanel;
import yi_java3st_3team.ui.chart.InitScene;
import yi_java3st_3team.ui.chart.MemberInfoPanelPieChart;
import yi_java3st_3team.ui.chart.MemberInfoUIPanel;
import yi_java3st_3team.ui.panel.BookLcAndMlManagerPanel;
import yi_java3st_3team.ui.panel.BookManagerPanel;
import yi_java3st_3team.ui.panel.BookPlsManageMentPanel;
import yi_java3st_3team.ui.panel.BookRegistrationPanel;
import yi_java3st_3team.ui.panel.LibrarianSelectUIPanel;
import yi_java3st_3team.ui.panel.MemberJoinUIPanel;
import yi_java3st_3team.ui.panel.MemberSelectUIPanel;
import yi_java3st_3team.ui.panel.MemberBookOverdueUIPanel;
import yi_java3st_3team.ui.panel.MemberJoinPanel;
import yi_java3st_3team.ui.panel.BookRecomManagerPanel;
import yi_java3st_3team.ui.panel.MemberRentPanel;
import yi_java3st_3team.ui.panel.BookRequestIntoPanel;
import yi_java3st_3team.ui.panel.MemberReturnPanel;
import yi_java3st_3team.ui.panel.content.PasswordCheckPanel;
import yi_java3st_3team.ui.panel.submenu.WestBookManagementPanel;
import yi_java3st_3team.ui.panel.submenu.WestLendingManagementPanel;
import yi_java3st_3team.ui.panel.submenu.WestLibrarianManagementPanel;
import yi_java3st_3team.ui.panel.submenu.WestMemberManagementPanel;
import yi_java3st_3team.ui.panel.submenu.WestStatisticPanel;
import yi_java3st_3team.ui.service.LibrarianService;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MainFrame_mgr extends JFrame {
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
	private JPanel chartBookInfo;
	private JPanel chartBookCateInfo;
	private JPanel chartMemberInfo;
	private BookInfoPanelBarChart bookInfoChart;
	private BookInfoCatePanelBarChart bookInfoCafeChart;

	private MemberInfoPanelPieChart memInfoChart;
	private MemberJoinUIPanel memberJoin;
	private MemberSelectUIPanel memberSelect;
	private LibrarianSelectUIPanel LibrarianSelect;

	private BookRegistrationPanel bookReqst;
	private BookManagerPanel bookMgn;
	private BookRecomManagerPanel recomBookAdd;
	private BookPlsManageMentPanel bookPlsMgn;
	private BookRequestIntoPanel reqstInto;

	private BookLcAndMlManagerPanel bookCatMag;
	private MemberBookOverdueUIPanel overdueMgn;
	private LoginFrame loginFrame;

	private MemberRentPanel rentPanel;
	private MemberReturnPanel returnPanel;
	private Thread chartThread;
	private JLabel lblGreeting;
	private JLabel lblProfile;
	private JPanel pProfile;
	private Librarian lib;
	private Member member;
	private Thread panelThread;
	private MainFrame_mgr mainFrame;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					// select Look and Feel
//					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
////					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
////					UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
////					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
////					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
////					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//					JFrame frame = new MainFrame_ex();
//					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public MainFrame_mgr() {
		initialize();
	}

	private void initialize() {
		MouseAdapter menuAdapter = getMouseAdapter();
		setThread();
		setTitle("도서관 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1400, 960);
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

		lblHome = new JLabel("HOME");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		pHome.add(lblHome, BorderLayout.CENTER);

		pBookMgn = new JPanel();
		pBookMgn.setBackground(Color.WHITE);
		pBookMgn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pBookMgn);
		pBookMgn.setLayout(new BorderLayout(0, 0));

		lblBookMgn = new JLabel("도서관리");
		lblBookMgn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookMgn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pBookMgn.add(lblBookMgn, BorderLayout.NORTH);

		pMemMgn = new JPanel();
		pMemMgn.setBackground(Color.WHITE);
		pMemMgn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pMemMgn);
		pMemMgn.setLayout(new BorderLayout(0, 0));

		lblMemMgn = new JLabel("회원관리");
		lblMemMgn.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemMgn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pMemMgn.add(lblMemMgn, BorderLayout.NORTH);

		pChkOutRtn = new JPanel();
		pChkOutRtn.setBackground(Color.WHITE);
		pChkOutRtn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pChkOutRtn);
		pChkOutRtn.setLayout(new BorderLayout(0, 0));

		lblChkOutRtn = new JLabel("대여/반납");
		lblChkOutRtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblChkOutRtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pChkOutRtn.add(lblChkOutRtn, BorderLayout.NORTH);

		pEmpMgn = new JPanel();
		pEmpMgn.setBackground(Color.WHITE);
		pEmpMgn.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pEmpMgn);
		pEmpMgn.setLayout(new BorderLayout(0, 0));

		lblEmpMgn = new JLabel("직원관리");
		lblEmpMgn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpMgn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pEmpMgn.add(lblEmpMgn, BorderLayout.NORTH);

		pStatistic = new JPanel();
		pStatistic.setBackground(Color.WHITE);
		pStatistic.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pStatistic);
		pStatistic.setLayout(new BorderLayout(0, 0));

		lblStatistic = new JLabel("통계조회");
		lblStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistic.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pStatistic.add(lblStatistic, BorderLayout.NORTH);

		pProfile = new JPanel();
		pProfile.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pProfile);

		lblProfile = new JLabel("프로필");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pProfile.add(lblProfile);

		JPanel pDummy1 = new JPanel();
		pDummy1.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pDummy1);

		JPanel pDummy2 = new JPanel();
		pDummy2.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pDummy2);

		pLogout = new JPanel();
		pLogout.setBorder(new EmptyBorder(5, 5, 5, 5));
		pLogout.setBackground(Color.ORANGE);
		pSouthMenuPanel.add(pLogout);
		pLogout.setLayout(new BorderLayout(0, 0));

		lblLogOut = new JLabel("로그아웃");
		lblLogOut.setForeground(Color.WHITE);
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pLogout.add(lblLogOut, BorderLayout.NORTH);

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

		pWest = new JPanel();
		contentPane.add(pWest, BorderLayout.WEST);
		pWest.setLayout(new BorderLayout(0, 0));
		pHome.addMouseListener(menuAdapter);
		pBookMgn.addMouseListener(menuAdapter);
		pMemMgn.addMouseListener(menuAdapter);
		pChkOutRtn.addMouseListener(menuAdapter);
		pEmpMgn.addMouseListener(menuAdapter);
		pStatistic.addMouseListener(menuAdapter);
		pLogout.addMouseListener(menuAdapter);
		pProfile.addMouseListener(menuAdapter);

		mainFrame = this;
	}

	public void setThread() {
		chartThread = initChartThread();
		chartThread.run();
		panelThread = initPanelThread();
		panelThread.run();
	}

	public JLabel getLblGreeting() {
		return lblGreeting;
	}

	private JPanel getHomeMenuPanel() {
		// HomeMenu를 만드는 패널을 리턴
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(50, 50, 50, 50));
		lblGreeting = new JLabel("");
		lblGreeting.setFont(new Font("맑은 고딕", Font.BOLD, 65));
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGreeting, BorderLayout.CENTER);
		return panel;
	}

	private synchronized MouseAdapter getMouseAdapter() {
		MouseAdapter menuAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] menuPanels = new JPanel[] { pHome, pBookMgn, pMemMgn, pChkOutRtn, pEmpMgn, pStatistic,
						pProfile };
				JLabel[] menuLabels = new JLabel[] { lblHome, lblBookMgn, lblMemMgn, lblChkOutRtn, lblEmpMgn,
						lblStatistic, lblProfile };
				// Menu panel,label 초기화
				for (JPanel p : menuPanels) {
					p.setBackground(Color.white);
				}
				for (JLabel label : menuLabels) {
					label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

					label.setForeground(Color.black);
				}
				// mouse가 눌린 menu panel 및 menu label 판별 및 클릭
				JPanel chkPanel = (JPanel) e.getSource();
				for (JPanel p : menuPanels) {
					if (p.equals(chkPanel)) {
						p.setBackground(new Color(12, 160, 174));
						JLabel label = (JLabel) p.getComponent(0);
						label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
						label.setForeground(Color.white);
					}
				}
				JLabel label = (JLabel) chkPanel.getComponent(0);
				switch (label.getText()) {
				case "HOME":
					String greeting = lblGreeting.getText();
					contentPane.remove(pCenter);
					contentPane.remove(pWest);
					pCenter = getHomeMenuPanel();
					lblGreeting.setText(greeting);
					contentPane.add(pCenter, BorderLayout.CENTER);
					repaint();
					revalidate();
					break;

				case "도서관리":
					contentPane.remove(pWest);
					contentPane.remove(pCenter);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestBookManagementPanel();
				
					JPanel[] pBook = ((WestBookManagementPanel) pWest).getPanels();
					pBook[0].setBackground(new Color(52, 147, 221));
					JLabel l = (JLabel)pBook[0].getComponent(0);
					l.setForeground(Color.white);
					l.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					pCenter = bookReqst;
					contentPane.add(pWest,BorderLayout.WEST);
					contentPane.add(pCenter,BorderLayout.CENTER);
					repaint();
					revalidate();
					((BookRegistrationPanel) pCenter).clearTf();
					for (JPanel panel : pBook) {
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for (JPanel panel : pBook) {
									JLabel label = (JLabel) panel.getComponent(0);
									panel.setBackground(new Color(240, 240, 240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel) e.getSource();
								JLabel chkLabel = (JLabel) chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52, 147, 221));
								chkLabel.setForeground(Color.white);
								switch (chkLabel.getText()) {
								case "도서등록":
									contentPane.remove(pCenter);
									pCenter = bookReqst;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									((BookRegistrationPanel) pCenter).clearTf();
									break;
								case "보유도서 관리":
									contentPane.remove(pCenter);
									pCenter = bookMgn;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									((BookManagerPanel) pCenter).loadData();
									break;
								case "신청도서 관리":
									contentPane.remove(pCenter);
									pCenter = reqstInto;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									((BookRequestIntoPanel) pCenter).loadData();
									break;
								case "추천도서 등록":
									contentPane.remove(pCenter);
									pCenter = recomBookAdd;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									((BookRecomManagerPanel) pCenter).loadData();
									break;
								case "출판사 관리":
									contentPane.remove(pCenter);
									pCenter = bookPlsMgn;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									((BookPlsManageMentPanel) pCenter).loadDate();
									break;
								case "도서분류 관리":
									contentPane.remove(pCenter);
									pCenter = bookCatMag;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									((BookLcAndMlManagerPanel) pCenter).loadData();
									break;
								}
							}

						});
					}
					contentPane.add(pCenter, BorderLayout.CENTER);
					contentPane.add(pWest, BorderLayout.WEST);
					repaint();
					revalidate();
					break;

				case "회원관리":
					contentPane.remove(pWest);
					contentPane.remove(pCenter);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestMemberManagementPanel();
					JPanel[] pMember = ((WestMemberManagementPanel) pWest).getPanels();
					pMember[0].setBackground(new Color(52, 147, 221));
					JLabel l2 = (JLabel)pMember[0].getComponent(0);
					l2.setForeground(Color.white);
					l2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					pCenter = memberJoin;
					contentPane.add(pWest,BorderLayout.WEST);
					contentPane.add(pCenter,BorderLayout.CENTER);
					contentPane.repaint();
					contentPane.revalidate();
					((MemberJoinUIPanel)pCenter).clearTf();
					for (JPanel panel : pMember) {
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for (JPanel panel : pMember) {
									JLabel label = (JLabel) panel.getComponent(0);
									panel.setBackground(new Color(240, 240, 240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel) e.getSource();
								JLabel chkLabel = (JLabel) chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52, 147, 221));
								chkLabel.setForeground(Color.white);
								switch (chkLabel.getText()) {
								case "회원등록":
									contentPane.remove(pCenter);
									pCenter = memberJoin;
									contentPane.add(pCenter, BorderLayout.CENTER);
									contentPane.repaint();
									contentPane.revalidate();
									((MemberJoinUIPanel)pCenter).clearTf();
									break;
								case "회원 조회/수정":
									contentPane.remove(pCenter);
									pCenter = memberSelect;
									contentPane.add(pCenter, BorderLayout.CENTER);
									contentPane.repaint();
									contentPane.revalidate();
									((MemberSelectUIPanel) pCenter).loadData();
									break;
								}
							}

						});
					}
					contentPane.add(pCenter, BorderLayout.CENTER);
					contentPane.add(pWest, BorderLayout.WEST);
					repaint();
					revalidate();
					break;
				case "대여/반납":
					contentPane.remove(pWest);
					contentPane.remove(pCenter);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestLendingManagementPanel();
					JPanel[] pLending = ((WestLendingManagementPanel) pWest).getPanels();
					pLending[0].setBackground(new Color(52, 147, 221));
					JLabel l3 = (JLabel)pLending[0].getComponent(0);
					l3.setForeground(Color.white);
					l3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					pCenter = rentPanel;
					contentPane.add(pWest,BorderLayout.WEST);
					contentPane.add(pCenter,BorderLayout.CENTER);
					contentPane.repaint();
					contentPane.revalidate();
					((MemberRentPanel) pCenter).loadData();
					for (JPanel panel : pLending) {
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for (JPanel panel : pLending) {
									JLabel label = (JLabel) panel.getComponent(0);
									panel.setBackground(new Color(240, 240, 240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel) e.getSource();
								JLabel chkLabel = (JLabel) chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52, 147, 221));
								chkLabel.setForeground(Color.white);
								switch (chkLabel.getText()) {
								case "대여 관리":
									contentPane.remove(pCenter);
									pCenter = rentPanel;
									contentPane.add(pCenter, BorderLayout.CENTER);
									contentPane.repaint();
									contentPane.revalidate();
									((MemberRentPanel) pCenter).loadData();
									break;
								case "반납 관리":
									contentPane.remove(pCenter);
									pCenter = returnPanel;
									contentPane.add(pCenter, BorderLayout.CENTER);
									contentPane.repaint();
									contentPane.revalidate();
									((MemberReturnPanel)pCenter).loadData();
									break;
								case "연체 조회":
									contentPane.remove(pCenter);
									pCenter = overdueMgn;
									contentPane.add(pCenter, BorderLayout.CENTER);
									contentPane.repaint();
									contentPane.revalidate();
									((MemberBookOverdueUIPanel)pCenter).loadData();
									break;
								}
							}

						});
					}
					contentPane.add(pCenter, BorderLayout.CENTER);
					contentPane.add(pWest, BorderLayout.WEST);
					repaint();
					revalidate();
					break;

				case "직원관리":
					contentPane.remove(pWest);
					contentPane.remove(pCenter);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestLibrarianManagementPanel();
					JPanel[] pLibrarian = ((WestLibrarianManagementPanel) pWest).getPanels();
					pLibrarian[0].setBackground(new Color(52, 147, 221));
					JLabel l4 = (JLabel)pLibrarian[0].getComponent(0);
					l4.setForeground(Color.white);
					l4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					pCenter = LibrarianSelect;
					contentPane.add(pWest,BorderLayout.WEST);
					contentPane.add(pCenter,BorderLayout.CENTER);
					contentPane.repaint();
					contentPane.revalidate();
					((LibrarianSelectUIPanel) pCenter).loadData();
					for (JPanel panel : pLibrarian) {
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for (JPanel panel : pLibrarian) {
									JLabel label = (JLabel) panel.getComponent(0);
									panel.setBackground(new Color(240, 240, 240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel) e.getSource();
								JLabel chkLabel = (JLabel) chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52, 147, 221));
								chkLabel.setForeground(Color.white);
								switch (chkLabel.getText()) {
								case "직원 등록/수정":
									contentPane.remove(pCenter);
									pCenter = LibrarianSelect;
									contentPane.add(pCenter, BorderLayout.CENTER);
									contentPane.repaint();
									contentPane.revalidate();
									((LibrarianSelectUIPanel) pCenter).loadData();
									break;
								}
							}
						});
					}
					contentPane.add(pCenter, BorderLayout.CENTER);
					contentPane.add(pWest, BorderLayout.WEST);
					repaint();
					revalidate();
					break;

				case "통계조회":
					contentPane.remove(pWest);
					contentPane.remove(pCenter);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestStatisticPanel();
					JPanel[] panels = ((WestStatisticPanel) pWest).getPanels();
					panels[0].setBackground(new Color(52, 147, 221));
					JLabel l5 = (JLabel)panels[0].getComponent(0);
					l5.setForeground(Color.white);
					l5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					pCenter = chartBookInfo;
					contentPane.add(pWest,BorderLayout.WEST);
					contentPane.add(pCenter,BorderLayout.CENTER);
					for (JPanel panel : panels) {
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for (JPanel panel : panels) {
									JLabel label = (JLabel) panel.getComponent(0);
									panel.setBackground(new Color(240, 240, 240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel) e.getSource();
								JLabel chkLabel = (JLabel) chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52, 147, 221));
								chkLabel.setForeground(Color.white);
								switch (chkLabel.getText()) {
								case "대여/반납 통계":
									contentPane.remove(pCenter);
									pCenter = chartBookInfo;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									break;
								case "도서보유현황":
									contentPane.remove(pCenter);
									pCenter = chartBookCateInfo;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									break;
								case "이용자 현황":
									contentPane.remove(pCenter);
									pCenter = chartMemberInfo;
									contentPane.add(pCenter, BorderLayout.CENTER);
									repaint();
									revalidate();
									break;
								}
							}
						});
					}
					contentPane.add(pCenter, BorderLayout.CENTER);
					contentPane.add(pWest, BorderLayout.WEST);
					repaint();
					revalidate();
					break;
				case "프로필":
					contentPane.remove(pWest);
					contentPane.remove(pCenter);
					pCenter = getPassMenuPanel();
					contentPane.add(pCenter, BorderLayout.CENTER);
					repaint();
					revalidate();
					break;
				case "로그아웃":
					dispose();
					LoginFrame.loginLib = null;
					loginFrame.setVisible(true);
					loginFrame.loadData();
					loginFrame.clearTf();
					break;
				}
				chartThread.interrupt();
				chartThread.run();
			}
		};
		return menuAdapter;
	}

	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public Librarian getLib() {
		return lib;
	}

	public void setLib(LibrarianService service, Librarian lib) {
		try {
			this.lib = service.showLibrarianById(lib);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member, MemberUIService service) {
		this.member = service.SelectedByNo(member);
	}

	public MainFrame_mgr getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame_mgr mainFrame) {
		this.mainFrame = mainFrame;
	}

	public JPanel getpCenter() {
		return pCenter;
	}

	public void setpCenter(JPanel pCenter) {
		this.pCenter = pCenter;
	}

	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

	private Thread initChartThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				bookInfoChart = new BookInfoPanelBarChart();
				bookInfoCafeChart = new BookInfoCatePanelBarChart();
				memInfoChart = new MemberInfoPanelPieChart();
				Platform.runLater(() -> initFX((InitScene) bookInfoChart));
				Platform.runLater(() -> initFX((InitScene) bookInfoCafeChart));
				Platform.runLater(() -> initFX((InitScene) memInfoChart));
			}
		});
		return thread;
	}

	private Thread initPanelThread() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				bookReqst = new BookRegistrationPanel();
				bookMgn = new BookManagerPanel();
				recomBookAdd = new BookRecomManagerPanel();
				bookPlsMgn = new BookPlsManageMentPanel();
				bookCatMag = new BookLcAndMlManagerPanel();
				reqstInto = new BookRequestIntoPanel();

				memberJoin = new MemberJoinUIPanel();
				memberSelect = new MemberSelectUIPanel();
				LibrarianSelect = new LibrarianSelectUIPanel();

				overdueMgn = new MemberBookOverdueUIPanel();

				rentPanel = new MemberRentPanel();
				returnPanel = new MemberReturnPanel();

				chartBookCateInfo = new BookCafeInfoUIPanel();
				chartBookInfo = new BookInfoUIPanel();
				chartMemberInfo = new MemberInfoUIPanel();

				chartBookCateInfo.add(bookInfoCafeChart, BorderLayout.CENTER);
				chartBookCateInfo.setBorder(new EmptyBorder(50, 100, 50, 100));
				chartBookCateInfo.setBackground(Color.WHITE);

				chartBookInfo.add(bookInfoChart, BorderLayout.CENTER);
				bookInfoChart.setBorder(new EmptyBorder(100, 200, 50, 100));
				chartBookInfo.setBackground(Color.WHITE);

				chartMemberInfo.add(memInfoChart, BorderLayout.CENTER);
				memInfoChart.setBorder(new EmptyBorder(0, 120, 0, 0));
				chartMemberInfo.setBackground(Color.WHITE);
			}
		});
		return thread;
	}

	private JPanel getPassMenuPanel() {
		JPanel panel = new PasswordCheckPanel();
		((PasswordCheckPanel) panel).setLib(lib);
		((PasswordCheckPanel) panel).setMainFrame_ex(mainFrame);
		return panel;
	}
}
