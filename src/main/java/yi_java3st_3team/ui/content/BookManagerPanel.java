package yi_java3st_3team.ui.content;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

public class BookManagerPanel extends JPanel {
	private JTextField tfSearchBar;

	public BookManagerPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel pOptions = new JPanel();
		pOptions.setBorder(new EmptyBorder(20, 130, 20, 0));
		pSearch.add(pOptions);
		pOptions.setLayout(new GridLayout(0, 3, 0, 0));
		
		JRadioButton rdoBookCode = new JRadioButton("도서코드");
		rdoBookCode.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOptions.add(rdoBookCode);
		
		JRadioButton rdoBookName = new JRadioButton("도서명");
		rdoBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOptions.add(rdoBookName);
		
		JComboBox cmbCat = new JComboBox();
		cmbCat.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pOptions.add(cmbCat);
		
		JPanel pBars = new JPanel();
		pBars.setBorder(new EmptyBorder(20, 0, 20, 100));
		pSearch.add(pBars);
		pBars.setLayout(new BoxLayout(pBars, BoxLayout.X_AXIS));
		
		tfSearchBar = new JTextField();
		pBars.add(tfSearchBar);
		tfSearchBar.setColumns(10);
		
		JPanel pSearchBtns = new JPanel();
		pSearchBtns.setBorder(new EmptyBorder(0, 10, 0, 0));
		pBars.add(pSearchBtns);
		pSearchBtns.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setBackground(new Color(255, 204, 51));
		btnSearch.setPreferredSize(new Dimension(57, 20));
		pSearchBtns.add(btnSearch);
		
		JPanel pList = new JPanel();
		add(pList);
		pList.setLayout(new BoxLayout(pList, BoxLayout.Y_AXIS));
	}

}
