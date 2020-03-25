package yi_java3st_3team.ui.panel.submenu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestLibrarianManagementPanel extends AbsWestMenuPanel {

	public WestLibrarianManagementPanel() {
		initLabelText(lbl1);
	}
	
	@Override
	protected String[] getTexts() {
		return new String[] {"직원 등록/수정"};
	}
	
	public JPanel[] getPanels() {
		return new JPanel[] {panel1};
	}
}
