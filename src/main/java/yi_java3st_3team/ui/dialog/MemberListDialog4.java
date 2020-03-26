package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.panel.MemberReturnPanel;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberListDialog4 extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private MemberReturnPanel lending3;
	private JTable table;
	private MemberUIService service;
	private TestTabelModel model;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	public MemberListDialog4(JFrame jFrame, String string, boolean b, Member id) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		initialize(id);
	}

	public MemberReturnPanel getReturnPanel() {
		return lending3;
	}

	public void setReturnPanel(MemberReturnPanel returnPanel) {
		this.lending3 = returnPanel;
	}

	private void initialize(Member name) {
		service = new MemberUIService();
		getContentPane().setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		model = new TestTabelModel();
		List<Member> list = service.showLendingMemberId3(name);

		for (Member mem : list) {
			StringBuilder overdueCdt = new StringBuilder();

			if (mem.getLendPsbCdt() == 0) {
				overdueCdt.append("정상");
			}
			if (mem.getLendPsbCdt() == 1) {
				overdueCdt.append("연체");
			}
			model.addRow(new Object[] { mem.getMberId(), mem.getMberName(), mem.getGrade().getGradeName(), overdueCdt,
					mem.getOdCnt() });
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
			super(new String[] { "회원ID", "회원이름", "회원등급", "연체여부", "연체횟수" }, 0);
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
		lending3.getpMember().getTfMberId().setText((String) table.getValueAt(row, 0));
		lending3.getpMember().getTfMberName().setText((String) table.getValueAt(row, 1));
		lending3.getpMember().getTfGrade().setText((String) table.getValueAt(row, 2));
		lending3.getpMember().getTfOverdueCdt().setText(table.getValueAt(row, 3).toString());
		int odCdt = (int) table.getValueAt(row, 4);
		lending3.getpMember().getTfOdCnt().setText(odCdt + "");
		Member id = new Member((String) table.getValueAt(row, 0));
		lending3.returnBookList(id);
		dispose();
	}

}