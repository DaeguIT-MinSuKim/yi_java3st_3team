package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.PublishingCompany;

public interface PublishingCompanyDao {
	PublishingCompany selectPublishingCompanyByNo(PublishingCompany pc);

	List<PublishingCompany> selectPublishingCompanyByAll();

	int insertPublishingCompany(PublishingCompany pc);

	int updatePublishingCompany(PublishingCompany pc);

	int deletePublishingCompany(PublishingCompany pc);
	
	int selectLastCode();
}
