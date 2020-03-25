package yi_java3st_3team.ui.panel.content;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MemberIdSelectPanel2 extends JPanel {
	private JTextField tfMberId;
	private JTextField tfOverdueCdt;
	private JTextField tfMberName;
	private JTextField tfOdCnt;
	private JTextField tfGrade;
	private JButton btnMberId;
	private JButton btnMberName;

	public JTextField getTfMberId() {
		return tfMberId;
	}

	public void setTfMberId(JTextField tfMberId) {
		this.tfMberId = tfMberId;
	}

	public JTextField getTfOverdueCdt() {
		return tfOverdueCdt;
	}

	public void setTfOverdueCdt(JTextField tfOverdueCdt) {
		this.tfOverdueCdt = tfOverdueCdt;
	}

	public JTextField getTfMberName() {
		return tfMberName;
	}

	public void setTfMberName(JTextField tfMberName) {
		this.tfMberName = tfMberName;
	}

	public JTextField getTfpOdCnt() {
		return tfOdCnt;
	}

	public void setTfpOdCnt(JTextField tfpOdCnt) {
		this.tfOdCnt = tfpOdCnt;
	}

	public JTextField getTfGrade() {
		return tfGrade;
	}

	public void setTfGrade(JTextField tfGrade) {
		this.tfGrade = tfGrade;
	}

	public JTextField getTfOdCnt() {
		return tfOdCnt;
	}

	public void setTfOdCnt(JTextField tfOdCnt) {
		this.tfOdCnt = tfOdCnt;
	}

	public JButton getBtnMberId() {
		return btnMberId;
	}

	public JButton getBtnMberName() {
		return btnMberName;
	}

	public MemberIdSelectPanel2() {

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

		JPanel pOverdueCdt = new JPanel();
		pOverdueCdt.setBackground(Color.WHITE);
		p3.add(pOverdueCdt);
		pOverdueCdt.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblOverdueCdt = new JLabel("연체 여부");
		lblOverdueCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblOverdueCdt.setHorizontalAlignment(SwingConstants.CENTER);
		pOverdueCdt.add(lblOverdueCdt);

		tfOverdueCdt = new JTextField();
		tfOverdueCdt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOverdueCdt.add(tfOverdueCdt);
		tfOverdueCdt.setColumns(10);

		JPanel pOdCnt = new JPanel();
		pOdCnt.setBackground(Color.WHITE);
		p3.add(pOdCnt);
		pOdCnt.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblpOdCnt = new JLabel("연체 횟수");
		lblpOdCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblpOdCnt.setHorizontalAlignment(SwingConstants.CENTER);
		pOdCnt.add(lblpOdCnt);

		tfOdCnt = new JTextField();
		tfOdCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOdCnt.add(tfOdCnt);
		tfOdCnt.setColumns(10);
	}

}
