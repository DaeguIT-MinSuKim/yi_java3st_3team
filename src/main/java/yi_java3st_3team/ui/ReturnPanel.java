package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberIdSelectPanel2;
import yi_java3st_3team.ui.dialog.MemberListDialog3;
import yi_java3st_3team.ui.dialog.MemberListDialog4;
import yi_java3st_3team.ui.list.ReturnListPanel;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class ReturnPanel extends JPanel implements ActionListener {
	private MemberIdSelectPanel2 pMember;
	private JPanel pList;
	private JPanel pLendingSearch;
	private JPanel pLendingLbl;
	private JPanel pAllCk;
	private JPanel p03;
	private JPanel p04;
	private JButton btnCk;
	private ReturnListPanel pLendingList;
	private JPanel pBtn;
	private JPanel p05;
	private JPanel p06;
	private JButton btnCancel;
	private JButton btnLending;
	private LendingUiService lendingService;
	private Member member;

	public ReturnPanel() {
		lendingService = new LendingUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pMember = new MemberIdSelectPanel2();
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

		pLendingList = new ReturnListPanel();
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

		btnLending = new JButton("반납");
		btnLending.addActionListener(this);
		p06.add(btnLending);
	}

	public MemberIdSelectPanel2 getpMember() {
		return pMember;
	}

	public void setpMember(MemberIdSelectPanel2 pMember) {
		this.pMember = pMember;
	}

	public ReturnListPanel getpLendingList() {
		return pLendingList;
	}

	public void setpLendingList(ReturnListPanel pLendingList) {
		this.pLendingList = pLendingList;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pMember.getBtnMberName()) {
			do_pMemberBtnMberName_actionPerformed(e);
		}
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
	}

	protected void do_btnCk_actionPerformed(ActionEvent e) {
		pLendingList.AllChecking(true);
	}

	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		pLendingList.AllChecking(false);
	}

	protected void do_btnLending_actionPerformed(ActionEvent e) {
		pLendingList.setReturn(pMember.getTfMberId().getText());
	}

	protected void do_pMemberBtnMberId_actionPerformed(ActionEvent e) {
		Member id = new Member(pMember.getTfMberId().getText());
		MemberListDialog3 memberDialog = new MemberListDialog3(new JFrame(), "회원검색", true, id);
		memberDialog.setReturnPanel(this);
		memberDialog.setVisible(true);
	}

	public void returnBookList(Member id) {
		member = lendingService.showLendingMemberId2(id);
		pLendingList.testting2(member);
	}

	protected void do_pMemberBtnMberName_actionPerformed(ActionEvent e) {
		Member name = new Member(pMember.getTfMberName().getText(), new Date());
		MemberListDialog4 memberDialog = new MemberListDialog4(new JFrame(), "회원검색", true, name);
		memberDialog.setReturnPanel(this);
		memberDialog.setVisible(true);
	}
}
