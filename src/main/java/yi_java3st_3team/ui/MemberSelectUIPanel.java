package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.dialog.MemberUpdateDialog;
import yi_java3st_3team.ui.list.MemberTblPanel;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberSelectUIPanel extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private MemberUIService service;
	private JButton btnSearch;
	private MemberTblPanel pMemberList;
	private JRadioButton radioBtnID;
	private JRadioButton radioBtnName;
	private JRadioButton radioBtnBirthday;
	private MemberUpdateDialog updateDialog;

	public MemberSelectUIPanel() {
		service = new MemberUIService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pNorth.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(30);
		add(pNorth, BorderLayout.NORTH);
		
		radioBtnID = new JRadioButton("회원ID");
		radioBtnID.setFont(new Font("굴림", Font.PLAIN, 11));
		pNorth.add(radioBtnID);
		
		radioBtnName = new JRadioButton("회원이름");
		radioBtnName.setFont(new Font("굴림", Font.PLAIN, 11));
		pNorth.add(radioBtnName);
		
		radioBtnBirthday = new JRadioButton("생년월일");
		radioBtnBirthday.setFont(new Font("굴림", Font.PLAIN, 11));
		pNorth.add(radioBtnBirthday);
		
		tfSearch = new JTextField();
		pNorth.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pNorth.add(btnSearch);
		
		JPanel pList = new JPanel();
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		pMemberList = new MemberTblPanel();
		pMemberList.loadData(service.showMemberListAll());
		pMemberList.setPopupMenu(createPop());
		pList.add(pMemberList, BorderLayout.CENTER);
	}

	private JPopupMenu createPop() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);
		
		JMenuItem authorityItem = new JMenuItem("권한변경");
		authorityItem.addActionListener(myPopMenuListener);
		popMenu.add(authorityItem);
		
		return popMenu;
	}
	
	
	ActionListener myPopMenuListener = new ActionListener() {
		private JFrame updateFrame;

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getActionCommand().contentEquals("수정")) {
					
					updateDialog = new MemberUpdateDialog(updateFrame, "회원정보 수정");
					//updateDialog.setBounds(100,100,454,430);
					updateDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					updateDialog.setVisible(true);
					
					pMemberList.loadData(service.showMemberListAll());
				
				}
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};

	public MemberSelectUIPanel(MemberUIService service) {
		this.service = service;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		
	}
}
