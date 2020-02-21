package yi_java3st_3team.ui.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class HeadMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public HeadMenu() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴메뉴");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
	}

}
