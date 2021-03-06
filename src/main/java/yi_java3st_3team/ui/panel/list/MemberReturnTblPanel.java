package yi_java3st_3team.ui.panel.list;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class MemberReturnTblPanel extends JPanel {
	private static MemberReturnTblPanel test = new MemberReturnTblPanel();
	private JTable table;
	private LendingUiService service;
	private TestTabelModel model;
	private int returnIdx;
	private int returnGetIdx;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setLayout(new BorderLayout());
					frame.setBounds(0, 0, 900, 400);
					frame.add(test, BorderLayout.CENTER);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberReturnTblPanel() {
		initialize();
	}

	private void initialize() {
		service = new LendingUiService();
		setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		model = new TestTabelModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}

	public int getReturnGetIdx() {
		return returnGetIdx;
	}

	public void setReturnGetIdx(int returnGetIdx) {
		this.returnGetIdx = returnGetIdx;
	}

	public class TestTabelModel extends DefaultTableModel {
		public TestTabelModel() {
			super(new String[] { "도서코드", "도서명", "저자/역자", "발행년도", "출판사", "대여일", "반납예정일", "선택" }, 0);
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			Class clazz = String.class;
			switch (columnIndex) {
			case 0:
				clazz = Integer.class;
				break;
			case 7:
				clazz = Boolean.class;
				break;
			}
			return clazz;
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 7;
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			if (aValue instanceof Boolean && column == 7) {
				Vector rowData = (Vector) getDataVector().get(row);
				rowData.set(7, (boolean) aValue);
				fireTableCellUpdated(row, column);
			}
		}
	}

	public void testting(Lending lending) {
		model.addRow(new Object[] { lending.getBookCd().getBookCode(), lending.getBookCd().getBookName(),
				String.format("%s", lending.getBookCd().getAuthrName() + "/" + lending.getBookCd().getTrnslrName()),
				new SimpleDateFormat("yyyy-MM-dd").format(lending.getBookCd().getPblicteYear()),
				lending.getBookCd().getPls().getPlsName(),
				new SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate()),
				new SimpleDateFormat("yyyy-MM-dd").format(lending.getRturnDueDate()),false });
	}

	public void testting2(Member member) {
		List<Lending> list = service.selectLendingByMberId(member);
		if (list == null) {
			JOptionPane.showMessageDialog(null, "반납할 도서가 없습니다.");
			return;
		}
		for (Lending lending : list) {
			StringBuilder sb = new StringBuilder();
			if (lending.getBookCd().getTrnslrName() == null) {
				sb.append(lending.getBookCd().getAuthrName());
			} else {
				sb.append(lending.getBookCd().getAuthrName());
				sb.append("/");
				sb.append(lending.getBookCd().getTrnslrName());
			}
			model.addRow(new Object[] { lending.getBookCd().getBookCode(), lending.getBookCd().getBookName(), sb,
					new SimpleDateFormat("yyyy-MM-dd").format(lending.getBookCd().getPblicteYear()),
					lending.getBookCd().getPls().getPlsName(),
					new SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate()),
					lending.getRturnDueDate() == null ? ""
							: String.format("%s",
									new SimpleDateFormat("yyyy-MM-dd").format(lending.getRturnDueDate())),true });
		}
	}

	public void AllChecking(boolean b) {
		int i = model.getRowCount();
		for (int j = 0; j < i; j++) {
			model.setValueAt(b, j, 7);
		}
	}

	public void setReturn(String mberId) {
		ArrayList<String> list = new ArrayList<String>();
		int cnt = model.getRowCount();
		for (int i = 0; i < cnt; i++) {
//			boolean chk = (Boolean) model.getValueAt(i, 7);
//			System.out.println("1=============================" + model.getValueAt(i, 7));
//			boolean chk = model.getValueAt(i, 7) == null ? false : true;
			boolean chk = (Boolean)model.getValueAt(i, 7);
//			System.out.println("2=============================" + model.getValueAt(i, 7));
			if (chk) {
				String bookCd = (String) model.getValueAt(i, 0);
				Member member = service.selectedMberId(mberId);
				Book book = service.selectedBookCd(bookCd);
				service.updateLendingList(member, book);
				list.add(book.getBookName());
			}
		}
		for (int i = cnt - 1; i > -1; i--) {
			boolean chk = (Boolean) model.getValueAt(i, 7);
//			boolean chk = model.getValueAt(i, 7) == null ? false : true;
			if (chk) {
				model.removeRow(i);
			}
		}
		JOptionPane.showMessageDialog(null, list.toString() + " 반납 되었습니다.");
	}

	public void clearTf() {
		table.removeAll();
		int cnt = model.getRowCount();
		for (int i = cnt - 1; i > -1; i--) {
			model.removeRow(i);
		}
	}

}
