package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import yi_java3st_3team.LoginFrame;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.chart.InitScene;
import yi_java3st_3team.ui.panel.BookRankingPanel;
import yi_java3st_3team.ui.panel.MemberBookSearchPanel;
import yi_java3st_3team.ui.panel.MemberProfileModifyPanel;
import yi_java3st_3team.ui.panel.MemberUseCdtPanel;
import yi_java3st_3team.ui.panel.MemberRecomBookInfoPanel;
import yi_java3st_3team.ui.panel.MemberRequestBookPanel;
import yi_java3st_3team.ui.panel.content.PasswordCheckPanel;
import yi_java3st_3team.ui.panel.submenu.WestMemberProfileMenuPanel;
import yi_java3st_3team.ui.panel.submenu.WestRecomBookPanel;
//github.com/DaeguIT-MinSuKim/yi_java3st_3team.git
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MainFrame_user extends JFrame {
	private JPanel contentPane;
	private JPanel pSouthMenuPanel;
	private JLabel lblHome;
	private JLabel lblProfile;
	private JLabel lblLogOut;
	private JPanel pHome;
	private JPanel pProfile;
	private JPanel pBookSearch;
	private JPanel pRecommendBook;
	private JPanel pRequestBook;
	private JLabel lblRequestBook;
	private JPanel pLogout;
	private JPanel pWest;
	private JPanel pCenter;
	private JLabel lblBookSearch;
	private JPanel profileModifyPanel;
	private JLabel lblGreeting;
	private JPanel memberUseCdtpanel;
	private JPanel memberBookSearchPanel;
	private Member member;
	private JLabel lblRecommendBook;
	private JPanel bookRecomPanel;
	private LoginFrame loginFrame;
	private JPanel bookRankPanel;
	private Thread menuThread;
	private MainFrame_user mainFrame;
	private JPanel requestBookPanel;

	public MainFrame_user() {
		initialize();
	}

	private void initialize() {
		MouseAdapter menuAdapter = getMouseAdapter();
		setTitle("도서관 회원 프로그램");
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
		pHome.setBackground(new Color(12,160,174));
		pHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pHome);
		pHome.setLayout(new BorderLayout(0, 0));
		
		lblHome = new JLabel("HOME");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		pHome.add(lblHome, BorderLayout.CENTER);
		
		pProfile = new JPanel();
		pProfile.setBackground(Color.WHITE);
		pProfile.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pProfile);
		pProfile.setLayout(new BorderLayout(0, 0));
		
		lblProfile = new JLabel("프로필");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pProfile.add(lblProfile, BorderLayout.NORTH);
		
		pBookSearch = new JPanel();
		pBookSearch.setBackground(Color.WHITE);
		pBookSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pBookSearch);
		pBookSearch.setLayout(new BorderLayout(0, 0));
		
		lblBookSearch = new JLabel("도서검색");
		lblBookSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pBookSearch.add(lblBookSearch, BorderLayout.NORTH);
		
		pRecommendBook = new JPanel();
		pRecommendBook.setBackground(Color.WHITE);
		pRecommendBook.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pRecommendBook);
		pRecommendBook.setLayout(new BorderLayout(0, 0));
		
		lblRecommendBook = new JLabel("도서추천");
		lblRecommendBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecommendBook.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pRecommendBook.add(lblRecommendBook, BorderLayout.NORTH);
		
		pRequestBook = new JPanel();
		pRequestBook.setBackground(Color.WHITE);
		pRequestBook.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pRequestBook);
		pRequestBook.setLayout(new BorderLayout(0, 0));
		
		lblRequestBook = new JLabel("도서신청");
		lblRequestBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequestBook.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pRequestBook.add(lblRequestBook, BorderLayout.NORTH);
		
		JPanel pDummy1 = new JPanel();
		pDummy1.setBackground(Color.WHITE);
		pDummy1.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pDummy1);
		pDummy1.setLayout(new BorderLayout(0, 0));
		
		JPanel pDummy2 = new JPanel();
		pDummy2.setBackground(Color.WHITE);
		pDummy2.setBorder(new EmptyBorder(5, 5, 5, 5));
		pSouthMenuPanel.add(pDummy2);
		pDummy2.setLayout(new BorderLayout(0, 0));
		
		JPanel pDummy3 = new JPanel();
		pDummy3.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pDummy3);
		
		JPanel pDummy4 = new JPanel();
		pDummy4.setBackground(Color.WHITE);
		pSouthMenuPanel.add(pDummy4);
		
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
		pProfile.addMouseListener(menuAdapter);
		pBookSearch.addMouseListener(menuAdapter);
		pRecommendBook.addMouseListener(menuAdapter);
		pRequestBook.addMouseListener(menuAdapter);
		pLogout.addMouseListener(menuAdapter);
		menuThread = getMenuThread();
		menuThread.run();
		
		mainFrame = this;
	}
	
	public JPanel getProfileModifyPanel() {
		return profileModifyPanel;
	}

	public JPanel getpCenter() {
		return pCenter;
	}
	
	public void setpCenter(JPanel pCenter) {
		this.pCenter = pCenter;
	}

	public JLabel getLblGreeting() {
		return lblGreeting;
	}
	
	public MainFrame_user getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame_user mainFrame) {
		this.mainFrame = mainFrame;
	}

	public Thread getMenuThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				profileModifyPanel = new MemberProfileModifyPanel();
				memberUseCdtpanel = new MemberUseCdtPanel();
				memberBookSearchPanel = new MemberBookSearchPanel();
				bookRecomPanel = new MemberRecomBookInfoPanel();
				bookRankPanel = new BookRankingPanel();
				requestBookPanel = new MemberRequestBookPanel();
			}
		});
		return thread;
	}
	
	private JPanel getHomeMenuPanel() {
		//HomeMenu를 만드는 패널을 리턴
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(50, 50, 50, 50));
		lblGreeting = new JLabel();
		lblGreeting.setFont(new Font("맑은 고딕", Font.BOLD, 65));
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGreeting, BorderLayout.CENTER);
		return panel;
	}

	private synchronized MouseAdapter getMouseAdapter() {
		MouseAdapter menuAdapter = new MouseAdapter() {
			private String greeting;

			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] menuPanels = new JPanel[] {pHome,pProfile,pBookSearch,pRecommendBook,pRequestBook};
				JLabel[] menuLabels = new JLabel[] {lblHome,lblProfile,lblBookSearch,lblRecommendBook,lblRequestBook};
				//Menu panel,label 초기화
				for(JPanel p : menuPanels) {
					p.setBackground(Color.white);
				}
				for(JLabel label : menuLabels) {
					label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
					label.setForeground(Color.black);
				}
				//mouse가 눌린 menu panel 및 menu label 판별 및 클릭
				JPanel chkPanel = (JPanel)e.getSource();
				for(JPanel p : menuPanels) {
					if(p.equals(chkPanel)) {
						p.setBackground(new Color(12,160,174));
						JLabel label = (JLabel)p.getComponent(0);
						label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
						label.setForeground(Color.white);
					}
				}
				JLabel label = (JLabel)chkPanel.getComponent(0);
				switch(label.getText()) {
				case "HOME":
					greeting = lblGreeting.getText();
					contentPane.remove(pCenter);
					contentPane.remove(pWest);
					pCenter = getHomeMenuPanel();
					lblGreeting.setText(greeting);
					contentPane.add(pCenter,BorderLayout.CENTER);
					repaint();
					revalidate();
					break;
				case "프로필":
					contentPane.remove(pCenter);
					contentPane.remove(pWest);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestMemberProfileMenuPanel();
					JPanel[] pBook = ((WestMemberProfileMenuPanel) pWest).getPanels();
					pBook[0].setBackground(new Color(52, 147, 221));
					JLabel l = (JLabel)pBook[0].getComponent(0);
					l.setForeground(Color.white);
					l.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					pCenter = getPassMenuPanel();
					contentPane.add(pWest,BorderLayout.WEST);
					contentPane.add(pCenter,BorderLayout.CENTER);
					for(JPanel panel : pBook) {
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for(JPanel panel : pBook) {
									JLabel label = (JLabel)panel.getComponent(0);
									panel.setBackground(new Color(240, 240, 240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel) e.getSource();
								JLabel chkLabel = (JLabel) chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52,147,221));
								chkLabel.setForeground(Color.white);
								switch(chkLabel.getText()) {
								case "프로필 수정" :
									contentPane.remove(pCenter);
									pCenter = getPassMenuPanel();
									contentPane.add(pCenter,BorderLayout.CENTER);
									repaint();
									revalidate();
									break;
								case "이용현황" :		
									contentPane.remove(pCenter);
									pCenter = memberUseCdtpanel;
									contentPane.add(pCenter,BorderLayout.CENTER);
									repaint();
									revalidate();
									((MemberUseCdtPanel)pCenter).setItem();
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
				case "도서검색":
					contentPane.remove(pCenter);
					contentPane.remove(pWest);
					pCenter = memberBookSearchPanel;
					pCenter.setBackground(Color.white);
					contentPane.add(pCenter,BorderLayout.CENTER);
					repaint();
					revalidate();
					((MemberBookSearchPanel)pCenter).loadData();
					break;
				case "도서추천":
					contentPane.remove(pCenter);
					contentPane.remove(pWest);
					pCenter = new JPanel();
					pCenter.setBackground(Color.white);
					pWest = new WestRecomBookPanel();
					JPanel[] pReqst = ((WestRecomBookPanel) pWest).getPanels();
					pReqst[0].setBackground(new Color(52, 147, 221));
					JLabel l2 = (JLabel)pReqst[0].getComponent(0);
					l2.setForeground(Color.white);
					l2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					pCenter = bookRankPanel;
					contentPane.add(pWest,BorderLayout.WEST);
					contentPane.add(pCenter,BorderLayout.CENTER);
					repaint();
					revalidate();
					((BookRankingPanel)pCenter).loadData();
					for(JPanel panel : pReqst) {
						panel.addMouseListener(new MouseAdapter() {

							@Override
							public void mouseClicked(MouseEvent e) {
								for(JPanel panel : pReqst) {
									JLabel label = (JLabel)panel.getComponent(0);
									panel.setBackground(new Color(240,240,240));
									label.setForeground(Color.black);
								}
								JPanel chkPanel = (JPanel) e.getSource();
								JLabel chkLabel = (JLabel) chkPanel.getComponent(0);
								chkPanel.setBackground(new Color(52, 147, 221));
								chkLabel.setForeground(Color.white);
								switch(chkLabel.getText()) {
								case "대여순위/신착도서":
									contentPane.remove(pCenter);
									pCenter = bookRankPanel;
									contentPane.add(pCenter,BorderLayout.CENTER);
									repaint();
									revalidate();
									((BookRankingPanel)pCenter).loadData();
									break;
								case "추천도서":
									contentPane.remove(pCenter);
									pCenter = bookRecomPanel;
									contentPane.add(pCenter,BorderLayout.CENTER);
									repaint();
									revalidate();
									((MemberRecomBookInfoPanel)pCenter).loadData();
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
				case "도서신청":
					contentPane.remove(pCenter);
					contentPane.remove(pWest);
					pCenter = requestBookPanel;
					pCenter.setBackground(Color.white);
					contentPane.add(pCenter,BorderLayout.CENTER);
					repaint();
					revalidate();
					((MemberRequestBookPanel)pCenter).loadData();
					break;
				case "로그아웃":
					dispose();
					LoginFrame.loginMber = null;
					loginFrame.setVisible(true);
					loginFrame.loadData();
					loginFrame.clearTf();
					break;
			}
		}};
		return menuAdapter;
	}
	
	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(MemberUIService service, Member mem) {
		member = service.SelectedByNo(mem);
	}
	private JPanel getPassMenuPanel() {
		JPanel panel = new PasswordCheckPanel();
		((PasswordCheckPanel) panel).setMember(member);
		((PasswordCheckPanel) panel).setMainFrame_user(mainFrame);
		return panel;
	}
}
