package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;

public interface MiddleClassificationDao {
	MiddleClassification selectMiddleClassificationByNo(MiddleClassification mlsfc);
	
	List<MiddleClassification> selectMiddleClassificationByAll();
	List<MiddleClassification> selectMiddleClassificationGroupLc(LargeClassification lc);

	int insertMiddleClassification(MiddleClassification mlsfc);

	int updateMiddleClassification(MiddleClassification mlsfc);

	int deleteMiddleClassification(MiddleClassification mlsfc);
	
	int selectLastCode(LargeClassification lc);
}
