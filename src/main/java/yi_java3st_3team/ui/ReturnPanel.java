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
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.FlowLayout;

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
	private JPanel panel;
	private JPanel pNorth;

	public ReturnPanel() {
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

		pLendingList = new ReturnListPanel();
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
