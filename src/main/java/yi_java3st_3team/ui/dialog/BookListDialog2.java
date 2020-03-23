package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.ui.RentPanel;
import yi_java3st_3team.ui.service.BookUiService;

@SuppressWarnings("serial")
public class BookListDialog2 extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private RentPanel lending3;
	private JTable table;
	private BookUiService service;
	private TestTabelModel model;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	public BookListDialog2(JFrame jFrame, String string, boolean b, Book name) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		initialize(name);
	}

	public RentPanel getLending3() {
		return lending3;
	}

	public void setLending3(RentPanel lending3) {
		this.lending3 = lending3;
	}

	private void initialize(Book name) {
		service = new BookUiService();
		getContentPane().setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		model = new TestTabelModel();
		List<Book> list = service.LendingBookByName(name);
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +15);
		for (Book book : list) {
			StringBuilder sb = new StringBuilder();
			if (book.getTrnslrName().equals("")) {
				sb.append(book.getAuthrName());
			} else {
				sb.append(book.getAuthrName() + "/" + book.getTrnslrName());
			}
			model.addRow(new Object[] { book.getBookCode(), book.getBookName(), sb,
					new SimpleDateFormat("yyyy-MM-dd").format(book.getPblicteYear()), book.getPls().getPlsName(),
					new SimpleDateFormat("yyyy-MM-dd").format(now),
					new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) });
		}
		table = new JTable(model);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		scrollPane.setViewportView(table);
	}

	public class TestTabelModel extends DefaultTableModel {
		public TestTabelModel() {
			super(new String[] { "도서코드", "도서명", "저자/역자", "발행년도", "출판사" }, 0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			do_okButton_actionPerformed(e);
		}
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
	}

	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		dispose();
	}

	protected void do_okButton_actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		String bookCd = (String) table.getValueAt(row, 0);
		Book bookCode = new Book(bookCd);
		Book book = service.LendingBookByCode(bookCode);
		lending3.getpLendingList().search(book);
		dispose();
	}
}