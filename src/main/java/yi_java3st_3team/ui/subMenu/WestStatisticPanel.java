package yi_java3st_3team.ui.subMenu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestStatisticPanel extends AbsWestMenuPanel {
	/**
	 * Create the panel.
	 */
	public WestStatisticPanel() {
		initLabelText(lbl1,lbl2,lbl3);
	}
	@Override
	protected String[] getTexts() {
		return new String[] {"대여/반납 통계","도서보유현황","이용자 현황"};
	}
	public JPanel[] getPanels() {
		return new JPanel[] {panel1,panel2,panel3};
	}
}
