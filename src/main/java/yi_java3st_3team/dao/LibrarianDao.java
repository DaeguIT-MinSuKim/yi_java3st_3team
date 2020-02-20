package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Librarian;

public interface LibrarianDao {
	Librarian selectLibrarianByNo(Librarian lib);

	List<Librarian> selectLibrarianByAll();

	int insertLibrarian(Librarian lib);

	int updateLibrarian(Librarian lib);

	int deleteLibrarian(Librarian lib);
}
