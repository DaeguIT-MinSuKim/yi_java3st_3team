package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.ui.LendingPanel3;
import yi_java3st_3team.ui.list.MemberListDialog.TestTabelModel;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberListDialog2 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private static MemberListDialog2 test = new MemberListDialog2();
	private JTable table;
	private MemberUIService service;
	private TestTabelModel model;
	private JTextField tfMember;
	private LendingPanel3 lendings;
	private JPanel pSearch;
	private JRadioButton rdbtnCode;
	private JRadioButton rdbtnName;
	private JButton btnMember;
	private JPanel pMemberList;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	public static void main(String[] args) {
		try {
			MemberListDialog2 dialog = new MemberListDialog2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberListDialog2() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			pSearch = new JPanel();
			contentPanel.add(pSearch, BorderLayout.NORTH);
			pSearch.setLayout(new GridLayout(0, 4, 0, 0));
			{
				rdbtnCode = new JRadioButton("회원ID");
				pSearch.add(rdbtnCode);
			}
			{
				rdbtnName = new JRadioButton("회원명");
				pSearch.add(rdbtnName);
			}
			{
				tfMember = new JTextField();
				pSearch.add(tfMember);
				tfMember.setColumns(10);
			}
			{
				btnMember = new JButton("검색");
				pSearch.add(btnMember);
			}
		}
		{
			pMemberList = new JPanel();
			
			contentPanel.add(pMemberList, BorderLayout.CENTER);
			{
				memberTbl = new JTable();
//				memberTbl.
				
				pMemberList.add(memberTbl);
			}
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
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
				
				}

				if (e.getActionCommand().contentEquals("삭제")) {
					

					int result = JOptionPane.showConfirmDialog(null, "선택된 대분류 데이터를 삭제하겠습니까?", "삭제확인",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.CLOSED_OPTION) {
					} else if (result == JOptionPane.YES_OPTION) {
						
						JOptionPane.showMessageDialog(null, "삭제되었습니다");
					} else {
					}

				}
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};
	private JTable memberTbl;

}
