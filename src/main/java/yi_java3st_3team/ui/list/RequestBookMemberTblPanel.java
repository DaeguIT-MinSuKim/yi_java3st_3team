package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.RequestBook;

@SuppressWarnings("serial")
public class RequestBookMemberTblPanel extends AbsListNullExceptionCopePanel<RequestBook> {

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(150, 100, 100, 100, 100, 100);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
				"신청도서명", "저자", "역자", "출판사", "신청일", "입고여부"
		};
	}

	@Override
	protected Object[] toArray(RequestBook item) {
		return new Object[] {
				item.getRequestBookName(),
				item.getRequestBookAuthor(),
				item.getRequestBookTrnslr(),
				item.getRequestBookPls(),
				String.format("%tF", item.getRequestDate()),
				item.getWhCdt() > 0 ? "입고완료" : "미입고"
		};
	}

	@Override
	public void updateRow(RequestBook item, int updateIdx) {
	}

}
