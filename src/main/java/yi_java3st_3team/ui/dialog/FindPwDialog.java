package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.service.LoginUiService;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FindPwDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfBirthday;
	private JButton cancelButton;
	
	private LoginUiService service = new LoginUiService();
	private Member findMber;
	private Librarian findLib;
	private JButton okButton;

	public FindPwDialog(JFrame frame, String title) {
		super(frame, title, true);
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(15, 0, 15, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 10, 10));
		{
			JLabel lblId = new JLabel("아이디");
			lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblId.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblId);
		}
		{
			tfId = new JTextField();
			contentPanel.add(tfId);
			tfId.setColumns(10);
		}
		{
			JLabel lblName = new JLabel("이름");
			lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblName.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblName);
		}
		{
			tfName = new JTextField();
			contentPanel.add(tfName);
			tfName.setColumns(10);
		}
		{
			JLabel lblBirthday = new JLabel("생년월일");
			lblBirthday.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblBirthday);
		}
		{
			tfBirthday = new JTextField();
			contentPanel.add(tfBirthday);
			tfBirthday.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(10, 0, 15, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("취소");
				cancelButton.addActionListener(this);
				cancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				okButton = new JButton("확인");
				okButton.addActionListener(this);
				okButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			try {
				okButtonActionPerformed(e);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "아래와 같은 형식으로 작성해주시기 바랍니다.\n아이디:test@test.com\n이름: 홍길동\n생년월일 : 1900-01-01");
				clearTf();
			}
		}
		if (e.getSource() == cancelButton) {
			cancelButtonActionPerformed(e);
		}
	}
	protected void cancelButtonActionPerformed(ActionEvent e) {
		setVisible(false);
	}
	protected void okButtonActionPerformed(ActionEvent e) throws ParseException {
		try {
			validCheck();
			String id = tfId.getText().trim();
			String name = tfName.getText().trim();
			String tfBrtdy = tfBirthday.getText().trim();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = sdf.parse(tfBrtdy);
			
			findMber = service.showMemberPw(new Member(id, name, birthday));
			findLib = service.showLibPw(new Librarian(id, name, birthday));
			
			if(findMber == null) {
				if(findLib == null) {
					JOptionPane.showMessageDialog(null, "등록되지 않은 아이디입니다.");
					clearTf();
					return;
				}
				JOptionPane.showMessageDialog(null, findLib.getLbName()+"님의 패스워드는 [ "+findLib.getLbPass()+" ] 입니다.");
				clearTf();
			}
			
			JOptionPane.showMessageDialog(null, findMber.getMberName()+"님의 패스워드는 [ "+findMber.getMberPass()+" ] 입니다.");
			clearTf();
			
			
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void clearTf() {
		tfId.setText("");
		tfName.setText("");
		tfBirthday.setText("");
	}
	
	private void validCheck() {
		if(tfId.getText().contentEquals("") || tfName.getText().contentEquals("") || tfBirthday.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
	}
}
