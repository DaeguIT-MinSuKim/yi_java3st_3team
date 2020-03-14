package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Book;

public interface BookDao {
	Book selectBookByCode(Book book);
	
	List<Book> selectBookByAll();
	List<Book> selectBookByCodeAndCat(Book book);
	List<Book> selectBookByNameAndCat(Book book);
	
	List<Book> selectBookOnMber(Book book);
	
	String selectBookByLastCode();
	
	int insertBook(Book book);
	int updateBook(Book book);
	int deleteBook(Book book);
	int selectLendableBooks();
	int selectDuringLendBooks();
	int selectTotalBooks();
}
