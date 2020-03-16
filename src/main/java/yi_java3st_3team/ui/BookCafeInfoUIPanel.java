package yi_java3st_3team.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import yi_java3st_3team.ui.service.StatisticUIService;

@SuppressWarnings("serial")
public class BookCafeInfoUIPanel extends JPanel {
	private BookInfoCateInfoPanel pNorth;
	private StatisticUIService service;
	
	public BookCafeInfoUIPanel() {
		initialize();
	}
	private void initialize() {
		service = new StatisticUIService();
		setLayout(new BorderLayout(0, 0));
		
		pNorth = new BookInfoCateInfoPanel();
		pNorth.setLblText(service);
		add(pNorth, BorderLayout.NORTH);
	}
	public BookInfoCateInfoPanel getpNorth() {
		return pNorth;
	}
}
