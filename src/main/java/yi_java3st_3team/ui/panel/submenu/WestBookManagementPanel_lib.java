package yi_java3st_3team.ui.panel.submenu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestBookManagementPanel_lib extends AbsWestMenuPanel {
	/**
	 * Create the panel.
	 */
	public WestBookManagementPanel_lib() {
		initLabelText(lbl1,lbl2,lbl3,lbl4);
	}
	
	@Override
	protected String[] getTexts() {
		return new String[] {"도서등록","보유도서 관리", "신청도서 관리","추천도서 등록"};
	}
	
	public JPanel[] getPanels() {
		return new JPanel[] {panel1,panel2,panel3,panel4};
	}
}
