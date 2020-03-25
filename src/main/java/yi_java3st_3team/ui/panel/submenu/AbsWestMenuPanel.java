package yi_java3st_3team.ui.panel.submenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public abstract class AbsWestMenuPanel extends JPanel {
	protected JPanel panel1;
	protected JPanel panel2;
	protected JPanel panel3;
	protected JPanel panel4;
	protected JPanel panel5;
	protected JPanel panel6;
	protected JPanel panel7;
	protected JPanel panel8;
	protected JPanel panel9;
	protected JLabel lbl1;
	protected JLabel lbl2;
	protected JLabel lbl3;
	protected JLabel lbl4;
	protected JLabel lbl5;
	protected JLabel lbl6;
	protected JLabel lbl7;
	protected JLabel lbl8;
	protected JLabel lbl9;
	/**
	 * Create the panel.
	 */
	public AbsWestMenuPanel() {
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(50, 0, 50, 0));
		setLayout(new GridLayout(9, 0, 0, 0));
		setBackground(new Color(240,240,240));
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
	
		lbl1 = new JLabel("");
		lbl1.setFont(new Font("굴림", Font.BOLD, 15));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lbl1, BorderLayout.CENTER);
		
		panel2 = new JPanel();
		panel2.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));
		
		lbl2 = new JLabel("");
		lbl2.setFont(new Font("굴림", Font.BOLD, 15));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(lbl2, BorderLayout.CENTER);
		
		panel3 = new JPanel();
		panel3.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel3);
		panel3.setLayout(new BorderLayout(0, 0));
		
		lbl3 = new JLabel("");
		lbl3.setFont(new Font("굴림", Font.BOLD, 15));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(lbl3, BorderLayout.CENTER);
		
		panel4 = new JPanel();
		panel4.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel4);
		panel4.setLayout(new BorderLayout(0, 0));
		
		lbl4 = new JLabel("");
		lbl4.setFont(new Font("굴림", Font.BOLD, 15));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(lbl4, BorderLayout.CENTER);
		
		panel5 = new JPanel();
		panel5.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel5);
		panel5.setLayout(new BorderLayout(0, 0));
		
		lbl5 = new JLabel("");
		lbl5.setFont(new Font("굴림", Font.BOLD, 15));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		panel5.add(lbl5, BorderLayout.CENTER);
		
		panel6 = new JPanel();
		panel6.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel6);
		panel6.setLayout(new BorderLayout(0, 0));
		
		lbl6 = new JLabel("");
		lbl6.setFont(new Font("굴림", Font.BOLD, 15));
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		panel6.add(lbl6, BorderLayout.CENTER);
		
		panel7 = new JPanel();
		panel7.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel7);
		panel7.setLayout(new BorderLayout(0, 0));
		
		lbl7 = new JLabel("");
		lbl7.setFont(new Font("굴림", Font.BOLD, 15));
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		panel7.add(lbl7, BorderLayout.CENTER);
		
		panel8 = new JPanel();
		panel8.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel8);
		panel8.setLayout(new BorderLayout(0, 0));
		
		lbl8 = new JLabel("");
		lbl8.setFont(new Font("굴림", Font.BOLD, 15));
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		panel8.add(lbl8, BorderLayout.CENTER);
		
		panel9 = new JPanel();
		panel9.setBorder(new EmptyBorder(5, 50, 5, 50));
		add(panel9);
		panel9.setLayout(new BorderLayout(0, 0));
		
		lbl9 = new JLabel("");
		lbl9.setFont(new Font("굴림", Font.BOLD, 15));
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		panel9.add(lbl9, BorderLayout.CENTER);
		
		panel1.setBackground(new Color(240,240,240));
		panel2.setBackground(new Color(240,240,240));
		panel3.setBackground(new Color(240,240,240));
		panel4.setBackground(new Color(240,240,240));
		panel5.setBackground(new Color(240,240,240));
		panel6.setBackground(new Color(240,240,240));
		panel7.setBackground(new Color(240,240,240));
		panel8.setBackground(new Color(240,240,240));
		panel9.setBackground(new Color(240,240,240));
	}
	protected void initLabelText(JLabel...jLabels) {
		String[] texts = getTexts();
		for(int i=0;i<jLabels.length;i++) {
			jLabels[i].setText(texts[i]);
			jLabels[i].setFont(new Font("맑은 고딕",Font.BOLD,16));
		}
	}
	protected abstract String[] getTexts();
}
