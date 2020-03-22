package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import javafx.beans.binding.StringBinding;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
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
			}
			else {
				Vector rowData = (Vector)getDataVector().get(row);
				rowData.setElementAt(aValue, 7);
				fireTableCellUpdated(row, column);
			}
		}
	}

	public void search(Book book) {
		try {
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +15);
			model.addRow(new Object[] { book.getBookCode(), book.getBookName(),
					String.format("%s", book.getAuthrName() + "/" + book.getTrnslrName()),
					new SimpleDateFormat("yyyy-MM-dd").format(book.getPblicteYear()), book.getPls().getPlsName(),
					new SimpleDateFormat("yyyy-MM-dd").format(now),
					new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())});		
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
			for(Book book : bookList) {
				if(model.getRowCount() >= res) {
					return;
				}
				StringBuilder sb = new StringBuilder();
				if(book.getTrnslrName().equals("")) {
					sb.append(book.getAuthrName());
				}
				else {
					sb.append(book.getAuthrName()+"/"+book.getTrnslrName());
				}
				model.addRow(new Object[] { book.getBookCode(), book.getBookName(),
//						String.format("%s", book.getAuthrName() + "/" + book.getTrnslrName()),
						sb,
						new SimpleDateFormat("yyyy-MM-dd").format(book.getPblicteYear()), book.getPls().getPlsName(),
						new SimpleDateFormat("yyyy-MM-dd").format(now),
						new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())});
				JOptionPane.showMessageDialog(null, model.getRowCount());
			}	
		} catch (NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "입력하지 않으셨거나 잘못입력하셨습니다. 다시 입력해주세요.");
		}
	}
	public void AllChecking(boolean b) {
		int i = model.getRowCount();
		for(int j= 0; j<i; j++) {
			model.setValueAt(b, j, 7);
		}
	}

	public void setRent(String mberId) {
		int[] selIdx = table.getSelectedRows();
		for(int idx : selIdx) {
			boolean chk = (Boolean)model.getValueAt(idx, 7);
			if(chk) {
				String bookCd = (String)model.getValueAt(idx, 0);
				Member m = service.selectedMberId(mberId);
				Book b = service.selectedBookCd(bookCd);
				TableColumnModel colModel = table.getColumnModel();
				colModel.getColumn(7).setCellRenderer(new DefaultTableCellRenderer());
				colModel.getColumn(7).getCellRenderer().getTableCellRendererComponent(table,"대여완료", false, false, idx, 7);
				model.setValueAt("대여완료", idx, 7);
				
//				service.insertSelectedLendingList(m, b);
			}
		}
		
		/*
		 * int i = model.getRowCount(); for(int j =0; j<i; j++) {
		 * JOptionPane.showMessageDialog(null, model.getValueAt(j, 7));
		 * JOptionPane.showMessageDialog(null, message); boolean chk =
		 * (Boolean)model.getValueAt(j, 7); JOptionPane.showMessageDialog(null, chk);
		 * if(chk) { String bookCd = (String)model.getValueAt(j, 0); Member m =
		 * service.selectedMberId(mberId); Book b = service.selectedBookCd(bookCd);
		 * if(model.getColumnClass(7) == Boolean.class) {
		 * if((Boolean)model.getValueAt(j, 7) == true) { model.setValueAt2(true, j, 7);
		 * } } service.insertSelectedLendingList(m, b); } }
		 */
	}
	Class<?> getColumnClass() {
		Class clazz = String.class;
		return clazz;
	}
	public int checkingRow_Cnt() {
		int i = model.getRowCount();
		int c = 0;
		for(int j=0; j<i; j++) {
			if((Boolean)model.getValueAt(j, 7) == true) {
				c++;
			}
		}
		return c;
	}

	public void checkingRow_Cnt(int res) {
		
	}


}
