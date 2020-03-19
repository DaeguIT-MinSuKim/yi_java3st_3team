package yi_java3st_3team.ui.service;

import java.util.List;

import yi_java3st_3team.dao.LibrarianDao;
import yi_java3st_3team.dao.TitleDao;
import yi_java3st_3team.dao.ZipCodeDao;
import yi_java3st_3team.dao.impl.LibrarianDaoImpl;
import yi_java3st_3team.dao.impl.TitleDaoImpl;
import yi_java3st_3team.dao.impl.ZipCodeDaoImpl;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.dto.ZipCode;

public class LibrarianUIService {
	private LibrarianDao libDao;
	private ZipCodeDao zipDao;
	private TitleDao titleDao;

	public LibrarianUIService() {
		libDao = LibrarianDaoImpl.getInstance();
		zipDao = ZipCodeDaoImpl.getInstance();
		titleDao = TitleDaoImpl.getInstance();
	}

	public void insertLibrarian(Librarian lib) {
		libDao.insertLibrarian(lib); //사서등록
	}

	public Librarian IDCheckLibrarian(Librarian lib) {
		return libDao.selectLibrarianById(lib); //아이디 중복체크
	}


	public void updateLibrarian(Librarian lib) {
		libDao.updateLibrarian(lib); //사서정보수정
	}

	public ZipCode zipCodeCheck(ZipCode zip) {
		return zipDao.selectZipCodeByNo(zip); //우편번호체크
	}

	public List<Librarian> showLibrarianListAll() {
		return libDao.selectLibrarianByAll(); //사서 목록, 근무여부 리스트
	}

	public List<Title> showTitleList() {
		return titleDao.selectTitleByAll(); //권한콤보박스용
	}
	
	public List<Librarian> searchLibrarianByID(Librarian lib) {
		return libDao.searchLibrarianByID(lib); //아이디로 검색
	}

	public List<Librarian> searchLibrarianByName(Librarian lib) {
		return libDao.searchLibrarianByName(lib); //이름으로 검색
	}

	public List<Librarian> showWorkList(Librarian lib) {
		return libDao.selectByWork(lib);
	}


}
