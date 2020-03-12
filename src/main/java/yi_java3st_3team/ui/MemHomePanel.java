package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MemHomePanel extends JPanel {

	private JPanel pName;
	private JLabel lblPic;
	private JLabel lblWelcome;
	private JPanel pLending;
	private JLabel lblLendingBook;
	private JLabel lblRturnDueDate;
	private JLabel lblOverDueDate;
	private JLabel lblLendingBook2;
	private JLabel lblRturnDueDate2;
	private JLabel lblOverDueDate2;

	public MemHomePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));

		pName = new JPanel();
		add(pName);
		pName.setLayout(new BorderLayout(0, 0));

		lblPic = new JLabel("");
		pName.add(lblPic, BorderLayout.CENTER);

		lblWelcome = new JLabel("");
		pName.add(lblWelcome, BorderLayout.SOUTH);

		pLending = new JPanel();
		add(pLending);
		pLending.setLayout(new GridLayout(0, 3, 0, 0));

		lblLendingBook = new JLabel("대여 중 도서");
		pLending.add(lblLendingBook);

		lblRturnDueDate = new JLabel("반납 예정일");
		pLending.add(lblRturnDueDate);

		lblOverDueDate = new JLabel("연체 일수");
		pLending.add(lblOverDueDate);

		lblLendingBook2 = new JLabel("");
		pLending.add(lblLendingBook2);

		lblRturnDueDate2 = new JLabel("");
		pLending.add(lblRturnDueDate2);

		lblOverDueDate2 = new JLabel("");
		pLending.add(lblOverDueDate2);

		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblLendingBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblRturnDueDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverDueDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblLendingBook2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRturnDueDate2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverDueDate2.setHorizontalAlignment(SwingConstants.CENTER);
	}

}
