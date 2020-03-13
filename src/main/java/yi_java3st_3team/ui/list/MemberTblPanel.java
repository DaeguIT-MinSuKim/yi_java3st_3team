package yi_java3st_3team.ui.list;

import javax.swing.SwingConstants;

import yi_java3st_3team.dto.Member;

@SuppressWarnings("serial")
public class MemberTblPanel extends AbsListPanel<Member> {

	public MemberTblPanel() {
		
	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(100,100,100,100,100,100,100,100,100,100);
		tableCellAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6,7,8,9);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"회원ID", "이름", "생년월일", "주소", "전화번호", "총대여권수", "현재대여권수", "등급", "가입일", "탈퇴여부"};
	}

	@Override
	protected Object[] toArray(Member item) {
		return null;
	}

	@Override
	public void updateRow(Member item, int updateIdx) {
		
	}

}
