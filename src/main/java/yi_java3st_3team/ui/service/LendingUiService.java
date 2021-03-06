package yi_java3st_3team.ui.service;

import java.sql.SQLException;
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
		return lendingDao.showLendingListByOverdue();
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

	public int showLendBookCnt(Lending lending) {
		return lendingDao.getLendBookCnt(lending);
	}

	public int showLendBookTotalCnt(Lending lending) {
		return lendingDao.getLendBookTotalCnt(lending);
	}

	public Member showLendingMemberId(Member member) {
		return memberDao.selectMemberByNo2(member);
	}

	public Member showLendingMemberId2(Member member) {
		return memberDao.selectMemberByNo3(member);
	}

	public void modifyLendingByCodeAndMberId(Lending lending) {
		lendingDao.updateLendingByCodeAndMberId(lending);
	}

	public Book showLendingBookCode(Book book) {
		return lendingDao.showLendingByBookCode(book);
	}

	public List<Lending> showLendingListByOverdue() {
		return lendingDao.showLendingListByOverdue();
	}
	public List<Lending> selectLendingByMberIdAll(Member member) {
		return lendingDao.selectLendingByMberIdAll(member);
	}

	public List<Lending> selectLendingByMberId(Member member) {
		return lendingDao.selectLendingByMberId(member);
	}
	public List<Lending> selectLendingByMberId2() {
		return lendingDao.selectLendingByMberIdChecking();
	}
	
	public List<Lending> showBastList() {
		return lendingDao.selectLendingBastList();
	}

	public void insertSelectedLendingList(Member mberId, Book bookCd) {
		lendingDao.insertLendingUpdateBookMember(mberId, bookCd);
	}

	public Member selectedMberId(String mberId) {
		Member member = new Member(mberId);
		return memberDao.selectMemberByNo(member);
	}

	public Book selectedBookCd(String bookCd) {
		Book book = new Book(bookCd);
		return bookDao.selectBookByCode(book);
	}

	public void updateLendingList(Member m, Book b) {
		lendingDao.updateLendingBookMember(m,b);
	}

	public void updateOdCnt(Member member) {
		memberDao.updateOdCnt(member);
	}
	public int updateMemberOdCnt(Member m) throws SQLException {
		return lendingDao.updateMemberOdcnt(m);
	}
	public int selectLendingByMemberReturnNullCount(Member member) {
		return lendingDao.selectLendingByMemberReturnNullCount(member);
	}

	public void updateLendingList2(Member member) {
		lendingDao.updateLendingBookMember(member);
		
	}
}
