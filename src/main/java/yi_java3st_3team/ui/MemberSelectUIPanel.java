package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Book;
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
	private JFrame updateFrame;
	private Member member;

	public MemberSelectUIPanel() {
		service = new MemberUIService();
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		pNorth.setBorder(new EmptyBorder(20, 0, 20, 0));
		FlowLayout flowLayout = (FlowLayout) pNorth.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(30);
		add(pNorth, BorderLayout.NORTH);

		radioBtnID = new JRadioButton("회원ID");
		radioBtnID.setFont(new Font("굴림", Font.PLAIN, 14));
		pNorth.add(radioBtnID);

		radioBtnName = new JRadioButton("회원이름");
		radioBtnName.setFont(new Font("굴림", Font.PLAIN, 14));
		pNorth.add(radioBtnName);

		radioBtnBirthday = new JRadioButton("생년월일");
		radioBtnBirthday.setFont(new Font("굴림", Font.PLAIN, 14));
		pNorth.add(radioBtnBirthday);

		tfSearch = new JTextField();
		pNorth.add(tfSearch);
		tfSearch.setColumns(20);

		btnSearch = new JButton("검색");
		btnSearch.setBackground(Color.ORANGE);
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 14));
		btnSearch.addActionListener(this);
		pNorth.add(btnSearch);

		JPanel pList = new JPanel();
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pMemberList = new MemberTblPanel();
		pMemberList.setBorder(new EmptyBorder(10, 0, 0, 0));
		loadData();
		pMemberList.setPopupMenu(createPop());
		pList.add(pMemberList, BorderLayout.CENTER);
	}

	public void loadData() {
		pMemberList.loadData(service.showMemberListAll());
	}

	private JPopupMenu createPop() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("회원정보 수정");

		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("탈퇴여부 설정");

		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);

		JMenuItem authorityItem = new JMenuItem("대여권한 설정");

		authorityItem.addActionListener(myPopMenuListener);
		popMenu.add(authorityItem);

		return popMenu;
	}

	ActionListener myPopMenuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getActionCommand().contentEquals("회원정보 수정")) {

					Member upMember = pMemberList.getSelectedItem();
					
				
					updateDialog = new MemberUpdateDialog(updateFrame, "회원정보 수정");
					updateDialog.setItem(upMember);
					updateDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					updateDialog.setVisible(true);

					loadData();
					
				}
				
				if(e.getActionCommand().contentEquals("탈퇴여부 설정")) {
					Member upMember = pMemberList.getSelectedItem();
					
					int result = JOptionPane.showConfirmDialog(null, "탈퇴상태로 바꾸시겠습니까?", "탈퇴여부 설정", JOptionPane.YES_NO_OPTION);
					
					if(result == JOptionPane.CLOSED_OPTION) {
						loadData();
					} else if(result == JOptionPane.YES_OPTION) {
						service.updateByWdrCdt(upMember);
						loadData();
						
					} else {
						loadData();
					} 

				}
				if(e.getActionCommand().contentEquals("대여권한 설정")) {
					int result = JOptionPane.showConfirmDialog(null, "대여권한을 변경하시겠습니까?", "대여권한 변경", JOptionPane.YES_NO_OPTION);
					
				}
				
				}
			catch (Exception e1) {
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
			Member member = new Member();
			
			try {
				if(radioBtnID.isSelected()) {
					
				}
			}catch (Exception e1) {
			}
	}
}

