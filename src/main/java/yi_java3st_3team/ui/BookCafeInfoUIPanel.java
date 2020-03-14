package yi_java3st_3team.ui;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import yi_java3st_3team.ui.service.StatisticUIService;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class BookCafeInfoUIPanel extends JPanel {
	private BookInfoCateInfoPanel pNorth;
	private StatisticUIService service;
	/**
	 * Create the panel.
	 */
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
