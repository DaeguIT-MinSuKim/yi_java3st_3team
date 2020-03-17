package yi_java3st_3team.ui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestRecomBookPanel extends AbsWestMenuPanel {
	
	public WestRecomBookPanel() {
		initLabelText(lbl1,lbl2);
	}
	
	@Override
	protected String[] getTexts() {
		return new String[] {"대여순위/신착도서","추천도서"};
	}
	
	public JPanel[] getPanels() {
		return new JPanel[] {panel1,panel2};
	}

}
