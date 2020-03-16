package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.ui.content.MemberSendMailDialog;
import yi_java3st_3team.ui.list.OverdueMemList;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class OverdueUIPanel extends JPanel implements ActionListener {
	private JButton btnSelAll;
	private OverdueMemList pCenter;
	private boolean allChk;
	private JButton btnSendMail;
	private MemberSendMailDialog dlgSendMail;
	private LendingUiService service;
	public OverdueUIPanel() {
		initialize();
	}
	private void initialize() {
		service = new LendingUiService();
		setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		pNorth.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblTitle = new JLabel("연체회원 목록");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pNorth.add(lblTitle);
		
		JPanel pDummy = new JPanel();
		pNorth.add(pDummy);
		
		btnSelAll = new JButton("모두선택");
		btnSelAll.addActionListener(this);
		pNorth.add(btnSelAll);
		
		pCenter = new OverdueMemList();
		List<Lending> list = service.showOverDueList();
		if(list!=null) {
			pCenter.loadData(list);
		}
		pCenter.setBackground(Color.WHITE);
		add(pCenter, BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);
		
		btnSendMail = new JButton("메일 보내기");
		btnSendMail.addActionListener(this);
		pSouth.add(btnSendMail);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSendMail) {
			btnSendMailActionPerformed(e);
		}
		if (e.getSource() == btnSelAll) {
			btnSelAllActionPerformed(e);
		}
	}
	protected void btnSelAllActionPerformed(ActionEvent e) {
		TableModel model = pCenter.getTable().getModel();
		if(!allChk) {
			for(int i=0;i<model.getRowCount();i++) {
				model.setValueAt(true, i, 8);
			}
			allChk = true;
		}
		else {
			for(int i=0;i<model.getRowCount();i++) {
				model.setValueAt(false, i, 8);
			}
			allChk = false;
		}
	}
	protected void btnSendMailActionPerformed(ActionEvent e) {
		TableModel model = pCenter.getTable().getModel();
		for(int i=0;i<model.getRowCount();i++) {
			if((boolean)model.getValueAt(i, 8)) {
				int res = JOptionPane.showConfirmDialog(null, (String)model.getValueAt(i, 3)+"님께 메일을 보내시겠습니까?");
				if(res==0) {
					dlgSendMail = new MemberSendMailDialog();
					dlgSendMail.setModal(true);
					dlgSendMail.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
				}
			}
		}
	}
}
