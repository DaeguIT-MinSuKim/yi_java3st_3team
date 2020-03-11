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

import yi_java3st_3team.ui.content.BookManagerPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTest1;
	private JFrame frame1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		
		JButton btnTest2 = new JButton("상원 TEST");
		contentPane.add(btnTest2);
		
		JButton btnTest3 = new JButton("태원 TEST");
		contentPane.add(btnTest3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTest1) {
			btnTest1ActionPerformed(e);
		}
	}
	protected void btnTest1ActionPerformed(ActionEvent e) {
		if(frame1 == null) {
//			frame1 = new LoginFrame();
			frame1 = new JFrame();
			frame1.setTitle("보유도서 관리");
			frame1.setBounds(50, 50, 1800, 1000);
			frame1.getContentPane().add(new BookManagerPanel());
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else {
			if(frame1.isVisible()) {
				return;
			}
			frame1 = new JFrame();
			frame1.setTitle("보유도서 관리");
			frame1.setBounds(50, 50, 1800, 1000);
			frame1.getContentPane().add(new BookManagerPanel());
			frame1.setVisible(true);
		}
	}
}
