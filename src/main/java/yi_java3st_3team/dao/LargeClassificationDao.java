package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.LargeClassification;

public interface LargeClassificationDao {
	LargeClassification selectLargeClassificationByNo(LargeClassification LClass);

	List<LargeClassification> selectLargeClassificationByAll();

	int insertLargeClassification(LargeClassification LClass);

	int updateLargeClassification(LargeClassification LClass);

	int deleteLargeClassification(LargeClassification LClass);
}
