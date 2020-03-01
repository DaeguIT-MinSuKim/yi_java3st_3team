package yi_java3st_3team.ui.service;

import yi_java3st_3team.dao.RecommendationDao;
import yi_java3st_3team.dao.impl.RecommendationDaoImpl;
import yi_java3st_3team.dto.Recommendation;

public class LoginUiService {
	private RecommendationDao recomDao;
	
	public LoginUiService() {
		recomDao = RecommendationDaoImpl.getInstance();
	}
	
	public Recommendation showRecommendationByListNO() {
		return recomDao.selectRecommendationByLastNo();
	}

}
