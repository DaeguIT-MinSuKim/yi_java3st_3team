package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.MiddleClassification;

@SuppressWarnings("serial")
public class BookLcAndMlTblPanel extends AbsListPanel<MiddleClassification> {

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(100, 150, 100, 150);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
				"대분류 코드", "대분류 이름", "중분류 코드", "중분류 이름"
		};
	}

	@Override
	protected Object[] toArray(MiddleClassification item) {
		return new Object[] {
				item.getLclasNo().getLclasNo(),
				item.getLclasNo().getLclasName(),
				item.getMlsfcNo(),
				item.getMlsfcName()
		};
	}

	@Override
	public void updateRow(MiddleClassification item, int updateIdx) {
		model.setValueAt(item.getLclasNo().getLclasNo(), updateIdx, 0);
		model.setValueAt(item.getLclasNo().getLclasName(), updateIdx, 1);
		model.setValueAt(item.getMlsfcNo(), updateIdx, 2);
		model.setValueAt(item.getMlsfcName(), updateIdx, 3);
	}

}
