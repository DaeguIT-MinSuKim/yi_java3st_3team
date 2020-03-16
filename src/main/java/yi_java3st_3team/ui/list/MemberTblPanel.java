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
		String lendCdt;
		String wdrCnt;
		String grade;
		
		if(item.getMberDetailAd().length() > 0) {
			totalAd = String.format("(%d) %s %s",item.getMberZip().getZipCode(),item.getMberBassAd(),item.getMberDetailAd());
		}else {
			totalAd = item.getMberBassAd();
		}
		
		if(item.getLendPsbCdt() ==0) {
			lendCdt = "대여가능";
		}else if(item.getLendPsbCdt()==1) {
			lendCdt = "대여불가능";
		}else {
			lendCdt ="대여가능";
		}
		
		if(item.getWdrCdt() ==0) {
			wdrCnt = "가입";
		}else if(item.getWdrCdt() ==1) {
			wdrCnt = "탈퇴";
		}else {
			wdrCnt = "가입";
		}
		
		if(item.getGrade().getGradeNo() == 1) {
			grade = "일반";
		}else if(item.getGrade().getGradeNo() == 2) {
			grade="우수";
		}else {
			grade = "일반";
		}

//		if(item.getOdCnt() > 4) {
//			i
//		}
		
		
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
				wdrCnt,
				lendCdt,
				item.getOdCnt()
		};
	}

	@Override
	public void updateRow(Member item, int updateIdx) {
		String totalAd;
		String lendCdt;
		String wdrCnt;
		String grade;
		
		if(item.getMberDetailAd().length() > 0) {
			totalAd = String.format("(%d) %s %s",item.getMberZip().getZipCode(),item.getMberBassAd(),item.getMberDetailAd());
		}else {
			totalAd = item.getMberBassAd();
		}
		
		if(item.getLendPsbCdt() ==0) {
			lendCdt = "대여가능";
		}else if(item.getLendPsbCdt()==1) {
			lendCdt = "대여불가능";
		}else {
			lendCdt ="대여가능";
		}
		
		if(item.getWdrCdt() ==0) {
			wdrCnt = "가입";
		}else if(item.getWdrCdt() ==1) {
			wdrCnt = "탈퇴";
		}else {
			wdrCnt = "가입";
		}
		
		if(item.getGrade().getGradeNo() == 1) {
			grade = "일반";
		}else if(item.getGrade().getGradeNo() == 1) {
			grade="우수";
		}else {
			grade = "일반";
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
		model.setValueAt(wdrCnt, updateIdx, 9);
		model.setValueAt(lendCdt, updateIdx, 10);
		model.setValueAt(item.getOdCnt(), updateIdx, 11);
	}
}
