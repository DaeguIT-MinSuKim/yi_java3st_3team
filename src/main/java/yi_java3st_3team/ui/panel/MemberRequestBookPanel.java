package yi_java3st_3team.ui.panel;

import yi_java3st_3team.LoginFrame;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.RequestBook;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;

import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.panel.list.MemberRequestBookTblPanel;
import yi_java3st_3team.ui.service.RequestBookUiService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class MemberRequestBookPanel extends AbsItemPanel<RequestBook> implements ItemListener, ActionListener {
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPls;
	private JTextField tfTrnslr;
	private JComboBox<String> cmbYear;
	private RequestBookUiService service;
	private RequestBook rbId = new RequestBook(new Member(LoginFrame.loginMber.getMberId()));
	private MemberRequestBookTblPanel pReqstBookList;
	private JPanel pListDummy;
	private JButton btnNewButton;
	private JButton btnCancel;

	public MemberRequestBookPanel() {
		service = new RequestBookUiService();
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		pNorth.setBorder(new EmptyBorder(20, 50, 10, 50));
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BoxLayout(pNorth, BoxLayout.X_AXIS));

		JPanel pTfs = new JPanel();
		pTfs.setBackground(Color.WHITE);
		pNorth.add(pTfs);
		pTfs.setLayout(new GridLayout(0, 4, 0, 10));

		JLabel lblBookName = new JLabel("도서명");
		lblBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		pTfs.add(lblBookName);

		tfBookName = new JTextField();
		tfBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pTfs.add(tfBookName);
		tfBookName.setColumns(10);

		JLabel lblAuthor = new JLabel("저자");
		lblAuthor.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		pTfs.add(lblAuthor);

		tfAuthor = new JTextField();
		tfAuthor.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfAuthor.setColumns(10);
		pTfs.add(tfAuthor);

		JLabel lblPls = new JLabel("출판사");
		lblPls.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		pTfs.add(lblPls);

		tfPls = new JTextField();
		tfPls.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfPls.setColumns(10);
		pTfs.add(tfPls);

		JLabel lblTrnslr = new JLabel("역자");
		lblTrnslr.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblTrnslr.setHorizontalAlignment(SwingConstants.CENTER);
		pTfs.add(lblTrnslr);

		tfTrnslr = new JTextField();
		tfTrnslr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfTrnslr.setColumns(10);
		pTfs.add(tfTrnslr);

		JPanel pBtn = new JPanel();
		pBtn.setBackground(Color.WHITE);
		pNorth.add(pBtn);

		btnNewButton = new JButton("신청");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnNewButton.addActionListener(this);
		btnNewButton.setPreferredSize(new Dimension(150, 80));
		pBtn.add(btnNewButton);

		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));

		JPanel pTitle = new JPanel();
		pTitle.setBackground(Color.WHITE);
		pTitle.setBorder(new EmptyBorder(10, 30, 5, 30));
		pCenter.add(pTitle, BorderLayout.NORTH);
		pTitle.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblTitle = new JLabel("도서신청 리스트");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		pTitle.add(lblTitle);

		JPanel pcmb = new JPanel();
		pcmb.setBackground(Color.WHITE);
		FlowLayout fl_pcmb = (FlowLayout) pcmb.getLayout();
		fl_pcmb.setAlignment(FlowLayout.RIGHT);
		pTitle.add(pcmb);

		cmbYear = new JComboBox<>();
		cmbYear.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		cmbYear.addItemListener(this);
		pcmb.add(cmbYear);

		JLabel lblYear = new JLabel("년");
		lblYear.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pcmb.add(lblYear);

		JPanel pList = new JPanel();
		pList.setBackground(Color.WHITE);
		pList.setBorder(new EmptyBorder(10, 30, 10, 30));
		pCenter.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pListDummy = new JPanel();
		pList.add(pListDummy, BorderLayout.CENTER);
		pListDummy.setLayout(new BorderLayout(0, 0));

		pReqstBookList = new MemberRequestBookTblPanel();
		pReqstBookList.setBackground(Color.WHITE);
		pListDummy.add(pReqstBookList, BorderLayout.CENTER);

		JPanel pCancelBtn = new JPanel();
		pCancelBtn.setBackground(Color.WHITE);
		FlowLayout fl_pCancelBtn = (FlowLayout) pCancelBtn.getLayout();
		fl_pCancelBtn.setAlignment(FlowLayout.RIGHT);
		pCancelBtn.setBorder(new EmptyBorder(10, 30, 20, 30));
		pCenter.add(pCancelBtn, BorderLayout.SOUTH);

		btnCancel = new JButton("신청취소");
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnCancel.addActionListener(this);
		pCancelBtn.add(btnCancel);

		setCmbYearList();
		setService(service);
	}
	
	public void loadData() {
		setService(service);
		clearTf();
	}

	public void setService(RequestBookUiService service) {
		this.service = service;
		pReqstBookList.loadData(service.showRequestByIdAll(rbId));
	}

	public void setCmbYearList() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		List<String> years = new ArrayList<String>();
		years.add("전체");

		for (int i = 0; i > -10; i--) {
			years.add(sdf.format(cal.getTime()));
			cal.add(Calendar.YEAR, -1);
		}

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new Vector<>(years));
		cmbYear.setModel(model);
		cmbYear.setSelectedIndex(0);
	}

	@Override
	public RequestBook getItem() {
		Member requestMbId = new Member(LoginFrame.loginMber.getMberId());
		String requestBookName = tfBookName.getText().trim();
		String requestBookAuthor = tfAuthor.getText().trim();
		String requestBookTrnslr = tfTrnslr.getText().trim();
		String requestBookPls = tfPls.getText().trim();
		Date requestDate = new Date();
		int whCdt = 0;

		return new RequestBook(requestMbId, requestBookName, requestBookAuthor, requestBookTrnslr, requestBookPls,
				requestDate, whCdt);
	}

	@Override
	public void setItem(RequestBook item) {
	}

	@Override
	public void clearTf() {
		tfAuthor.setText("");
		tfBookName.setText("");
		tfPls.setText("");
		tfTrnslr.setText("");
		cmbYear.setSelectedIndex(0);
	}

	@Override
	public void validCheck() {
		if (tfBookName.getText().contentEquals("") || tfAuthor.getText().contentEquals("")
				|| tfPls.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbYear) {
			cmbYearItemStateChanged(e);
		}
	}

	protected void cmbYearItemStateChanged(ItemEvent e) {
		if (cmbYear.getSelectedItem().equals("전체")) {
			setService(service);
			return;
		}

		String year = cmbYear.getSelectedItem() + "";
		pReqstBookList.loadData(service.showRequestByIdAndYear(rbId, year));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		try {
			String bookName = tfBookName.getText().trim();
			String authr = tfAuthor.getText().trim();
			String trnslr = tfTrnslr.getText().trim();
			String pls = tfPls.getText().trim();
			if(service.checkBook(bookName, authr, trnslr, pls) != null) {
				JOptionPane.showMessageDialog(null, "보유하고 있는 도서있니다. \n사서에게 문의해주시기 바랍니다.");
				return;
			}
			validCheck();
			RequestBook newReqst = getItem();
			service.addRequestBook(newReqst);
			clearTf();
			pReqstBookList.loadData(service.showRequestByIdAll(rbId));
			JOptionPane.showMessageDialog(null, "신청되었습니다.");
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		try {
			RequestBook deleteRd = pReqstBookList.getSelectedItem();
			
			int result = JOptionPane.showConfirmDialog(null, "선택된 정보를 삭제하겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.CLOSED_OPTION) {
			} else if (result == JOptionPane.YES_OPTION) {
				service.removeRequestBook(deleteRd);
				setService(service);
				JOptionPane.showMessageDialog(null, "삭제되었습니다");
			} else {
			}
			
			
		} catch (RuntimeException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
}
