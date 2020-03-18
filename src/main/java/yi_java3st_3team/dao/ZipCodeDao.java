package yi_java3st_3team.dao;

import yi_java3st_3team.dto.ZipCode;

public interface ZipCodeDao {
	public abstract ZipCode selectZipCodeByNo(ZipCode zip); //우편번호체크
}
