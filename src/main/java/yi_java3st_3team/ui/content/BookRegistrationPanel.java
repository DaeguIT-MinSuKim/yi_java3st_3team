package yi_java3st_3team.ui.content;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.dto.PublishingCompany;
import yi_java3st_3team.ui.exception.InvalidCheckException;
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
public class BookRegistrationPanel extends AbsItemPanel<Book> implements ActionListener {
	private Dimension picDimesion = new Dimension(150, 210);
	private String picPath;
	private JLabel lblBookImg;
	private JTextField tfBookName;
	private JTextField tfAuthr;
	private JTextField tfTrnslr;
	private JTextField tfBookPirce;
	private JDateChooser tfRegistDate;
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
	private JButton btnCancel;
	private JButton btnSave;

	public BookRegistrationPanel() {
		service = new BookUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(50, 0, 0, 40));
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 10, 10));

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
		pCategory.add(cmbLc);

		cmbMl = new JComboBox<>();
		pCategory.add(cmbMl);

		JLabel lblPls = new JLabel("출판사");
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPls);

		cmbPls = new JComboBox<>();
		pCenter.add(cmbPls);

		JLabel lblPblicYear = new JLabel("출간일");
		lblPblicYear.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPblicYear);

		tfRegistDate = new JDateChooser(new Date(), "yyyy-MM-dd");
		pCenter.add(tfRegistDate);

		JLabel lblLendPsbCdt = new JLabel("대여가능여부");
		lblLendPsbCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblLendPsbCdt);

		pLendPsbCdt = new JPanel();
		pCenter.add(pLendPsbCdt);
		pLendPsbCdt.setLayout(new GridLayout(0, 2, 10, 10));

		lendPsbCdtBtnGrp = new ButtonGroup();

		rdoYes = new JRadioButton("대여 가능");
		rdoYes.setSelected(true);
		pLendPsbCdt.add(rdoYes);

		rdoNo = new JRadioButton("대여 불가능");
		pLendPsbCdt.add(rdoNo);

		lendPsbCdtBtnGrp.add(rdoYes);
		lendPsbCdtBtnGrp.add(rdoNo);

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

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setFocusable(false);
		btnCancel.setPreferredSize(new Dimension(80, 40));
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pSouth.add(btnCancel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(10, 0));
		pSouth.add(lblNewLabel);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		btnSave.setFocusable(false);
		btnSave.setPreferredSize(new Dimension(80, 40));
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

	private void setPicStr(String imgPath) {
		picPath = imgPath;
		lblBookImg.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage()
				.getScaledInstance((int) picDimesion.getWidth(), (int) picDimesion.getHeight(), Image.SCALE_DEFAULT)));
	}

	@Override
	public Book getItem() {
		validCheck();
		LargeClassification lcNo = (LargeClassification) cmbLc.getSelectedItem();
		MiddleClassification mlNo = (MiddleClassification) cmbMl.getSelectedItem();

		String lcNoStd = String.format("%02d", lcNo.getLclasNo());
		String mlNoStd = String.format("%02d", mlNo.getMlsfcNo());
		String lastCode = service.getLastCode();
		int lastCodeAp = lastCode.substring(0, 1).charAt(0);
		int lastNum = Integer.parseInt(lastCode.substring(lastCode.length() - 2, lastCode.length()));
		String bookCode = null;

		if (lastNum == 99) {
			bookCode = ((char) (lastCodeAp + 1)) + lcNoStd + mlNoStd + String.format("%02d", 1);
		} else {
			bookCode = ((char) lastCodeAp) + lcNoStd + mlNoStd + String.format("%02d", (lastNum + 1));
		}

		String bookName = tfBookName.getText().trim();
		String authrName = tfAuthr.getText().trim();
		String trnslrName = tfTrnslr.getText().trim();
		PublishingCompany pls = (PublishingCompany) cmbPls.getSelectedItem();
		Date pblicteYear = tfRegistDate.getDate();
		int bookPrice = Integer.parseInt(tfBookPirce.getText().trim());

		int lendPsbCdt = 0;
		if (rdoYes.isSelected()) {
			lendPsbCdt = 0;
		} else if (rdoNo.isSelected()) {
			lendPsbCdt = 1;
		}

		int totalLeCnt = 0;
		byte[] bookImg = getImge();
		Date registDate = new Date();
		int dsuseCdt = 0;

		return new Book(bookCode, bookName, authrName, trnslrName, pls, pblicteYear, bookPrice, lendPsbCdt, totalLeCnt,
				bookImg, lcNo, mlNo, registDate, dsuseCdt);
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
	public void setItem(Book item) {}

	@Override
	public void clearTf() {
		tfBookName.setText("");
		tfAuthr.setText("");
		tfTrnslr.setText("");
		tfBookPirce.setText("");
		cmbLc.setSelectedIndex(-1);
		cmbMl.setSelectedIndex(-1);
		cmbPls.setSelectedIndex(-1);
		tfRegistDate.setDate(new Date());
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
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
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

	protected void btnCancelActionPerformed(ActionEvent e) {
		clearTf();
	}

	protected void btnSaveActionPerformed(ActionEvent e) {
		try {
			Book newBook = getItem();
			LogUtil.prnLog(newBook.toDebug());
			service.addBook(newBook);
			clearTf();
			JOptionPane.showMessageDialog(null,
					String.format("%s[%s] 추가되었습니다.", newBook.getBookName(), newBook.getBookCode()));
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "도서가격에 숫자만 작성해주세요.");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
