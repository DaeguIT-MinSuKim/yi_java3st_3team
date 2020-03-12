package yi_java3st_3team.ui.list;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Lending;

@SuppressWarnings("serial")
public class LendingListPanel extends AbsListPanel<Lending> {
	public LendingListPanel() {
	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(50, 250, 100, 50, 50, 50, 50, 50);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
	}

	@Override
	protected String[] getColNames() {
		return new String[] { "도서코드", "도서명", "저자/역자", "발행년도", "출판사", "대여일", "반납예정일", "선택" };
	}

	@Override
	protected Object[] toArray(Lending item) {
		JCheckBox chBox;
		return new Object[] { 
				item.getBookCd().getBookCode(), 
				item.getBookCd().getBookName(),
				String.format("%s/%s", item.getBookCd().getAuthrName(), item.getBookCd().getTrnslrName()),
				item.getBookCd().getRegistDate(), 
				item.getBookCd().getPls(), 
				item.getLendDate(), 
				item.getRturnDueDate(),
				chBox = new JCheckBox("") };
	}

	@Override
	public void updateRow(Lending item, int updateIdx) {
		JCheckBox chBox;
		model.setValueAt(item.getBookCd().getBookCode(), updateIdx, 0);
		model.setValueAt(item.getBookCd().getBookName(), updateIdx, 1);
		model.setValueAt(String.format("%s/%s", item.getBookCd().getAuthrName(), item.getBookCd().getTrnslrName()), updateIdx, 2);
		model.setValueAt(item.getBookCd().getRegistDate(), updateIdx, 3);
		model.setValueAt(item.getBookCd().getPls(), updateIdx, 4);
		model.setValueAt(item.getLendDate(), updateIdx, 5);
		model.setValueAt(item.getRturnDueDate(), updateIdx, 6);
		model.setValueAt(chBox = new JCheckBox(""), updateIdx, 7);
	}

}
