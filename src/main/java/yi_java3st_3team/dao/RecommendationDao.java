package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Recommendation;

public interface RecommendationDao {
	Recommendation selectRecommendationByNo(Recommendation recommend);

	List<Recommendation> selectRecommendationByAll();

	int insertRecommendation(Recommendation recommend);

	int updateRecommendation(Recommendation recommend);

	int deleteRecommendation(Recommendation recommend);
}
