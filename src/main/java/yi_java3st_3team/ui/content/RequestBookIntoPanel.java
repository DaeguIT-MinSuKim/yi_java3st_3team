package yi_java3st_3team.ui.content;

import yi_java3st_3team.dto.RequestBook;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import yi_java3st_3team.ui.list.RequestIntoTblPanel;
import yi_java3st_3team.ui.service.RequestBookUiService;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class RequestBookIntoPanel extends JPanel implements ActionListener {
	private RequestBookUiService service;
	private RequestIntoTblPanel pReqstList;
	private JComboBox<String> cmbYear;
	private JComboBox<String> cmbMonth;
	private JComboBox<String> cmbOption;
	private JButton btnSearch;
	private JButton btnTotalChk;
	private JButton btnExcel;
	private JButton btnWh;
	private JButton btnTotalUnChk;

	public RequestBookIntoPanel() {
		service = new RequestBookUiService();
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(30, 30, 30, 30));
		setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		pNorth.setBorder(new EmptyBorder(10, 20, 10, 20));
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));

		JPanel pSearch = new JPanel();
		pSearch.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) pSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pNorth.add(pSearch, BorderLayout.CENTER);

		cmbYear = new JComboBox<>();
		cmbYear.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pSearch.add(cmbYear);

		JLabel lblYear = new JLabel("년");
		lblYear.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pSearch.add(lblYear);

		cmbMonth = new JComboBox<>();
		cmbMonth.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pSearch.add(cmbMonth);

		JLabel lblMonth = new JLabel("월");
		lblMonth.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pSearch.add(lblMonth);

		cmbOption = new JComboBox<>();
		cmbOption.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pSearch.add(cmbOption);

		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnSearch.addActionListener(this);
		pSearch.add(btnSearch);

		JPanel pChk = new JPanel();
		pChk.setBackground(Color.WHITE);
		pNorth.add(pChk, BorderLayout.EAST);

		btnTotalChk = new JButton("모두 선택");
		btnTotalChk.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnTotalChk.addActionListener(this);

		btnTotalUnChk = new JButton("모두 해제");
		btnTotalUnChk.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnTotalUnChk.addActionListener(this);
		pChk.add(btnTotalUnChk);
		pChk.add(btnTotalChk);

		JPanel pList = new JPanel();
		pList.setBackground(Color.WHITE);
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pReqstList = new RequestIntoTblPanel();
		pReqstList.setBackground(Color.WHITE);
		pReqstList.loadDate(service.showRequestAll());

		pList.add(pReqstList, BorderLayout.CENTER);

		JPanel pSouth = new JPanel();
		pSouth.setBackground(Color.WHITE);
		pSouth.setBorder(new EmptyBorder(30, 0, 0, 0));
		add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pLeft = new JPanel();
		pLeft.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) pLeft.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pSouth.add(pLeft);

		btnExcel = new JButton("엑셀저장");
		btnExcel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnExcel.addActionListener(this);
		pLeft.add(btnExcel);

		JPanel pRight = new JPanel();
		pRight.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) pRight.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		pSouth.add(pRight);

		btnWh = new JButton("입고처리");
		btnWh.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnWh.addActionListener(this);
		pRight.add(btnWh);

		setCmbYearList();
		setCmbMonthList();
		setCmbWhCdtList();
	}

	public void setService(RequestBookUiService service) {
		this.service = service;
	}

	public void setCmbYearList() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		List<String> years = new ArrayList<String>();

		for (int i = 0; i > -10; i--) {
			years.add(sdf.format(cal.getTime()));
			cal.add(Calendar.YEAR, -1);
		}

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new Vector<>(years));
		cmbYear.setModel(model);
	}

	public void setCmbMonthList() {
		List<String> months = new ArrayList<String>();

		for (int i = 1; i <= 12; i++) {
			months.add(String.format("%02d", i));
		}

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new Vector<>(months));
		cmbMonth.setModel(model);
		cmbMonth.setSelectedIndex(-1);
	}

	public void setCmbWhCdtList() {
		List<String> whCdt = new ArrayList<String>();
		whCdt.add("입고완료");
		whCdt.add("미입고");
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new Vector<>(whCdt));
		cmbOption.setModel(model);
		cmbOption.setSelectedIndex(-1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnWh) {
			btnWhActionPerformed(e);
		}
		if (e.getSource() == btnExcel) {
			try {
				btnExcelActionPerformed(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnTotalUnChk) {
			btnTotalUnChkActionPerformed(e);
		}
		if (e.getSource() == btnTotalChk) {
			btnTotalChkActionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
	}

	protected void btnSearchActionPerformed(ActionEvent e) {

		if (cmbYear.getModel().getSelectedItem() != null) {
			String year = (String) cmbYear.getModel().getSelectedItem();
			String month = null;
			String Option = (String) cmbOption.getModel().getSelectedItem();
			RequestBook rb = new RequestBook();

			System.out.println("whcdt : " + Option);

			if (cmbMonth.getModel().getSelectedItem() != null) {
				month = (String) cmbMonth.getModel().getSelectedItem();
			}

			try {
				if (Option.equals("입고완료")) {
					rb.setWhCdt(1);
				}

				if (Option.equals("미입고")) {
					rb.setWhCdt(0);
				}

			} catch (NullPointerException e1) {
				rb.setWhCdt(-1);
			}

			pReqstList.loadDate(service.showRequestByOptionAll(rb, year, month));
		}

		cmbYear.setSelectedIndex(0);
		cmbMonth.setSelectedIndex(-1);
		cmbOption.setSelectedIndex(-1);
	}

	protected void btnTotalChkActionPerformed(ActionEvent e) {
		pReqstList.totlaChk();
	}

	protected void btnTotalUnChkActionPerformed(ActionEvent e) {
		pReqstList.totlaUnChk();
	}

	protected void btnExcelActionPerformed(ActionEvent e) throws IOException {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(today);
		String fileName = "신청도서리스트(" + date + ").xls";

		int tbColumnCnt = pReqstList.getColumnCnt() - 1;
		int tbRowCnt = pReqstList.getRowCnt();

		String filePath = System.getProperty("user.dir") + "\\document\\Excel\\" + fileName + "\\";
		File file = new File(filePath);
		if(!file.exists()) {
			file.createNewFile();
		} else {
			JOptionPane.showMessageDialog(null, "저장폴더 위치에 이름이 같이 파일이 있습니다.\n 폴더 위치 \n[D:\\workspace\\workspace_teamProject\\yi_java3st_3team\\document]");
			return;
		}
		
		String SheetName = "bookList";
		String[][] data = new String[tbRowCnt][tbColumnCnt - 1];

		String[] getColumn = new String[tbColumnCnt];
		for (int i = 0; i < tbColumnCnt; i++) { // 컬럼명 받기
			getColumn[i] = pReqstList.getColumnName(i);
		}

		String[][] getData = new String[tbRowCnt][tbColumnCnt]; // 데이터 받기
		for (int i = 0; i < tbRowCnt; i++) {
			for (int j = 0; j < tbColumnCnt; j++) {
				getData[i][j] = pReqstList.getValueAt(i, j);
			}
		}

		try {
			WritableWorkbook workbook = Workbook.createWorkbook(file); // 파일경로 설정
			WritableSheet sheet = workbook.createSheet(SheetName, 0); // 시트이름과 몇번째 시트인덱스
			jxl.write.WritableCellFormat format_column = new WritableCellFormat(); // 컬럼 포멧. 스트링
			jxl.write.WritableCellFormat format_data = new WritableCellFormat(); // 데이터 포멧. 스트링
			jxl.write.WritableCellFormat format_integer1 = new WritableCellFormat(NumberFormats.INTEGER); // 데이터 포멧. 정수형
			jxl.write.WritableCellFormat format_float1 = new WritableCellFormat(NumberFormats.FLOAT); // 데이터 포멧. 실수형
			format_column.setBackground(jxl.format.Colour.GRAY_25); // 컬럼 백그라운드 색 설정
			format_column.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); // 컬럼 보더라인 스타일 설정

			for (int i = 0; i < getColumn.length; i++) { // 컬럼명 넣기
				Label label = new jxl.write.Label(i, 0, getColumn[i], format_column);
				sheet.addCell(label);
			}

			for (int i = 0; i < data.length; i++) { // 데이터넣기. 컬럼명이 0번에 들어가므로 데이터는 1무터 넣는다.
				for (int j = 0; j < getData[i].length; j++) {
					Label lbl = new jxl.write.Label(j, i + 1, getData[i][j], format_data);
					sheet.addCell(lbl);
				}
			}

			workbook.write();// 파일저장
			workbook.close();// 파일닫기
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void btnWhActionPerformed(ActionEvent e) {
		pReqstList.getSelectedItem();
		pReqstList.loadDate(service.showRequestAll());
	}
}
