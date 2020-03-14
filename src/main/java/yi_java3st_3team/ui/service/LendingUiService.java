package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.BookDao;
import yi_java3st_3team.dao.GradeDao;
import yi_java3st_3team.dao.LendingDao;
import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.impl.BookDaoImpl;
import yi_java3st_3team.dao.impl.GradeDaoImpl;
import yi_java3st_3team.dao.impl.LendingDaoImpl;
import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;

public class LendingUiService {
	private LendingDao lendingDao;
	private GradeDao gradeDao;
	private MemberDao memberDao;
	private BookDao bookDao;

	public LendingUiService() {
		lendingDao = LendingDaoImpl.getInstance();
		gradeDao = GradeDaoImpl.getInstance();
		memberDao = MemberDaoImpl.getInstance();
		bookDao = BookDaoImpl.getInstance();
	}

	public List<Lending> showLendingList() {
		return lendingDao.selectLendingByAll();
	}

	public List<Lending> showMemberRentalList(Member mem) {
		return lendingDao.showMemberRentalList(mem);
	}

	public List<Lending> showMemberReturnList(Member mem) {
		return lendingDao.showMemberReturnList(mem);
	}

	public List<Lending> showOverDueList() {
		return lendingDao.selectLendingByOverDueCdt();
	}

	public void modifyLending(Lending lending) {
		lendingDao.updateLending(lending);
	}

	public void addLending(Lending lending) {
		lendingDao.insertLending(lending);
	}

	public List<Lending> selectLendingByAllTest() {
		return lendingDao.selectLendingByAllTest();
	}

	public List<Lending> showMemberLendBookTotlaList(Lending lending) {
		return lendingDao.selectLendingByMberIdAndLendBookTotalAll(lending);
	}

	public List<Lending> showMenberLendBookList(Lending lending) {
		return lendingDao.selectLendingByMberIdAndLendBookAll(lending);
	}

	public Member showLendingMemberId(Member member) {
		return memberDao.selectMemberByNo(member);
	}

	public void modifyLendingByCodeAndMberId(Lending lending) {
		lendingDao.updateLendingByCodeAndMberId(lending);
	}

	public Book showLendingBookCode(Book book) {
		return lendingDao.showLendingByBookCode(book);
	}
}
