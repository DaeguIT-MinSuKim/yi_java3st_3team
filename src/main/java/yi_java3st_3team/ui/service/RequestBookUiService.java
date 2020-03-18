package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.RequestBookDao;
import yi_java3st_3team.dao.impl.RequestBookDaoImpl;
import yi_java3st_3team.dto.RequestBook;

public class RequestBookUiService {
	private RequestBookDao dao;
	
	public RequestBookUiService() {
		dao = RequestBookDaoImpl.getInstance();
	}
	
	public List<RequestBook> showRequestAll() {
		return dao.selectRequestBookByAll();
	}
	
	public List<RequestBook> showRequestByOptionAll(RequestBook rb) {
		return dao.selectRequestBookByOptionAll(rb);
	}
	
	public List<RequestBook> showRequestByYearOption(RequestBook rb) {
		return dao.selectRequestBookByIdAndYearOption(rb);
	}
	
	public List<RequestBook> showRequestById(RequestBook rb) {
		return dao.selectRequestBookById(rb);
	}
	
	public List<RequestBook> showRequestByIdAndYear(RequestBook rb) {
		return dao.selectRequestBookByIdAndYearOption(rb);
	}
	
	public void addRequestBook(RequestBook rb) {
		dao.insertRequestBook(rb);
	}
	
	public void modifyRequestBook(RequestBook rb) {
		dao.updateRequestBook(rb);
	}
	
	public void removeRequestBook(RequestBook rb) {
		dao.deleteRequestBook(rb);
	}
}
