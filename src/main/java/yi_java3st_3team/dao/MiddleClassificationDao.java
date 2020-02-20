package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.MiddleClassification;

public interface MiddleClassificationDao {
	MiddleClassification selectMiddleClassificationByNo(MiddleClassification MClass);

	List<MiddleClassification> selectMiddleClassificationByAll();

	int insertMiddleClassification(MiddleClassification MClass);

	int updateMiddleClassification(MiddleClassification MClass);

	int deleteMiddleClassification(MiddleClassification MClass);
}
