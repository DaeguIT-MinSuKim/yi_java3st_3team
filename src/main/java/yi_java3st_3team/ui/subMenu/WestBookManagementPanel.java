package yi_java3st_3team.ui.subMenu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestBookManagementPanel extends AbsWestMenuPanel {
	/**
	 * Create the panel.
	 */
	public WestBookManagementPanel() {
		initLabelText(lbl1,lbl2,lbl3,lbl4,lbl5,lbl6);
	}
	
	@Override
	protected String[] getTexts() {
		return new String[] {"도서등록","보유도서 관리", "신청도서 관리","추천도서 등록", "출판사 관리", "도서분류 관리"};
	}
	
	public JPanel[] getPanels() {
		return new JPanel[] {panel1,panel2,panel3,panel4,panel5,panel6};
	}
}
