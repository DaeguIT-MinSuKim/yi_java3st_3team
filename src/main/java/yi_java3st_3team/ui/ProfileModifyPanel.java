package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberJoinPanel;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.list.MemberTblPanel;
import yi_java3st_3team.ui.service.MemberUIService;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ProfileModifyPanel extends JPanel implements ActionListener{
	private MemberUIService service;
	private MemberJoinPanel pMember;
	private JButton btnAdd;
	private JButton btnCancel;
	
	public ProfileModifyPanel() {
		service = new MemberUIService();
		initialize();
	}

	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel pContent = new JPanel();
		pContent.setBackground(Color.WHITE);
		add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));
		
		pMember = new MemberJoinPanel();
		pMember.setService(service);
		pContent.add(pMember, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		pBtns.setBackground(Color.WHITE);
		add(pBtns);
		
		btnAdd = new JButton("저장");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}
	
	public MemberJoinPanel getpMember() {
		return pMember;
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
		try {
			Member updateMem = pMember.getItem();
			service.updateByWdrCdt(updateMem);
			JOptionPane.showMessageDialog(null, String.format("%s님의 프로필 수정이 완료되었습니다.", updateMem.getMberId()));
		}catch(InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	public void initTf(Member member) {
		pMember.getTfID().setText(member.getMberId());
		pMember.getTfName().setText(member.getMberName());
		pMember.getPfPW1().setText(member.getMberPass());
		pMember.getTfBirthday().setDate(member.getMberBrthdy());
		pMember.getTfTel().setText(member.getMberTel());
		pMember.getTfZip().setText(member.getMberZip().getZipCode()+"");
		pMember.getTfAddress().setText(member.getMberBassAd());
		pMember.getTfDetailAdress().setText(member.getMberDetailAd());
		ImageIcon icon = new ImageIcon(member.getMberImg());
		pMember.setPicImageIcon(icon);
		pMember.getTfID().setEditable(false);
	}

}
