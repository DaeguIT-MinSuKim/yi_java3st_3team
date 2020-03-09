package yi_java3st_3team.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class MemberJoinUIPanel extends JPanel {

	public MemberJoinUIPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pContent = new JPanel();
		add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));
		
		JPanel pMember = new JPanel();
		pContent.add(pMember);
		pMember.setLayout(new BorderLayout(0, 0));
		
		JPanel pBtns = new JPanel();
		add(pBtns);
		
		JButton btnAdd = new JButton("저장");
		pBtns.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		pBtns.add(btnCancel);

	}

}
