package yi_java3st_3team.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Member;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MemberIdSelectPanel extends JPanel implements ActionListener {
	private JTextField tfMberId;
	private JTextField tfLendPsbCdt;
	private JTextField tfMberName;
	private JTextField tfLendBookCdt;
	private JTextField tfGrade;
	private JButton btnMberId;

	public MemberIdSelectPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel p1 = new JPanel();
		add(p1);
		p1.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblMemberData = new JLabel("회원정보");
		lblMemberData.setFont(new Font("굴림", Font.BOLD, 20));
		lblMemberData.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(lblMemberData);

		JPanel p2 = new JPanel();
		add(p2);
		p2.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel pMberId = new JPanel();
		p2.add(pMberId);
		pMberId.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblMberId = new JLabel("회원ID");
		lblMberId.setHorizontalAlignment(SwingConstants.CENTER);
		pMberId.add(lblMberId);

		tfMberId = new JTextField();
		pMberId.add(tfMberId);
		tfMberId.setColumns(10);

		btnMberId = new JButton("검색");
		btnMberId.addActionListener(this);
		pMberId.add(btnMberId);

		JPanel pMberName = new JPanel();
		p2.add(pMberName);
		pMberName.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lbMberName = new JLabel("회원이름");
		lbMberName.setHorizontalAlignment(SwingConstants.CENTER);
		pMberName.add(lbMberName);

		tfMberName = new JTextField();
		pMberName.add(tfMberName);
		tfMberName.setColumns(10);

		JPanel pGrade = new JPanel();
		p2.add(pGrade);
		pGrade.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblGrade = new JLabel("회원등급");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pGrade.add(lblGrade);

		tfGrade = new JTextField();
		pGrade.add(tfGrade);
		tfGrade.setColumns(10);

		JPanel p3 = new JPanel();
		add(p3);
		p3.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel pLendPsbCdt = new JPanel();
		p3.add(pLendPsbCdt);
		pLendPsbCdt.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblLendPsbCdt = new JLabel("대여가능 여부");
		lblLendPsbCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendPsbCdt.add(lblLendPsbCdt);

		tfLendPsbCdt = new JTextField();
		pLendPsbCdt.add(tfLendPsbCdt);
		tfLendPsbCdt.setColumns(10);

		JPanel pLendBookCdt = new JPanel();
		p3.add(pLendBookCdt);
		pLendBookCdt.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblLendBookCdt = new JLabel("대여가능 권수");
		lblLendBookCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendBookCdt.add(lblLendBookCdt);

		tfLendBookCdt = new JTextField();
		pLendBookCdt.add(tfLendBookCdt);
		tfLendBookCdt.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMberId) {
			do_btnMberId_actionPerformed(e);
		}
	}

	protected void do_btnMberId_actionPerformed(ActionEvent e) {
		String mberId;
		mberId = tfMberId.getText();
		Member member = new Member(mberId);
		
		
	}
}
