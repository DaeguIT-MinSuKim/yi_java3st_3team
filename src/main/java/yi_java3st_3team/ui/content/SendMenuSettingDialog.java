package yi_java3st_3team.ui.content;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Email;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SendMenuSettingDialog extends JDialog implements ActionListener {
	private MemberSendMailDialog dlgMemberSendMail;
	private final JPanel contentPanel = new JPanel();
	private JButton btnSave;
	private JTextField tfHost;
	private JTextField tfPortNum;
	private JTextField tfUserName;
	private JTextField tfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SendMenuSettingDialog dialog = new SendMenuSettingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SendMenuSettingDialog() {
		initialize();
	}
	private void initialize() {
		setTitle("SMTP Settings");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 10, 10));
		{
			JLabel lblHost = new JLabel("호스트 이름");
			lblHost.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblHost);
		}
		{
			tfHost = new JTextField();
			contentPanel.add(tfHost);
			tfHost.setColumns(10);
		}
		{
			JLabel lblPortNum = new JLabel("포트 번호");
			lblPortNum.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblPortNum);
		}
		{
			tfPortNum = new JTextField();
			tfPortNum.setColumns(10);
			contentPanel.add(tfPortNum);
		}
		{
			JLabel lblUserName = new JLabel("아이디");
			lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblUserName);
		}
		{
			tfUserName = new JTextField();
			tfUserName.setColumns(10);
			contentPanel.add(tfUserName);
		}
		{
			JLabel lblPass = new JLabel("비밀번호");
			lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblPass);
		}
		{
			tfPass = new JTextField();
			tfPass.setColumns(10);
			contentPanel.add(tfPass);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSave = new JButton("저장");
				btnSave.addActionListener(this);
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
		}
	}
	public Email getItem() {
		String hostName = tfHost.getText();
		String portNum = tfPortNum.getText();
		String userId = tfUserName.getText();
		String userPass = tfPass.getText();
		return new Email(hostName, portNum, userId, userPass);
	}
	
	public void clearTf() {
		tfHost.setText("");
		tfPortNum.setText("");
		tfUserName.setText("");
		tfPass.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			btnSaveActionPerformed(e);
		}
	}
	protected void btnSaveActionPerformed(ActionEvent e) {
		Email email = getItem();
		dlgMemberSendMail.setEmail(email);
		dispose();
		JOptionPane.showMessageDialog(null, "저장되었습니다");
	}
}
