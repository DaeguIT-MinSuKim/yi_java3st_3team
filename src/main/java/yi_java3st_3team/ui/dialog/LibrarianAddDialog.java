package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.panel.LibrarianSelectUIPanel;
import yi_java3st_3team.ui.panel.list.LibrarianTblPanel;
import yi_java3st_3team.ui.service.LibrarianUIService;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LibrarianAddDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfId;
	private JTextField tfName;
	private JButton btnAdd;
	private JButton btnCancel;
	private LibrarianUIService service;
	private LibrarianTblPanel pLibrarianList;
	private JComboBox<Title> cmbTitle;
	private LibrarianAddDialog addLibrarian;
	private JPasswordField passPW;
	private Title title;
	private Librarian findId;
	private LibrarianSelectUIPanel selectUI;

	public LibrarianAddDialog(JFrame frame, String title) {
		super(frame, title, true);
		setTitle("사서 등록");
		service = new LibrarianUIService();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 10, 15));

		JLabel lblId = new JLabel("사서 ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblId);

		tfId = new JTextField();
		contentPanel.add(tfId);
		tfId.setColumns(10);

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblName);

		tfName = new JTextField();
		contentPanel.add(tfName);
		tfName.setColumns(10);

		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblPassword);

		passPW = new JPasswordField();
		contentPanel.add(passPW);

		JLabel lblTitle = new JLabel("직급");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblTitle);

		cmbTitle = new JComboBox();
		contentPanel.add(cmbTitle);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnAdd = new JButton("등록");
		btnAdd.addActionListener(this);
		btnAdd.setPreferredSize(new Dimension(75, 25));
		btnAdd.setActionCommand("OK");
		buttonPane.add(btnAdd);
		getRootPane().setDefaultButton(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setPreferredSize(new Dimension(75, 25));
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);

		setService(service);

	}

	public void loadData() {
		pLibrarianList.loadData(service.showLibrarianListAll());
	}

	private Librarian getItem() {
		validCheck();
		String lbId = tfId.getText().trim();
		String lbPass = new String(passPW.getPassword());
		String lbName = tfName.getText().trim();
		// Date lbBirthDay = null;
		// ZipCode lbZip = null;
		// String lbBassAd = null;
		// String lbDetailAd = null;
		// String lbTel = null;
		// byte[] lbImg = null;
		Date joinDate = new Date();
		Title titleName = (Title) cmbTitle.getSelectedItem();
		Title title = new Title(titleName.getTitleName().equals("사서") ? 1 : 0);
//		int titleIdx = cmbTitle.getSelectedIndex();
//		if(titleIdx == 0) {
//			title = new Title(0);
//		}
		// Title title = cmbTitle.getSelectedItem();
		int workCdt = 1;

		return new Librarian(lbId, lbPass, lbName, title, joinDate, workCdt);
	}

	public LibrarianSelectUIPanel getSelectUI() {
		return selectUI;
	}

	public void setSelectUI(LibrarianSelectUIPanel selectUI) {
		this.selectUI = selectUI;
	}

	private void setService(LibrarianUIService service) {
		this.service = service;
		setCmbList(service.showTitleList());
	}

	private void setCmbList(List<Title> showTitleList) {
		DefaultComboBoxModel<Title> model = new DefaultComboBoxModel<Title>(new Vector<>(showTitleList));
		cmbTitle.setModel(model);
		cmbTitle.setSelectedIndex(1);
	}

	public void validCheck() {
		if (tfId.getText().contentEquals("") || tfName.getText().contentEquals("")
				|| passPW.getPassword().length == 0) {
			throw new InvalidCheckException();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		String Id = tfId.getText().trim();
		findId = service.IDCheckLibrarian(new Librarian(Id));

		try {
			if (findId != null) {
				JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
				clearTf();
			} else {

				Librarian addLib = getItem();
				service.insertLibrarian(addLib);
				selectUI.loadData();
				JOptionPane.showMessageDialog(null, String.format("[ %s ] 님 사서가입이 완료되었습니다.", addLib.getLbName()));
				setVisible(false);
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		dispose();
	}

	private void clearTf() {
		tfId.setText("");
		tfName.setText("");
		passPW.setText("");
		cmbTitle.setSelectedIndex(1);
	}
}
