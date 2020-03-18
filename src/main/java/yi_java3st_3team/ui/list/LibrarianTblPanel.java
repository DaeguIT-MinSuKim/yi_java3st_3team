package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Librarian;

@SuppressWarnings("serial")
public class LibrarianTblPanel extends AbsListPanel<Librarian> {

	public LibrarianTblPanel() {
		
	}
	
	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(70,50,100,300,100,50,70,40);
		tableCellAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6,7);
	}

	@Override
	protected String[] getColNames() {
		
		return new String[] {"사서ID", "이름", "생년월일", "주소", "전화번호", "직책", "입사일", "근무여부"};
	}

	@Override
	protected Object[] toArray(Librarian item) {
		String totalAd;
		String title = item.getTitle().getTitleNo() == 1 ? "사서" : "총관리자"; 
		String workCdt = item.getWorkCdt() > 0? "퇴사":"가입";
		
		if(item.getLbDetailAd().length() >0) {
			totalAd = String.format("(%d) %s %s", item.getLbZip().getZipCode(), item.getLbBassAd(),item.getLbDetailAd());
		}else {
			totalAd = item.getLbBassAd();
		}

		return new Object[] {
				item.getLbId(),
				item.getLbName(),
				String.format("%tF", item.getLbBirthDay()),
				totalAd,
				item.getLbTel(),
				title,
				String.format("%tF", item.getJoinDate()),
				workCdt
		};
	}

	@Override
	public void updateRow(Librarian item, int updateIdx) {
		String totalAd;
		String title = item.getTitle().getTitleNo() == 1 ? "사서" : "총관리자"; 
		String workCdt = item.getWorkCdt() > 0? "퇴사":"가입";
		
		if(item.getLbDetailAd().length() >0) {
			totalAd = String.format("(%d) %s %s", item.getLbZip().getZipCode(), item.getLbBassAd(),item.getLbDetailAd());
		}else {
			totalAd = item.getLbBassAd();
		}
		model.setValueAt(item.getLbId(), updateIdx, 0);
		model.setValueAt(item.getLbName(), updateIdx, 1);
		model.setValueAt(String.format("%tF", item.getLbBirthDay()), updateIdx, 2);
		model.setValueAt(totalAd, updateIdx, 3);
		model.setValueAt(item.getLbTel(), updateIdx, 4);
		model.setValueAt(title, updateIdx, 5);
		model.setValueAt(String.format("%tF", item.getJoinDate()), updateIdx, 6);
		model.setValueAt(workCdt, updateIdx, 7);
	
	}

}
