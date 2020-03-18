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

import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.list.LibrarianTblPanel;
import yi_java3st_3team.ui.service.LibrarianUIService;

@SuppressWarnings("serial")
public class LibrarianAddDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfPassword;
	private JButton btnAdd;
	private JButton btnCancel;
	private LibrarianUIService service;
	private LibrarianTblPanel pLibrarianList;
	private JComboBox<Title> cmbTitle;
	

//	public static void main(String[] args) {
//		try {
//			LibrarianAddDialog dialog = new LibrarianAddDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public LibrarianAddDialog(JFrame frame, String title) {
		super(frame, title, true);
		service = new LibrarianUIService();
		setTitle("사서 등록");
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

		tfPassword = new JTextField();
		contentPanel.add(tfPassword);
		tfPassword.setColumns(10);

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


	private void setService(LibrarianUIService service2) {
		this.service = service;
		setCmbList(service.showTitleList());
	}


	private void setCmbList(List<Title> showTitleList) {
		DefaultComboBoxModel<Title> model = new DefaultComboBoxModel<Title>(new Vector<>(showTitleList));
		cmbTitle.setModel(model);
	}
	
	public void validCheck() {
		if (tfId.getText().contentEquals("") || tfName.getText().contentEquals("")
				|| tfPassword.getText().contentEquals("")) {
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
		
		dispose();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		
		dispose();
	}
	
	public void setItem(Librarian addLib) {
			tfId.setText(addLib.getLbId());
			tfName.setText(addLib.getLbName());
			tfPassword.setText(addLib.getLbPass());
			if(addLib.getTitle().getTitleNo()==0) {
				cmbTitle.setSelectedItem("사서");
			}else {
				cmbTitle.setSelectedIndex(addLib.getTitle().getTitleNo()-1);
			}
	}

}
