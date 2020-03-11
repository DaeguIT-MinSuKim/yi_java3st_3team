package yi_java3st_3team.ui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Recommendation;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.service.RecomUiService;

@SuppressWarnings("serial")
public class ReComBookAddPanel extends AbsItemPanel<Recommendation> implements ActionListener {
	private Dimension picDimesion = new Dimension(150, 210);
	private String defaultImg = getClass().getClassLoader().getResource("book-noImg.png").getPath();
	private String picPath;
	private JLabel lblBookImg;
	private JTextField tfCategory;
	private JTextField tfWriter;
	private JTextField tfBookName;
	private JTextField tfPls;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextArea taPost;
	private String getBookCode;
	private RecomUiService service;
	
	
	public ReComBookAddPanel() {
		service = new RecomUiService();
		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pList = new JPanel();
		pList.setPreferredSize(new Dimension(10, 150));
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		BookListPanel pBookList = new BookListPanel(this);
		pBookList.setPreferredSize(new Dimension(104, 10));
		pList.add(pBookList);
		
		JPanel pTf = new JPanel();
		pTf.setBorder(new EmptyBorder(30, 10, 20, 10));
		add(pTf);
		pTf.setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		pTf.add(pWest, BorderLayout.WEST);
		pWest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblBookImg = new JLabel();
		lblBookImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookImg.setSize(picDimesion);
		lblBookImg.setPreferredSize(picDimesion);
		setPicStr(defaultImg);
		pWest.add(lblBookImg);
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(0, 10, 0, 10));
		pTf.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
		
		JPanel pBox1 = new JPanel();
		pBox1.setBorder(new EmptyBorder(10, 10, 10, 10));
		pCenter.add(pBox1);
		pBox1.setLayout(new GridLayout(0, 4, 0, 10));
		
		JLabel lblCategory = new JLabel("카테고리");
		lblCategory.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCategory.setBorder(new EmptyBorder(0, 0, 0, 10));
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		pBox1.add(lblCategory);
		
		tfCategory = new JTextField();
		tfCategory.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfCategory.setEditable(false);
		pBox1.add(tfCategory);
		tfCategory.setColumns(10);
		
		JLabel lblPls = new JLabel("저자/역자");
		lblPls.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblPls.setBorder(new EmptyBorder(0, 0, 0, 10));
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		pBox1.add(lblPls);
		
		tfWriter = new JTextField();
		tfWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfWriter.setEditable(false);
		tfWriter.setColumns(10);
		pBox1.add(tfWriter);
		
		JLabel lblWriter = new JLabel("도서명");
		lblWriter.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblWriter.setBorder(new EmptyBorder(0, 0, 0, 10));
		lblWriter.setHorizontalAlignment(SwingConstants.CENTER);
		pBox1.add(lblWriter);
		
		tfBookName = new JTextField();
		tfBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfBookName.setEditable(false);
		tfBookName.setColumns(10);
		pBox1.add(tfBookName);
		
		JLabel lblBookName = new JLabel("출판사");
		lblBookName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblBookName.setBorder(new EmptyBorder(0, 0, 0, 10));
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		pBox1.add(lblBookName);
		
		tfPls = new JTextField();
		tfPls.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfPls.setEditable(false);
		tfPls.setColumns(10);
		pBox1.add(tfPls);
		
		JPanel pBox2 = new JPanel();
		pBox2.setBorder(new EmptyBorder(10, 0, 0, 0));
		pCenter.add(pBox2);
		pBox2.setLayout(new BorderLayout(0, 0));
		
		JPanel pPost = new JPanel();
		pPost.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
		pBox2.add(pPost, BorderLayout.NORTH);
		pPost.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPost = new JLabel("추천글 작성");
		lblPost.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblPost.setBorder(new EmptyBorder(10, 0, 10, 0));
		pPost.add(lblPost);
		
		JPanel pTa = new JPanel();
		pTa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pBox2.add(pTa, BorderLayout.CENTER);
		pTa.setLayout(new BorderLayout(0, 0));
		
		taPost = new JTextArea();
		taPost.setBorder(new EmptyBorder(10, 10, 10, 10));
		taPost.setLineWrap(true);
		pTa.add(taPost);
		
		JPanel pBox3 = new JPanel();
		pCenter.add(pBox3);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setPreferredSize(new Dimension(80, 40));
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pBox3.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(10, 0));
		pBox3.add(lblNewLabel);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		btnSave.setPreferredSize(new Dimension(80, 40));
		btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pBox3.add(btnSave);
	}
	
	@Override
	public Recommendation getItem() {
		validCheck();
		Book bookCode = new Book(getBookCode);
		String bookCont = taPost.getText();
		return new Recommendation(bookCode, bookCont);
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

	
	public void setItem(Book item) {
		getBookCode = item.getBookCode();
		tfCategory.setText(String.format("%s/%s", item.getLcNo().getLclasName(), item.getMlNo().getMlsfcName()));
		if(item.getTrnslrName().equals("") || item.getTrnslrName() == null) {
			tfWriter.setText(item.getAuthrName().trim());
		} else {
			tfWriter.setText(String.format("%s/%s", item.getAuthrName(), item.getTrnslrName()));
		}
		tfBookName.setText(item.getBookName().trim());
		tfPls.setText(item.getPls().getPlsName());
		if(item.getBookImg() == null || item.getBookImg().length == 0) {
			setPicStr(defaultImg);
		} else {
			setPicByte(item.getBookImg());
		}
	}

	@Override
	public void clearTf() {
		tfCategory.setText("");
		tfWriter.setText("");
		tfBookName.setText("");
		tfPls.setText("");
		taPost.setText("");
		setPicStr(defaultImg);
	}

	@Override
	public void validCheck() {
		if(taPost.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
	}
	@Override
	public void setItem(Recommendation item) {}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			btnSaveActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		clearTf();
	}
	protected void btnSaveActionPerformed(ActionEvent e) {
		try {
			if(taPost.getText().length() > 1050) {
				JOptionPane.showMessageDialog(null, "입력 가능한 글자 수를 넘었습니다", "경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Recommendation newRecom = getItem();
			service.addRecom(newRecom);
			clearTf();
			JOptionPane.showMessageDialog(null, "추천도서가 추가되었습니다");
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
