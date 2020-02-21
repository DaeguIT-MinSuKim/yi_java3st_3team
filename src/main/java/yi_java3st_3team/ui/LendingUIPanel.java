package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.ui.menu.HeadMenu;
import yi_java3st_3team.ui.menu.sub.LendingSubMenu;

@SuppressWarnings("serial")
public class LendingUIPanel extends JFrame implements ActionListener {

	private JPanel contentPane;
	private LendingSubMenu panel_2;
	private JPanel panel_1;
	private JPanel panel_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LendingUIPanel frame = new LendingUIPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LendingUIPanel() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		HeadMenu panel = new HeadMenu();
		contentPane.add(panel, BorderLayout.NORTH);

		panel_1 = new JPanel();
		contentPane.add(panel_1);

		panel_2 = new LendingSubMenu();
		panel_2.getBtn1().addActionListener(this);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("HOme");
		panel_4.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panel_2.getBtn1()) {
			do_panel_2Btn1_actionPerformed(e);
		}
	}

	protected void do_panel_2Btn1_actionPerformed(ActionEvent e) {
		panel_1.remove(panel_4);
		panel_1.add(new JLabel("aaaa"));
		revalidate();
	}
}
