package yi_java3st_3team.ui.panel.content;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.dto.PublishingCompany;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.panel.AbsItemPanel;
import yi_java3st_3team.ui.service.BookUiService;
import yi_java3st_3team.util.LogUtil;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BookUpdatePanel extends AbsItemPanel<Book> implements ActionListener {
	private Dimension picDimesion = new Dimension(150, 210);
	private String picPath;
	private JLabel lblBookImg;
	private JTextField tfBookName;
	private JTextField tfAuthr;
	private JTextField tfTrnslr;
	private JTextField tfBookPirce;
	private JDateChooser tfPblicDate;
	private JComboBox<LargeClassification> cmbLc;
	private JComboBox<MiddleClassification> cmbMl;
	private JComboBox<PublishingCompany> cmbPls;
	private JPanel pLendPsbCdt;
	private JRadioButton rdoYes;
	private JRadioButton rdoNo;
	private ButtonGroup lendPsbCdtBtnGrp;

	private BookUiService service;
	private JPanel pCenter;
	private JButton btnBookImg;
	private String defaultImg = getClass().getClassLoader().getResource("book-noImg.png").getPath();
	private JButton btnSave;
	private JLabel lblBookCode;
	private JTextField tfBookCode;
	private JRadioButton rdoRental;
	

	public BookUpdatePanel() {
		service = new BookUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(50, 0, 0, 40));
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 10, 10));
		
		lblBookCode = new JLabel("도서코드");
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBookCode);
		
		tfBookCode = new JTextField();
		tfBookCode.setEditable(false);
		pCenter.add(tfBookCode);
		tfBookCode.setColumns(10);

		JLabel lblBookName = new JLabel("도서명");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBookName);

		tfBookName = new JTextField();
		pCenter.add(tfBookName);
		tfBookName.setColumns(10);

		JLabel lblAuthr = new JLabel("저 자");
		lblAuthr.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblAuthr);

		tfAuthr = new JTextField();
		tfAuthr.setColumns(10);
		pCenter.add(tfAuthr);

		JLabel lblTrnslr = new JLabel("역 자");
		lblTrnslr.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblTrnslr);

		tfTrnslr = new JTextField();
		pCenter.add(tfTrnslr);
		tfTrnslr.setColumns(10);

		JLabel lblBookPirce = new JLabel("도서가격");
		lblBookPirce.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBookPirce);

		tfBookPirce = new JTextField();
		pCenter.add(tfBookPirce);
		tfBookPirce.setColumns(10);

		JLabel lblCategory = new JLabel("카테고리(분류)");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblCategory);

		JPanel pCategory = new JPanel();
		pCenter.add(pCategory);
		pCategory.setLayout(new GridLayout(0, 2, 10, 10));

		cmbLc = new JComboBox<>();
		cmbLc.setEnabled(false);
		pCategory.add(cmbLc);

		cmbMl = new JComboBox<>();
		cmbMl.setEnabled(false);
		pCategory.add(cmbMl);

		JLabel lblPls = new JLabel("출판사");
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPls);

		cmbPls = new JComboBox<>();
		pCenter.add(cmbPls);

		JLabel lblPblicYear = new JLabel("출간일");
		lblPblicYear.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPblicYear);

		tfPblicDate = new JDateChooser(new Date(), "yyyy-MM-dd");
		pCenter.add(tfPblicDate);

		JLabel lblLendPsbCdt = new JLabel("대여가능여부");
		lblLendPsbCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblLendPsbCdt);

		pLendPsbCdt = new JPanel();
		pCenter.add(pLendPsbCdt);

		lendPsbCdtBtnGrp = new ButtonGroup();
		pLendPsbCdt.setLayout(new GridLayout(0, 3, 0, 0));

		rdoYes = new JRadioButton("대여 가능");
		rdoYes.setHorizontalAlignment(SwingConstants.CENTER);
		pLendPsbCdt.add(rdoYes);
		
		rdoRental = new JRadioButton("대여중");
		rdoRental.setHorizontalAlignment(SwingConstants.CENTER);
		pLendPsbCdt.add(rdoRental);

		rdoNo = new JRadioButton("대여 불가능");
		rdoNo.setHorizontalAlignment(SwingConstants.CENTER);
		pLendPsbCdt.add(rdoNo);

		lendPsbCdtBtnGrp.add(rdoYes);
		lendPsbCdtBtnGrp.add(rdoNo);
		lendPsbCdtBtnGrp.add(rdoRental);

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

		JPanel pBookImgBtn = new JPanel();
		pEast.add(pBookImgBtn);

		btnBookImg = new JButton("도서이미지");
		btnBookImg.addActionListener(this);
		btnBookImg.setFocusable(false);
		btnBookImg.setPreferredSize(new Dimension(130, 40));
		btnBookImg.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pBookImgBtn.add(btnBookImg);

		JPanel pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(30, 0, 30, 0));
		add(pSouth, BorderLayout.SOUTH);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		btnSave.setFocusable(false);
		btnSave.setPreferredSize(new Dimension(130, 40));
		btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pSouth.add(btnSave);

		setService(service);
	}

	public void setService(BookUiService service) {
		this.service = service;
		setCmbLcList(service.showLcList());
		setCmbPlsList(service.showPlsList());
		cmbLc.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					setCmbMlList(service.showMlList((LargeClassification) cmbLc.getSelectedItem()));
				}
			}
		});
	}

	public void setCmbLcList(List<LargeClassification> lcList) {
		DefaultComboBoxModel<LargeClassification> model = new DefaultComboBoxModel<LargeClassification>(
				new Vector<>(lcList));
		cmbLc.setModel(model);
		cmbLc.setSelectedIndex(-1);
	}

	public void setCmbMlList(List<MiddleClassification> mlList) {
		DefaultComboBoxModel<MiddleClassification> model = new DefaultComboBoxModel<MiddleClassification>(
				new Vector<>(mlList));
		cmbMl.setModel(model);
		cmbMl.setSelectedIndex(-1);
	}

	public void setCmbPlsList(List<PublishingCompany> plsList) {
		DefaultComboBoxModel<PublishingCompany> model = new DefaultComboBoxModel<PublishingCompany>(
				new Vector<>(plsList));
		cmbPls.setModel(model);
		cmbPls.setSelectedIndex(0);
	}

	@Override
	public Book getItem() {
		validCheck();

		String bookCode = tfBookCode.getText().trim();
		String bookName = tfBookName.getText().trim();
		String authrName = tfAuthr.getText().trim();
		String trnslrName = tfTrnslr.getText().trim();
		PublishingCompany pls = (PublishingCompany) cmbPls.getSelectedItem();
		Date pblicteYear = tfPblicDate.getDate();
		int bookPrice = Integer.parseInt(tfBookPirce.getText().trim());

		int lendPsbCdt = 0;
		if (rdoYes.isSelected()) {
			lendPsbCdt = 0;
		} else if (rdoRental.isSelected()) {
			lendPsbCdt = 1;
		} else {
			lendPsbCdt = 2;
		}

		byte[] bookImg = getImge();
		LargeClassification lcNo = (LargeClassification) cmbLc.getSelectedItem();
		MiddleClassification mlNo = (MiddleClassification) cmbMl.getSelectedItem();
		
		return new Book(bookCode, bookName, authrName, trnslrName, pls, pblicteYear, bookPrice, lendPsbCdt, bookImg, lcNo, mlNo);
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

	@Override
	public void setItem(Book item) {
		tfBookCode.setText(item.getBookCode());
		tfBookName.setText(item.getBookName());
		tfAuthr.setText(item.getAuthrName());
		tfTrnslr.setText(item.getTrnslrName() != null ? item.getTrnslrName() : "");
		tfBookPirce.setText(item.getBookPrice()+"");
		cmbLc.setSelectedItem(item.getLcNo());
		cmbMl.setSelectedItem(item.getMlNo());
		cmbMl.setSelectedIndex(item.getMlNo().getMlsfcNo()-1);
		cmbPls.setSelectedItem(item.getPls());
		tfPblicDate.setDate(item.getPblicteYear());
		
		if(item.getLendPsbCdt() == 0) {
			rdoYes.setSelected(true);
			rdoRental.setEnabled(false);
		} else if (item.getLendPsbCdt() == 1) {
			rdoRental.setSelected(true);
			rdoRental.setEnabled(false);
			rdoNo.setEnabled(false);
			rdoYes.setEnabled(false);
		} else {
			rdoNo.setSelected(true);
			rdoRental.setEnabled(false);
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

	@Override
	public void clearTf() {
		tfBookName.setText("");
		tfAuthr.setText("");
		tfTrnslr.setText("");
		tfBookPirce.setText("");
		cmbLc.setSelectedIndex(-1);
		cmbMl.setSelectedIndex(-1);
		cmbPls.setSelectedIndex(-1);
		tfPblicDate.setDate(new Date());
		rdoYes.setSelected(true);
		setPicStr(defaultImg);
	}

	@Override
	public void validCheck() {
		if (tfBookName.getText().contentEquals("") || tfAuthr.getText().contentEquals("")
				|| tfBookPirce.getText().contentEquals("") || cmbLc.getSelectedIndex() == -1
				|| cmbMl.getSelectedIndex() == -1 || cmbPls.getSelectedIndex() == -1) {
			throw new InvalidCheckException();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			btnSaveActionPerformed(e);
		}
		if (e.getSource() == btnBookImg) {
			btnBookImgActionPerformed(e);
		}
	}

	protected void btnBookImgActionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG or PNG or GIF", "jpg", "png", "gif");
		chooser.setFileFilter(filter);

		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		picPath = chooser.getSelectedFile().getPath();
		setPicStr(picPath);
	}

	protected void btnSaveActionPerformed(ActionEvent e) {
		try {
			Book upBook = getItem();
			service.modifyBook(upBook);
			JOptionPane.showMessageDialog(null,
					String.format("%s[%s] 수정 되었습니다.", upBook.getBookName(), upBook.getBookCode()));
			
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "도서가격에 숫자만 작성해주세요.");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
