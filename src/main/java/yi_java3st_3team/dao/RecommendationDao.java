package yi_java3st_3team.dao;

import yi_java3st_3team.dto.Recommendation;

public interface RecommendationDao {
	Recommendation selectRecommendationByLastNo();
	Recommendation selectRecommendationByBookCode(Recommendation recommend);

	int insertRecommendation(Recommendation recommend);
	int updateRecommendation(Recommendation recommend);
	int deleteRecommendation(Recommendation recommend);

}
