package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.RequestBook;

public interface RequestBookDao {
	List<RequestBook> selectRequestBookByAll();
	List<RequestBook> selectRequestBookByOptionAll(RequestBook rb);
	List<RequestBook> selectRequestBookByYearOption(RequestBook rb);
	List<RequestBook> selectRequestBookById(RequestBook rb);
	List<RequestBook> selectRequestBookByIdAndYearOption(RequestBook rb);

	int insertRequestBook(RequestBook rb);
	int updateRequestBook(RequestBook rb);
	int deleteRequestBook(RequestBook rb);
}
