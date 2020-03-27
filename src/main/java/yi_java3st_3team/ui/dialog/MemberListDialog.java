package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.panel.MemberRentPanel;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberListDialog extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private MemberRentPanel lending3;
	private JTable table;
	private MemberUIService service;
	private TestTabelModel model;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	public MemberListDialog(JFrame jFrame, String string, boolean b, Member id) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		initialize(id);
	}

	public MemberRentPanel getLending3() {
		return lending3;
	}

	public void setLending3(MemberRentPanel lending3) {
		this.lending3 = lending3;
	}

	private void initialize(Member id) {
		service = new MemberUIService();
		getContentPane().setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		model = new TestTabelModel();
		List<Member> list = service.showLendingMemberId2(id);
		for (Member mem : list) {
			StringBuilder lendCdt = new StringBuilder();
			if (mem.getWdrCdt() == 0) {
				if(mem.getLendPsbCdt() ==1) {
					return;
				}
				if (mem.getLendPsbCdt() == 1) {
					lendCdt.append("불가능");
				}
				if (mem.getLendPsbCdt() == 0) {
					lendCdt.append("가능");
				}
				int LendBookCnt = mem.getLendBookCnt();
				int BookLeCnt = mem.getGrade().getBookLeCnt();
				int res = BookLeCnt - LendBookCnt;
				model.addRow(new Object[] { mem.getMberId(), mem.getMberName(), mem.getGrade().getGradeName(), lendCdt,
						res });
			}
		}
		table = new JTable(model);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		scrollPane.setViewportView(table);
	}

	public class TestTabelModel extends DefaultTableModel {
		public TestTabelModel() {
			super(new String[] { "회원ID", "회원이름", "회원등급", "대여가능여부", "대여가능권수" }, 0);
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			Class clazz = String.class;
			return clazz;
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			do_okButton_actionPerformed(e);
		}
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
	}

	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		dispose();
	}

	protected void do_okButton_actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (table.getValueAt(row, 3).toString().equals("불가능")) {
			JOptionPane.showMessageDialog(null, "대여불가능하십니다.");
			return;
		}
		if((Integer)table.getValueAt(row, 4) == 0) {
			JOptionPane.showMessageDialog(null, "대여 가능한 권 수를 초과 하였습니다.");
			return;
		}
		lending3.getpMember().getTfMberId().setText((String) table.getValueAt(row, 0));
		lending3.getpMember().getTfMberName().setText((String) table.getValueAt(row, 1));
		lending3.getpMember().getTfGrade().setText((String) table.getValueAt(row, 2));
		lending3.getpMember().getTfLendPsbCdt().setText(table.getValueAt(row, 3).toString());
		int res = (int) table.getValueAt(row, 4);
		lending3.getpMember().getTfLendBookCdt().setText(res + "");
		dispose();
	}
}