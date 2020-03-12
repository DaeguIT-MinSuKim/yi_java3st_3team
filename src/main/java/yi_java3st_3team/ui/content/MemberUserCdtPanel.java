package yi_java3st_3team.ui.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class MemberUserCdtPanel extends JPanel {

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
		pMbmImg.setLayout(new BorderLayout(0, 0));
		
		JPanel pImgNorth = new JPanel();
		pImgNorth.setBorder(new EmptyBorder(0, 0, 10, 0));
		pMbmImg.add(pImgNorth, BorderLayout.NORTH);
		
		JLabel lblMbmImg = new JLabel("img");
		lblMbmImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMbmImg.setPreferredSize(new Dimension(150, 200));
		pImgNorth.add(lblMbmImg, BorderLayout.CENTER);
		
		JLabel lblGrade = new JLabel("등급");
		lblGrade.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pMbmImg.add(lblGrade, BorderLayout.SOUTH);
		
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

}
