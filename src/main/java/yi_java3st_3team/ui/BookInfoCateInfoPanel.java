package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import yi_java3st_3team.ui.service.StatisticUIService;

import java.awt.Color;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BookInfoCateInfoPanel extends JPanel {
	private JLabel lblTotalBookCount;
	private JLabel lblDisposalBookCount;

	/**
	 * Create the panel.
	 */
	public BookInfoCateInfoPanel() {
		initialize();
	}
	private void initialize() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(0);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblTotalBooks = new JLabel("총 보유권수");
		lblTotalBooks.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel.add(lblTotalBooks);
		
		JLabel lblDisposalBooks = new JLabel("총 폐기도서");
		lblDisposalBooks.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel.add(lblDisposalBooks);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(80);
		add(panel_1, BorderLayout.CENTER);
		
		lblTotalBookCount = new JLabel("0권");
		lblTotalBookCount.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		panel_1.add(lblTotalBookCount);
		
		lblDisposalBookCount = new JLabel("0권");
		lblDisposalBookCount.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		panel_1.add(lblDisposalBookCount);
	}
	public void setLblText(StatisticUIService service) {
		lblDisposalBookCount.setText(service.selectDisposalBooks() + "권");
		lblTotalBookCount.setText(service.selectTotalBooks() + "권");
	}
}
