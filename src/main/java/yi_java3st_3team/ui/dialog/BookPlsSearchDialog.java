package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import yi_java3st_3team.dto.PublishingCompany;
import yi_java3st_3team.ui.list.BookPlsTblPanel;
import yi_java3st_3team.ui.service.BookUiService;

@SuppressWarnings("serial")
public class BookPlsSearchDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfPlsName;
	private JButton btnSearch;
	private BookUiService service;
	private BookPlsTblPanel pPlsList;
	private JPanel pSouth;
	private JButton btnChoice;

	public BookPlsSearchDialog(JFrame frame, String title) {
		super(frame, title, true);
		service = new BookUiService();
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel pNorth = new JPanel();
			pNorth.setBorder(new EmptyBorder(10, 20, 10, 20));
			getContentPane().add(pNorth, BorderLayout.NORTH);
			pNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			{
				JLabel lblPlsName = new JLabel("출판사 이름 : ");
				pNorth.add(lblPlsName);
			}
			{
				tfPlsName = new JTextField();
				pNorth.add(tfPlsName);
				tfPlsName.setColumns(10);
			}
			{
				btnSearch = new JButton(" 검색 ");
				btnSearch.addActionListener(this);
				pNorth.add(btnSearch);
			}
		}
		contentPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pList = new JPanel();
			contentPanel.add(pList, BorderLayout.CENTER);
			pList.setLayout(new BorderLayout(0, 0));
			{
				pPlsList = new BookPlsTblPanel();
				pPlsList.loadData(service.showPlsList());
				pList.add(pPlsList, BorderLayout.CENTER);
			}
		}
		{
			pSouth = new JPanel();
			getContentPane().add(pSouth, BorderLayout.SOUTH);
			{
				btnChoice = new JButton("선택");
				btnChoice.addActionListener(this);
				pSouth.add(btnChoice);
			}
		}
	}
	
	public PublishingCompany getPls() {
		try {			
			return pPlsList.getSelectedItem();
		} catch (RuntimeException e) {
			return null;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnChoice) {
			btnChoiceActionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			btnNewButtonActionPerformed(e);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		String pcName = tfPlsName.getText();
		pPlsList.loadData(service.searchPlsNameList(pcName));
	}

	protected void btnChoiceActionPerformed(ActionEvent e) {
		setVisible(false);
	}

}
