package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;

public interface LendingDao {
	Lending selectLendingByNo(Lending lending);

	List<Lending> selectLendingByAll();
	List<Lending> selectLendingByAllTest();
	List<Lending> selectLendingByMberIdAll(Lending lending);
	List<Lending> selectLendingByMberIdAndLendBookAll(Lending lending);
	int insertLending(Lending lending);

	int updateLending(Lending lending);

	int deleteLending(Lending lending);

	List<Lending> showMemberRentalList(Member mem);

	List<Lending> showMemberReturnList(Member mem);

	List<Lending> selectLendingByOverDueCdt();

	List<Lending> selectLendingByMberIdAndLendBookTotalAll(Lending lending);
	int selectAvgRendDate();
}
