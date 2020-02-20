package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.RequestBook;

public interface RequestBookDao {
	RequestBook selectRequestBookByNo(RequestBook rb);

	List<RequestBook> selectRequestBookByAll();

	int insertRequestBook(RequestBook rb);

	int updateRequestBook(RequestBook rb);

	int deleteRequestBook(RequestBook rb);
}
