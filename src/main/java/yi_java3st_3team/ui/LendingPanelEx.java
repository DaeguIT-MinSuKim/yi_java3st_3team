package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.content.MemberIdSelectPanel;
import yi_java3st_3team.ui.service.BookUiService;
import yi_java3st_3team.ui.service.LendingUiService;
import yi_java3st_3team.ui.list.LendingListPanel;

@SuppressWarnings("serial")
public class LendingPanelEx extends JPanel {
	private JTextField textField;
	public LendingPanelEx() {
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		MemberIdSelectPanel panel = new MemberIdSelectPanel();
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label = new JLabel("대여 도서 목록");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("도서 코드");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		panel_4.add(textField);
		
		JButton button = new JButton("검색");
		panel_4.add(button);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		
		JButton button_1 = new JButton("모두 선택");
		panel_5.add(button_1);
		
		LendingListPanel panel_10 = new LendingListPanel();
		panel_2.add(panel_10, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		
		JButton button_2 = new JButton("취소");
		panel_9.add(button_2);
		
		JButton button_3 = new JButton("대여");
		panel_9.add(button_3);
	}

}
