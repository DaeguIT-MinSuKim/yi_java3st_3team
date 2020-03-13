package yi_java3st_3team.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTest1;
	private JFrame frame1;
	private JButton btnTest3;
	private JFrame frame3;
	private JButton btnTest2;
	private JFrame frame2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// select Look and Feel
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("테스트프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));

		btnTest1 = new JButton("경진 TEST");
		btnTest1.addActionListener(this);
		contentPane.add(btnTest1);

		btnTest2 = new JButton("상원 TEST");
		btnTest2.addActionListener(this);
		contentPane.add(btnTest2);

		btnTest3 = new JButton("태원 TEST");
		btnTest3.addActionListener(this);
		contentPane.add(btnTest3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTest2) {
			do_btnTest2_actionPerformed(e);
		}
		if (e.getSource() == btnTest1) {
			btnTest1ActionPerformed(e);
		}
		if (e.getSource() == btnTest3) {
			btnTest3ActionPerformed(e);
		}
	}

	private void btnTest3ActionPerformed(ActionEvent e) {
//		if (frame3 == null) {
//			frame3 = new LoginFrame();
//			frame3 = new JFrame();
//			frame3.setTitle("회원등록");
//			frame3.setBounds(50, 50, 1300, 800);
//			frame3.getContentPane().add(new MemberJoinUIPanel());
//			frame3.setVisible(true);
//			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		} else {
//			if (frame3.isVisible()) {
//				return;
//			}
//			frame3 = new JFrame();
//			frame3.setTitle("도서등록");
//			frame3.setBounds(50, 50, 1800, 1000);
//			frame3.getContentPane().add(new BookManagerPanel());
//			frame3.setVisible(true);
//		}
		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 850, 600);
		MemberSelectUIPanel selectUI = new MemberSelectUIPanel();
		frame.getContentPane().add(selectUI);
		frame.setVisible(true);

	}

	protected void btnTest1ActionPerformed(ActionEvent e) {
		if (frame1 == null) {
			frame1 = new LoginFrame();
//			frame1 = new JFrame();
//			frame1.setTitle("추천도서 등록");
//			frame1.setBounds(50, 50, 1000, 700);
//			frame1.getContentPane().add(new MemberUserCdtPanel());
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		} else {
			if (frame1.isVisible()) {
				return;
			}
			frame1 = new LoginFrame();
//			frame1 = new JFrame();
//			frame1.setTitle("추천도서 등록");
//			frame1.setBounds(50, 50, 1000, 700);
//			frame1.getContentPane().add(new MemberUserCdtPanel());
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}

	protected void do_btnTest2_actionPerformed(ActionEvent e) {
		if (frame2 == null) {
			frame2 = new JFrame();
			frame2.setBounds(50, 50, 850, 600);
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			LendingPanel Lendings = new LendingPanel();
			frame2.getContentPane().add(Lendings);
			frame2.setVisible(true);
		} else {
			if (frame2.isVisible()) {
				return;
			}
			frame2 = new JFrame();
			frame2.setBounds(50, 50, 850, 600);
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			LendingPanel2 Lendings = new LendingPanel2();
			frame2.getContentPane().add(Lendings);
			frame2.setVisible(true);
		}
	}
}
