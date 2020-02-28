package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.RequestBook;

public interface RequestBookDao {
	List<RequestBook> selectRequestBookByDate(RequestBook rb);
	List<RequestBook> selectRequestBookByAll();
	List<RequestBook> selectRequestBookById(RequestBook rb);

	int insertRequestBook(RequestBook rb);
	int updateRequestBook(RequestBook rb);
	int deleteRequestBook(RequestBook rb);
}
