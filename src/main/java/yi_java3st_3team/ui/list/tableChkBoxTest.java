package yi_java3st_3team.ui.list;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class tableChkBoxTest extends JPanel {
	private static tableChkBoxTest test = new tableChkBoxTest();
	private JTable table;
	private LendingUiService service;
	/**
	 * Create the panel.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setLayout(new BorderLayout());
					frame.setBounds(0, 0, 900, 400);
					frame.add(test,BorderLayout.CENTER);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public tableChkBoxTest() {
		initialize();
	}
	private void initialize() {
		service = new LendingUiService();
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		TestTabelModel model = new TestTabelModel();
		List<Lending> list = service.selectLendingByAllTest();
		
		for(Lending lending : list) {
			model.addRow(new Object[] {lending.getBookCd().getBookCode(),lending.getBookCd().getBookName(),lending.getBookCd().getAuthrName(),lending.getBookCd().getPblicteYear(),lending.getBookCd().getPls().getPlsName(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lending.getLendDate()),lending.getRturnDate()==null?"":String.format("%s",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lending.getLendDate())),false});
		}
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}
	public class TestTabelModel extends DefaultTableModel {
		public TestTabelModel() {
			super(new String[] {"도서코드", "도서명", "저자/역자", "발행년도", "출판사", "대여일", "반납예정일","선택"},0);
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			Class clazz = String.class;
			switch(columnIndex) {
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
			if(aValue instanceof Boolean && column == 7) {
				Vector rowData = (Vector)getDataVector().get(row);
				rowData.set(7, (boolean)aValue);
				fireTableCellUpdated(row, column);
			}
		}	
	}
}
