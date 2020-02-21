package yi_java3st_3team.ui.menu.sub;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LendingSubMenu extends JPanel implements ActionListener {
	public JPanel p;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	public LendingSubMenu() {

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		add(panel);

		JPanel panel_1 = new JPanel();
		add(panel_1);

		btn1 = new JButton("New button");
		btn1.addActionListener(this);
		panel_1.add(btn1);

		JPanel panel_4 = new JPanel();
		add(panel_4);

		btn2 = new JButton("New button");
		btn2.addActionListener(this);
		panel_4.add(btn2);

		JPanel panel_2 = new JPanel();
		add(panel_2);

		btn3 = new JButton("New button");
		btn3.addActionListener(this);
		panel_2.add(btn3);

		JPanel panel_3 = new JPanel();
		add(panel_3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn3) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btn2) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btn1) {
//			do_btnNewButton_actionPerformed(e);
		}
	}

//	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
//		p = new JPanel();
//		JLabel l = new JLabel("first");
//		p.add(l);
//		p.setVisible(true);
//		JDialog d = new JDialog();
//		d.getContentPane().add(p);
//		d.setVisible(true);
//	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		p = new JPanel();
		JLabel l = new JLabel("two");
		p.add(l);
		p.setVisible(true);
		JDialog d = new JDialog();
		d.getContentPane().add(p);
		d.setVisible(true);
	}

	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		p = new JPanel();
		JLabel l = new JLabel("last");
		p.add(l);
		p.setVisible(true);
		JDialog d = new JDialog();
		d.getContentPane().add(p);
		d.setVisible(true);
	}

	public JButton getBtn1() {
		return btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}
	
	
}
