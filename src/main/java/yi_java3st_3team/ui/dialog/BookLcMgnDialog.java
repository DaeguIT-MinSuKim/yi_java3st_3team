package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.list.BookLcTblPanel;
import yi_java3st_3team.ui.service.LargeClassificationUiService;

@SuppressWarnings("serial")
public class BookLcMgnDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCode;
	private JTextField tfName;
	private JButton cancelButton;
	private BookLcTblPanel pLcList;

	private LargeClassificationUiService service;
	private JButton okButton;

	public BookLcMgnDialog(JFrame frame, String title) {
		super(frame, title, true);
		service = new LargeClassificationUiService();
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pLc = new JPanel();
			pLc.setBorder(new EmptyBorder(10, 20, 10, 20));
			contentPanel.add(pLc, BorderLayout.CENTER);
			pLc.setLayout(new GridLayout(0, 2, 10, 10));
			{
				JLabel lblCode = new JLabel("대분류 코드");
				lblCode.setHorizontalAlignment(SwingConstants.CENTER);
				pLc.add(lblCode);
			}
			{
				tfCode = new JTextField();
				tfCode.setEnabled(false);
				pLc.add(tfCode);
				tfCode.setColumns(10);
				tfCode.setText((service.getLcLastCode() + 1) + "");
			}
			{
				JLabel lblName = new JLabel("대분류 이름");
				lblName.setHorizontalAlignment(SwingConstants.CENTER);
				pLc.add(lblName);
			}
			{
				tfName = new JTextField();
				tfName.setColumns(10);
				pLc.add(tfName);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("추가");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("취소");
				cancelButton.addActionListener(this);
				{
					btnModify = new JButton("수정");
					btnModify.setEnabled(false);
					btnModify.addActionListener(this);
					buttonPane.add(btnModify);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel pList = new JPanel();
			pList.setBorder(new EmptyBorder(5, 10, 10, 10));
			getContentPane().add(pList);
			pList.setLayout(new BorderLayout(0, 0));
			{
				pLcList = new BookLcTblPanel();
				pLcList.loadData(service.showLcListAll());
				pLcList.setPopupMenu(createPopupMenu());
				pList.add(pLcList, BorderLayout.CENTER);
			}
		}
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);

		return popMenu;
	}

	ActionListener myPopMenuListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getActionCommand().contentEquals("수정")) {
					LargeClassification updateLc = pLcList.getSelectedItem();
					setItem(updateLc);
					btnModify.setEnabled(true);
					okButton.setEnabled(false);
				}

				if (e.getActionCommand().contentEquals("삭제")) {
					LargeClassification deleteLc = pLcList.getSelectedItem();

					int result = JOptionPane.showConfirmDialog(null, "선택된 대분류 데이터를 삭제하겠습니까?", "삭제확인",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.CLOSED_OPTION) {
					} else if (result == JOptionPane.YES_OPTION) {
						service.removeLc(deleteLc);
						pLcList.loadData(service.showLcListAll());
						clearTf();
						JOptionPane.showMessageDialog(null, "삭제되었습니다");
					} else {
					}

				}
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};
	private JButton btnModify;

	public void setItem(LargeClassification item) {
		tfCode.setText(item.getLclasNo() + "");
		tfName.setText(item.getLclasName());
	}

	public void clearTf() {
		tfCode.setText((service.getLcLastCode() + 1) + "");
		tfName.setText("");
	}

	public LargeClassification getItem() {
		validCheck();
		int lclasNo = Integer.parseInt(tfCode.getText().trim());
		String lclasName = tfName.getText();
		return new LargeClassification(lclasNo, lclasName);
	}

	private void validCheck() {
		if (tfName.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModify) {
			btnModifyActionPerformed(e);
		}
		if (e.getSource() == okButton) {
			okButtonActionPerformed(e);
		}
		if (e.getSource() == cancelButton) {
			cancelButtonActionPerformed(e);
		}
	}

	protected void cancelButtonActionPerformed(ActionEvent e) {
		clearTf();
		btnModify.setEnabled(false);
		okButton.setEnabled(true);
	}

	protected void okButtonActionPerformed(ActionEvent e) {
		try {
			LargeClassification newlc = getItem();
			service.addLc(newlc);
			pLcList.loadData(service.showLcListAll());
			clearTf();
			JOptionPane.showMessageDialog(null, "추가되었습니다");
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			SQLException e2 = (SQLException) e1;
			if (e2.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "코드 중복");
				System.err.println(e2.getMessage());
				return;
			}
			e1.printStackTrace();
		}
	}

	protected void btnModifyActionPerformed(ActionEvent e) {
		try {
			LargeClassification updateLc = getItem();
			service.modifyLc(updateLc);
			pLcList.loadData(service.showLcListAll());
			clearTf();
			JOptionPane.showMessageDialog(null, "수정되었습니다");
			btnModify.setEnabled(false);
			okButton.setEnabled(true);
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
}
