package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Librarian;

public interface LibrarianDao {
	Librarian selectLibrarianById(Librarian lib); //아이디중복체크
	Librarian loginLibrarian(Librarian lib);
	Librarian findLibrarianId(Librarian lib);
	Librarian findLibrarianPw(Librarian lib);
	
	
	List<Librarian> selectLibrarianByAll(); //사서의 목록,근무여부
	List<Librarian> searchLibrarianByID(Librarian lib); //아이디로검색
	List<Librarian> searchLibrarianByName(Librarian lib); //이름으로 검색
	List<Librarian> selectByWork(Librarian lib);
	
	int insertLibrarian(Librarian lib); //사서등록
	int updateLibrarian(Librarian lib); //사서정보수정
	int deleteLibrarian(Librarian lib);
}
