package yi_java3st_3team.ui.list;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Lending;

@SuppressWarnings("serial")
public class LendingListPanel extends AbsListPanel<Lending> {

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(50, 250, 100, 50, 50, 50, 50, 50, 50);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
	}

	@Override
	protected String[] getColNames() {
		return new String[] { "도서코드", "도서명", "저자/역자", "발행년도", "출판사", "대여일", "반납예정일", "연체일수", "선택" };
	}

	@Override
	protected Object[] toArray(Lending item) {
		JCheckBox chBox;
		return new Object[] { item.getBookCd().getBookCode(), item.getBookCd().getBookName(),
				String.format("%s/%s", item.getBookCd().getAuthrName(), item.getBookCd().getTrnslrName()),
				item.getBookCd().getRegistDate(), item.getBookCd().getPls(), item.getLendDate(), item.getRturnDueDate(),
				item.getOverdueDate(), chBox = new JCheckBox() };
	}

	@Override
	public void updateRow(Lending time, int updateIdx) {
	}

}
