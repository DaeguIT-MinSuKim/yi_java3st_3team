package yi_java3st_3team.ui.service;

import yi_java3st_3team.dao.LibrarianDao;
import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.RecommendationDao;
import yi_java3st_3team.dao.impl.LibrarianDaoImpl;
import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dao.impl.RecommendationDaoImpl;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.Recommendation;

public class LoginUiService {
	private RecommendationDao recomDao;
	private MemberDao mberDao;
	private LibrarianDao libDao;
	
	public LoginUiService() {
		recomDao = RecommendationDaoImpl.getInstance();
		mberDao = MemberDaoImpl.getInstance();
		libDao = LibrarianDaoImpl.getInstance();
	}
	
	public Recommendation showRecommendationByListNO() {
		return recomDao.selectRecommendationByLastNo();
	}

	public Member showMemberId(Member member) {
		return mberDao.findMemberId(member);
	}
	
	public Member showMemberPw(Member member) {
		return mberDao.findMemberPw(member);
	}
	
	public Member login(Member member) {
		return mberDao.loginMember(member);
	}
	
	public Librarian showLibId(Librarian lib) {
		return libDao.findLibrarianId(lib);
	}
	
	public Librarian showLibPw(Librarian lib) {
		return libDao.findLibrarianPw(lib);
	}
	
	public Librarian login(Librarian lib) {
		return libDao.loginLibrarian(lib);
	}
}
