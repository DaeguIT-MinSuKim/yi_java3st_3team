package yi_java3st_3team.ui.service;

import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Member;

public class MemberUIService {
	private MemberDao MemDao;
	
	public MemberUIService() {
		MemDao = MemberDaoImpl.getInstance();
	}
	public void addMember(Member mem) {
		MemDao.insertMember(mem);
	}
	public Member IDCheckMember(Member mem) {
		return MemDao.selectMemberByNo(mem);
	}
	
}
