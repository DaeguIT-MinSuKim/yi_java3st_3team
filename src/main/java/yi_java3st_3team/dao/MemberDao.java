package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Member;

public interface MemberDao {
	Member selectMemberByNo(Member member);
	Member loginMember(Member member);

	List<Member> selectMemberByAll();

	int insertMember(Member member);

	int updateMember(Member member);

	int deleteMember(Member member);
	
	
}
