package yi_java3st_3team.ui.panel.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.PublishingCompany;

@SuppressWarnings("serial")
public class BookPlsTblPanel extends AbsListPanel<PublishingCompany> {

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(50, 150);
		tableCellAlign(SwingConstants.CENTER, 0, 1);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
				"출판사 코드", "출판사 이름"
		};
	}

	@Override
	protected Object[] toArray(PublishingCompany item) {
		return new Object[] {
				item.getPlsNo(),
				item.getPlsName()
		};
	}

	@Override
	public void updateRow(PublishingCompany item, int updateIdx) {
		model.setValueAt(item.getPlsNo(), updateIdx, 0);
		model.setValueAt(item.getPlsName(), updateIdx, 1);
	}

}
