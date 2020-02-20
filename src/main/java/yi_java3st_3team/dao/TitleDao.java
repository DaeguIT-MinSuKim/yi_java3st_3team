package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Title;

public interface TitleDao {
	Title selectTitleByNo(Title title);

	List<Title> selectTitleByAll();

	int insertTitle(Title title);

	int updateTitle(Title title);

	int deleteTitle(Title title);
}
