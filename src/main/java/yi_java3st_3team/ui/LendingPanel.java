package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import yi_java3st_3team.ui.list.LendingListPanel;
import yi_java3st_3team.ui.service.LendingUiService;
import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberIdSelectPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private LendingListPanel pLengingList;
	private JPanel pBtn;
	private JPanel p05;
	private JPanel p06;
	private JButton btnCancel;
	private JButton btnLending;
	private LendingUiService service;

	public LendingPanel() {

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
		pLendingLbl.add(btnSearch);

		pAllCk = new JPanel();
		pLendingSearch.add(pAllCk);
		pAllCk.setLayout(new GridLayout(1, 0, 0, 0));

		p03 = new JPanel();
		pAllCk.add(p03);

		p04 = new JPanel();
		pAllCk.add(p04);

		btnCk = new JButton("모두 선택");
		pAllCk.add(btnCk);

		pLengingList = new LendingListPanel();
		pList.add(pLengingList, BorderLayout.CENTER);

		pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(1, 0, 0, 0));

		p05 = new JPanel();
		pBtn.add(p05);

		p06 = new JPanel();
		pBtn.add(p06);

		btnCancel = new JButton("취소");
		p06.add(btnCancel);

		btnLending = new JButton("대여");
		p06.add(btnLending);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pMember.getBtnMberId()) {
			do_pMemberBtnMberId_actionPerformed(e);
		}
	}
	protected void do_pMemberBtnMberId_actionPerformed(ActionEvent e) {
		JTextField mberId2 = pMember.getTfMberId();
		String mberId = mberId2.getText();
		Member member  = new Member(mberId);
		MemberDao instance = MemberDaoImpl.getInstance();
		instance.selectLendingMemberByNo(member);
//		service.showLendingMemberId(member);
	}
}
