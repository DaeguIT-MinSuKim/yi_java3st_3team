package yi_java3st_3team.ui.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.LoginFrame;
import yi_java3st_3team.ui.service.LendingUiService;
import yi_java3st_3team.ui.service.MemberUIService;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import yi_java3st_3team.ui.list.MemberUseCdtTblPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MemberUseCdtPanel extends JPanel implements ActionListener {
	private Dimension picDimesion = new Dimension(150, 200);
	private String defaultImg = getClass().getClassLoader().getResource("no-image.png").getPath();
	private JLabel lblMbmImg;
	private String picPath;
	private MemberUIService service;
	private LendingUiService lendService;
	private LoginFrame loginFrame;
	private JLabel lblGrade;
	private JLabel lblLendCnt;
	private JLabel lblTotlaCnt;
	private MemberUseCdtTblPanel pTotalTblList;
	private MemberUseCdtTblPanel pLendTblList;
	private JButton btnRturnPsmCdt;

	public MemberUseCdtPanel() {
		service = new MemberUIService();
		lendService = new LendingUiService();
		initialize();
	}
	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(10, 30, 10, 30));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		add(pWest, BorderLayout.WEST);
		pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
		
		JPanel pMbmImg = new JPanel();
		pMbmImg.setBackground(Color.WHITE);
		pMbmImg.setBorder(new EmptyBorder(0, 0, 10, 0));
		pWest.add(pMbmImg);
		pMbmImg.setLayout(new BoxLayout(pMbmImg, BoxLayout.Y_AXIS));
		
		JPanel pImgNorth = new JPanel();
		pImgNorth.setBorder(new EmptyBorder(0, 0, 0, 0));
		pMbmImg.add(pImgNorth);
		
		lblMbmImg = new JLabel();
		lblMbmImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMbmImg.setPreferredSize(picDimesion);
		lblMbmImg.setSize(picDimesion);
		setPicStr(defaultImg);
		pImgNorth.setLayout(new GridLayout(0, 1, 0, 0));
		pImgNorth.add(lblMbmImg);
		
		JPanel pGrade = new JPanel();
		pGrade.setBackground(Color.WHITE);
		pMbmImg.add(pGrade);
		
		lblGrade = new JLabel("등급");
		lblGrade.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pGrade.add(lblGrade);
		
		JPanel pLendBookCnt = new JPanel();
		pLendBookCnt.setBackground(Color.WHITE);
		pLendBookCnt.setBorder(new EmptyBorder(50, 0, 30, 0));
		pWest.add(pLendBookCnt);
		pLendBookCnt.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleLend = new JLabel("대여 중 도서");
		lblTitleLend.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblTitleLend.setHorizontalAlignment(SwingConstants.CENTER);
		pLendBookCnt.add(lblTitleLend, BorderLayout.NORTH);
		
		lblLendCnt = new JLabel("0권");
		lblLendCnt.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblLendCnt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendBookCnt.add(lblLendCnt, BorderLayout.CENTER);
		
		JPanel pLendTotalCnt = new JPanel();
		pLendTotalCnt.setBackground(Color.WHITE);
		pLendTotalCnt.setBorder(new EmptyBorder(30, 0, 50, 0));
		pWest.add(pLendTotalCnt);
		pLendTotalCnt.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleTotla = new JLabel("총 대여권수");
		lblTitleTotla.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblTitleTotla.setHorizontalAlignment(SwingConstants.CENTER);
		pLendTotalCnt.add(lblTitleTotla, BorderLayout.NORTH);
		
		lblTotlaCnt = new JLabel("0권");
		lblTotlaCnt.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblTotlaCnt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendTotalCnt.add(lblTotlaCnt, BorderLayout.CENTER);
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(Color.WHITE);
		pCenter.setBorder(new EmptyBorder(0, 50, 0, 0));
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
		
		JPanel pLendList = new JPanel();
		pLendList.setBackground(Color.WHITE);
		pCenter.add(pLendList);
		pLendList.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLendTitle = new JLabel("대여도서리스트");
		lblLendTitle.setBackground(Color.WHITE);
		lblLendTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		pLendList.add(lblLendTitle, BorderLayout.NORTH);
		
		JPanel pLendTbl = new JPanel();
		pLendList.add(pLendTbl, BorderLayout.CENTER);
		pLendTbl.setLayout(new BorderLayout(0, 0));
		
		pLendTblList = new MemberUseCdtTblPanel(this);
		pLendTblList.setBackground(Color.WHITE);
		pLendTbl.add(pLendTblList, BorderLayout.CENTER);
		
		JPanel pRturnPsmCdt = new JPanel();
		FlowLayout fl_pRturnPsmCdt = (FlowLayout) pRturnPsmCdt.getLayout();
		fl_pRturnPsmCdt.setAlignment(FlowLayout.RIGHT);
		pRturnPsmCdt.setBackground(Color.WHITE);
		pLendList.add(pRturnPsmCdt, BorderLayout.SOUTH);
		
		btnRturnPsmCdt = new JButton("반납연기신청");
		btnRturnPsmCdt.addActionListener(this);
		btnRturnPsmCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pRturnPsmCdt.add(btnRturnPsmCdt);
		
		JPanel pTotalList = new JPanel();
		pTotalList.setBorder(new EmptyBorder(20, 0, 0, 0));
		pTotalList.setBackground(Color.WHITE);
		pCenter.add(pTotalList);
		pTotalList.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTotalTitle = new JLabel("총 대여도서리스트");
		lblTotalTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		pTotalList.add(lblTotalTitle, BorderLayout.NORTH);
		
		JPanel pTotalTbl = new JPanel();
		pTotalList.add(pTotalTbl, BorderLayout.CENTER);
		pTotalTbl.setLayout(new BorderLayout(0, 0));
		
		pTotalTblList = new MemberUseCdtTblPanel(this);
		pTotalTblList.setBackground(Color.WHITE);
		pTotalTbl.add(pTotalTblList, BorderLayout.CENTER);
		
	}

	public void setService(LendingUiService lendService) {
		this.lendService = lendService;
		Lending lending = new Lending(new Member(LoginFrame.loginMber.getMberId()));
		pTotalTblList.loadData(lendService.showMemberLendBookTotlaList(lending));
		pLendTblList.loadData(lendService.showMemberLendBookList(lending));
	}
	
	private void setPicByte(byte[] bookImg) {
		lblMbmImg.setIcon(new ImageIcon(new ImageIcon(bookImg).getImage().getScaledInstance((int)picDimesion.getWidth(), 
				(int)picDimesion.getHeight(), Image.SCALE_DEFAULT)));
	}

	private void setPicStr(String imgPath) {
		picPath = imgPath;
		lblMbmImg.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage()
				.getScaledInstance((int) picDimesion.getWidth(), (int) picDimesion.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	public void setLogingFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	
	public void setItem() {
		if(LoginFrame.loginMber.getMberImg() == null || LoginFrame.loginMber.getMberImg().length == 0) {
			setPicStr(defaultImg);
		} else {
			setPicByte(LoginFrame.loginMber.getMberImg());
		}
		
		lblGrade.setText(LoginFrame.loginMber.getGrade().getGradeNo() > 1 ? "우수회원" : "일반회원");
		lblLendCnt.setText(String.format("%d권", LoginFrame.loginMber.getLendBookCnt()));
		lblTotlaCnt.setText(String.format("%d권", LoginFrame.loginMber.getTotalLeCnt()));
		setService(lendService);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRturnPsmCdt) {
			btnRturnPsmCdtActionPerformed(e);
		}
	}
	protected void btnRturnPsmCdtActionPerformed(ActionEvent e) {
		int[] selCnt = pLendTblList.selCnt();
		for(int sc : selCnt) {
			System.out.println(sc);
			
		}
	}
}