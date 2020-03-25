package yi_java3st_3team.ui.panel.submenu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestMemberManagementPanel extends AbsWestMenuPanel {
	
	public WestMemberManagementPanel() {
		initLabelText(lbl1,lbl2);
	}
	
	@Override
	protected String[] getTexts() {
		return new String[] {"회원등록","회원 조회/수정"};
	}
	
	public JPanel[] getPanels() {
		return new JPanel[] {panel1,panel2};
	}

}
