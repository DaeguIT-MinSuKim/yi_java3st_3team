package yi_java3st_3team.dao;

import java.awt.print.Book;
import java.util.List;

public interface BookDao {
	Book selectBookByNo(Book book);

	List<Book> selectBookByAll();

	int insertBook(Book book);

	int updateBook(Book book);

	int deleteBook(Book book);
}
