package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberIdSelectPanel;
import yi_java3st_3team.ui.list.RentListPanel;
import yi_java3st_3team.ui.service.BookUiService;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class LendingPanel extends JPanel implements ActionListener {
	private JTextField tfBookSearch;
	private MemberIdSelectPanel pMember;
	private JPanel pList;
	private JPanel pLendingSearch;
	private JPanel pLendingLbl;
	private JButton btnSearch;
	private JPanel pAllCk;
	private JPanel p03;
	private JButton btnCheckTrue;
	private RentListPanel pLendingList;
	private JPanel pBtn;
	private JPanel p05;
	private JPanel p06;
	private JButton btnLending;
	private LendingUiService lendingService;
	private BookUiService bookService;
	private JPanel pUseless;
	private JButton btnCheckFalse;
	private JPanel pUseless2;
	private JLabel lblList;
	private JLabel lblBookCode;
	
	public LendingPanel() {
		lendingService = new LendingUiService();
		bookService = new BookUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pMember = new MemberIdSelectPanel();
		pMember.getBtnMberId().addActionListener(this);
		add(pMember, BorderLayout.NORTH);
		pMember.setLayout(new GridLayout(0, 1, 0, 0));

		pList = new JPanel();
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pLendingSearch = new JPanel();
		pList.add(pLendingSearch, BorderLayout.NORTH);
		pLendingSearch.setLayout(new GridLayout(1, 0, 0, 0));

		pLendingLbl = new JPanel();
		pLendingSearch.add(pLendingLbl);
		pLendingLbl.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblList = new JLabel("대여도서 목록");
		lblList.setFont(new Font("나눔바른고딕 Light", Font.BOLD, 17));
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(lblList);
		
		lblBookCode = new JLabel("도서코드");
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(lblBookCode);
		
		tfBookSearch = new JTextField();
		tfBookSearch.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(tfBookSearch);
		tfBookSearch.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pLendingLbl.add(btnSearch);
		
		pAllCk = new JPanel();
		pLendingSearch.add(pAllCk);
		pAllCk.setLayout(new GridLayout(0, 3, 0, 0));

		p03 = new JPanel();
		pAllCk.add(p03);

		btnCheckTrue = new JButton("모두 선택");
		btnCheckTrue.addActionListener(this);
		pAllCk.add(btnCheckTrue);
		
		btnCheckFalse = new JButton("취소");
		btnCheckFalse.addActionListener(this);
		pAllCk.add(btnCheckFalse);

		pLendingList = new RentListPanel();
		pList.add(pLendingList, BorderLayout.CENTER);

		pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(1, 0, 0, 0));

		p05 = new JPanel();
		pBtn.add(p05);

		p06 = new JPanel();
		pBtn.add(p06);

		pUseless = new JPanel();
		p06.add(pUseless);
		p06.setLayout(new GridLayout(0, 3, 0, 0));

		pUseless2 = new JPanel();
		p06.add(pUseless2);
		
		btnLending = new JButton("대여");
		btnLending.addActionListener(this);
		p06.add(btnLending);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheckFalse) {
			do_btnCheckFalse_actionPerformed(e);
		}
		if (e.getSource() == pMember.getBtnMberId()) {
			do_pMemberBtnMberId_actionPerformed(e);
		}
		if (e.getSource() == btnLending) {
			do_btnLending_actionPerformed(e);
		}
		if (e.getSource() == btnCheckTrue) {
			do_btnCk_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		try {
			Book id = new Book(tfBookSearch.getText());
			Book book = bookService.LendingBookByCode(id);
			pLendingList.search(book);
			tfBookSearch.setText("");
		} catch (NullPointerException e2) {
			JOptionPane.showMessageDialog(null, "입력하지 않으셨거나 잘못 입력하셨습니다.");
			e2.printStackTrace();	
		}

	}

	protected void do_btnCk_actionPerformed(ActionEvent e) {
		pLendingList.checkingAll(true);
	}

	protected void do_btnLending_actionPerformed(ActionEvent e) {
		pLendingList.setRent(pMember.getTfMberId().getText());
	}

	protected void do_pMemberBtnMberId_actionPerformed(ActionEvent e) {
		Member id = new Member(pMember.getTfMberId().getText());
		Member member = lendingService.showLendingMemberId(id);
		pMember.getTfMberName().setText(member.getMberName());
		if (member.getGrade().getGradeNo() == 1) {
			pMember.getTfGrade().setText("일반");
		} else {
			pMember.getTfGrade().setText("우수");
		}

		if (member.getLendPsbCdt() == 0) {
			pMember.getTfLendPsbCdt().setText("가능");
		} else {
			pMember.getTfLendPsbCdt().setText("불가능");
			JOptionPane.showMessageDialog(null, "대출하실 수 없습니다.");
		}
		int LendBookCnt = member.getLendBookCnt();
		int BookLeCnt = member.getGrade().getBookLeCnt();
		int res = BookLeCnt - LendBookCnt;
		pMember.getTfLendBookCdt().setText(res + "");
	}
	protected void do_btnCheckFalse_actionPerformed(ActionEvent e) {
		pLendingList.checkingAll(false);
	}
}
