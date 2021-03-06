package yi_java3st_3team.dao;

import java.sql.SQLException;
import java.util.List;

import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;

public interface LendingDao {
	Lending selectLendingByNo(Lending lending);

	List<Lending> selectLendingByAll();
	int selectLendingByMemberReturnNullCount(Member member);
	List<Lending> selectLendingByAllTest();

	List<Lending> selectLendingByMberIdAll(Lending lending);
	List<Lending> selectLendingByMberIdAll(Member member);

	List<Lending> selectLendingByMberIdAndLendBookAll(Lending lending);
	
	int getLendBookCnt(Lending lending);
	
	int getLendBookTotalCnt(Lending lending);

	int insertLending(Lending lending);

	int updateLending(Lending lending);

	int deleteLending(Lending lending);

	List<Lending> showMemberRentalList(Member mem);

	List<Lending> showMemberReturnList(Member mem);

	List<Lending> selectLendingByOverDueCdt();

	List<Lending> selectLendingByMberIdAndLendBookTotalAll(Lending lending);

	int selectAvgRendDate();
	
	int updateLendingByCodeAndMberId(Lending lending);

	Book showLendingByBookCode(Book book);
	List<Lending> showLendingListByOverdue();
	List<Lending> selectLendingByMberId(Member member);
	List<Lending> selectLendingByMberIdChecking();
	
	List<Lending> selectLendingBastList();
	
	int insertLendingUpdateBookMember(Member member, Book book);

	int updateLendingBookMember(Member m, Book b);
	int updateMemberOdcnt(Member m) throws SQLException;

	int updateLendingBookMember(Member member);
}
