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
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class MemberJoinUIPanel extends JPanel implements ActionListener {
	private MemberUIService service;
	private MemberJoinPanel pMember;
	private MemberTblPanel pMemberList;

	private JButton btnAdd;
	private JButton btnCancel;

	public MemberJoinUIPanel() {
		service = new MemberUIService();
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(40, 40, 40, 40));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pContent = new JPanel();
		add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));

		pMember = new MemberJoinPanel();
		pMember.setService(service);
		pContent.add(pMember, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pBtns.setBorder(new EmptyBorder(10, 0, 0, 0));
		pBtns.setBackground(Color.WHITE);
		add(pBtns);

		btnAdd = new JButton("저장");
		btnAdd.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnAdd.setPreferredSize(new Dimension(80, 30));
		btnAdd.addActionListener(this);
		pBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnCancel.setPreferredSize(new Dimension(80, 30));
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			btnAddAction(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelAction(e);
		}
	}

	private void btnCancelAction(ActionEvent e) {
		pMember.clearTf();

	}

	private void btnAddAction(ActionEvent e) {
	if(pMember.getLblPWCheck().getText().equals("비밀번호 불일치") || pMember.getPfPW2().getPassword().length==0) {
		JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
		return;
	}else {
		try {
			Member newMem = pMember.getItem();
			service.addMember(newMem);
			// pMemberList.addItem(newMem);
			pMember.clearTf();
			JOptionPane.showMessageDialog(null, String.format("%s님 회원등록이 완료되었습니다.", newMem.getMberId()));
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	}

}
