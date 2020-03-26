package yi_java3st_3team.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.ui.dialog.BookUpdateDialog;
import yi_java3st_3team.ui.panel.content.BookUpdatePanel;
import yi_java3st_3team.ui.panel.list.BookTblPanel;
import yi_java3st_3team.ui.service.BookUiService;

@SuppressWarnings("serial")
public class BookManagerPanel extends JPanel implements ActionListener {
	private JTextField tfSearchBar;
	private BookTblPanel pBookList;
	private BookUiService service;
	private JComboBox<LargeClassification> cmbCat;
	private JButton btnSearch;
	private JRadioButton rdoBookCode;
	private JRadioButton rdoBookName;
	private ButtonGroup rdoGroup;
	private JPanel pList;
	private JFrame updateFrame;
	private JFrame disuseFrame;

	public BookManagerPanel() {
		service = new BookUiService();
		initialize();
	}

	private void initialize() {
		setBorder(new EmptyBorder(20, 0, 0, 0));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JPanel pSearch = new JPanel();
		pSearch.setBackground(Color.WHITE);
		add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel pOptions = new JPanel();
		pOptions.setBackground(Color.WHITE);
		pOptions.setBorder(new EmptyBorder(20, 130, 20, 0));
		pSearch.add(pOptions);
		pOptions.setLayout(new GridLayout(0, 3, 0, 0));

		rdoGroup = new ButtonGroup();

		rdoBookCode = new JRadioButton("도서코드");
		rdoBookCode.setBackground(Color.WHITE);
		rdoBookCode.setSelected(true);
		rdoBookCode.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOptions.add(rdoBookCode);

		rdoBookName = new JRadioButton("도서명");
		rdoBookName.setBackground(Color.WHITE);
		rdoBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOptions.add(rdoBookName);

		rdoGroup.add(rdoBookCode);
		rdoGroup.add(rdoBookName);

		cmbCat = new JComboBox<>();
		cmbCat.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOptions.add(cmbCat);

		JPanel pBars = new JPanel();
		pBars.setBackground(Color.WHITE);
		pBars.setBorder(new EmptyBorder(20, 0, 20, 100));
		pSearch.add(pBars);
		pBars.setLayout(new BoxLayout(pBars, BoxLayout.X_AXIS));

		tfSearchBar = new JTextField();
		tfSearchBar.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pBars.add(tfSearchBar);
		tfSearchBar.setColumns(10);

		JPanel pSearchBtns = new JPanel();
		pSearchBtns.setBorder(new EmptyBorder(0, 10, 0, 0));
		pBars.add(pSearchBtns);
		pSearchBtns.setLayout(new GridLayout(0, 1, 0, 0));

		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnSearch.setPreferredSize(new Dimension(80, 20));
		pSearchBtns.add(btnSearch);

		pList = new JPanel();
		pList.setBorder(new EmptyBorder(10, 20, 10, 20));
		pList.setBackground(Color.WHITE);
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));

		pBookList = new BookTblPanel();
		pBookList.setBackground(Color.WHITE);
		pBookList.loadData(service.showBookListAll());
		pBookList.setPopupMenu(createPopupMenu());
		pList.add(pBookList, BorderLayout.CENTER);

		btnSearch.addActionListener(this);
		setService(service);
	}
	
	public void loadData() {
		pBookList.loadData(service.showBookListAll());
		rdoBookCode.setSelected(true);
		cmbCat.setSelectedIndex(-1);
		tfSearchBar.setText("");
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("도서정보수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem disuseItem = new JMenuItem("도서폐기");
		disuseItem.addActionListener(myPopMenuListener);
		popMenu.add(disuseItem);
		
		JMenuItem deleteItem = new JMenuItem("도서삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	ActionListener myPopMenuListener = new ActionListener() {
		private BookUpdateDialog updateDialog;

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getActionCommand().contentEquals("도서정보수정")) {
					Book upBook = pBookList.getSelectedItem();
					BookUpdatePanel upBookPanel = new BookUpdatePanel();
					upBookPanel.setItem(upBook);
					
					updateDialog = new BookUpdateDialog(updateFrame, "도서정보수정");
					updateDialog.setBounds(100, 100, 1000, 600);
					updateDialog.getContentPane().add(upBookPanel);
					updateDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					updateDialog.setVisible(true);
					
					pBookList.loadData(service.showBookListAll());
				}
				
				if(e.getActionCommand().contentEquals("도서폐기")) {
					Book dsuseBook = pBookList.getSelectedItem();
					
					int result = JOptionPane.showConfirmDialog(null, "선택된 도서를 폐기하겠습니까?", "도서폐기확인", JOptionPane.YES_NO_OPTION);
					
					if(result == JOptionPane.CLOSED_OPTION) {
						pBookList.loadData(service.showBookListAll());
					} else if(result == JOptionPane.YES_OPTION) {
						dsuseBook.setDsuseCdt(1);
						service.modifyBook(dsuseBook);
						pBookList.loadData(service.showBookListAll());
					} else {
						dsuseBook.setDsuseCdt(0);
						service.modifyBook(dsuseBook);
						
						pBookList.loadData(service.showBookListAll());
					} 
				}
				
				if(e.getActionCommand().contentEquals("도서삭제")) {
					Book deleteBook = pBookList.getSelectedItem();
					
					int result = JOptionPane.showConfirmDialog(null, "선택된 도서 데이터를 삭제하겠습니까?", "도서삭제확인", JOptionPane.YES_NO_OPTION);
						
					if(result == JOptionPane.CLOSED_OPTION) {
						
					} else if (result == JOptionPane.YES_OPTION) {
						service.removeBook(deleteBook);
						pBookList.loadData(service.showBookListAll());
					} else {
						
					}
				}
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};
	
	public void setService(BookUiService service) {
		this.service = service;
		setCmbLcList(service.showLcList());
	}

	public void setCmbLcList(List<LargeClassification> lcList) {
		DefaultComboBoxModel<LargeClassification> model = new DefaultComboBoxModel<LargeClassification>(
				new Vector<>(lcList));
		cmbCat.setModel(model);
		cmbCat.setSelectedIndex(-1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		Book book = new Book();

		try {
			if (rdoBookCode.isSelected()) {
				if (cmbCat.getSelectedIndex() > -1) {
					book.setBookCode(tfSearchBar.getText());
					book.setLcNo((LargeClassification) cmbCat.getSelectedItem());
					pBookList.loadData(service.searchBookCodeAndCat(book));
				} else {
					book.setBookCode(tfSearchBar.getText());
					pBookList.loadData(service.searchBookCodeAndCat(book));
				}
			}

			if (rdoBookName.isSelected()) {
				if (cmbCat.getSelectedIndex() > -1) {
					book.setBookName(tfSearchBar.getText());
					book.setLcNo((LargeClassification) cmbCat.getSelectedItem());
					pBookList.loadData(service.searchBookNameAndCat(book));
				} else {
					book.setBookName(tfSearchBar.getText());
					pBookList.loadData(service.searchBookNameAndCat(book));
				}
			}
			
			cmbCat.setSelectedIndex(-1);
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "찾는 도서가 없습니다");
			cmbCat.setSelectedIndex(-1);
		}

	}
}
