package yi_java3st_3team.ui.panel.content;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MemberIdSelectPanel extends JPanel {
	private JTextField tfMberId;
	private JTextField tfLendPsbCdt;
	private JTextField tfMberName;
	private JTextField tfLendBookCdt;
	private JTextField tfGrade;
	private JButton btnMberId;
	private JButton btnMberName;

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

	public JButton getBtnMberName() {
		return btnMberName;
	}

	public MemberIdSelectPanel() {
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 1, 10, 10));

		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		add(p1);
		p1.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblMemberData = new JLabel("회원정보");
		lblMemberData.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		p1.add(lblMemberData);

		JPanel p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		add(p2);
		p2.setLayout(new GridLayout(0, 3, 10, 10));

		JPanel pMberId = new JPanel();
		pMberId.setBackground(Color.WHITE);
		p2.add(pMberId);
		pMberId.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblMberId = new JLabel("회원ID");
		lblMberId.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblMberId.setHorizontalAlignment(SwingConstants.CENTER);
		pMberId.add(lblMberId);

		tfMberId = new JTextField();
		tfMberId.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pMberId.add(tfMberId);
		tfMberId.setColumns(10);

		btnMberId = new JButton("검색");
		btnMberId.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pMberId.add(btnMberId);

		JPanel pMberName = new JPanel();
		pMberName.setBackground(Color.WHITE);
		p2.add(pMberName);
		pMberName.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lbMberName = new JLabel("회원이름");
		lbMberName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lbMberName.setHorizontalAlignment(SwingConstants.CENTER);
		pMberName.add(lbMberName);

		tfMberName = new JTextField();
		tfMberName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pMberName.add(tfMberName);
		tfMberName.setColumns(10);

		btnMberName = new JButton("검색");
		btnMberName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pMberName.add(btnMberName);

		JPanel pGrade = new JPanel();
		pGrade.setBackground(Color.WHITE);
		p2.add(pGrade);
		pGrade.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblGrade = new JLabel("회원등급");
		lblGrade.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pGrade.add(lblGrade);

		tfGrade = new JTextField();
		tfGrade.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pGrade.add(tfGrade);
		tfGrade.setColumns(10);

		JPanel p3 = new JPanel();
		p3.setBackground(Color.WHITE);
		add(p3);
		p3.setLayout(new GridLayout(0, 3, 10, 10));

		JPanel pLendPsbCdt = new JPanel();
		pLendPsbCdt.setBackground(Color.WHITE);
		p3.add(pLendPsbCdt);
		pLendPsbCdt.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblLendPsbCdt = new JLabel("대여가능 여부");
		lblLendPsbCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblLendPsbCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendPsbCdt.add(lblLendPsbCdt);

		tfLendPsbCdt = new JTextField();
		tfLendPsbCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pLendPsbCdt.add(tfLendPsbCdt);
		tfLendPsbCdt.setColumns(10);

		JPanel pLendBookCdt = new JPanel();
		pLendBookCdt.setBackground(Color.WHITE);
		p3.add(pLendBookCdt);
		pLendBookCdt.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblLendBookCdt = new JLabel("대여가능 권수");
		lblLendBookCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblLendBookCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pLendBookCdt.add(lblLendBookCdt);

		tfLendBookCdt = new JTextField();
		tfLendBookCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pLendBookCdt.add(tfLendBookCdt);
		tfLendBookCdt.setColumns(10);
	}

}
