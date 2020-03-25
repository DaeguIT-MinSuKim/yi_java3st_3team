package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class RentListPanel extends JPanel {
	private static RentListPanel test = new RentListPanel();
	private JTable table;
	private LendingUiService service;
	private TestTabelModel model;

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

	public RentListPanel() {
		initialize();
	}

	public TestTabelModel getModel() {
		return model;
	}

	public void setModel(TestTabelModel model) {
		this.model = model;
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
			} else {
				Vector rowData = (Vector) getDataVector().get(row);
				rowData.setElementAt(aValue, 7);
				fireTableCellUpdated(row, column);
			}
		}
	}

	public void search(Book book) {
		try {
			int cnt = model.getRowCount();
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +15);
			StringBuilder sb = new StringBuilder();
			if (book.getTrnslrName().equals("")) {
				sb.append(book.getAuthrName());
			} else {
				sb.append(book.getAuthrName() + "/" + book.getTrnslrName());
			}
			for (int i = 0; i < cnt; i++) {
				if ((boolean) model.getValueAt(i, 0).equals(book.getBookCode())) {

					JOptionPane.showMessageDialog(null, "이미 추가한 책입니다.");
					model.removeRow(i);
					break;
				}
			}
			model.addRow(new Object[] { book.getBookCode(), book.getBookName(), sb,
					new SimpleDateFormat("yyyy-MM-dd").format(book.getPblicteYear()), book.getPls().getPlsName(),
					new SimpleDateFormat("yyyy-MM-dd").format(now),
					new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) });

		} catch (NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "입력하지 않으셨거나 잘못입력하셨습니다. 다시 입력해주세요.");
		}
	}

	public void search2(List<Book> bookList, int res) {
		try {
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +15);
			for (Book book : bookList) {
				if (model.getRowCount() >= res) {
					return;
				}
				StringBuilder sb = new StringBuilder();
				if (book.getTrnslrName().equals("")) {
					sb.append(book.getAuthrName());
				} else {
					sb.append(book.getAuthrName() + "/" + book.getTrnslrName());
				}
				model.addRow(new Object[] { book.getBookCode(), book.getBookName(), sb,
						new SimpleDateFormat("yyyy-MM-dd").format(book.getPblicteYear()), book.getPls().getPlsName(),
						new SimpleDateFormat("yyyy-MM-dd").format(now),
						new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) });
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "입력하지 않으셨거나 잘못입력하셨습니다. 다시 입력해주세요.");
		}
	}

	public void checkingAll(boolean b) {
		int i = model.getRowCount();
		for (int j = 0; j < i; j++) {
			model.setValueAt(b, j, 7);
		}
	}

	public void setRent(String mberId) {
		ArrayList<String> list = new ArrayList<String>();
		int cnt = table.getRowCount();
		for (int i = 0; i < cnt; i++) {
			boolean chk = (Boolean) model.getValueAt(i, 7);
			if (chk == true) {
				String bookCd = (String) model.getValueAt(i, 0);
				Member member = service.selectedMberId(mberId);
				Book book = service.selectedBookCd(bookCd);
				service.insertSelectedLendingList(member, book);
				list.add(book.getBookName());
			}
		}
		for (int i = cnt - 1; i > -1; i--) {
			boolean chk = (Boolean) model.getValueAt(i, 7);
			if (chk) {
				model.removeRow(i);
			}
		}
		JOptionPane.showMessageDialog(null, list.toString() + " 대여 되었습니다.");
	}

	Class<?> getColumnClass() {
		Class clazz = String.class;
		return clazz;
	}

	public int checkingRow_Cnt() {
		int i = model.getRowCount();
		int c = 0;
		for (int j = 0; j < i; j++) {
			if ((Boolean) model.getValueAt(j, 7) == true) {
				c++;
			}
		}
		return c;
	}
	public void clearTf() {
		table.removeAll();
		int cnt = model.getRowCount();
		for (int i = cnt - 1; i > -1; i--) {
				model.removeRow(i);
		}
	}
}
