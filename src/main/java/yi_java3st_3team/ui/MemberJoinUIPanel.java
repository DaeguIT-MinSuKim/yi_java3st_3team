package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberJoinPanel;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.list.MemberTblPanel;
import yi_java3st_3team.ui.service.MemberUIService;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class MemberJoinUIPanel extends JPanel implements ActionListener{
	private MemberUIService service;
	private MemberJoinPanel pMember;
	private MemberTblPanel pMemberList;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;

	public MemberJoinUIPanel() {
		service = new MemberUIService();
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panel = new JPanel();
		add(panel);
		
		panel_2 = new JPanel();
		add(panel_2);
		
		panel_4 = new JPanel();
		add(panel_4);
		
		JPanel pContent = new JPanel();
		add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));
		
		pMember = new MemberJoinPanel();
		pMember.setService(service);
		pContent.add(pMember, BorderLayout.CENTER);
		
		panel_6 = new JPanel();
		add(panel_6);
		
		panel_7 = new JPanel();
		add(panel_7);
		
		JPanel pBtns = new JPanel();
		add(pBtns);
		
		btnAdd = new JButton("저장");
		btnAdd.addActionListener(this);
		pBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		panel_1 = new JPanel();
		add(panel_1);
		
		panel_3 = new JPanel();
		add(panel_3);
		
		panel_5 = new JPanel();
		add(panel_5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			btnAddAction(e);
		}
		if(e.getSource() == btnCancel) {
			btnCancelAction(e);
		}
	}

	private void btnCancelAction(ActionEvent e) {
		pMember.clearTf();
		
	}

	private void btnAddAction(ActionEvent e) {
		try{
			Member newMem = pMember.getItem();
			service.addMember(newMem);
		//	pMemberList.addItem(newMem);
			pMember.clearTf();
			JOptionPane.showMessageDialog(null, String.format("%s님 회원가입이 완료되었습니다.", newMem.getMberId()));
		}catch(InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

}
