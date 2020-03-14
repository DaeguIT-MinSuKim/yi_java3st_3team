package yi_java3st_3team.ui;

import javax.swing.JPanel;

import yi_java3st_3team.ui.service.StatisticUIService;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class MemberInfoUIPanel extends JPanel {
	private StatisticUIService service;
	public MemberInfoUIPanel() {
		initialize();
	}
	private void initialize() {
		service = new StatisticUIService();
		setLayout(new BorderLayout(0, 0));
		
		MemberInfoPanel pNorth = new MemberInfoPanel();
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLblText(service);
	}

}
