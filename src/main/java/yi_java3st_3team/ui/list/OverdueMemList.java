package yi_java3st_3team.ui.list;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import yi_java3st_3team.dto.Lending;

@SuppressWarnings("serial")
public class OverdueMemList extends AbsListPanel<Lending> {

	/**
	 * Create the panel.
	 */
	public OverdueMemList() {

	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(80,170,150,50,150,150,50);
		tableCellAlign(SwingConstants.CENTER, 0,1,2,3,4,5);
	}
	
	@Override
	public void loadData(List<Lending> items) {
		list = items;
		TestTabelModel model = new TestTabelModel(getRows(items), getColNames());
		table.setModel(model);

		setTblWidthAlign();

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"도서코드","도서명","회원ID","이름","대여일","반납예정일","선택"};
	}

	@Override
	protected Object[] toArray(Lending item) {
		return new Object[] {item.getBookCd().getBookCode(),item.getBookCd().getBookName(),item.getMberId().getMberId(),item.getMberId().getMberName(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(item.getLendDate()),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(item.getRturnDueDate()),false};
	}

	@Override
	public void updateRow(Lending item, int updateIdx) {
		
	}
	public class TestTabelModel extends DefaultTableModel {
		public TestTabelModel() {
			super(new String[] {"도서코드", "도서명", "저자/역자", "발행년도", "출판사", "대여일", "반납예정일","선택"},0);
		}
		public TestTabelModel(Object[][] rows, String[] columns) {
			super(rows,columns);
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			Class clazz = String.class;
			switch(columnIndex) {
			case 0:
				clazz = Integer.class;
				break;
			case 6:
				clazz = Boolean.class;
				break;
			}
			return clazz;
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 6;
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			if(aValue instanceof Boolean && column == 6) {
				Vector rowData = (Vector)getDataVector().get(row);
				rowData.set(6, (boolean)aValue);
				fireTableCellUpdated(row, column);
			}
		}	
	}

}
