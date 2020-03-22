package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.BookDao;
import yi_java3st_3team.dao.RequestBookDao;
import yi_java3st_3team.dao.impl.BookDaoImpl;
import yi_java3st_3team.dao.impl.RequestBookDaoImpl;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.RequestBook;

public class RequestBookUiService {
	private RequestBookDao dao;
	private BookDao bookDao;
	
	public RequestBookUiService() {
		dao = RequestBookDaoImpl.getInstance();
		bookDao = BookDaoImpl.getInstance();
	}
	
	public List<RequestBook> showRequestAll() {
		return dao.selectRequestBookByAll();
	}
	
	public List<RequestBook> showRequestByOptionAll(RequestBook rb, String year, String month) {
		return dao.selectRequestBookByOptionAll(rb, year, month);
	}
	
	public List<RequestBook> showRequestByYearOption(RequestBook rb, String year) {
		return dao.selectRequestBookByYearOption(rb, year);
	}
	
	public List<RequestBook> showRequestByIdAll(RequestBook rb) {
		return dao.selectRequestBookByIdAll(rb);
	}
	
	public List<RequestBook> showRequestByIdAndYear(RequestBook rb, String year) {
		return dao.selectRequestBookByIdAndYearOption(rb, year);
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
	
	public Book checkBook(String bookName, String authr, String trnslr, String pls) {
		return bookDao.selectBookByNameAndWriterNameAndPls(bookName, authr, trnslr, pls);
	}
}
