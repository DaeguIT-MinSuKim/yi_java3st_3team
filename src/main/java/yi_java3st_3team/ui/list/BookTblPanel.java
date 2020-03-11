package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Book;

@SuppressWarnings("serial")
public class BookTblPanel extends AbsListPanel<Book> {

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(100, 150, 100, 100, 100, 70, 50, 80, 50, 50, 100, 100, 50);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12);
		tableCellAlign(SwingConstants.RIGHT, 5);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
				"도서코드", "도서명", "저자/역자", "출판사", "발행년도", "도서가격", "보유권수", "대여가능여부", "총대여횟수", "도서이미지", "분류", "등록일자", "폐기여부"
		};
	}

	@Override
	protected Object[] toArray(Book item) {
		String writer;
		String lendCdt;
		String imgCdt = item.getBookImg().length != 8706 && item.getBookImg().length > 0? "있음" : "없음";
		String dsuseCdt = item.getDsuseCdt() > 0 ? "Yes" : "No";
		
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
				String.format("%s[%02d]", item.getPls().getPlsName(), item.getPls().getPlsNo()),
				String.format("%tF", item.getPblicteYear()),
				item.getBookPrice(),
				item.getBookCnt(),
				lendCdt,
				item.getTotalLeCnt(),
				imgCdt,
				String.format("%s[%02d] / %s[%02d]", item.getLcNo().getLclasName(), item.getLcNo().getLclasNo(), item.getMlNo().getMlsfcName(), item.getMlNo().getMlsfcNo()),
				String.format("%tF", item.getRegistDate()),
				dsuseCdt
		};
	}

	@Override
	public void updateRow(Book item, int updateIdx) {
		String writer;
		String lendCdt;
		String imgCdt = item.getBookImg().length != 8706 && item.getBookImg().length > 0? "있음" : "없음";
		String dsuseCdt = item.getDsuseCdt() == 0 ? "No" : "Yes";
		
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
		
		model.setValueAt(item.getBookCode(), updateIdx, 0);
		model.setValueAt(item.getBookName().replace("|", ","), updateIdx, 1);
		model.setValueAt(writer, updateIdx, 2);
		model.setValueAt(String.format("%s[%02d]", item.getPls().getPlsName(), item.getPls().getPlsNo()), updateIdx, 3);
		model.setValueAt(String.format("%tF", item.getPblicteYear()), updateIdx, 4);
		model.setValueAt(item.getBookPrice(), updateIdx, 5);
		model.setValueAt(item.getBookCnt(), updateIdx, 6);
		model.setValueAt(lendCdt, updateIdx, 7);
		model.setValueAt(item.getTotalLeCnt(), updateIdx, 8);
		model.setValueAt(imgCdt, updateIdx, 9);
		model.setValueAt(String.format("%s[%02d] / %s[%02d]", item.getLcNo().getLclasName(), item.getLcNo().getLclasNo(), item.getMlNo().getMlsfcNo(), item.getMlNo().getMlsfcNo()), updateIdx, 10);
		model.setValueAt(String.format("%tF", item.getRegistDate()), updateIdx, 11);
		model.setValueAt(dsuseCdt, updateIdx, 12);
	}

}

