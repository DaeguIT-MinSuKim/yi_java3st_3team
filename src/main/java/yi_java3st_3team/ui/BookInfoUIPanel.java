package yi_java3st_3team.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

@SuppressWarnings("serial")
public class BookInfoUIPanel extends JPanel {
	private JFXPanel fxPanel;
	/**
	 * Create the panel.
	 */
	public BookInfoUIPanel() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				fxPanel = new BookInfoPanelBarChart();
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
