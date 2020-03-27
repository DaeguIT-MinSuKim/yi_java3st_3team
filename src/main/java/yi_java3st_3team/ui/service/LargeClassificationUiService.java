package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.LargeClassificationDao;
import yi_java3st_3team.dao.impl.LargeClassificationDaoImpl;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;

public class LargeClassificationUiService {
	private LargeClassificationDao lcDao;
	
	public LargeClassificationUiService() {
		lcDao = LargeClassificationDaoImpl.getInstace();
	}
	
	public List<LargeClassification> showLcListAll() {
		return lcDao.selectLargeClassificationByAll();
	}

	public int getLcLastCode() {
		return lcDao.selectLaseCode();
	}
	
	public int addLc(LargeClassification lc) {
		return lcDao.insertLargeClassification(lc);
	}
	
	public int modifyLc(LargeClassification lc) {
		return lcDao.updateLargeClassification(lc);
	}
	
	public int removeLc(LargeClassification lc) {
		return lcDao.deleteLargeClassification(lc);
	}
	
	public int checkMl(int lcNo) {
		return lcDao.selectLargeClassificationByNoAndMl(lcNo);
	}
}

