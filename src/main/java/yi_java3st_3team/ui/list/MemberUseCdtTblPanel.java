package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class MemberUseCdtTblPanel extends JPanel {
	private JTable table;
	private TestTabelModel model;
	private LendingUiService service;
	
	private List<Lending> lists;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private Calendar cal = Calendar.getInstance();

	public MemberUseCdtTblPanel() {
		initialize();
	}

	private void initialize() {
		
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
	
	public void loadDate(List<Lending> list) {
		lists = list;
		
		model = new TestTabelModel();
		
		for (Lending lending : list) {	
			String writer;
			
			if(lending.getBookCd().getTrnslrName() == null || lending.getBookCd().getTrnslrName().length() == 0) {
				writer = lending.getBookCd().getAuthrName().replace("|", ",");
			} else {
				writer = String.format("%s/%s", lending.getBookCd().getAuthrName().replace("|", ","), lending.getBookCd().getTrnslrName().replace("|", ","));
			}
			
			model.addRow(new Object[] {
					
					lending.getBookCd().getBookName().replace("|", ","),
					writer,
					String.format("%tF", lending.getBookCd().getPblicteYear()),
					lending.getBookCd().getPls().getPlsName(),
					new SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate()),
					String.format("%tF", lending.getRturnDueDate()),
					lending.getRturnPsmCdt() > 0 ? "신청완료" : "신청가능",
					false
			});
			
		}
		
		table.setModel(model);
		tableSetWidth(150, 100, 100, 100, 100, 100, 100, 100);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
	}
	
	public void getSelectedItem() {
		
		for(int i=0; i<table.getRowCount(); i++) {
			Boolean checkCdt = (Boolean) table.getValueAt(i, 7);
			
			if(checkCdt && lists.get(i).getRturnPsmCdt() == 0) {
				Date date = lists.get(i).getRturnDueDate();
				int cdt = lists.get(i).getRturnPsmCdt();
				cal.setTime(date);
				cal.add(Calendar.DATE, 10);
				Date rturnDate = cal.getTime();
				System.out.println(rturnDate + " / " + cdt + " / " + lists.get(i).getBookCd().getBookCode()+"/"
						+ lists.get(i).getMberId().getMberId());
//				System.out.println(lists.get(i).getBookCd().getBookCode());
//				Lending lending = new Lending();				
//				lending.setBookCd(new Book(lists.get(i).getBookCd().getBookCode()));
//				lending.setMberId(new Member(lists.get(i).getMberId().getMberId()));
//				lending.setRturnPsmCdt(1);
//				lending.setRturnDueDate(rturnDate);
//				System.out.println(lending.toString());
//				service.modifyLendingByCodeAndMberId(lending);
			}
		}
		
	}
	
	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public class TestTabelModel extends DefaultTableModel {
		public TestTabelModel() {
			super(new String[] { "도서명", "저자/역자", "발행년도", "출판사", "대여일", "반납예정일", "반납연기여부", "선택" }, 0);
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
}
