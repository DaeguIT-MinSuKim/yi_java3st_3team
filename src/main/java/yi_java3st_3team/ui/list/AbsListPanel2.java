package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public abstract class AbsListPanel2<T> extends JPanel {
	private JScrollPane scrollPane;
	protected JTable table;
	protected NotEditableModel model;
	protected List<T> list;

	public AbsListPanel2() {
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);
	}
	
	public JTable getTable() {
		return table;
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}

	public void loadData(List<T> items) {
		list = items;
		try {
			model = new NotEditableModel(getRows(items), getColNames());
		} catch (NullPointerException e) {
			model = new NotEditableModel(null, getColNames());
		}
		table.setModel(model);

		setTblWidthAlign();

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
	}

	protected abstract void setTblWidthAlign();

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

	protected abstract String[] getColNames();

	protected Object[][] getRows(List<T> items) {
		Object[][] rows = new Object[items.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(items.get(i));
		}
		return rows;
	}

	protected abstract Object[] toArray(T item);

	public void removeRow() {
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}

	public abstract void updateRow(T item, int updateIdx);

	public void addItem(T item) {
		model.addRow(toArray(item));
	}

	public int getSelectedRowIdx() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1) {
			throw new RuntimeException("원하는 정보의 리스트를 선택해주세요.");
		}
		return selectedIdx;
	}

	public T getSelectedItem() {
		int selectedIdx = getSelectedRowIdx();
		return list.get(selectedIdx);
	};

	protected class NotEditableModel extends DefaultTableModel {

		public NotEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

	public void clearSelection() {
		table.clearSelection();
	}

}
