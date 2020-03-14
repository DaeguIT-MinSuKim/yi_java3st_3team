package yi_java3st_3team.ui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProfileMenuPanel extends AbsWestMenuPanel {

	/**
	 * Create the panel.
	 */
	public ProfileMenuPanel() {
		initLabelText(lbl1,lbl2);
	}

	@Override
	protected String[] getTexts() {
		return new String[] {"프로필 수정","이용현황"};
	}
	public JPanel[] getPanels() {
		return new JPanel[] {panel1,panel2};
	}
}
