package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.PublishingCompanyDao;
import yi_java3st_3team.dao.impl.PublishingCompanyDaoImpl;
import yi_java3st_3team.dto.PublishingCompany;

public class PublishingCompanyUiService {
	private PublishingCompanyDao plsDao;
	
	public PublishingCompanyUiService() {
		plsDao = PublishingCompanyDaoImpl.getInstance();
	}
	
	public List<PublishingCompany> showPlsListAll() {
		return plsDao.selectPublishingCompanyByAll();
	}
	
	public void addPls(PublishingCompany pls) {
		plsDao.insertPublishingCompany(pls);
	}
	
	public void modifyPls(PublishingCompany pls) {
		plsDao.updatePublishingCompany(pls);
	}
	
	public void removePls(PublishingCompany pls) {
		plsDao.deletePublishingCompany(pls);
	}
	
	public int getLastCode() {
		return plsDao.selectLastCode();
	}
}
