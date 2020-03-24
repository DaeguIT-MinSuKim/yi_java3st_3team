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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

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
	private JPanel pNorth;

	public RentPanel() {
		initialize();
	}

	private void initialize() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		pNorth = new JPanel();
		pNorth.setBorder(new LineBorder(Color.DARK_GRAY));
		add(pNorth, BorderLayout.NORTH);

		pMember = new MemberIdSelectPanel();
		pMember.getBtnMberName().addActionListener(this);
		pMember.getBtnMberId().addActionListener(this);
		pNorth.setLayout(new GridLayout(0, 1, 0, 0));
		pMember.setLayout(new GridLayout(0, 1, 10, 10));
		pNorth.add(pMember);

		pList = new JPanel();
		pList.setBackground(Color.WHITE);
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pLendingSearch = new JPanel();
		pLendingSearch.setBackground(Color.WHITE);
		pLendingSearch.setBorder(new EmptyBorder(20, 0, 10, 0));
		pList.add(pLendingSearch, BorderLayout.NORTH);
		pLendingSearch.setLayout(new GridLayout(1, 0, 0, 0));

		pLendingLbl = new JPanel();
		pLendingLbl.setBackground(Color.WHITE);
		pLendingSearch.add(pLendingLbl);
		pLendingLbl.setLayout(new GridLayout(1, 0, 10, 10));

		rdbtnBookCode = new JRadioButton("도서코드");
		rdbtnBookCode.setSelected(true);
		rdbtnBookCode.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		rdbtnBookCode.setBackground(Color.WHITE);
		pLendingLbl.add(rdbtnBookCode);
		buttonGroup.add(rdbtnBookCode);

		rdbtnBookName = new JRadioButton("도서명");
		rdbtnBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		rdbtnBookName.setBackground(Color.WHITE);
		pLendingLbl.add(rdbtnBookName);
		buttonGroup.add(rdbtnBookName);

		tfBookSearch = new JTextField();
		tfBookSearch.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(tfBookSearch);
		tfBookSearch.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnSearch.addActionListener(this);
		pLendingLbl.add(btnSearch);

		pAllCk = new JPanel();
		pAllCk.setBackground(Color.WHITE);
		pLendingSearch.add(pAllCk);
		pAllCk.setLayout(new GridLayout(0, 3, 10, 0));

		p03 = new JPanel();
		p03.setBackground(Color.WHITE);
		pAllCk.add(p03);

		btnCheckTrue = new JButton("모두 선택");
		btnCheckTrue.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnCheckTrue.addActionListener(this);
		pAllCk.add(btnCheckTrue);

		btnCheckFalse = new JButton("취소");
		btnCheckFalse.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnCheckFalse.addActionListener(this);
		pAllCk.add(btnCheckFalse);

		pLendingList = new RentListPanel();
		pLendingList.setBackground(Color.WHITE);
		pList.add(pLendingList, BorderLayout.CENTER);

		pBtn = new JPanel();
		pBtn.setBackground(Color.WHITE);
		pBtn.setBorder(new EmptyBorder(10, 0, 10, 0));
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(1, 0, 0, 0));

		p05 = new JPanel();
		p05.setBackground(Color.WHITE);
		pBtn.add(p05);

		p06 = new JPanel();
		pBtn.add(p06);

		pUseless = new JPanel();
		pUseless.setBackground(Color.WHITE);
		p06.add(pUseless);
		p06.setLayout(new GridLayout(0, 3, 0, 0));

		pUseless2 = new JPanel();
		pUseless2.setBackground(Color.WHITE);
		p06.add(pUseless2);

		btnLending = new JButton("대여");
		btnLending.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
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
