package yi_java3st_3team.ui.panel.submenu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestLendingManagementPanel extends AbsWestMenuPanel {
	
	public WestLendingManagementPanel() {
		initLabelText(lbl1,lbl2,lbl3);
	}
	
	@Override
	protected String[] getTexts() {
		return new String[] {"대여 관리","반납 관리","연체 조회"};
	}
	
	public JPanel[] getPanels() {
		return new JPanel[] {panel1,panel2,panel3};
	}

}
