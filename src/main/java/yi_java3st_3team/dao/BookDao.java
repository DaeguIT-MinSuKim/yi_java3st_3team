package yi_java3st_3team.dao;

import java.util.List;

import yi_java3st_3team.dto.Book;

public interface BookDao {
	Book selectBookByCode(Book book);

	List<Book> selectBookByAll();

	List<Book> selectBookByCodeAndCat(Book book);

	List<Book> selectBookByNameAndCat(Book book);

	List<Book> selectBookOnMber(Book book);
	
	List<Book> selectBookAllOnMber();

	String selectBookByOverlapBookLastCode(String bName, String aName, int pls);
	
	String selectBookByCatLastCode(int lcNo, int mlNo);

	List<Book> LendingBookByCode(Book book);

	int insertBook(Book book);

	int updateBook(Book book);

	int deleteBook(Book book);

	int selectLendableBooks();

	int selectDuringLendBooks();

	int selectTotalBooks();

	int selectDisposalBooks();

	int[] selectCountByCate();

	List<Book> selectNewBookList();

	List<Book> lendingBookByName(Book book);
}
