package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Grade;

public interface GradeDao {
	Grade selectGradeByNo(Grade grade);

	List<Grade> selectGradeByAll();

	int insertGrade(Grade grade);

	int updateGrade(Grade grade);

	int deleteGrade(Grade grade);
}
