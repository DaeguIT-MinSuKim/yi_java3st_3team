package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.LargeClassification;

public interface LargeClassificationDao {
	LargeClassification selectLargeClassificationByNo(LargeClassification lclas);

	List<LargeClassification> selectLargeClassificationByAll();

	int insertLargeClassification(LargeClassification lclas);

	int updateLargeClassification(LargeClassification lclas);

	int deleteLargeClassification(LargeClassification lclas);
	
	int selectLaseCode();
}
