package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.ui.content.LibrarianModifyPanel;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.service.LibrarianService;

@SuppressWarnings("serial")
public class LibrarianProfileModifyPanel extends JPanel implements ActionListener{
	private LibrarianService service;
	private LibrarianModifyPanel pLib;
	private JButton btnAdd;
	private JButton btnCancel;
	
	public LibrarianProfileModifyPanel() {
		service = new LibrarianService();
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
		
		pLib = new LibrarianModifyPanel();
		pContent.add(pLib, BorderLayout.CENTER);
		
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
	
	public LibrarianModifyPanel getpMember() {
		return pLib;
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
		pLib.clearTf();
		
	}

	private void btnAddAction(ActionEvent e) {
		try {
			Librarian updateLib = pLib.getItem();
			JOptionPane.showMessageDialog(null, new ImageIcon(updateLib.getLbImg()));
			service.modifyLibrarian(updateLib);
			JOptionPane.showMessageDialog(null, String.format("%s님의 프로필 수정이 완료되었습니다.", updateLib.getLbId()));
		}catch(InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}catch(SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void initTf(Librarian lib) {
		pLib.getTfID().setText(lib.getLbId());
		pLib.getTfName().setText(lib.getLbName());
		pLib.getPfPW1().setText(lib.getLbPass());
		pLib.getTfBirthday().setDate(lib.getLbBirthDay());
		pLib.getTfTel().setText(lib.getLbTel());
		pLib.getTfZip().setText(lib.getLbZip().getZipCode()+"");
		pLib.getTfAddress().setText(lib.getLbBassAd());
		pLib.getTfDetailAdress().setText(lib.getLbDetailAd());
		ImageIcon icon = lib.getLbImg()==null?(ImageIcon)pLib.getLblPic().getIcon():new ImageIcon(lib.getLbImg());
		pLib.setPicImageIcon(icon);
		pLib.getTfID().setEditable(false);
	}

}
