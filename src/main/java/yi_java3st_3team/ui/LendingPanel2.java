package yi_java3st_3team.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberIdSelectPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import yi_java3st_3team.ui.list.LendingListPanel;
import yi_java3st_3team.ui.service.LendingUiService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LendingPanel2 extends JPanel implements ActionListener {
	private MemberIdSelectPanel pMember;
	private JButton btnReturn;
	private JButton btnCancel;
	private JButton btnNCk;
	private LendingUiService service;


	public LendingPanel2() {
		service = new LendingUiService();
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		pMember = new MemberIdSelectPanel();
		pMember.getBtnMberId().addActionListener(this);
		add(pMember, BorderLayout.NORTH);
		
		JPanel pList = new JPanel();
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		pList.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		btnNCk = new JButton("모두 선택");
		panel_6.add(btnNCk);
		
		LendingListPanel pLendingList = new LendingListPanel();
		pList.add(pLendingList, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		pBtn.add(panel);
		
		JPanel pBtns = new JPanel();
		pBtn.add(pBtns);
		pBtns.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		pBtns.add(panel_1);
		
		btnCancel = new JButton("취소");
		pBtns.add(btnCancel);
		
		btnReturn = new JButton("반납");
		pBtns.add(btnReturn);
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
		
		service.showLendingMemberId(member);
		
	}
}
