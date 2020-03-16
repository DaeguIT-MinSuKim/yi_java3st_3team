package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
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
		service = new LendingUiService();
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
		try {
			for (Lending lending : list) {	
				String writer;
				
				if(lending.getBookCd().getTrnslrName() == null || lending.getBookCd().getTrnslrName().length() == 0) {
					writer = lending.getBookCd().getAuthrName().replace("|", ",");
				} else {
					writer = String.format("%s/%s", lending.getBookCd().getAuthrName().replace("|", ","), lending.getBookCd().getTrnslrName().replace("|", ","));
				}
				
				model.addRow(new Object[] {
						lending.getBookCd().getBookCode(),
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
		} catch (NullPointerException e) {
			model.addRow(new Object[] {
					"", "", "", "", "", "", "", ""
			});
		}
		
		table.setModel(model);
		tableSetWidth(150, 100, 100, 100, 100, 100, 100, 100, 100);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
	}
	
	public void getSelectedItem() {
		
		for(int i=0; i<table.getRowCount(); i++) {
			Boolean checkCdt = (Boolean) table.getValueAt(i, 8);
			
			if(checkCdt) {
				if (lists.get(i).getRturnPsmCdt() == 0) {					
					Date date = lists.get(i).getRturnDueDate();
					int cdt = lists.get(i).getRturnPsmCdt();
					cal.setTime(date);
					cal.add(Calendar.DATE, 10);
					Date rturnDate = cal.getTime();
					System.out.println(rturnDate + " / " + cdt + " / " + lists.get(i).getBookCd().getBookCode()+"/"
							+ lists.get(i).getMberId().getMberId());
					
					
					Lending lending = new Lending();				
					lending.setBookCd(new Book(lists.get(i).getBookCd().getBookCode()));
					lending.setMberId(new Member(lists.get(i).getMberId().getMberId()));
					lending.setRturnPsmCdt(1);
					lending.setRturnDueDate(rturnDate);
					service.modifyLendingByCodeAndMberId(lending);
				} else if( lists.get(i).getRturnPsmCdt() > 0){
					JOptionPane.showMessageDialog(null, "이미 반납신청 되었습니다.\n(반납연기신청은 1회만 가능합니다.)");
				}
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
			super(new String[] { "도서코드", "도서명", "저자/역자", "발행년도", "출판사", "대여일", "반납예정일", "반납연기여부", "선택" }, 0);
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			Class clazz = String.class;
			switch (columnIndex) {
			case 0:
				clazz = Integer.class;
				break;
			case 8:
				clazz = Boolean.class;
				break;
			}
			return clazz;
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 8;
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			if (aValue instanceof Boolean && column == 8) {
				Vector rowData = (Vector) getDataVector().get(row);
				rowData.set(8, (boolean) aValue);
				fireTableCellUpdated(row, column);
			}
		}
	}
}
