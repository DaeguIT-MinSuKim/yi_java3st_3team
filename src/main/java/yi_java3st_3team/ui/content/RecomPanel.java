package yi_java3st_3team.ui.content;

import yi_java3st_3team.dto.Recommendation;
import yi_java3st_3team.ui.service.RecomUiService;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class RecomPanel extends JPanel {
	private Dimension picDimesion = new Dimension(150, 210);
	private String defaultImg = getClass().getClassLoader().getResource("book-noImg.png").getPath();
	private String picPath;
	
	private JTextField tfCategory;
	private JTextField tfBookName;
	private JTextField tfWriter;
	private JTextField tfPblicYear;
	private JTextField tfPls;
	private JLabel lblBookImg;
	
	private RecomUiService service;
	private JTextArea taContent;
	
	public RecomPanel() {
		service = new RecomUiService();
		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pBox1 = new JPanel();
		pBox1.setBorder(new EmptyBorder(50, 50, 20, 50));
		add(pBox1);
		pBox1.setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		pWest.setBorder(new EmptyBorder(0, 0, 0, 0));
		pBox1.add(pWest, BorderLayout.WEST);
		pWest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pImg = new JPanel();
		pImg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pWest.add(pImg);
		pImg.setLayout(new BorderLayout(0, 0));
		
		lblBookImg = new JLabel();
		lblBookImg.setSize(picDimesion);
		lblBookImg.setPreferredSize(picDimesion);
		setPicStr(defaultImg);
		pImg.add(lblBookImg, BorderLayout.CENTER);
		
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(0, 0, 0, 150));
		pBox1.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 15, 15));
		
		JLabel lblCategory = new JLabel("카테고리");
		lblCategory.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblCategory);
		
		tfCategory = new JTextField();
		tfCategory.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfCategory.setEditable(false);
		pCenter.add(tfCategory);
		tfCategory.setColumns(10);
		
		JLabel lblBookName = new JLabel("도서명");
		lblBookName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBookName);
		
		tfBookName = new JTextField();
		tfBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfBookName.setEditable(false);
		tfBookName.setColumns(10);
		pCenter.add(tfBookName);
		
		JLabel lblWriter = new JLabel("저자/역자");
		lblWriter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblWriter.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblWriter);
		
		tfWriter = new JTextField();
		tfWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfWriter.setEditable(false);
		tfWriter.setColumns(10);
		pCenter.add(tfWriter);
		
		JLabel lblPblicYear = new JLabel("발행일");
		lblPblicYear.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPblicYear.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPblicYear);
		
		tfPblicYear = new JTextField();
		tfPblicYear.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfPblicYear.setEditable(false);
		tfPblicYear.setColumns(10);
		pCenter.add(tfPblicYear);
		
		JLabel lblPls = new JLabel("출판사");
		lblPls.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPls);
		
		tfPls = new JTextField();
		tfPls.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfPls.setEditable(false);
		tfPls.setColumns(10);
		pCenter.add(tfPls);
		
		JPanel pBox2 = new JPanel();
		pBox2.setBorder(new EmptyBorder(0, 50, 30, 50));
		add(pBox2);
		pBox2.setLayout(new BorderLayout(0, 0));
		
		JPanel pTitle = new JPanel();
		pTitle.setBorder(new EmptyBorder(10, 0, 10, 0));
		pBox2.add(pTitle, BorderLayout.NORTH);
		pTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("추천글");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		pTitle.add(lblTitle, BorderLayout.NORTH);
		
		JPanel pContent = new JPanel();
		pContent.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pBox2.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new BorderLayout(0, 0));
		
		taContent = new JTextArea();
		taContent.setBorder(new EmptyBorder(15, 15, 15, 15));
		taContent.setLineWrap(true);
		taContent.setEditable(false);
		pContent.add(taContent, BorderLayout.CENTER);
		
		setService(service);
	}

	public void setService(RecomUiService service) {
		this.service = service;
		setItem(service.showRecomBookByLastNo());
	}

	
	public void setItem(Recommendation item) {
		tfCategory.setText(String.format("%s / %s", item.getBookCode().getLcNo().getLclasName(), item.getBookCode().getMlNo().getMlsfcName()));
		tfBookName.setText(item.getBookCode().getBookName());
		if(item.getBookCode().getTrnslrName().equals("")) {
			tfWriter.setText(item.getBookCode().getAuthrName());
		} else {
			tfWriter.setText(String.format("%s / %s", item.getBookCode().getAuthrName(), item.getBookCode().getTrnslrName()));
		}
		tfPblicYear.setText(String.format("%tF", item.getBookCode().getPblicteYear()));
		tfPls.setText(item.getBookCode().getPls().getPlsName());
		if(item.getBookCode().getBookImg().length == 0) {
			setPicStr(defaultImg);
		} else {
			setPicByte(item.getBookCode().getBookImg());
		}
		taContent.setText(item.getBookCont());
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
