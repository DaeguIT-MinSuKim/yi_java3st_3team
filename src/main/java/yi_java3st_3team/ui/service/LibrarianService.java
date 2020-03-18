package yi_java3st_3team.ui.service;

import java.sql.SQLException;
import java.util.List;

import yi_java3st_3team.dao.LibrarianDao;
import yi_java3st_3team.dao.impl.LibrarianDaoImpl;
import yi_java3st_3team.dto.Librarian;

public class LibrarianService {
	private LibrarianDao dao;

	public LibrarianService() {
		dao = LibrarianDaoImpl.getInstance();
	}
	public List<Librarian> showLibrarians() throws SQLException {
		return dao.selectLibrarianByAll();
	}
	public Librarian showLibrarianById(Librarian lib) throws SQLException {
		return dao.selectLibrarianById(lib);
	}
	public int addLibrarian(Librarian lib) throws SQLException {
		return dao.insertLibrarian(lib);
	}
	public int modifyLibrarian(Librarian lib) throws SQLException {
		return dao.updateLibrarian(lib);
	}
	public int removeLibrarian(Librarian lib) throws SQLException {
		return dao.deleteLibrarian(lib);
	}
}
