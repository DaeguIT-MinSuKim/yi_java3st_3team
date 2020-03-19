package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
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
public class ReturnListPanel extends JPanel {
	private static ReturnListPanel test = new ReturnListPanel();
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

	public ReturnListPanel() {
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

		/*
		 * for(Lending lending : list) { model.addRow(new Object[] {
		 * lending.getBookCd().getBookCode(), lending.getBookCd().getBookName(),
		 * lending.getBookCd().getAuthrName(), new
		 * SimpleDateFormat("yyyy-MM-dd").format(lending.getBookCd().getPblicteYear()),
		 * lending.getBookCd().getPls().getPlsName(), new
		 * SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate()),lending.
		 * getRturnDate()==null?"":String.format("%s",new
		 * SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate())),false}); }
		 */
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
				new SimpleDateFormat("yyyy-MM-dd").format(lending.getRturnDueDate()) });
	}

	public void testting2(Member member) {
		List<Lending> list = service.selectLendingByMberId(member);
		
		for(Lending lending : list) { 
			
			model.addRow(new Object[] {
					lending.getBookCd().getBookCode(),
					lending.getBookCd().getBookName(),
					String.format("%s", lending.getBookCd().getAuthrName()+ "/" + lending.getBookCd().getTrnslrName()),
					new SimpleDateFormat("yyyy-MM-dd").format(lending.getBookCd().getPblicteYear()),
					lending.getBookCd().getPls().getPlsName(),
					new SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate()),
					lending.getRturnDueDate()==null?"":String.format("%s",new SimpleDateFormat("yyyy-MM-dd").format(lending.getRturnDueDate()))
					}); 
		}

	}

	public void AllChecking(boolean b) {
		int i = model.getRowCount();
		for(int j= 0; j<i; j++) {
			model.setValueAt(b, j, 7);
		}
	}

	public void setReturn(String mberId) {
		int i = model.getRowCount();
		for(int j =0; j<i; j++) {
			Boolean chk = (Boolean)model.getValueAt(j, 7);
			
			if(chk) {
//				Book book = new Book();
//				book.setBookCode((String)model.getValueAt(j, 0));
				String bookCd = (String)model.getValueAt(j, 0);
				JOptionPane.showMessageDialog(null, bookCd);
				Member m = service.selectedMberId(mberId);
				System.out.println("=================================="+bookCd);
				Book b = service.selectedBookCd(bookCd);
				System.out.println("=================================="+bookCd);
				service.updateLendingList(m, b);
			}
		}
	}



}
