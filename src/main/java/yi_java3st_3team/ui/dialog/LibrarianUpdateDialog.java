package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.ui.LibrarianSelectUIPanel;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.list.LibrarianTblPanel;
import yi_java3st_3team.ui.service.LibrarianUIService;

@SuppressWarnings("serial")
public class LibrarianUpdateDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfId;
	private JTextField tfName;
	private JButton btnUpdate;
	private JButton btnCancel;
	private LibrarianUIService service;
	private LibrarianTblPanel pLibrarianList;
	private JComboBox<Title> cmbTitle;
	private JComboBox<Librarian> cmbWork;
	private LibrarianSelectUIPanel selectUI;
	private Librarian lib;

//	public static void main(String[] args) {
//		try {
//			LibrarianUpdateDialog dialog = new LibrarianUpdateDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public LibrarianUpdateDialog(JFrame frame, String title) {
		super(frame, title, true);
		service = new LibrarianUIService();
		lib = new Librarian();
		setTitle("정보 수정");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 10, 15));

		JLabel lblId = new JLabel("사서 ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblId);

		tfId = new JTextField();
		tfId.setEditable(false);
		contentPanel.add(tfId);
		tfId.setColumns(10);

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblName);

		tfName = new JTextField();
		contentPanel.add(tfName);
		tfName.setColumns(10);

		JLabel lblTitle = new JLabel("직급");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblTitle);

		cmbTitle = new JComboBox();
		contentPanel.add(cmbTitle);

		JLabel lblWork = new JLabel("근무여부");
		lblWork.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblWork);

		cmbWork = new JComboBox();
		contentPanel.add(cmbWork);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		btnUpdate.setPreferredSize(new Dimension(75, 25));
		btnUpdate.setActionCommand("OK");
		buttonPane.add(btnUpdate);
		getRootPane().setDefaultButton(btnUpdate);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setPreferredSize(new Dimension(75, 25));
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
		
		setService(service);
	}


	private void setService(LibrarianUIService service) {
		this.service = service;
		setCmbTitleList(service.showTitleList());
		setCmbWorkList(service.showWorkList(lib));
	}


	public LibrarianSelectUIPanel getSelectUI() {
		return selectUI;
	}


	public void setSelectUI(LibrarianSelectUIPanel selectUI) {
		this.selectUI = selectUI;
	}


	private void setCmbTitleList(List<Title> titleList) {
		DefaultComboBoxModel<Title> model = new DefaultComboBoxModel<Title>(new Vector<>(titleList));
		cmbTitle.setModel(model);
	}
	
	private void setCmbWorkList(List<Librarian> showWorkList) {
		DefaultComboBoxModel<Librarian> model = new DefaultComboBoxModel<Librarian>(new Vector<>(showWorkList));
		cmbWork.setModel(model);
	}
	
	public void validCheck() {
		if (tfId.getText().contentEquals("") || tfName.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnUpdate) {
			btnUpdateActionPerformed(e);
		}
	}

	protected void btnUpdateActionPerformed(ActionEvent e) {
		
		
		 selectUI.loadData();
		dispose();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		
		dispose();
	}


	public void setItem(Librarian item) {
		tfId.setText(item.getLbId());
		tfName.setText(item.getLbName());
		if(item.getTitle().getTitleNo() ==0) {
			cmbTitle.setSelectedItem("총관리자");
		}else {
			cmbTitle.setSelectedIndex(item.getTitle().getTitleNo());
		}
		if(item.getWorkCdt()==0) {
			cmbWork.setSelectedItem("퇴직");
		}else {
			cmbWork.setSelectedIndex(item.getWorkCdt());
		}
	}
}
