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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MemberUserCdtPanel extends JPanel {
	private Dimension picDimesion = new Dimension(150, 200);
	private String defaultImg = getClass().getClassLoader().getResource("no-image.png").getPath();
	private JLabel lblMbmImg;
	private String picPath;

	public MemberUserCdtPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 30, 10, 30));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		add(pWest, BorderLayout.WEST);
		pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
		
		JPanel pMbmImg = new JPanel();
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
		pMbmImg.add(pGrade);
		
		JLabel lblGrade = new JLabel("등급");
		lblGrade.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pGrade.add(lblGrade);
		
		JPanel pLendBookCnt = new JPanel();
		pLendBookCnt.setBorder(new EmptyBorder(50, 0, 30, 0));
		pWest.add(pLendBookCnt);
		pLendBookCnt.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleLend = new JLabel("대여 중 도서");
		lblTitleLend.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblTitleLend.setHorizontalAlignment(SwingConstants.CENTER);
		pLendBookCnt.add(lblTitleLend, BorderLayout.NORTH);
		
		JLabel lblLendCnt = new JLabel("0권");
		lblLendCnt.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblLendCnt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendBookCnt.add(lblLendCnt, BorderLayout.CENTER);
		
		JPanel pLendTotalCnt = new JPanel();
		pLendTotalCnt.setBorder(new EmptyBorder(30, 0, 50, 0));
		pWest.add(pLendTotalCnt);
		pLendTotalCnt.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleTotla = new JLabel("총 대여권수");
		lblTitleTotla.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblTitleTotla.setHorizontalAlignment(SwingConstants.CENTER);
		pLendTotalCnt.add(lblTitleTotla, BorderLayout.NORTH);
		
		JLabel lblTotlaCnt = new JLabel("0권");
		lblTotlaCnt.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblTotlaCnt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendTotalCnt.add(lblTotlaCnt, BorderLayout.CENTER);
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(0, 50, 0, 0));
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel pLendList = new JPanel();
		pCenter.add(pLendList);
		pLendList.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLendTitle = new JLabel("대여도서리스트");
		lblLendTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		pLendList.add(lblLendTitle, BorderLayout.NORTH);
		
		JPanel pLendTblList = new JPanel();
		pLendList.add(pLendTblList, BorderLayout.CENTER);
		
		JPanel pTotalList = new JPanel();
		pCenter.add(pTotalList);
		pTotalList.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTotalTitle = new JLabel("총 대여도서리스트");
		lblTotalTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		pTotalList.add(lblTotalTitle, BorderLayout.NORTH);
		
		JPanel pTotlaTblList = new JPanel();
		pTotalList.add(pTotlaTblList, BorderLayout.CENTER);
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
}
