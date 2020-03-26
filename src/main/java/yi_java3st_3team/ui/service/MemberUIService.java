package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.GradeDao;
import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.TitleDao;
import yi_java3st_3team.dao.ZipCodeDao;
import yi_java3st_3team.dao.impl.GradeDaoImpl;
import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dao.impl.TitleDaoImpl;
import yi_java3st_3team.dao.impl.ZipCodeDaoImpl;
import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.dto.ZipCode;

public class MemberUIService {
	private MemberDao memDao;
	private ZipCodeDao zipDao;
	private GradeDao gradeDao;

	public MemberUIService() {
		memDao = MemberDaoImpl.getInstance();
		zipDao = ZipCodeDaoImpl.getInstance();
		gradeDao = GradeDaoImpl.getInstance();
	}

	public void addMember(Member mem) {
		memDao.insertMember(mem);
	}

	public Member IDCheckMember(Member mem) {
		return memDao.selectMemberByNo(mem);
	}

	public ZipCode zipCodeCheck(ZipCode zip) {
		return zipDao.selectZipCodeByNo(zip);
	}

	public Member SelectedByNo(Member mem) {
		return memDao.selectMemberByNo(mem);
	}

	public List<Member> showMemberListAll() {
		return memDao.selectMemberByAll();
	}

	public List<Member> searchMemberByID(Member mem) {
		return memDao.searchMemberByID(mem);
	}

	public List<Member> searchMemberByName(Member mem) {
		return memDao.searchMemberByName(mem);
	}

	public List<Member> searchMemberByBirtyday(Member mem) {
		return memDao.searchMemberByBirtyday(mem);
	}

	public List<Grade> showGradeList() {
		return gradeDao.selectGradeByAll();
	}

	public void removeMember(Member mem) {
		memDao.deleteMember(mem);
	}

	public void updateByWdrCdt(Member mem) {
		memDao.updateMember(mem);
	}

	public void updateMember(Member mem) {
		memDao.updateMember(mem);
	}
	public void updateCountMember(Member mem) {
		memDao.updateCountMember(mem);
	}

	public List<Member> showLendingMemberId2(Member id) {
		return memDao.selectMemberByCodeName(id);
	}

	public List<Member> showLendingMemberId3(Member name) {
		return memDao.selectMemberByCodeName2(name);
	}

}
