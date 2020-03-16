package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Member;

public interface MemberDao {
	Member selectMemberByNo(Member member);
	Member loginMember(Member member);
	Member findMemberId(Member member);
	Member findMemberPw(Member member);

	List<Member> selectMemberByAll();
	Member searchMemberByID(Member member);
	List<Member> searchMemberByName(Member member);
	List<Member> searchMemberByBirtyday(Member member);

	int insertMember(Member member);

	int updateMember(Member member);

	int deleteMember(Member member);
	
	int[] selectMemberCounts();
	Member selectLendingMemberByNo(Member member);
}
