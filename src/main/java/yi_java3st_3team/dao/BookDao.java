package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Book;

public interface BookDao {
	Book selectBookByCode(Book book);
	Book selectBookByName(Book book);
	String selectBookByLastCode();

	List<Book> selectBookByAll();

	int insertBook(Book book);
	int updateBook(Book book);
	int deleteBook(Book book);
}
