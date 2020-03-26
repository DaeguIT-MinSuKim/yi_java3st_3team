package yi_java3st_3team.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.dialog.MemberListDialog3;
import yi_java3st_3team.ui.dialog.MemberListDialog4;
import yi_java3st_3team.ui.panel.content.MemberIdSelectPanel2;
import yi_java3st_3team.ui.panel.list.MemberReturnTblPanel;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class MemberReturnPanel extends JPanel implements ActionListener {
	private MemberIdSelectPanel2 pMember;
	private JPanel pList;
	private JPanel pLendingSearch;
	private JPanel pLendingLbl;
	private JPanel pAllCk;
	private JPanel p03;
	private JPanel p04;
	private JButton btnCk;
	private MemberReturnTblPanel pLendingList;
	private JPanel pBtn;
	private JPanel p05;
	private JPanel p06;
	private JButton btnCancel;
	private JButton btnLending;
	private LendingUiService lendingService;
	private Member member;
	private JPanel pNorth;
//	private int rturnbookCount;

	public MemberReturnPanel() {
		lendingService = new LendingUiService();
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));

		pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		pNorth.setBorder(new LineBorder(Color.DARK_GRAY));
		add(pNorth, BorderLayout.NORTH);

		pMember = new MemberIdSelectPanel2();

		pMember.getBtnMberName().addActionListener(this);

		pMember.setBackground(Color.WHITE);
		pNorth.setLayout(new GridLayout(0, 1, 0, 0));

		pMember.getBtnMberId().addActionListener(this);
		pNorth.add(pMember);

		pList = new JPanel();
		pList.setBackground(Color.WHITE);
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pLendingSearch = new JPanel();
		pLendingSearch.setBorder(new EmptyBorder(20, 0, 10, 0));
		pLendingSearch.setBackground(Color.WHITE);
		pList.add(pLendingSearch, BorderLayout.NORTH);
		pLendingSearch.setLayout(new GridLayout(1, 0, 0, 0));

		pLendingLbl = new JPanel();
		pLendingLbl.setBackground(Color.WHITE);
		pLendingSearch.add(pLendingLbl);
		pLendingLbl.setLayout(new GridLayout(1, 0, 0, 0));

		pAllCk = new JPanel();
		pAllCk.setBackground(Color.WHITE);
		pLendingSearch.add(pAllCk);
		pAllCk.setLayout(new GridLayout(1, 0, 0, 0));

		p03 = new JPanel();
		p03.setBackground(Color.WHITE);
		pAllCk.add(p03);

		p04 = new JPanel();
		p04.setBackground(Color.WHITE);
		pAllCk.add(p04);

		btnCk = new JButton("모두 선택");
		btnCk.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnCk.addActionListener(this);
		pAllCk.add(btnCk);

		pLendingList = new MemberReturnTblPanel();
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
		FlowLayout flowLayout = (FlowLayout) p06.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		p06.setBackground(Color.WHITE);
		pBtn.add(p06);

		btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnCancel.addActionListener(this);
		p06.add(btnCancel);

		btnLending = new JButton("반납");
		btnLending.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnLending.addActionListener(this);
		p06.add(btnLending);

	}

	public MemberIdSelectPanel2 getpMember() {
		return pMember;
	}

	public void setpMember(MemberIdSelectPanel2 pMember) {
		this.pMember = pMember;
	}

	public MemberReturnTblPanel getpLendingList() {
		return pLendingList;
	}

	public void setpLendingList(MemberReturnTblPanel pLendingList) {
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
//		pLendingList.setReturnGetIdx(rturnbookCount);
		pMember.clearTf();
	}

	protected void do_pMemberBtnMberId_actionPerformed(ActionEvent e) {
		pLendingList.clearTf();
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
		pLendingList.clearTf();
		Member name = new Member(pMember.getTfMberName().getText(), new Date());
		MemberListDialog4 memberDialog = new MemberListDialog4(new JFrame(), "회원검색", true, name);
		memberDialog.setReturnPanel(this);
		memberDialog.setVisible(true);
	}

	public void loadData() {
		pMember.getTfGrade().setText("");
		pMember.getTfGrade().setEnabled(false);
		pMember.getTfOdCnt().setText("");
		pMember.getTfOdCnt().setEnabled(false);
		pMember.getTfOverdueCdt().setText("");
		pMember.getTfOverdueCdt().setEnabled(false);
		pMember.getTfMberId().setText("");
		pMember.getTfMberId().setEnabled(true);
		pMember.getTfMberName().setText("");
		pMember.getTfMberName().setEnabled(true);
		pLendingList.clearTf();
	}
}
