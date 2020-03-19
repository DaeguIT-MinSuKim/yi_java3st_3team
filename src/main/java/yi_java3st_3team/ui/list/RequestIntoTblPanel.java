package yi_java3st_3team.ui.list;

import java.awt.BorderLayout;
import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
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

import jxl.Workbook;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.RequestBook;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class RequestIntoTblPanel extends JPanel {
	private JTable table;
	private TestTabelModel model;
	private LendingUiService service;
	
	private List<RequestBook> lists;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private Calendar cal = Calendar.getInstance();

	public RequestIntoTblPanel() {
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
	
//	public void excelEvent() {
//		String filePath = System.getProperty("user.dir")+"\\data.xls\\";
//		String SheetName = "bookList";
//		String[][] data = new String[][];
//		
//		String[] getColumn = new String[table.getColumnCount()];
//		for(int i=0; i<table.getColumnCount(); i++) { // 컬럼명 받기
//			getColumn[i] = table.getColumnName(i);
//		}
//		
//		String[][] getData = new String[table.getRowCount()][table.getColumnCount()]; // 데이터 받기
//		for(int i=0; i<table.getRowCount(); i++) {
//			for(int j=0; j<table.getColumnCount(); j++) {
//				getData[i][j] = (String) table.getValueAt(i, j);
//			}
//		}
//		
//		try {
//			WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath)); //파일경로 설정
//			WritableSheet sheet = workbook.createSheet(SheetName, 0); //시트이름과 몇번째 시트인덱스
//			jxl.write.WritableCellFormat format_column = new WritableCellFormat(); //컬럼 포멧. 스트링
//			jxl.write.WritableCellFormat format_data = new WritableCellFormat(); //데이터 포멧. 스트링
//			jxl.write.WritableCellFormat format_integer1 = new WritableCellFormat(NumberFormats.INTEGER); // 데이터 포멧. 정수형
//			jxl.write.WritableCellFormat format_float1 = new WritableCellFormat(NumberFormats.FLOAT); // 데이터 포멧. 실수형
//			format_column.setBackground(jxl.format.Colour.GRAY_25); // 컬럼 백그라운드 색 설정
//			format_column.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); // 컬럼 보더라인 스타일 설정
//			
//			for(int i=0; i<)
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}
	
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
	
	public void loadDate(List<RequestBook> list) {
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
						reqst.getRequestMbId().getMberId(),
						String.format("%tF", reqst.getRequestDate()),
						reqst.getWhCdt() > 0 ? "입고완료" : "미입고",
						false
				});
				
			}
		} catch (NullPointerException e) {
			model.addRow(new Object[] {});
		}
		
		table.setModel(model);
		tableSetWidth(30, 200, 100, 100, 150, 100, 80, 30);
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
//					if (lists.get(i).getRturnPsmCdt() == 0) {					
//						Date date = lists.get(i).getRturnDueDate();
//						int cdt = lists.get(i).getRturnPsmCdt();
//						cal.setTime(date);
//						cal.add(Calendar.DATE, 10);
//						Date rturnDate = cal.getTime();
//						System.out.println(rturnDate + " / " + cdt + " / " + lists.get(i).getBookCd().getBookCode()+"/"
//								+ lists.get(i).getMberId().getMberId());
//						
//						
//						Lending lending = new Lending();				
//						lending.setBookCd(new Book(lists.get(i).getBookCd().getBookCode()));
//						lending.setMberId(new Member(lists.get(i).getMberId().getMberId()));
//						lending.setRturnPsmCdt(1);
//						lending.setRturnDueDate(rturnDate);
//						service.modifyLendingByCodeAndMberId(lending);
//					} else if( lists.get(i).getRturnPsmCdt() > 0){
//						JOptionPane.showMessageDialog(null, "이미 반납신청 되었습니다.\n(반납연기신청은 1회만 가능합니다.)");
//					}
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
			super(new String[] { "no", "신청도서명", "저자/역자", "출판사", "신청회원ID", "신청일자", "입고여부", "선택" }, 0);
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
