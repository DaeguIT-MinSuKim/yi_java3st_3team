package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import yi_java3st_3team.ui.list.MemberTblPanel;
import yi_java3st_3team.ui.service.MemberUIService;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class MemberSelectUIPanel extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private MemberUIService service;
	private JButton btnSearch;
	private MemberTblPanel pMemberList;
	private JRadioButton radioBtnID;
	private JRadioButton radioBtnName;
	private JRadioButton radioBtnBirthday;

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
		pMemberList.setPopupMenu(createPop());
		pList.add(pMemberList, BorderLayout.CENTER);
		//pMemberList.setLayout(new BorderLayout(0, 0));
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
		@Override
		public void actionPerformed(ActionEvent e) {
			
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
