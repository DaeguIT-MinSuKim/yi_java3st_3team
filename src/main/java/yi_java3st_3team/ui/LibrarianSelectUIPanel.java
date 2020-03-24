package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.plaf.PanelUI;

import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.ui.dialog.LibrarianAddDialog;
import yi_java3st_3team.ui.dialog.LibrarianUpdateDialog;
import yi_java3st_3team.ui.list.LibrarianTblPanel;
import yi_java3st_3team.ui.service.LibrarianUIService;

@SuppressWarnings("serial")
public class LibrarianSelectUIPanel extends JPanel implements ActionListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfSearch;
	private LibrarianTblPanel pLibrarianList;
	private LibrarianUIService service;
	private JButton btnSearch;
	private JRadioButton radioId;
	private JRadioButton radioName;
	private JPanel pList;
	private JButton btnAdd;
	private LibrarianUpdateDialog updateDialog;
	private LibrarianAddDialog AddDialog;
	private JFrame updateFrame;

	public LibrarianSelectUIPanel() {
		service = new LibrarianUIService();
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(30, 20, 10, 20));
		setLayout(new BorderLayout(0, 0));
		pLibrarianList = new LibrarianTblPanel();
		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

		radioId = new JRadioButton("사서ID");
		radioId.setSelected(true);
		radioId.setBackground(Color.WHITE);
		radioId.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pNorth.add(radioId);

		radioName = new JRadioButton("사서이름");
		radioName.setBackground(Color.WHITE);
		radioName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pNorth.add(radioName);
		
		buttonGroup.add(radioId);
		buttonGroup.add(radioName);

		tfSearch = new JTextField();
		tfSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pNorth.add(tfSearch);
		tfSearch.setColumns(20);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setForeground(Color.BLACK);
//		btnSearch.setBackground(Color.ORANGE);
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnSearch.setPreferredSize(new Dimension(80, 30));
		pNorth.add(btnSearch);
		
		btnAdd = new JButton("등록");
		btnAdd.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnAdd.addActionListener(this);
		btnAdd.setForeground(Color.BLACK);
//		btnAdd.setBackground(new Color(245, 222, 179));
		btnAdd.setPreferredSize(new Dimension(80, 30));
		pNorth.add(btnAdd);

		pList = new JPanel();
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pLibrarianList = new LibrarianTblPanel();
		pLibrarianList.setBackground(Color.WHITE);
		loadData();
		pLibrarianList.setPopupMenu(createPop());
		pLibrarianList.setBorder(new EmptyBorder(10, 0, 0, 0));
		pList.add(pLibrarianList, BorderLayout.CENTER);
	}
	

	public void loadData() {
		pLibrarianList.loadData(service.showLibrarianListAll());
		radioId.setSelected(true);
		tfSearch.setText("");
	}

	private JPopupMenu createPop() {
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPop);
		popMenu.add(updateItem);
		
		return popMenu;
	}
	
	ActionListener myPop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getActionCommand().contentEquals("수정")) {
					Librarian updateLib = pLibrarianList.getSelectedItem();
					
					updateDialog = new LibrarianUpdateDialog(updateFrame, "");
					updateDialog.setItem(updateLib);
					//updateDialog.setSelectUI(this);
					updateDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					updateDialog.setVisible(true);
					
					loadData();
				}
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
		if(e.getSource() ==btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	
	public void notCheck() {
		if(!radioId.isSelected() && !radioName.isSelected()) {
			JOptionPane.showMessageDialog(null, "체크박스를 선택해주세요.");
		}
	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		AddDialog = new LibrarianAddDialog(updateFrame, "");
		AddDialog.setSelectUI(this);
		AddDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		AddDialog.setVisible(true);
	}
	
	protected void btnSearchActionPerformed(ActionEvent e) {
		Librarian lib = new Librarian();
		
		notCheck();
		
		try {
			if(radioId.isSelected()) {
				lib.setLbId(tfSearch.getText().trim());
				if(service.searchLibrarianByID(lib).isEmpty()) {
					JOptionPane.showMessageDialog(null, "찾는 사서가 없습니다");
				}else {
					pLibrarianList.loadData(service.searchLibrarianByID(lib));
				}
				radioId.setSelected(false);
			}
			
			if(radioName.isSelected()) {
				lib.setLbName(tfSearch.getText().trim());
				if(service.searchLibrarianByName(lib).isEmpty()) {
					JOptionPane.showMessageDialog(null, "찾는 사서가 없습니다");
				}else {
					pLibrarianList.loadData(service.searchLibrarianByName(lib));
				}
				radioName.setSelected(false);
			}
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

}
