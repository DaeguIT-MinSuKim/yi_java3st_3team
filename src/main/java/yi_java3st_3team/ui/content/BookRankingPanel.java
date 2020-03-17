package yi_java3st_3team.ui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.ui.service.BookUiService;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class BookRankingPanel extends JPanel {
	
	private Dimension picDimesion = new Dimension(100, 140);
	private String defaultImg = getClass().getClassLoader().getResource("book-noImg.png").getPath();
	
	private JPanel pBastRank;
	private JPanel pRank;
	private JLabel lblRank;
	private JPanel pBookInfo;
	private JPanel pBookImg;
	private JLabel lblBookImg;
	private JPanel pTitle;
	private JPanel pLeft;
	private JLabel lblTitName;
	private JLabel lblTitWriter;
	private JLabel lblTitPls;
	private JLabel lblTitCat;
	private JPanel pRight;
	private JLabel lblName;
	private JLabel lblWriter;
	private JLabel lblPls;
	private JLabel lblCat;
	private LendingUiService lendingService;
	private BookUiService bookService;
	private JPanel pBastList;
	private JPanel pNewList;
	
	public BookRankingPanel() {
		lendingService = new LendingUiService();
		bookService = new BookUiService();
		initialize();
	}
	
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pBast = new JPanel();
		pBast.setBackground(Color.WHITE);
		pBast.setBorder(new EmptyBorder(30, 30, 30, 30));
		add(pBast);
		pBast.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBast = new JLabel("대여 베스트 도서");
		lblBast.setBorder(new EmptyBorder(10, 0, 20, 0));
		lblBast.setHorizontalAlignment(SwingConstants.CENTER);
		lblBast.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		pBast.add(lblBast, BorderLayout.NORTH);
		
		pBastList = new JPanel();
		pBastList.setBackground(Color.WHITE);
		pBast.add(pBastList, BorderLayout.CENTER);
		pBastList.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pNew = new JPanel();
		pNew.setBackground(Color.WHITE);
		pNew.setBorder(new EmptyBorder(30, 30, 30, 30));
		add(pNew);
		pNew.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNew = new JLabel("신착도서");
		lblNew.setBorder(new EmptyBorder(10, 0, 20, 0));
		lblNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblNew.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		pNew.add(lblNew, BorderLayout.NORTH);
		
		pNewList = new JPanel();
		pNewList.setBackground(Color.WHITE);
		pNew.add(pNewList, BorderLayout.CENTER);
		pNewList.setLayout(new GridLayout(0, 1, 0, 0));
		
		getBastRanking();
		getNewRanking();
	}
	
	public void getBastRanking() {
		List<Lending> list = lendingService.showBastList();
		for(int i=0; i<list.size(); i++) {
			
			String writer;
			if(list.get(i).getBookCd().getTrnslrName().length() == 0 || list.get(i).getBookCd().getTrnslrName() == null) {
				writer = list.get(i).getBookCd().getAuthrName();
			} else {
				writer = String.format("%s/%s", list.get(i).getBookCd().getAuthrName(), list.get(i).getBookCd().getTrnslrName());
			}
			
			pBastRank = new JPanel();
			pBastRank.setBackground(Color.WHITE);
			pBastRank.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
			pBastList.add(pBastRank);
			pBastRank.setLayout(new BorderLayout(0, 0));
			
			pRank = new JPanel();
			pRank.setBorder(new EmptyBorder(0, 25, 0, 25));
			pRank.setBackground(Color.WHITE);
			pBastRank.add(pRank, BorderLayout.WEST);
			pRank.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblRank = new JLabel((i+1)+"");
			lblRank.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblRank.setHorizontalAlignment(SwingConstants.CENTER);
			lblRank.setPreferredSize(new Dimension(30, 15));
			pRank.add(lblRank);
			
			pBookInfo = new JPanel();
			pBookInfo.setBackground(Color.WHITE);
			pBastRank.add(pBookInfo, BorderLayout.CENTER);
			pBookInfo.setLayout(new BorderLayout(0, 0));
			
			pBookImg = new JPanel();
			pBookImg.setBackground(Color.WHITE);
			pBookInfo.add(pBookImg, BorderLayout.WEST);
			pBookImg.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblBookImg = new JLabel();
			lblBookImg.setSize(new Dimension(150, 210));
			lblBookImg.setPreferredSize(new Dimension(110, 150));
			lblBookImg.setHorizontalAlignment(SwingConstants.CENTER);
			pBookImg.add(lblBookImg);
			
			if(list.get(i).getBookCd().getBookImg() == null || list.get(i).getBookCd().getBookImg().length == 0) {
				setPicStr(defaultImg);
			} else {
				setPicByte(list.get(i).getBookCd().getBookImg());
			}
			
			pTitle = new JPanel();
			pTitle.setBackground(Color.WHITE);
			pBookInfo.add(pTitle, BorderLayout.CENTER);
			pTitle.setLayout(new BorderLayout(0, 0));
			
			pLeft = new JPanel();
			pLeft.setBackground(Color.WHITE);
			pLeft.setBorder(new EmptyBorder(0, 20, 0, 20));
			pTitle.add(pLeft, BorderLayout.WEST);
			pLeft.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblTitName = new JLabel("도서명");
			lblTitName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitName.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitName);
			
			lblTitWriter = new JLabel("저자/역자");
			lblTitWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitWriter.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitWriter);
			
			lblTitPls = new JLabel("출판사");
			lblTitPls.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitPls.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitPls);
			
			lblTitCat = new JLabel("분류");
			lblTitCat.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitCat.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitCat);
			
			pRight = new JPanel();
			pRight.setBackground(Color.WHITE);
			pTitle.add(pRight, BorderLayout.CENTER);
			pRight.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblName = new JLabel(list.get(i).getBookCd().getBookName());
			lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblName);
			
			lblWriter = new JLabel(writer);
			lblWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblWriter);
			
			lblPls = new JLabel(list.get(i).getBookCd().getPls().getPlsName());
			lblPls.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblPls);
			
			lblCat = new JLabel(String.format("%s/%s", list.get(i).getBookCd().getLcNo().getLclasName(), list.get(i).getBookCd().getMlNo().getMlsfcName()));
			lblCat.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblCat);
		}
	}
	
	public void getNewRanking() {
		List<Book> list = bookService.showNewBookList();
		for(int i=0; i<list.size(); i++) {
			
			String writer;
			if(list.get(i).getTrnslrName().length() == 0 || list.get(i).getTrnslrName() == null) {
				writer = list.get(i).getAuthrName();
			} else {
				writer = String.format("%s/%s", list.get(i).getAuthrName(), list.get(i).getTrnslrName());
			}
			
			pBastRank = new JPanel();
			pBastRank.setBackground(Color.WHITE);
			pBastRank.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
			pNewList.add(pBastRank);
			pBastRank.setLayout(new BorderLayout(0, 0));
			
			pRank = new JPanel();
			pRank.setBorder(new EmptyBorder(0, 25, 0, 25));
			pRank.setBackground(Color.WHITE);
			pBastRank.add(pRank, BorderLayout.WEST);
			pRank.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblRank = new JLabel((i+1)+"");
			lblRank.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblRank.setHorizontalAlignment(SwingConstants.CENTER);
			lblRank.setPreferredSize(new Dimension(30, 15));
			pRank.add(lblRank);
			
			pBookInfo = new JPanel();
			pBookInfo.setBackground(Color.WHITE);
			pBastRank.add(pBookInfo, BorderLayout.CENTER);
			pBookInfo.setLayout(new BorderLayout(0, 0));
			
			pBookImg = new JPanel();
			pBookImg.setBackground(Color.WHITE);
			pBookInfo.add(pBookImg, BorderLayout.WEST);
			pBookImg.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblBookImg = new JLabel();
			lblBookImg.setSize(new Dimension(150, 210));
			lblBookImg.setPreferredSize(new Dimension(110, 150));
			lblBookImg.setHorizontalAlignment(SwingConstants.CENTER);
			pBookImg.add(lblBookImg);
			
			if(list.get(i).getBookImg() == null || list.get(i).getBookImg().length == 0) {
				setPicStr(defaultImg);
			} else {
				setPicByte(list.get(i).getBookImg());
			}
			
			pTitle = new JPanel();
			pTitle.setBackground(Color.WHITE);
			pBookInfo.add(pTitle, BorderLayout.CENTER);
			pTitle.setLayout(new BorderLayout(0, 0));
			
			pLeft = new JPanel();
			pLeft.setBackground(Color.WHITE);
			pLeft.setBorder(new EmptyBorder(0, 20, 0, 20));
			pTitle.add(pLeft, BorderLayout.WEST);
			pLeft.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblTitName = new JLabel("도서명");
			lblTitName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitName.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitName);
			
			lblTitWriter = new JLabel("저자/역자");
			lblTitWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitWriter.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitWriter);
			
			lblTitPls = new JLabel("출판사");
			lblTitPls.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitPls.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitPls);
			
			lblTitCat = new JLabel("분류");
			lblTitCat.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lblTitCat.setHorizontalAlignment(SwingConstants.LEFT);
			pLeft.add(lblTitCat);
			
			pRight = new JPanel();
			pRight.setBackground(Color.WHITE);
			pTitle.add(pRight, BorderLayout.CENTER);
			pRight.setLayout(new GridLayout(0, 1, 0, 0));
			
			lblName = new JLabel(list.get(i).getBookName());
			lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblName);
			
			lblWriter = new JLabel(writer);
			lblWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblWriter);
			
			lblPls = new JLabel(list.get(i).getPls().getPlsName());
			lblPls.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblPls);
			
			lblCat = new JLabel(String.format("%s/%s", list.get(i).getLcNo().getLclasName(), list.get(i).getMlNo().getMlsfcName()));
			lblCat.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			pRight.add(lblCat);
		}
	}
	
	private void setPicByte(byte[] bookImg) {
		lblBookImg.setIcon(new ImageIcon(new ImageIcon(bookImg).getImage().getScaledInstance((int)picDimesion.getWidth(), 
				(int)picDimesion.getHeight(), Image.SCALE_DEFAULT)));
	}

	private void setPicStr(String imgPath) {
		lblBookImg.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance((int) picDimesion.getWidth(), 
				(int) picDimesion.getHeight(), Image.SCALE_DEFAULT)));
	}
	

}
