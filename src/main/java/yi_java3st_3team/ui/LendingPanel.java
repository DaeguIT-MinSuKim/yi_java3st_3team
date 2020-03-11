package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import yi_java3st_3team.ui.list.LendingListPanel;

@SuppressWarnings("serial")
public class LendingPanel extends JPanel {
	private JTextField tfBookCode;

	public LendingPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel pMember = new JPanel();
		add(pMember, BorderLayout.NORTH);
		pMember.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pList = new JPanel();
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		JPanel pLendingSearch = new JPanel();
		pList.add(pLendingSearch, BorderLayout.NORTH);
		pLendingSearch.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel pLendingLbl = new JPanel();
		pLendingSearch.add(pLendingLbl);
		pLendingLbl.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbl01 = new JLabel("대여 도서 목록");
		lbl01.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(lbl01);

		JLabel lbl02 = new JLabel("도서 코드");
		lbl02.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(lbl02);

		tfBookCode = new JTextField();
		tfBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		pLendingLbl.add(tfBookCode);
		tfBookCode.setColumns(10);

		JButton btnSearch = new JButton("검색");
		pLendingLbl.add(btnSearch);

		JPanel pAllCk = new JPanel();
		pLendingSearch.add(pAllCk);
		pAllCk.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel p03 = new JPanel();
		pAllCk.add(p03);

		JPanel p04 = new JPanel();
		pAllCk.add(p04);

		JButton btnCk = new JButton("모두 선택");
		pAllCk.add(btnCk);

		LendingListPanel pLengingList = new LendingListPanel();
		pList.add(pLengingList, BorderLayout.CENTER);

		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel p05 = new JPanel();
		pBtn.add(p05);

		JPanel p06 = new JPanel();
		pBtn.add(p06);

		JButton btnCancel = new JButton("취소");
		p06.add(btnCancel);

		JButton btnLending = new JButton("대여");
		p06.add(btnLending);
	}

}
