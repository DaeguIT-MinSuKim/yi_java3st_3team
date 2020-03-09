package yi_java3st_3team.ui.service;

import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.ZipCodeDao;
import yi_java3st_3team.dao.impl.MemberDaoImpl;

public class MemberUIService {
	private MemberDao MemDao;
	
	public MemberUIService() {
		MemDao = MemberDaoImpl.getInstance();
	}
	
}
