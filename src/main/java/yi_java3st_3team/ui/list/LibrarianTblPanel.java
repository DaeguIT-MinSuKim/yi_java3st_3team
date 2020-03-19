package yi_java3st_3team.ui.list;

import java.util.Date;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Librarian;

@SuppressWarnings("serial")
public class LibrarianTblPanel extends AbsListPanel<Librarian> {

	public LibrarianTblPanel() {
		
	}
	
	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(120,40,80,280,100,50,70,40);
		tableCellAlign(SwingConstants.CENTER,1,2,4,5,6,7);
		tableCellAlign(SwingConstants.LEFT,0,3);
	}

	@Override
	protected String[] getColNames() {
		
		return new String[] {"사서ID", "이름", "생년월일", "주소", "전화번호", "직책", "입사일", "근무여부"};
	}

	@Override
	protected Object[] toArray(Librarian item) {
		String totalAd = null;
		String title = item.getTitle().getTitleNo() == 0 ? "총관리자" : "사서"; 
		String workCdt = item.getWorkCdt() > 0? "재직":"퇴직";
		String day;
//		if(item.getLbDetailAd().length() >0) {
//			totalAd = String.format("(%d) %s %s", item.getLbZip().getZipCode(), item.getLbBassAd(),item.getLbDetailAd());
//		}else {
//			totalAd = item.getLbBassAd();
		
//		}
		
		if(item.getLbDetailAd() !=null) {
			totalAd = String.format("(%d) %s %s", item.getLbZip().getZipCode(), item.getLbBassAd(),item.getLbDetailAd());
		}else if (item.getLbBassAd()==null) {
			totalAd = "";
		}
		
		if(item.getLbBirthDay() ==null) {
			day = "";
		}else{
			day = String.format("%tF", item.getLbBirthDay());
		}

		return new Object[] {
				item.getLbId(),
				item.getLbName(),
				day,
				totalAd,
				item.getLbTel(),
				title,
				String.format("%tF", item.getJoinDate()),
				workCdt
		};
	}

	@Override
	public void updateRow(Librarian item, int updateIdx) {
		String totalAd = null;
		String title = item.getTitle().getTitleNo() == 0 ? "총관리자" : "사서"; 
		String workCdt = item.getWorkCdt() > 0? "재직":"퇴직";
		String day;
		
		if(item.getLbDetailAd() !=null) {
			totalAd = String.format("(%d) %s %s", item.getLbZip().getZipCode(), item.getLbBassAd(),item.getLbDetailAd());
		}else if (item.getLbBassAd()==null) {
			totalAd = "";
		}
		
//		else if(item.getLbDetailAd() ==null) {
//			totalAd = String.format("(%d) %s", item.getLbZip().getZipCode(), item.getLbBassAd());
//		}else if(item.getLbZip() ==null && item.getLbBassAd() ==null && item.getLbDetailAd()==null ) {
//			totalAd = "";
//		}
		
		if(item.getLbBirthDay() ==null) {
			day = "";
		}else{
			day = String.format("%tF", item.getLbBirthDay());
		}
		
		model.setValueAt(item.getLbId(), updateIdx, 0);
		model.setValueAt(item.getLbName(), updateIdx, 1);
		model.setValueAt(day, updateIdx, 2);
		model.setValueAt(totalAd, updateIdx, 3);
		model.setValueAt(item.getLbTel(), updateIdx, 4);
		model.setValueAt(title, updateIdx, 5);
		model.setValueAt(String.format("%tF", item.getJoinDate()), updateIdx, 6);
		model.setValueAt(workCdt, updateIdx, 7);
	}
}
