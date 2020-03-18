package yi_java3st_3team.ui.content;

import yi_java3st_3team.dto.RequestBook;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import yi_java3st_3team.ui.list.RequestIntoTblPanel;
import yi_java3st_3team.ui.service.RequestBookUiService;

@SuppressWarnings("serial")
public class RequestBookIntoPanel extends AbsItemPanel<RequestBook> {
	private RequestBookUiService service;
	private RequestIntoTblPanel pReqstList;
	
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setBounds(100, 100, 1000, 800);
		test.getContentPane().add(new RequestBookIntoPanel());
		test.setVisible(true);
	}
	
	public RequestBookIntoPanel() {
		service = new RequestBookUiService();
		initialize();
	}
	
	private void initialize() {
		setBorder(new EmptyBorder(30, 30, 30, 30));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		pNorth.setBorder(new EmptyBorder(10, 20, 10, 20));
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pNorth.add(pSearch, BorderLayout.CENTER);
		
		JComboBox cmbYear = new JComboBox();
		pSearch.add(cmbYear);
		
		JLabel lblYear = new JLabel("년");
		pSearch.add(lblYear);
		
		JComboBox cmbMonth = new JComboBox();
		pSearch.add(cmbMonth);
		
		JLabel lblMonth = new JLabel("월");
		pSearch.add(lblMonth);
		
		JComboBox cmbOption = new JComboBox();
		pSearch.add(cmbOption);
		
		JButton btnSearch = new JButton("검색");
		pSearch.add(btnSearch);
		
		JPanel pChk = new JPanel();
		pNorth.add(pChk, BorderLayout.EAST);
		
		JButton btnTotalChk = new JButton("모두 선택");
		pChk.add(btnTotalChk);
		
		JPanel pList = new JPanel();
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		pReqstList = new RequestIntoTblPanel();
		pReqstList.loadDate(service.showRequestAll());
		
		pList.add(pReqstList, BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(30, 0, 0, 0));
		add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		pLeft.setBorder(new EmptyBorder(0, 30, 0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) pLeft.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pSouth.add(pLeft);
		
		JButton btnExcel = new JButton("엑셀저장");
		pLeft.add(btnExcel);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new EmptyBorder(0, 0, 0, 30));
		FlowLayout flowLayout_2 = (FlowLayout) pRight.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		pSouth.add(pRight);
		
		JButton btnWh = new JButton("입고처리");
		pRight.add(btnWh);
	}

	@Override
	public RequestBook getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItem(RequestBook item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearTf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validCheck() {
		// TODO Auto-generated method stub
		
	}

}
