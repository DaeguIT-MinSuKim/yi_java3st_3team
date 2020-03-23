package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberIdSelectPanel;
import yi_java3st_3team.ui.dialog.BookListDialog;
import yi_java3st_3team.ui.dialog.BookListDialog2;
import yi_java3st_3team.ui.dialog.MemberListDialog;
import yi_java3st_3team.ui.dialog.MemberListDialog2;
import yi_java3st_3team.ui.list.RentListPanel;

@SuppressWarnings("serial")
public class RentPanel extends JPanel implements ActionListener {
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
	private JRadioButton rdbtnBookCode;
	private JRadioButton rdbtnBookName;
	private JPanel pUseless;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnCheckFalse;
	private JPanel pUseless2;
	private int res;

	public RentPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pMember = new MemberIdSelectPanel();
		pMember.getBtnMberName().addActionListener(this);
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

		rdbtnBookCode = new JRadioButton("도서코드");
		pLendingLbl.add(rdbtnBookCode);
		buttonGroup.add(rdbtnBookCode);

		rdbtnBookName = new JRadioButton("도서명");
		pLendingLbl.add(rdbtnBookName);
		buttonGroup.add(rdbtnBookName);

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

	public MemberIdSelectPanel getpMember() {
		return pMember;
	}

	public void setpMember(MemberIdSelectPanel pMember) {
		this.pMember = pMember;
	}

	public RentListPanel getpLendingList() {
		return pLendingList;
	}

	public void setpLendingList(RentListPanel pLendingList) {
		this.pLendingList = pLendingList;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pMember.getBtnMberName()) {
			do_pMemberBtnMberName_actionPerformed(e);
		}
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
			if (pMember.getTfLendBookCdt().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "회원을 선택하고 와주세요.");
				return;
			}
			res = Integer.parseInt(pMember.getTfLendBookCdt().getText().trim());
			if (rdbtnBookCode.isSelected()) {
				Book id = new Book(tfBookSearch.getText());
				BookListDialog bookDialog = new BookListDialog(new JFrame(), "도서검색", true, id, res);
				bookDialog.setLending3(this);
				bookDialog.setVisible(true);
				tfBookSearch.setText("");
			}
			if (rdbtnBookName.isSelected()) {
				Book name = new Book(tfBookSearch.getText(), new Date());
				BookListDialog2 bookDialog = new BookListDialog2(new JFrame(), "도서검색", true, name);
				bookDialog.setLending3(this);
				bookDialog.setVisible(true);
				tfBookSearch.setText("");
			}
			if (rdbtnBookCode.isSelected() == false && rdbtnBookName.isSelected() == false) {
				JOptionPane.showMessageDialog(null, "선택해주세요.");
				return;
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
		MemberListDialog memberDialog = new MemberListDialog(new JFrame(), "회원검색", true, id);
		memberDialog.setLending3(this);
		memberDialog.setVisible(true);
	}

	protected void do_pMemberBtnMberName_actionPerformed(ActionEvent e) {
		Member name = new Member(pMember.getTfMberName().getText(), new Date());
		MemberListDialog2 memberDialog = new MemberListDialog2(new JFrame(), "회원검색", true, name);
		memberDialog.setLending3(this);
		memberDialog.setVisible(true);
	}

	protected void do_btnCheckFalse_actionPerformed(ActionEvent e) {
		pLendingList.checkingAll(false);
	}

}
