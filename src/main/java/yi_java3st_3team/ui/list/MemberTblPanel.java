package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Member;

@SuppressWarnings("serial")
public class MemberTblPanel extends AbsListPanel<Member> {

	public MemberTblPanel() {
		
	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(120,50,100,300,100,60,70,30,80,50,100,50);
		tableCellAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6,7,8,9,10,11);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"회원ID", "이름", "생년월일", "주소", "전화번호", "총대여권수", "현재대여권수", "등급", "가입일", "탈퇴여부", "대여가능여부", "연체횟수"};
	}

	@Override
	protected Object[] toArray(Member item) {
		String totalAd;
		String lendCdt = item.getLendPsbCdt() == 0 ? "대여가능" : "대여불가능";
		String wdrCdt =item.getWdrCdt() > 0 ? "탈퇴" : "가입";
		String grade = item.getGrade().getGradeNo() ==1 ? "일반" : "우수";
		
		if(item.getMberDetailAd().length() > 0) {
			totalAd = String.format("(%d) %s %s",item.getMberZip().getZipCode(),item.getMberBassAd(),item.getMberDetailAd());
		}else {
			totalAd = item.getMberBassAd();
		}
		
		return new Object[] {
				item.getMberId(),
				item.getMberName(),
				String.format("%tF", item.getMberBrthdy()),
				totalAd,
				item.getMberTel(),
				item.getTotalLeCnt(),
				item.getLendBookCnt(),
				grade,
				String.format("%tF", item.getJoinDt()),
				wdrCdt,
				lendCdt,
				item.getOdCnt()
		};
	}

	@Override
	public void updateRow(Member item, int updateIdx) {
		String totalAd;
		String lendCdt = item.getLendPsbCdt() == 0 ? "대여가능" : "대여불가능";
		String wdrCdt = item.getWdrCdt() == 0 ? "가입" : "탈퇴";
		String grade = item.getGrade().getGradeNo() ==1 ? "일반" : "우수";
		
		if(item.getMberDetailAd().length() > 0) {
			totalAd = String.format("(%d) %s %s",item.getMberZip().getZipCode(),item.getMberBassAd(),item.getMberDetailAd());
		}else {
			totalAd = item.getMberBassAd();
		}
		
		model.setValueAt(item.getMberId(), updateIdx, 0);
		model.setValueAt(item.getMberName(), updateIdx, 1);
		model.setValueAt(String.format("%tF", item.getMberBrthdy()),updateIdx, 2);
		model.setValueAt(totalAd, updateIdx, 3);
		model.setValueAt(item.getMberTel(), updateIdx, 4);
		model.setValueAt(item.getTotalLeCnt(), updateIdx, 5);
		model.setValueAt(item.getLendBookCnt(), updateIdx, 6);
		model.setValueAt(grade, updateIdx, 7);
		model.setValueAt(String.format("%tF", item.getJoinDt()), updateIdx, 8);
		model.setValueAt(wdrCdt, updateIdx, 9);
		model.setValueAt(lendCdt, updateIdx, 10);
		model.setValueAt(item.getOdCnt(), updateIdx, 11);
	}
}
