package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberIdSelectPanel2;
import yi_java3st_3team.ui.list.ReturnListPanel;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class LendingPanel2 extends JPanel implements ActionListener {
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

	public LendingPanel2() {
		lendingService = new LendingUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pMember = new MemberIdSelectPanel2();
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
		member = lendingService.showLendingMemberId2(id);
		
		
		pMember.getTfMberName().setText(member.getMberName());
		if (member.getGrade().getGradeNo() == 1) {
			pMember.getTfGrade().setText("일반");
		} else {
			pMember.getTfGrade().setText("우수");
		}

		if (member.getLendPsbCdt() == 0) {
			pMember.getTfOverdueCdt().setText("정상");
		} else {
			pMember.getTfOverdueCdt().setText("연체");
		}
		pMember.getTfpOdCnt().setText(member.getOdCnt()+"");
		
		pLendingList.testting2(member);
	}
}
