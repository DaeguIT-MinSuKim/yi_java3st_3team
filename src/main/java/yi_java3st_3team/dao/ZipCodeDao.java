package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.ZipCode;

public interface ZipCodeDao {
	ZipCode selectZipCodeByNo(ZipCode zip);

	List<ZipCode> selectZipCodeByAll();

	int insertZipCode(ZipCode zip);

	int updateZipCode(ZipCode zip);

	int deleteZipCode(ZipCode zip);
}
