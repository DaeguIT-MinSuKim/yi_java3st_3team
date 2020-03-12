package yi_java3st_3team.ui.content;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MemberIdSelectPanel extends JPanel {
	private JTextField tfMberId;
	private JTextField tfLendPsbCdt;
	private JTextField tfMberName;
	private JTextField tfLendBookCdt;
	private JTextField tfGrade;
	private JButton btnMberId;

	public JTextField getTfMberId() {
		return tfMberId;
	}

	public void setTfMberId(JTextField tfMberId) {
		this.tfMberId = tfMberId;
	}

	public JTextField getTfLendPsbCdt() {
		return tfLendPsbCdt;
	}

	public void setTfLendPsbCdt(JTextField tfLendPsbCdt) {
		this.tfLendPsbCdt = tfLendPsbCdt;
	}

	public JTextField getTfMberName() {
		return tfMberName;
	}

	public void setTfMberName(JTextField tfMberName) {
		this.tfMberName = tfMberName;
	}

	public JTextField getTfLendBookCdt() {
		return tfLendBookCdt;
	}

	public void setTfLendBookCdt(JTextField tfLendBookCdt) {
		this.tfLendBookCdt = tfLendBookCdt;
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

}
