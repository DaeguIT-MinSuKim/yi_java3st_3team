package yi_java3st_3team.ui.content;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class MemberIdSelectPanel2 extends JPanel {
	private JTextField tfMberId;
	private JTextField tfOverdueCdt;
	private JTextField tfMberName;
	private JTextField tfpOdCnt;
	private JTextField tfGrade;
	private JButton btnMberId;

	public JTextField getTfMberId() {
		return tfMberId;
	}

	public void setTfMberId(JTextField tfMberId) {
		this.tfMberId = tfMberId;
	}

	public JTextField getTfLendPsbCdt() {
		return tfOverdueCdt;
	}

	public void setTfLendPsbCdt(JTextField tfLendPsbCdt) {
		this.tfOverdueCdt = tfLendPsbCdt;
	}

	public JTextField getTfMberName() {
		return tfMberName;
	}

	public void setTfMberName(JTextField tfMberName) {
		this.tfMberName = tfMberName;
	}

	public JTextField getTfLendBookCdt() {
		return tfpOdCnt;
	}

	public void setTfLendBookCdt(JTextField tfLendBookCdt) {
		this.tfpOdCnt = tfLendBookCdt;
	}

	public JTextField getTfGrade() {
		return tfGrade;
	}

	public void setTfGrade(JTextField tfGrade) {
		this.tfGrade = tfGrade;
	}

	public JButton getBtnMberId() {
		return btnMberId;
	}

	public MemberIdSelectPanel2() {

		initialize();
	}

	private void initialize() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
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

		JPanel pOverdueCdt = new JPanel();
		p3.add(pOverdueCdt);
		pOverdueCdt.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblOverdueCdt = new JLabel("연체 여부");
		lblOverdueCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pOverdueCdt.add(lblOverdueCdt);

		tfOverdueCdt = new JTextField();
		pOverdueCdt.add(tfOverdueCdt);
		tfOverdueCdt.setColumns(10);

		JPanel pOdCnt = new JPanel();
		p3.add(pOdCnt);
		pOdCnt.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblpOdCnt = new JLabel("연체 횟수");
		lblpOdCnt.setHorizontalAlignment(SwingConstants.CENTER);
		pOdCnt.add(lblpOdCnt);

		tfpOdCnt = new JTextField();
		pOdCnt.add(tfpOdCnt);
		tfpOdCnt.setColumns(10);
	}

}
