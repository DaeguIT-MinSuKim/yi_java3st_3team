package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.MiddleClassification;

public interface MiddleClassificationDao {
	MiddleClassification selectMiddleClassificationByNo(MiddleClassification mlsfc);

	List<MiddleClassification> selectMiddleClassificationByAll();

	int insertMiddleClassification(MiddleClassification mlsfc);

	int updateMiddleClassification(MiddleClassification mlsfc);

	int deleteMiddleClassification(MiddleClassification mlsfc);
}
