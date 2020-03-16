package yi_java3st_3team.ui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Email;

@SuppressWarnings("serial")
public class MemberSendMailDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JMenuItem mntmSettings;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField tfTo;
	private JTextField tfSubject;
	private SendMenuSettingDialog dlgMailSetting;
	private Email email;
	private JTextArea tfMessage;
	private ConfigUtility configUtil;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MemberSendMailDialog dialog = new MemberSendMailDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * Create the dialog.
	 */
	public MemberSendMailDialog() {
		initialize();
	}
	private void initialize() {
		setTitle("메일 전송 프로그램");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pNorth = new JPanel();
			contentPanel.add(pNorth, BorderLayout.NORTH);
			pNorth.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBorderPainted(false);
				menuBar.setBackground(Color.WHITE);
				pNorth.add(menuBar);
				{
					JMenu mnMail = new JMenu("메일 서버");
					menuBar.add(mnMail);
					{
						mntmSettings = new JMenuItem("메일서버 설정");
						mntmSettings.addActionListener(this);
						mnMail.add(mntmSettings);
					}
				}
			}
			{
				JPanel pDummy = new JPanel();
				pDummy.setBackground(Color.WHITE);
				pNorth.add(pDummy);
			}
		}
		{
			JPanel pCenter = new JPanel();
			contentPanel.add(pCenter, BorderLayout.CENTER);
			pCenter.setLayout(new BorderLayout(0, 0));
			{
				JPanel pcNorth = new JPanel();
				pcNorth.setBorder(new EmptyBorder(5, 5, 5, 5));
				pCenter.add(pcNorth, BorderLayout.NORTH);
				pcNorth.setLayout(new BoxLayout(pcNorth, BoxLayout.X_AXIS));
				{
					JLabel lblTo = new JLabel("보낼 주소");
					pcNorth.add(lblTo);
				}
				{
					tfTo = new JTextField();
					pcNorth.add(tfTo);
					tfTo.setColumns(10);
				}
				{
					JLabel lblsubject = new JLabel("제목");
					pcNorth.add(lblsubject);
				}
				{
					tfSubject = new JTextField();
					tfSubject.setColumns(10);
					pcNorth.add(tfSubject);
				}
			}
			{
				JPanel pcCenter = new JPanel();
				pCenter.add(pcCenter, BorderLayout.CENTER);
				pcCenter.setLayout(new BorderLayout(0, 0));
				{
					tfMessage = new JTextArea();
					pcCenter.add(tfMessage);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("보내기");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("취소");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			cancelButtonActionPerformed(e);
		}
		if (e.getSource() == okButton) {
			okButtonActionPerformed(e);
		}
		if (e.getSource() == mntmSettings) {
			mntmSettingsActionPerformed(e);
		}
	}
	protected void mntmSettingsActionPerformed(ActionEvent e) {
		dlgMailSetting = new SendMenuSettingDialog();
		dlgMailSetting.setModal(true);
		dlgMailSetting.setVisible(true);
	}
	protected void okButtonActionPerformed(ActionEvent e) {
		try {
			configUtil.saveProperties(email.getHostName(), email.getPortNum(), email.getUserId(), email.getUserPass());
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	protected void cancelButtonActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "취소되었습니다");
		tfClear();
	}

	private void tfClear() {
		tfTo.setText("");
		tfSubject.setText("");
		tfMessage.setText("");
	}
}
