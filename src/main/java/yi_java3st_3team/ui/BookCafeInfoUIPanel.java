package yi_java3st_3team.ui;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import yi_java3st_3team.ui.service.StatisticUIService;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class BookCafeInfoUIPanel extends JPanel {
	private StatisticUIService service;
	private JFXPanel fxPanel;
	/**
	 * Create the panel.
	 */
	public BookCafeInfoUIPanel() {
		initialize();
	}
	private void initialize() {
		service = new StatisticUIService();
		setLayout(new BorderLayout(0, 0));
		
		BookInfoCateInfoPanel pNorth = new BookInfoCateInfoPanel();
		pNorth.setLblText(service);
		add(pNorth, BorderLayout.NORTH);
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				fxPanel = new BookInfoCatePanelBarChart();
				Platform.runLater(() -> initFX((InitScene) fxPanel));
			}
		});
		thread.run();
		add(fxPanel,BorderLayout.CENTER);
	}
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
}
