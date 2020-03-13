package yi_java3st_3team.ui.service;

import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.ZipCodeDao;
import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dao.impl.ZipCodeDaoImpl;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;

public class MemberUIService {
	private MemberDao MemDao;
	private ZipCodeDao ZipDao;
	public MemberUIService() {
		MemDao = MemberDaoImpl.getInstance();
		ZipDao = ZipCodeDaoImpl.getInstance();
	}
	public void addMember(Member mem) {
		MemDao.insertMember(mem);
	}
	public Member IDCheckMember(Member mem) {
		return MemDao.selectMemberByNo(mem);
	}
	
	public ZipCode zipCodeCheck(ZipCode zip) {
		return ZipDao.selectZipCodeByNo(zip);
	}
	
	
}
