package yi_java3st_3team.ui.content;

import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Color;

import yi_java3st_3team.ui.dialog.BookLcMgnDialog;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.list.BookLcAndMlTblPanel;
import yi_java3st_3team.ui.service.BookUiService;
import yi_java3st_3team.ui.service.MiddleClassIficationUiservice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookLcAndMlManagerPanel extends AbsItemPanel<MiddleClassification> implements ActionListener {
	private JTextField tfMlCode;
	private JTextField tfMlName;
	private BookLcAndMlTblPanel pLcMlList;
	private MiddleClassIficationUiservice service;
	private BookUiService bookService;
	private JComboBox<LargeClassification> cmbLc;
	private JButton btnCancel;
	private JButton btnAdd;
	private JButton btnLcAdd;
	private BookLcMgnDialog lcMgnDlg;
	private JFrame lcMgnFrame;

	public BookLcAndMlManagerPanel() {
		service = new MiddleClassIficationUiservice();
		bookService = new BookUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pContent = new JPanel();
		pContent.setBackground(Color.WHITE);
		add(pContent);
		pContent.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		pContent.add(lblNewLabel);

		JPanel pLcMlCon = new JPanel();
		pLcMlCon.setBackground(Color.WHITE);
		pContent.add(pLcMlCon);
		pLcMlCon.setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		pNorth.setBorder(new EmptyBorder(50, 50, 0, 30));
		pLcMlCon.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblLcTitle = new JLabel("대분류");
		lblLcTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblLcTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblLcTitle);

		cmbLc = new JComboBox<>();
		pNorth.add(cmbLc);

		JPanel pLcBtn = new JPanel();
		pLcBtn.setBackground(Color.WHITE);
		pLcBtn.setBorder(new EmptyBorder(0, 10, 0, 0));
		pNorth.add(pLcBtn);
		pLcBtn.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		btnLcAdd = new JButton("등록/수정");
		btnLcAdd.addActionListener(this);
		pLcBtn.add(btnLcAdd);

		JPanel pCenter = new JPanel();
		pCenter.setBackground(Color.WHITE);
		pCenter.setBorder(new EmptyBorder(30, 50, 50, 30));
		pLcMlCon.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 3, 0, 10));

		JLabel lblMlCode = new JLabel("중분류 코드");
		lblMlCode.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblMlCode.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblMlCode);

		tfMlCode = new JTextField();
		tfMlCode.setEnabled(false);
		pCenter.add(tfMlCode);
		tfMlCode.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("");
		pCenter.add(lblNewLabel_4);

		JLabel lblMlName = new JLabel("중분류 이름");
		lblMlName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblMlName.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblMlName);

		tfMlName = new JTextField();
		tfMlName.setColumns(10);
		pCenter.add(tfMlName);

		JLabel label_1 = new JLabel("");
		pCenter.add(label_1);

		JPanel pSouth = new JPanel();
		pSouth.setBackground(Color.WHITE);
		pLcMlCon.add(pSouth, BorderLayout.SOUTH);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pSouth.add(btnCancel);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setPreferredSize(new Dimension(10, 0));
		pSouth.add(lblNewLabel_5);

		btnAdd = new JButton("등록");
		btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pSouth.add(btnAdd);

		JLabel lblNewLabel_1 = new JLabel("");
		pContent.add(lblNewLabel_1);

		JPanel pList = new JPanel();
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));

		pLcMlList = new BookLcAndMlTblPanel();
		pLcMlList.setBackground(Color.WHITE);
		pLcMlList.loadData(service.showListAll());
		pLcMlList.setBorder(new EmptyBorder(20, 20, 20, 20));
		pList.add(pLcMlList, BorderLayout.CENTER);

		setLcList(bookService);
	}

	public void setLcList(BookUiService bookService) {
		this.bookService = bookService;
		setCmbLcList(bookService.showLcList());
		cmbLc.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tfMlCode.setText((service.getMlLastCode((LargeClassification) cmbLc.getSelectedItem()) + 1) + "");
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

	@Override
	public MiddleClassification getItem() {
		LargeClassification lclasNo = (LargeClassification) cmbLc.getSelectedItem();
		int mlsfcNo = Integer.parseInt(tfMlCode.getText().trim());
		String mlsfcName = tfMlName.getText().trim();
		return new MiddleClassification(lclasNo, mlsfcNo, mlsfcName);
	}

	@Override
	public void setItem(MiddleClassification item) {
		cmbLc.setSelectedItem(item.getLclasNo().getLclasNo());
		tfMlCode.setText(item.getMlsfcNo() + "");
		tfMlName.setText(item.getMlsfcName());
	}

	@Override
	public void clearTf() {
		cmbLc.setSelectedIndex(-1);
		tfMlCode.setText("");
		tfMlName.setText("");
	}

	@Override
	public void validCheck() {
		if (cmbLc.getSelectedIndex() == -1 || tfMlCode.equals("") || tfMlName.equals("")) {
			throw new InvalidCheckException();
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLcAdd) {
			btnLcAddActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		clearTf();
		btnAdd.setText("등록");
	}

	protected void btnLcAddActionPerformed(ActionEvent e) {
		lcMgnDlg = new BookLcMgnDialog(lcMgnFrame, "대분류 관리");
		lcMgnDlg.setBounds(100, 100, 300, 500);
		lcMgnDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		lcMgnDlg.setVisible(true);
		
		setCmbLcList(bookService.showLcList());
	}
}
