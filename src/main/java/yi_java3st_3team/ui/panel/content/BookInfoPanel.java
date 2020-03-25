package yi_java3st_3team.ui.panel.content;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.ui.service.BookUiService;

@SuppressWarnings("serial")
public class BookInfoPanel extends JPanel {
	private Dimension picDimesion = new Dimension(150, 210);
	private String picPath;
	private JLabel lblBookImg;

	private BookUiService service;
	private JPanel pCenter;
	private String defaultImg = getClass().getClassLoader().getResource("book-noImg.png").getPath();
	private JLabel lblBookCode;
	private JLabel lblGetBookCode;
	private JLabel lblGetBookName;
	private JLabel lblGetAuthr;
	private JLabel lblGetTrnslr;
	private JLabel lblGetBookPirce;
	private JLabel lblGetLendPsbCdt;
	private JLabel lblGetCat;
	private JLabel lblGetPls;
	private JLabel lblGetPblicDate;
	private JLabel lblBookCnt;
	private JLabel lblGetBookCnt;
	

	public BookInfoPanel() {
		service = new BookUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(50, 0, 50, 40));
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 10, 10));
		
		lblBookCode = new JLabel("도서코드");
		lblBookCode.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBookCode);
		
		lblGetBookCode = new JLabel("New label");
		lblGetBookCode.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetBookCode);

		JLabel lblBookName = new JLabel("도서명");
		lblBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBookName);
		
		lblGetBookName = new JLabel("New label");
		lblGetBookName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetBookName);

		JLabel lblAuthr = new JLabel("저 자");
		lblAuthr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblAuthr.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblAuthr);
		
		lblGetAuthr = new JLabel("New label");
		lblGetAuthr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetAuthr);

		JLabel lblTrnslr = new JLabel("역 자");
		lblTrnslr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblTrnslr.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblTrnslr);
		
		lblGetTrnslr = new JLabel("New label");
		lblGetTrnslr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetTrnslr);

		JLabel lblBookPirce = new JLabel("도서가격");
		lblBookPirce.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblBookPirce.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBookPirce);
		
		lblGetBookPirce = new JLabel("New label");
		lblGetBookPirce.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetBookPirce);

		JLabel lblCategory = new JLabel("카테고리(분류)");
		lblCategory.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblCategory);
		
		lblGetCat = new JLabel("New label");
		lblGetCat.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetCat);

		JLabel lblPls = new JLabel("출판사");
		lblPls.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPls);
		
		lblGetPls = new JLabel("New label");
		lblGetPls.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetPls);

		JLabel lblPblicDate = new JLabel("출간일");
		lblPblicDate.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblPblicDate.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPblicDate);
		
		lblGetPblicDate = new JLabel("New label");
		lblGetPblicDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetPblicDate);

		JLabel lblLendPsbCdt = new JLabel("대여가능여부");
		lblLendPsbCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblLendPsbCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblLendPsbCdt);
		
		lblGetLendPsbCdt = new JLabel("New label");
		lblGetLendPsbCdt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetLendPsbCdt);
		
		lblBookCnt = new JLabel("보유도서권수");
		lblBookCnt.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pCenter.add(lblBookCnt);
		
		lblGetBookCnt = new JLabel("New label");
		lblGetBookCnt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pCenter.add(lblGetBookCnt);

		JPanel pEast = new JPanel();
		pEast.setBorder(new EmptyBorder(50, 0, 0, 50));
		add(pEast, BorderLayout.EAST);
		pEast.setLayout(new BorderLayout(0, 0));

		JPanel pBookImg = new JPanel();
		pBookImg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pEast.add(pBookImg, BorderLayout.NORTH);

		lblBookImg = new JLabel();
		lblBookImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookImg.setSize(picDimesion);
		lblBookImg.setPreferredSize(picDimesion);
		setPicStr(defaultImg);
		pBookImg.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pBookImg.add(lblBookImg);

	}

	private byte[] getImge() {
		byte[] pic = null;
		File file = new File(picPath);
		try (InputStream is = new FileInputStream(file)) {
			pic = new byte[is.available()];
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pic;
	}

	public void setItem(Book item) {
		lblGetBookCode.setText(item.getBookCode());
		lblGetBookName.setText(item.getBookName());
		lblGetAuthr.setText(item.getAuthrName());
		lblGetTrnslr.setText(item.getTrnslrName() != null ? item.getTrnslrName() : "");
		lblGetBookPirce.setText(String.format("%,d 원", item.getBookPrice()));
		lblGetCat.setText(String.format("%s / %s", item.getLcNo().getLclasName(), item.getMlNo().getMlsfcName()));
		lblGetPls.setText(item.getPls().getPlsName());
		lblGetPblicDate.setText(String.format("%tF", item.getPblicteYear()));
		lblGetBookCnt.setText(item.getBookCnt() + " 권");
		
		if(item.getLendPsbCdt() == 0) {
			lblGetLendPsbCdt.setText("대여가능");
		} else if (item.getLendPsbCdt() == 1) {
			lblGetLendPsbCdt.setText("대여중");
		} else {
			lblGetLendPsbCdt.setText("대여불가능");
		}
		
		if(item.getBookImg() == null || item.getBookImg().length == 0) {
			setPicStr(defaultImg);
		} else {
			setPicByte(item.getBookImg());
		}
	}

	private void setPicByte(byte[] bookImg) {
		lblBookImg.setIcon(new ImageIcon(new ImageIcon(bookImg).getImage().getScaledInstance((int)picDimesion.getWidth(), 
				(int)picDimesion.getHeight(), Image.SCALE_DEFAULT)));
	}

	private void setPicStr(String imgPath) {
		picPath = imgPath;
		lblBookImg.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage()
				.getScaledInstance((int) picDimesion.getWidth(), (int) picDimesion.getHeight(), Image.SCALE_DEFAULT)));
	}

}
