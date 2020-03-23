package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
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

import yi_java3st_3team.dto.RequestBook;
import yi_java3st_3team.ui.service.RequestBookUiService;

@SuppressWarnings("serial")
public class RequestIntoTblPanel extends JPanel {
	private JTable table;
	private TestTabelModel model;
	private RequestBookUiService service;
	
	private List<RequestBook> lists;

	public RequestIntoTblPanel() {
		service = new RequestBookUiService();
		initialize();
	}

	private void initialize() {
		
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
	
	public int getColumnCnt() {
		return table.getColumnCount();
	}
	
	public int getRowCnt() {
		return table.getRowCount();
	}
	
	public String getColumnName(int i) {
		return table.getColumnName(i);
	}
	
	public String getValueAt(int i, int j) {
		return table.getValueAt(i, j)+"";
	}
	
	public void loadData(List<RequestBook> list) {
		lists = list;
		
		model = new TestTabelModel();
		try {
			int no = 1;
			for (RequestBook reqst : list) {	
				String writer;
				if(reqst.getRequestBookTrnslr() == null || reqst.getRequestBookTrnslr().length() == 0) {
					writer = reqst.getRequestBookAuthor();
				} else {
					writer = String.format("%s/%s", reqst.getRequestBookAuthor(), reqst.getRequestBookTrnslr());
				}
				
				model.addRow(new Object[] {
						no++,
						reqst.getRequestBookName(),
						writer,
						reqst.getRequestBookPls(),
						reqst.getOverlapCnt(),
						String.format("%tF", reqst.getRequestDate()),
						reqst.getWhCdt() > 0 ? "입고완료" : "미입고",
						false
				});
				
			}
		} catch (NullPointerException e) {
			
		}
		
		table.setModel(model);
		tableSetWidth(30, 200, 100, 100, 100, 100, 80, 30);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
	}
	
	public void totlaChk() {
		for(int i=0; i<table.getRowCount(); i++) {			
			table.setValueAt((boolean) true , i, 7);
		}
	}
	
	public void totlaUnChk() {
		for(int i=0; i<table.getRowCount(); i++) {			
			table.setValueAt((boolean) false , i, 7);
		}
	}
	
	public void getSelectedItem() {
		try {
			for(int i=0; i<table.getRowCount(); i++) {
				Boolean checkCdt = (Boolean) table.getValueAt(i, 7);
				
				if(checkCdt) {
					if (lists.get(i).getWhCdt() == 0) {										
						RequestBook reqst = new RequestBook();
						reqst.setRequestBookName(lists.get(i).getRequestBookName());
						reqst.setRequestBookPls(lists.get(i).getRequestBookPls());
						reqst.setWhCdt(1);
						service.modifyRequestBook(reqst);
					} else if( lists.get(i).getWhCdt() > 0){
						JOptionPane.showMessageDialog(null, "입고완료된 도서가 선택되었습니다.");
					}
				} 
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "선택된 정보가 없습니다");
		}
	}
	
	public void getCancleItem() {
		try {
			for(int i=0; i<table.getRowCount(); i++) {
				Boolean checkCdt = (Boolean) table.getValueAt(i, 7);
				
				if(checkCdt) {
					if (lists.get(i).getWhCdt() == 1) {										
						RequestBook reqst = new RequestBook();
						reqst.setRequestBookName(lists.get(i).getRequestBookName());
						reqst.setRequestBookPls(lists.get(i).getRequestBookPls());
						reqst.setWhCdt(0);
						service.modifyRequestBook(reqst);
					} else if( lists.get(i).getWhCdt() == 0){
						JOptionPane.showMessageDialog(null, "미입고 도서가 선택되었습니다.");
					}
				} 
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "선택된 정보가 없습니다");
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
			super(new String[] { "no", "신청도서명", "저자/역자", "출판사", "신청회원수", "신청일자", "입고여부", "선택" }, 0);
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
