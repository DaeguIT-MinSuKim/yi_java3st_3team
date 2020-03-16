package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.MiddleClassificationDao;
import yi_java3st_3team.dao.impl.MiddleClassificationDaoImpl;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;

public class MiddleClassIficationUiservice {
	private MiddleClassificationDao mlDao;
	
	public MiddleClassIficationUiservice() {
		mlDao = MiddleClassificationDaoImpl.getInstance();
	}
	
	public List<MiddleClassification> showListAll() {
		return mlDao.selectMiddleClassificationByAll();
	}
	
	public int getMlLastCode(LargeClassification lc) {
		return mlDao.selectLastCode(lc);
	}
	
	public int removeMl(MiddleClassification ml) {
		return mlDao.deleteMiddleClassification(ml);
	}
	
	public int addMl(MiddleClassification ml) {
		return mlDao.insertMiddleClassification(ml);
	}
	
	public int modifyMl(MiddleClassification ml) {
		return mlDao.updateMiddleClassification(ml);
	}
}
