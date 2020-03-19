package yi_java3st_3team.ui.content;

import yi_java3st_3team.dto.RequestBook;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class RequestBookMemberPanel extends AbsItemPanel<RequestBook> {
	public RequestBookMemberPanel() {
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		add(pNorth, BorderLayout.NORTH);
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel pTitle = new JPanel();
		pCenter.add(pTitle, BorderLayout.NORTH);
		
		JPanel pList = new JPanel();
		pCenter.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel pReqestList = new JPanel();
		pList.add(pReqestList, BorderLayout.CENTER);
		pReqestList.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		pCenter.add(panel, BorderLayout.SOUTH);
	}

	@Override
	public RequestBook getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItem(RequestBook item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearTf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validCheck() {
		// TODO Auto-generated method stub
		
	}

}
