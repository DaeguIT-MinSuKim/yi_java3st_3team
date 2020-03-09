package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.BookDao;
import yi_java3st_3team.dao.LargeClassificationDao;
import yi_java3st_3team.dao.MiddleClassificationDao;
import yi_java3st_3team.dao.PublishingCompanyDao;
import yi_java3st_3team.dao.impl.BookDaoImpl;
import yi_java3st_3team.dao.impl.LargeClassificationDaoImpl;
import yi_java3st_3team.dao.impl.MiddleClassificationDaoImpl;
import yi_java3st_3team.dao.impl.PublishingCompanyDaoImpl;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.dto.PublishingCompany;

public class BookUiService {
	private BookDao bookDao;
	private LargeClassificationDao lcDao;
	private MiddleClassificationDao mlDao;
	private PublishingCompanyDao plsDao;

	public BookUiService() {
		bookDao = BookDaoImpl.getInstance();
		lcDao = LargeClassificationDaoImpl.getInstace();
		mlDao = MiddleClassificationDaoImpl.getInstance();
		plsDao = PublishingCompanyDaoImpl.getInstance();
	}
	
	public List<LargeClassification> showLcList() {
		return lcDao.selectLargeClassificationByAll();
	}
	
	public List<MiddleClassification> showMlList(LargeClassification lc) {
		return mlDao.selectMiddleClassificationGroupLc(lc);
	}
	
	public List<PublishingCompany> showPlsList() {
		return plsDao.selectPublishingCompanyByAll();
	}
	
	public String getLastCode() {
		return bookDao.selectBookByLastCode();
	}
	
	public void addBook(Book book) {
		bookDao.insertBook(book);
	}
}