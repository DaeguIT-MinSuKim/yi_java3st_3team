package yi_java3st_3team.ui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.ui.list.MberBookSearchTblPanel;
import yi_java3st_3team.ui.service.BookUiService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MemberBookSearchPanel extends JPanel implements ActionListener {
	private JTextField tfName;
	private JTextField tfAuthr;
	private MberBookSearchTblPanel pBookList;
	private BookUiService service;
	private JButton button;
	private JFrame frame1;
	private JComboBox<LargeClassification> cmbCat;
	private JButton btnSearch;

	public MemberBookSearchPanel() {
		service = new BookUiService();
		initialize();
	}

	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BoxLayout(pNorth, BoxLayout.Y_AXIS));

		JPanel pSearch = new JPanel();
		pSearch.setBackground(Color.WHITE);
		pSearch.setBorder(new EmptyBorder(50, 150, 20, 150));
		pNorth.add(pSearch);
		pSearch.setLayout(new GridLayout(0, 3, 30, 0));

		JPanel pName = new JPanel();
		pName.setBackground(Color.WHITE);
		pSearch.add(pName);
		pName.setLayout(new BoxLayout(pName, BoxLayout.X_AXIS));

		JLabel lblName = new JLabel("도서명");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblName.setBorder(new EmptyBorder(0, 0, 0, 20));
		pName.add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pName.add(tfName);
		tfName.setColumns(10);

		JPanel pAuthr = new JPanel();
		pAuthr.setBackground(Color.WHITE);
		pSearch.add(pAuthr);
		pAuthr.setLayout(new BoxLayout(pAuthr, BoxLayout.X_AXIS));

		JLabel lblAuthr = new JLabel("저자");
		lblAuthr.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblAuthr.setBorder(new EmptyBorder(0, 0, 0, 20));
		pAuthr.add(lblAuthr);

		tfAuthr = new JTextField();
		tfAuthr.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pAuthr.add(tfAuthr);
		tfAuthr.setColumns(10);

		JPanel pCat = new JPanel();
		pCat.setBackground(Color.WHITE);
		pSearch.add(pCat);
		pCat.setLayout(new BoxLayout(pCat, BoxLayout.X_AXIS));

		JLabel lblCat = new JLabel("분류");
		lblCat.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCat.setBorder(new EmptyBorder(0, 0, 0, 20));
		pCat.add(lblCat);

		cmbCat = new JComboBox<>();
		cmbCat.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		pCat.add(cmbCat);

		JPanel pBtns = new JPanel();
		pBtns.setBackground(Color.WHITE);
		pNorth.add(pBtns);

		button = new JButton("상세보기");
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(150, 40));
		button.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pBtns.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(10, 0));
		pBtns.add(lblNewLabel);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setPreferredSize(new Dimension(150, 40));
		btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pBtns.add(btnSearch);

		JPanel pList = new JPanel();
		pList.setBackground(Color.WHITE);
		pList.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		pBookList = new MberBookSearchTblPanel();
		pBookList.setBackground(Color.WHITE);
		pBookList.loadData(service.showBookAllOnMber());
		pList.add(pBookList, BorderLayout.CENTER);

		setService(service);
	}
	
	public void loadData() {
		pBookList.loadData(service.showBookAllOnMber());
		cmbCat.setSelectedIndex(-1);
		tfAuthr.setText("");
		tfName.setText("");
	}

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
		if (e.getSource() == button) {
			buttonActionPerformed(e);
		}
	}

	protected void buttonActionPerformed(ActionEvent e) {
		try {
			Book bookInfoItem = pBookList.getSelectedItem();
			BookInfoPanel bookInfo = new BookInfoPanel();
			bookInfo.setItem(bookInfoItem);

			if (frame1 == null) {
				frame1 = new JFrame();
				frame1.setTitle("[" + bookInfoItem.getBookName() + "]의 상세 정보");
				frame1.setBounds(100, 100, 800, 600);
				frame1.getContentPane().add(bookInfo);
				frame1.setVisible(true);
			} else {
				if (frame1.isVisible()) {
					return;
				}
				frame1.removeAll();
				frame1 = new JFrame();
				frame1.setTitle("[" + bookInfoItem.getBookName() + "]의 상세 정보");
				frame1.setBounds(100, 100, 800, 600);
				frame1.getContentPane().add(bookInfo);
				frame1.setVisible(true);
			}
		} catch (RuntimeException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		Book book = new Book();

		try {
			
			if (tfName.getText().length() != 0) {
				book.setBookName(tfName.getText());
			}
			if (tfAuthr.getText().length() != 0) {
				book.setAuthrName(tfAuthr.getText());
			}

			if (cmbCat.getSelectedIndex() > -1) {
				book.setLcNo((LargeClassification) cmbCat.getSelectedItem());
			}
			
			pBookList.loadData(service.searchBookOnMber(book));
			cmbCat.setSelectedIndex(-1);
			
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "찾는 도서가 없습니다");
		}
	}
}
