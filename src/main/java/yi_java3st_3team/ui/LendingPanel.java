package yi_java3st_3team.ui;

import java.awt.BorderLayout;
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
	private JTextField tfBookCode;
	private MemberIdSelectPanel pMember;
	private JPanel pList;
	private JPanel pLendingSearch;
	private JPanel pLendingLbl;
	private JLabel lbl01;
	private JLabel lbl02;
	private JButton btnSearch;
	private JPanel pAllCk;
	private JPanel p03;
	private JPanel p04;
	private JButton btnCk;
	private RentListPanel pLendingList;
	private JPanel pBtn;
	private JPanel p05;
	private JPanel p06;
	private JButton btnCancel;
	private JButton btnLending;
	private LendingUiService lendingService;
	private BookUiService bookService;

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

		lbl01 = new JLabel("대여 도서 목록");
		lbl01.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(lbl01);

		lbl02 = new JLabel("도서 코드");
		lbl02.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(lbl02);

		tfBookCode = new JTextField();
		tfBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(tfBookCode);
		tfBookCode.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pLendingLbl.add(btnSearch);

		pAllCk = new JPanel();
		pLendingSearch.add(pAllCk);
		pAllCk.setLayout(new GridLayout(1, 0, 0, 0));

		p03 = new JPanel();
		pAllCk.add(p03);

		p04 = new JPanel();
		pAllCk.add(p04);

		btnCk = new JButton("모두 선택");
		btnCk.addActionListener(this);
		pAllCk.add(btnCk);

		pLendingList = new RentListPanel();
		pList.add(pLendingList, BorderLayout.CENTER);

		pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(1, 0, 0, 0));

		p05 = new JPanel();
		pBtn.add(p05);

		p06 = new JPanel();
		pBtn.add(p06);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		p06.add(btnCancel);

		btnLending = new JButton("대여");
		btnLending.addActionListener(this);
		p06.add(btnLending);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pMember.getBtnMberId()) {
			do_pMemberBtnMberId_actionPerformed(e);
		}
		if (e.getSource() == btnLending) {
			do_btnLending_actionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnCk) {
			do_btnCk_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		Book id = new Book(tfBookCode.getText());
		Book book = bookService.LendingBookByCode(id);
		JOptionPane.showMessageDialog(null, book.toString());
		pLendingList.testting(book);
		tfBookCode.setText("");
//		lendingService.showLendingBookCode(book);
//		pLengingList.addLending(book);
//		pLengingList.revalidate();
//		pLengingList.repaint();
//		pLengingList.addItem(item);
	}

	protected void do_btnCk_actionPerformed(ActionEvent e) {
		pLendingList.AllCheck();
	}

	protected void do_btnCancel_actionPerformed(ActionEvent e) {
	}

	protected void do_btnLending_actionPerformed(ActionEvent e) {
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
		JOptionPane.showMessageDialog(null, member.getGrade().getBookLeCnt());
		int res = BookLeCnt - LendBookCnt;
		pMember.getTfLendBookCdt().setText(res + "");
	}
}
