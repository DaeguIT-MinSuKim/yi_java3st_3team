package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Lending;

public interface LendingDao {
	Lending selectLendingByNo(Lending lending);

	List<Lending> selectLendingByAll();

	int insertTitle(Lending lending);

	int updateTitle(Lending lending);

	int deleteTitle(Lending lending);
}
