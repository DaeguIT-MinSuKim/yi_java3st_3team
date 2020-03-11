package yi_java3st_3team.ui.service;

import yi_java3st_3team.dao.RecommendationDao;
import yi_java3st_3team.dao.impl.RecommendationDaoImpl;
import yi_java3st_3team.dto.Recommendation;

public class RecomUiService {
	private RecommendationDao recomDao;
	
	public RecomUiService() {
		recomDao = RecommendationDaoImpl.getInstance();
	}
	
	public void addRecom(Recommendation recom) {
		recomDao.insertRecommendation(recom);
	}
}
