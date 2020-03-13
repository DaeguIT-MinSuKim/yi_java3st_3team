package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class MemberUseCdtTblPanel extends JPanel {
//	private static MemberUseCdtTblPanel test = new MemberUseCdtTblPanel();
	private JTable table;
	private LendingUiService service;
	private TestTabelModel model;

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
					lending.getBookCd().getPblicteYear(),
					lending.getBookCd().getPls().getPlsName(),
					new SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate()),
					lending.getRturnDate()==null?"":String.format("%s",new SimpleDateFormat("yyyy-MM-dd").format(lending.getLendDate())),	
					lending.getRturnPsmCdt() > 0 ? "신청완료" : "신청가능",
					false
			});
			
		}
		
		table.setModel(model);
		tableSetWidth(150, 100, 100, 100, 100, 100, 100, 100);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
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
