package yi_java3st_3team.ui.subMenu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestMemberProfileMenuPanel extends AbsWestMenuPanel {
	/**
	 * Create the panel.
	 */
	public WestMemberProfileMenuPanel() {
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
