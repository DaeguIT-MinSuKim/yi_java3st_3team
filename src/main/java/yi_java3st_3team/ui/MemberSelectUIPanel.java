package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
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
import javax.swing.table.TableCellRenderer;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.dialog.MemberUpdateDialog;
import yi_java3st_3team.ui.list.MemberTblPanel;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberSelectUIPanel extends JPanel implements ActionListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
	private TableCellRenderer cellRender;

	public MemberSelectUIPanel() {
		service = new MemberUIService();
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		pNorth.setBorder(new EmptyBorder(10, 0, 5, 0));
		FlowLayout flowLayout = (FlowLayout) pNorth.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(30);
		add(pNorth, BorderLayout.NORTH);

		radioBtnID = new JRadioButton("회원ID");
		radioBtnID.setSelected(true);
		radioBtnID.setBackground(Color.WHITE);
		radioBtnID.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pNorth.add(radioBtnID);
		buttonGroup.add(radioBtnID);

		radioBtnName = new JRadioButton("회원이름");
		radioBtnName.setBackground(Color.WHITE);
		radioBtnName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pNorth.add(radioBtnName);
		buttonGroup.add(radioBtnName);

		radioBtnBirthday = new JRadioButton("생년월일");
		radioBtnBirthday.setBackground(Color.WHITE);
		radioBtnBirthday.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pNorth.add(radioBtnBirthday);
		buttonGroup.add(radioBtnBirthday);

		tfSearch = new JTextField();
		tfSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pNorth.add(tfSearch);
		tfSearch.setColumns(20);

		btnSearch = new JButton("검색");
		btnSearch.setPreferredSize(new Dimension(80, 30));
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setBackground(Color.ORANGE);
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnSearch.addActionListener(this);
		pNorth.add(btnSearch);

		pList = new JPanel();
		pList.setBorder(new EmptyBorder(0, 20, 10, 20));
		pList.setBackground(Color.WHITE);
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pMemberList = new MemberTblPanel();
		pMemberList.setBackground(Color.WHITE);
		loadData();
		pMemberList.setPopupMenu(createPop());
		pMemberList.setBorder(new EmptyBorder(10, 0, 0, 0));
		pList.add(pMemberList, BorderLayout.CENTER);

	}

	public void loadData() {
		pMemberList.loadData(service.showMemberListAll());
		radioBtnID.setSelected(true);
		tfSearch.setText("");

	}

	private JPopupMenu createPop() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("회원정보 수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);

		JMenuItem wdrCdtItem = new JMenuItem("탈퇴여부 설정");
		wdrCdtItem.addActionListener(myPopMenuListener);
		popMenu.add(wdrCdtItem);

		JMenuItem authorityItem = new JMenuItem("대여권한 설정");
		authorityItem.addActionListener(myPopMenuListener);
		popMenu.add(authorityItem);

		return popMenu;
	}

	ActionListener myPopMenuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getActionCommand().contentEquals("회원정보 수정")) {
					Member upMember = pMemberList.getSelectedItem();

					updateDialog = new MemberUpdateDialog(updateFrame, "회원정보 수정");
					updateDialog.setItem(upMember);
					updateDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					updateDialog.setVisible(true);

					loadData();

				}

				if (e.getActionCommand().contentEquals("탈퇴여부 설정")) {
					Member upMember = pMemberList.getSelectedItem();

					if (upMember.getWdrCdt() == 0) {
						int dropOut = JOptionPane.showConfirmDialog(null, "탈퇴상태로 바꾸시겠습니까?", "탈퇴여부 설정",
								JOptionPane.YES_NO_OPTION);

						if (dropOut == JOptionPane.CLOSED_OPTION) {
							loadData();
						} else if (dropOut == JOptionPane.YES_OPTION) {
							upMember.setWdrCdt(1);
							service.updateByWdrCdt(upMember);
							loadData();
						}
					} else if (upMember.getWdrCdt() == 1) {

						int reJoin = JOptionPane.showConfirmDialog(null, "탈퇴회원입니다. 다시 가입으로 바꾸시겠습니까?", "재가입여부 설정",
								JOptionPane.YES_NO_OPTION);

						if (reJoin == JOptionPane.CLOSED_OPTION) {
							loadData();
						} else if (reJoin == JOptionPane.YES_OPTION) {
							upMember.setWdrCdt(0);
							service.updateByWdrCdt(upMember);
							loadData();
						}
					}

				}

				if (e.getActionCommand().contentEquals("대여권한 설정")) {
					Member upMember = pMemberList.getSelectedItem();

					int result = JOptionPane.showConfirmDialog(null, "대여권한을 변경하시겠습니까?", "대여권한 변경",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION && upMember.getLendPsbCdt() == 0) {
						upMember.setLendPsbCdt(1);
						service.updateByWdrCdt(upMember);
						loadData();
					} else if (result == JOptionPane.YES_OPTION && upMember.getLendPsbCdt() == 1) {
						upMember.setLendPsbCdt(0);
						upMember.setOdCnt(0);
						service.updateByWdrCdt(upMember);
						loadData();
					} else if (result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {
						loadData();
					}
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};
	private JPanel pList;

	public MemberSelectUIPanel(MemberUIService service) {
		this.service = service;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
	}

	public void notCheck() {
		if (!radioBtnID.isSelected() && !radioBtnName.isSelected() && !radioBtnBirthday.isSelected()) {
			JOptionPane.showMessageDialog(null, "체크박스를 선택해주세요.");
		}
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		Member member = new Member();
		notCheck();

		try {
			if (radioBtnID.isSelected()) {
				member.setMberId(tfSearch.getText());
				pMemberList.loadData(service.searchMemberByID(member));
			}

			if (radioBtnName.isSelected()) {
				member.setMberName(tfSearch.getText());
				pMemberList.loadData(service.searchMemberByName(member));
			}

			if (radioBtnBirthday.isSelected()) {
				member.setMberBrthdy(new SimpleDateFormat("yyyy-MM-dd").parse(tfSearch.getText().trim()));
				pMemberList.loadData(service.searchMemberByBirtyday(member));
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "찾는 회원이 없습니다.");
		}
	}
}
