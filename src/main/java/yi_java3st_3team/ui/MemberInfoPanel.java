package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import yi_java3st_3team.ui.service.StatisticUIService;

import java.awt.Color;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MemberInfoPanel extends JPanel {
	private JLabel lblTotalMemberCount;
	private JLabel lblNormalMemberCount;
	private JLabel lblVipMemberCount;
	/**
	 * Create the panel.
	 */
	public MemberInfoPanel() {
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setVgap(0);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblTotalMembers = new JLabel("총 회원수");
		lblTotalMembers.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(lblTotalMembers);
		
		JLabel lblNormalMembers = new JLabel("일반회원");
		lblNormalMembers.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(lblNormalMembers);
		
		JLabel labelVipMembers = new JLabel("우수회원");
		labelVipMembers.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(labelVipMembers);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(50);
		add(panel_1, BorderLayout.CENTER);
		
		lblTotalMemberCount = new JLabel("0명");
		lblTotalMemberCount.setFont(new Font("굴림", Font.PLAIN, 35));
		panel_1.add(lblTotalMemberCount);
		
		lblNormalMemberCount = new JLabel("0명");
		lblNormalMemberCount.setFont(new Font("굴림", Font.PLAIN, 35));
		panel_1.add(lblNormalMemberCount);
		
		lblVipMemberCount = new JLabel("0명");
		lblVipMemberCount.setFont(new Font("굴림", Font.PLAIN, 35));
		panel_1.add(lblVipMemberCount);
	}
	public void setLblText(StatisticUIService service) {
		int[] memCount = service.selectMemberCounts();
		lblTotalMemberCount.setText(memCount[0] + "명");
		lblNormalMemberCount.setText(memCount[1] + "명");
		lblVipMemberCount.setText(memCount[2] + "명");
	}
}
