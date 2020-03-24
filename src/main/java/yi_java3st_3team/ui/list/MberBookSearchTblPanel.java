package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Book;

@SuppressWarnings("serial")
public class MberBookSearchTblPanel extends AbsListPanel<Book> {

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(150, 250, 150, 100, 100, 100, 80, 80, 100);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
			"도서코드", "도서명", "저자/역자", "출판사", "발행일", "분류", "보유권수", "소장위치", "대여가능여부"
		};
	}

	@Override
	protected Object[] toArray(Book item) {
		String writer;
		String lendCdt;
		
		if(item.getTrnslrName().length() > 0) {
			writer = String.format("%s/%s", item.getAuthrName().replace("|", ","), item.getTrnslrName().replace("|", ","));
		} else {
			writer = item.getAuthrName();
		}
		
		if(item.getLendPsbCdt() == 0) {
			lendCdt = "대여가능";
		} else if(item.getLendPsbCdt() == 1){
			lendCdt = "대여중";
		} else {
			lendCdt = "대여불가능";
		}
		
		return new Object[] {
				item.getBookCode(),
				item.getBookName().replace("|", ","),
				writer,
				item.getPls().getPlsName(),
				String.format("%tF", item.getPblicteYear()),
				String.format("%s/%s", item.getLcNo().getLclasName(), item.getMlNo().getMlsfcName()),
				item.getBookCnt(),
				item.getBookCode().substring(0, 2),
				lendCdt
		};
	}

	@Override
	public void updateRow(Book item, int updateIdx) {		
	}

}
