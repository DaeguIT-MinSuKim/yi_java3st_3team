package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.Recommendation;
import yi_java3st_3team.ui.content.MemberUseCdtPanel;
import yi_java3st_3team.ui.dialog.FindIdDialog;
import yi_java3st_3team.ui.dialog.FindPwDialog;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.service.LendingUiService;
import yi_java3st_3team.ui.service.LoginUiService;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfLoginId;
	private JLabel lblRecomImg;
	private JLabel lblCategoryCon;
	private JLabel lblBookNameCon;
	private JLabel lblWriterCon;
	private JLabel lblPltYearCon;
	private JLabel lblPlsCon;
	private JTextArea taBookCont;
	private JPanel pRecomContent;
	private JButton btnFindId;
	private FindIdDialog findIdDlog;
	private FindPwDialog findPwDlog;

	private LoginUiService service;
	private String picPath;
	private JButton btnFindPw;
	private JButton btnNewButton;
	public static Member loginMber;
	public static Librarian loginLib;
	private JPasswordField pfLoginPw;

	private Dimension bookImg = new Dimension(100, 160);
	private Dimension libraryIcon = new Dimension(96, 96);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		service = new LoginUiService();
		initialize();
	}

	private void initialize() {
		setTitle("도서관 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pLoginArea = new JPanel();
		pLoginArea.setBorder(new EmptyBorder(100, 30, 100, 30));
		contentPane.add(pLoginArea);
		pLoginArea.setLayout(new BoxLayout(pLoginArea, BoxLayout.Y_AXIS));

		JPanel pLogin = new JPanel();
		pLogin.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pLoginArea.add(pLogin);
		pLogin.setLayout(new BoxLayout(pLogin, BoxLayout.Y_AXIS));

		JPanel pLoginTfs = new JPanel();
		pLoginTfs.setBorder(new EmptyBorder(50, 80, 0, 80));
		pLogin.add(pLoginTfs);
		pLoginTfs.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblLoginId = new JLabel("아이디");
		lblLoginId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pLoginTfs.add(lblLoginId);

		tfLoginId = new JTextField("fivestar@nate.com");
		tfLoginId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pLoginTfs.add(tfLoginId);
		tfLoginId.setColumns(10);

		JLabel lblLoginPw = new JLabel("패스워드");
		lblLoginPw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pLoginTfs.add(lblLoginPw);

		pfLoginPw = new JPasswordField("fsa233");
		pfLoginPw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pLoginTfs.add(pfLoginPw);

		JPanel pLoginBtn = new JPanel();
		pLoginBtn.setBorder(new EmptyBorder(30, 80, 30, 80));
		pLogin.add(pLoginBtn);
		pLoginBtn.setLayout(new GridLayout(0, 1, 0, 0));

		btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(new Color(255, 204, 51));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		pLoginBtn.add(btnNewButton);

		JPanel pLoginLbl = new JPanel();
		pLoginLbl.setBorder(new EmptyBorder(0, 10, 30, 10));
		pLogin.add(pLoginLbl);
		pLoginLbl.setLayout(new GridLayout(0, 3, 5, 5));

		btnFindId = new JButton("아이디찾기");
		btnFindId.addActionListener(this);
		pLoginLbl.add(btnFindId);

		btnFindPw = new JButton("패스워드 찾기");
		btnFindPw.addActionListener(this);
		pLoginLbl.add(btnFindPw);

		JButton btnNewJoin = new JButton("회원가입");
		pLoginLbl.add(btnNewJoin);

		JPanel pContent = new JPanel();
		pContent.setBorder(new EmptyBorder(30, 0, 50, 40));
		contentPane.add(pContent);
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));

		JPanel pRecomBook = new JPanel();
		pRecomBook.setBorder(new EmptyBorder(33, 0, 20, 0));
		pContent.add(pRecomBook);
		pRecomBook.setLayout(new BoxLayout(pRecomBook, BoxLayout.Y_AXIS));

		JPanel pTitle = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pTitle.getLayout();
		pRecomBook.add(pTitle);

		JLabel lblTitle = new JLabel("이달의 추천도서");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pTitle.add(lblTitle);

		JPanel pRecomArea = new JPanel();
		pRecomArea.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pRecomBook.add(pRecomArea);
		pRecomArea.setLayout(new BoxLayout(pRecomArea, BoxLayout.Y_AXIS));

		JPanel pRecomInfo = new JPanel();
		pRecomInfo.setBorder(new EmptyBorder(5, 10, 10, 10));
		pRecomArea.add(pRecomInfo);
		pRecomInfo.setLayout(new BoxLayout(pRecomInfo, BoxLayout.X_AXIS));

		lblRecomImg = new JLabel();
		lblRecomImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecomImg.setPreferredSize(bookImg);
		lblRecomImg.setSize(bookImg);
		setPic(lblRecomImg, getClass().getClassLoader().getResource("book-noImg.png").getPath(), bookImg);
		pRecomInfo.add(lblRecomImg);

		JPanel pRecomRight = new JPanel();
		pRecomRight.setBorder(new EmptyBorder(0, 10, 0, 0));
		pRecomInfo.add(pRecomRight);
		pRecomRight.setLayout(new BorderLayout(0, 0));

		JPanel pRecomTitle = new JPanel();
		pRecomRight.add(pRecomTitle, BorderLayout.WEST);
		pRecomTitle.setLayout(new GridLayout(0, 1, 5, 0));

		JLabel lblCategoryTit = new JLabel("카테고리");
		pRecomTitle.add(lblCategoryTit);

		JLabel lblBookNameTit = new JLabel("도서명");
		pRecomTitle.add(lblBookNameTit);

		JLabel lblWriterTit = new JLabel("저자/역자");
		pRecomTitle.add(lblWriterTit);

		JLabel lblPltYearTit = new JLabel("발행년도");
		pRecomTitle.add(lblPltYearTit);

		JLabel lblPlsTit = new JLabel("출판사");
		pRecomTitle.add(lblPlsTit);

		pRecomContent = new JPanel();
		pRecomContent.setBorder(new EmptyBorder(0, 10, 0, 0));
		pRecomRight.add(pRecomContent, BorderLayout.CENTER);
		pRecomContent.setLayout(new GridLayout(0, 1, 5, 0));

		lblCategoryCon = new JLabel();
		lblCategoryCon.setFont(new Font("굴림", Font.BOLD, 12));
		pRecomContent.add(lblCategoryCon);

		lblBookNameCon = new JLabel();
		lblBookNameCon.setFont(new Font("굴림", Font.BOLD, 12));
		pRecomContent.add(lblBookNameCon);

		lblWriterCon = new JLabel();
		lblWriterCon.setFont(new Font("굴림", Font.BOLD, 12));
		pRecomContent.add(lblWriterCon);

		lblPltYearCon = new JLabel();
		lblPltYearCon.setFont(new Font("굴림", Font.BOLD, 12));
		pRecomContent.add(lblPltYearCon);

		lblPlsCon = new JLabel();
		lblPlsCon.setFont(new Font("굴림", Font.BOLD, 12));
		pRecomContent.add(lblPlsCon);

		taBookCont = new JTextArea();
		taBookCont.setBorder(new EmptyBorder(10, 10, 10, 10));
		taBookCont.setLineWrap(true);
		taBookCont.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(taBookCont);
		scrollPane.setBorder(new EmptyBorder(0, 10, 10, 10));
		scrollPane.setPreferredSize(new Dimension(6, 100));
		scrollPane.setSize(new Dimension(0, 100));
		pRecomArea.add(scrollPane);

		JPanel pLibraryInfo = new JPanel();
		pLibraryInfo.setBackground(Color.WHITE);
		pLibraryInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		pContent.add(pLibraryInfo);
		pLibraryInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pLibrary = new JPanel();
		pLibrary.setBorder(new EmptyBorder(10, 10, 10, 10));
		pLibrary.setBackground(Color.WHITE);
		pLibraryInfo.add(pLibrary);
		pLibrary.setLayout(new BoxLayout(pLibrary, BoxLayout.X_AXIS));

		JLabel lblLibraryIcon = new JLabel();
		lblLibraryIcon.setBackground(Color.WHITE);
		lblLibraryIcon.setPreferredSize(libraryIcon);
		lblLibraryIcon.setSize(new Dimension(130, 100));
		setPic(lblLibraryIcon, getClass().getClassLoader().getResource("iconBk.png").getPath(), libraryIcon);
		pLibrary.add(lblLibraryIcon);

		JPanel pLibraryLbls = new JPanel();
		pLibraryLbls.setBackground(Color.WHITE);
		pLibraryLbls.setBorder(new EmptyBorder(0, 30, 0, 0));
		pLibrary.add(pLibraryLbls);
		pLibraryLbls.setLayout(new GridLayout(0, 1, 5, 5));

		JLabel lblLibraryName = new JLabel("3조 도서관");
		lblLibraryName.setBackground(Color.WHITE);
		pLibraryLbls.add(lblLibraryName);

		JLabel lblLibraryAdss = new JLabel("대구광역시 서구 어딘가");
		lblLibraryAdss.setBackground(Color.WHITE);
		pLibraryLbls.add(lblLibraryAdss);

		JLabel lblLibraryTel = new JLabel("053-000-0000 / FAX : 000-0000");
		lblLibraryTel.setBackground(Color.WHITE);
		pLibraryLbls.add(lblLibraryTel);

		setService(service);
	}

	public void setService(LoginUiService service) {
		this.service = service;
		setItem(service.showRecommendationByListNO());
	}

	public void setItem(Recommendation recom) {
		lblCategoryCon.setText(String.format("%s / %s", recom.getBookCode().getLcNo().getLclasName(),
				recom.getBookCode().getMlNo().getMlsfcName()));
		lblBookNameCon.setText(recom.getBookCode().getBookName());
		if (recom.getBookCode().getTrnslrName().equals("")) {
			lblWriterCon.setText(String.format("%s", recom.getBookCode().getAuthrName()));
		} else {
			lblWriterCon.setText(
					String.format("%s / %s", recom.getBookCode().getAuthrName(), recom.getBookCode().getTrnslrName()));
		}
		lblPltYearCon.setText(String.format("%s", recom.getBookCode().getPblicteYear()).substring(0, 4));
		lblPlsCon.setText(recom.getBookCode().getPls().getPlsName());
		taBookCont.setText(recom.getBookCont());
		if (recom.getBookCode().getBookImg().length == 0) {
			setPic(lblRecomImg, getClass().getClassLoader().getResource("book-noImg.png").getPath(), bookImg);
		} else {
			setPicBookImg(recom.getBookCode().getBookImg(), bookImg);
		}
	}

	private void setPicBookImg(byte[] bookImg, Dimension picDimension) {
		lblRecomImg.setIcon(new ImageIcon(new ImageIcon(bookImg).getImage().getScaledInstance(
				(int) picDimension.getWidth(), (int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	private void setPic(JLabel imgArea, String imgPath, Dimension picDimension) {
		picPath = imgPath;
		imgArea.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
		if (e.getSource() == btnFindPw) {
			btnFindPwActionPerformed(e);
		}
		if (e.getSource() == btnFindId) {
			btnFindIdActionPerformed(e);
		}
	}

	protected void btnFindIdActionPerformed(ActionEvent e) {
		findIdDlog = new FindIdDialog(this, "아이디 찾기");
		findIdDlog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		findIdDlog.setVisible(true);
	}

	protected void btnFindPwActionPerformed(ActionEvent e) {
		findPwDlog = new FindPwDialog(this, "패스워드 찾기");
		findPwDlog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		findPwDlog.setVisible(true);
	}

	// 회원 이용 현황 test
//	private JFrame test;
//	private MemberUseCdtPanel muc = new MemberUseCdtPanel();
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		try {
			validCheck();

			String id = tfLoginId.getText().trim();
			String pw = new String(pfLoginPw.getPassword());

			loginMber = service.login(new Member(id, pw));
			loginLib = service.login(new Librarian(id, pw));

			if (loginLib != null) {
				if (loginLib.getTitle().getTitleNo() == 0) {
					JOptionPane.showMessageDialog(null, "총관리자 로그인 [테스트용]");
					clearTf();
				}
				if (loginLib.getTitle().getTitleNo() == 1) {
					JOptionPane.showMessageDialog(null, "사서 로그인 [테스트용]");
					clearTf();
				}
				return;
			}

			if (loginMber != null) {
				// 회원 이용 현황 test
//				if (test == null) {
//					test = new JFrame();
//					test.setTitle("이용 현황");
//					test.setBounds(100, 100, 1200, 800);
//					test.getContentPane().add(muc);
//					muc.setLogingFrame(this);
//				}
//				dispose();
//				muc.setItem();
//				test.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "회원 로그인 [테스트용]");
				clearTf();
				
				return;
			}

			JOptionPane.showMessageDialog(null, "아이디 혹은 패스워드가 틀렸습니다.");

		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}

	private void clearTf() {
		tfLoginId.setText("");
		pfLoginPw.setText("");
	}

	private void validCheck() {
		if (tfLoginId.getText().contentEquals("") || pfLoginPw.getPassword().length == 0) {
			throw new InvalidCheckException();
		}
	}
}
