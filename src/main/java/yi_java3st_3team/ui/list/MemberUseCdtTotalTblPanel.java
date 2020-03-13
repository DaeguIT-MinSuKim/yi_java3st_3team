package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Lending;

@SuppressWarnings("serial")
public class MemberUseCdtTotalTblPanel extends AbsListPanel<Lending> {
	public MemberUseCdtTotalTblPanel() {
		
	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(150, 100, 100, 100, 100, 100, 100, 100, 100, 80);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {
				"도서명", "저자/역자", "분류", "출판사", "출간일", "대여일", "반납예정일", "반납일", "반납연기여부", "연체여부"
		};
	}

	@Override
	protected Object[] toArray(Lending item) {
		String writer;
		String rturnDate;
		
		if(item.getRturnDate() == null) {
			rturnDate = "";
		} else {
			rturnDate = String.format("%tF", item.getRturnDate());
		}
		
		
		if(item.getBookCd().getTrnslrName() != null && item.getBookCd().getTrnslrName().length() > 0) {
			writer = String.format("%s/%s", item.getBookCd().getAuthrName().replace("|", ","), item.getBookCd().getTrnslrName().replace("|", ","));
		} else {
			writer = item.getBookCd().getAuthrName().replace("|", ",");
		}
		
		return new Object[] {
				item.getBookCd().getBookName().replace("|", ","),
				writer,
				String.format("%s / %s", item.getBookCd().getLcNo().getLclasName(), item.getBookCd().getMlNo().getMlsfcName()),
				item.getBookCd().getPls().getPlsName(),
				String.format("%tF", item.getBookCd().getPblicteYear()),
				String.format("%tF", item.getLendDate()),
				String.format("%tF", item.getRturnDueDate()),
				rturnDate,
				item.getRturnPsmCdt() > 0 ? "Yes" : "No",
				item.getOverdueCdt() > 0 ? "Yes" : "No",
		};
	}

	@Override
	public void updateRow(Lending item, int updateIdx) {
	}

}