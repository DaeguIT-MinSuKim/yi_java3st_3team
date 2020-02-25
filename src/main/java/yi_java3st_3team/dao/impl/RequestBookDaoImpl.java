package yi_java3st_3team.dao.impl;

import java.util.List;

import yi_java3st_3team.dao.RequestBookDao;
import yi_java3st_3team.dto.RequestBook;

public class RequestBookDaoImpl implements RequestBookDao {
	private static final RequestBookDaoImpl instance = new RequestBookDaoImpl();
	
	public static RequestBookDao getInstance() {
		return instance;
	}

	@Override
	public RequestBook selectRequestBookByNo(RequestBook rb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestBook> selectRequestBookByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRequestBook(RequestBook rb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRequestBook(RequestBook rb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRequestBook(RequestBook rb) {
		// TODO Auto-generated method stub
		return 0;
	}

}
