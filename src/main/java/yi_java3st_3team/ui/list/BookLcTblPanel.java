package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.LargeClassification;

@SuppressWarnings("serial")
public class BookLcTblPanel extends AbsListPanel<LargeClassification> {

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(100, 200);
		tableCellAlign(SwingConstants.CENTER, 0, 1);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
				"대분류 코드", "대분류 이름"
		};
	}

	@Override
	protected Object[] toArray(LargeClassification item) {
		return new Object[] {
				item.getLclasNo(),
				item.getLclasName()
		};
	}

	@Override
	public void updateRow(LargeClassification item, int updateIdx) {
		model.setValueAt(item.getLclasNo(), updateIdx, 0);
		model.setValueAt(item.getLclasName(), updateIdx, 1);
	}

}
