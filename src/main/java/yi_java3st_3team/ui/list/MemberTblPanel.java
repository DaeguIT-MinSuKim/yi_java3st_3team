package yi_java3st_3team.ui.list;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import yi_java3st_3team.dto.Member;

@SuppressWarnings("serial")
public class MemberTblPanel extends AbsListPanel<Member> {
	public MemberTblPanel() {

	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(120, 50, 100, 280, 100, 70, 90, 30, 80, 70, 100, 70);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
	}

	@Override
	protected String[] getColNames() {
		return new String[] { "<html><b>회원ID</b></html>",
				"<html><b>이름</b></html>",
				"<html><b>생년월일</b></html>",
				"<html><b>주소</b></html>",
				"<html><b>전화번호</b></html>",
				"<html><b>총대여권수</b></html>",
				"<html><b>현재대여권수</b></html>",
				"<html><b>등급</b></html>",
				"<html><b>가입일</b></html>",
				"<html><b>탈퇴여부</b></html>",
				"<html><b>대여가능여부</b></html>",
				"<html><b>연체횟수</b></html>" };
	}

	@Override
	protected Object[] toArray(Member item) {
		String totalAd;
		String lendCdt = item.getLendPsbCdt() == 0 ? "대여가능" : "대여불가능";
		String wdrCdt = item.getWdrCdt() > 0 ? "탈퇴" : "가입";
		String grade = item.getGrade().getGradeNo() == 1 ? "일반" : "우수";
		int odCnt = item.getOdCnt();
		String odCntStr = String.format("%d", item.getOdCnt());
		String odCntName = String.format("%s", item.getMberName());

		if (item.getMberDetailAd().length() > 0) {
			totalAd = String.format("(%d) %s %s", item.getMberZip().getZipCode(), item.getMberBassAd(),
					item.getMberDetailAd());
		} else {
			totalAd = item.getMberBassAd();
		}
		
		if(odCnt >= 5) {
			odCntStr = String.format("<html><span style='color:red'><b>%d</b></span></html>", item.getOdCnt());
			odCntName =String.format("<html><span style='color:red'><b>%s</b></span></html>", item.getMberName());
		}

		return new Object[] { item.getMberId(),
				odCntName,
				String.format("%tF", item.getMberBrthdy()),
				totalAd,
				item.getMberTel(),
				item.getTotalLeCnt(),
				item.getLendBookCnt(),
				grade,
				String.format("%tF", item.getJoinDt()),
				wdrCdt,
				lendCdt,
				odCntStr
				};
	}

	@Override
	public void updateRow(Member item, int updateIdx) {
		String totalAd;
		String lendCdt = item.getLendPsbCdt() == 0 ? "대여가능" : "대여불가능";
		String wdrCdt = item.getWdrCdt() == 0 ? "가입" : "탈퇴";
		String grade = item.getGrade().getGradeNo() == 1 ? "일반" : "우수";
		int odCnt = item.getOdCnt();
		String odCntStr = String.format("%d", item.getOdCnt());
		String odCntName = String.format("%s", item.getMberName());
		
		if (item.getMberDetailAd().length() > 0) {
			totalAd = String.format("(%d) %s %s", item.getMberZip().getZipCode(), item.getMberBassAd(),
					item.getMberDetailAd());
		} else {
			totalAd = item.getMberBassAd();
		}
		
		if(odCnt >= 5) {
			odCntStr = String.format("<html><span style='color:red'><b>%d</b></span></html>", item.getOdCnt());
			odCntName =String.format("<html><span style='color:red'><b>%s</b></span></html>", item.getMberName());
		}

		model.setValueAt(item.getMberId(), updateIdx, 0);
		model.setValueAt(odCntName, updateIdx, 1);
		model.setValueAt(String.format("%tF", item.getMberBrthdy()), updateIdx, 2);
		model.setValueAt(totalAd, updateIdx, 3);
		model.setValueAt(item.getMberTel(), updateIdx, 4);
		model.setValueAt(item.getTotalLeCnt(), updateIdx, 5);
		model.setValueAt(item.getLendBookCnt(), updateIdx, 6);
		model.setValueAt(grade, updateIdx, 7);
		model.setValueAt(String.format("%tF", item.getJoinDt()), updateIdx, 8);
		model.setValueAt(wdrCdt, updateIdx, 9);
		model.setValueAt(lendCdt, updateIdx, 10);
		model.setValueAt(odCntStr, updateIdx, 11);
	}
}
