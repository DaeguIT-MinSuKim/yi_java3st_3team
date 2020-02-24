package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yi_java3st_3team.dao.BookDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.dto.PublishingCompany;
import yi_java3st_3team.util.LogUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public Book selectBookByCode(Book book) {
		String sql = "select book_code , book_name , authr_name , trnslr_name , pls , pblicte_year ," 
				   + " book_price , lend_psb_cdt , total_le_cnt , book_img , lc_no, ml_no ," 
				   + " regist_date , dsuse_cdt " 
				   + "	from book" 
				   + "	where book_code = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, book.getBookCode());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getBook(rs, true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Book getBook(ResultSet rs, boolean isImg) throws SQLException {
		String bookCode = rs.getString("book_code");
		String bookName = rs.getString("book_name");
		String authrName = rs.getString("authr_name");
		String trnslrName = rs.getString("trnslr_name");
		PublishingCompany pls = new PublishingCompany(rs.getInt("pls"));
		Date pblicteYear = rs.getTimestamp("pblicte_year");
		int bookPrice = rs.getInt("book_price");
		int lendPsbCdt = rs.getInt("lend_psb_cdt");
		int totalLeCnt = rs.getInt("total_le_cnt");
		LargeClassification lcNo = new LargeClassification(rs.getInt("lc_no"));
		MiddleClassification mlNo = new MiddleClassification(rs.getInt("ml_no"));
		Date registDate = rs.getTimestamp("regist_date");
		int dsuseCdt = rs.getInt("dsuse_cdt");
		
		Book book = new Book(bookCode, bookName, authrName, trnslrName, pls, pblicteYear, bookPrice, 
				lendPsbCdt, totalLeCnt, lcNo, mlNo, registDate, dsuseCdt);
		if(isImg) {
			byte[] bookImg = rs.getBytes("book_img");
			book.setBookImg(bookImg);
		}
		LogUtil.prnLog(book);
		return book;
	}

	@Override
	public List<Book> selectBookByAll() {
		String sql = "select book_code , book_name , authr_name , trnslr_name , pls , pblicte_year ," 
				   + " book_price , lend_psb_cdt , total_le_cnt , book_img , lc_no, ml_no , regist_date , dsuse_cdt " 
				   + " from book;";
		List<Book> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					list.add(getBook(rs, true));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertBook(Book book) {
		String sql = "insert into book(book_code , book_name , authr_name , trnslr_name , pls , " 
					+ "	pblicte_year , book_price , lend_psb_cdt , total_le_cnt , " 
					+ "	book_img , lc_no , ml_no , regist_date , dsuse_cdt ) values" 
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, book.getBookCode());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getAuthrName());
			pstmt.setString(4, book.getTrnslrName());
			pstmt.setInt(5, book.getPls().getPlsNo());
			pstmt.setTimestamp(6, new Timestamp(book.getPblicteYear().getTime()));
			pstmt.setInt(7, book.getBookPrice());
			pstmt.setInt(8, book.getLendPsbCdt());
			pstmt.setInt(9, book.getTotalLeCnt());
			if(book.getBookImg() != null) {
				pstmt.setBytes(10, book.getBookImg());
			}
			pstmt.setInt(11, book.getLcNo().getLclasNo());
			pstmt.setInt(12, book.getMlNo().getMlsfcNo());
			pstmt.setTimestamp(13, new Timestamp(book.getRegistDate().getTime()));
			pstmt.setInt(14, book.getDsuseCdt());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBook(Book book) {
		/*update book 
		set book_name = '먼 바다', authr_name = '공지영', trnslr_name = '', pls = '2', 
			pblicte_year = '2020-02-17', book_price = 15800, lend_psb_cdt = 0, 
			total_le_cnt = 5, book_img = '', lc_no = 09, ml_no = 01, 
			regist_date ='2020-02-19', dsuse_cdt = 0
		where book_code = 'D090101';*/
		StringBuilder sql = new StringBuilder("update book set ");
		if(book.getBookName() != null) sql.append("book_name = ?, ");
		if(book.getAuthrName() != null) sql.append("authr_name = ?, ");
		if(book.getTrnslrName() != null) sql.append("trnslr_name = ?, ");
		if(book.getPls() != null) sql.append("pls = ?, ");
		if(book.getPblicteYear() != null) sql.append("pblicte_year = ?, ");
		if(book.getBookPrice() != 0) sql.append("book_price = ?, ");
		
		return 0;
	}

	@Override
	public int deleteBook(Book book) {
		return 0;
	}

	

}
