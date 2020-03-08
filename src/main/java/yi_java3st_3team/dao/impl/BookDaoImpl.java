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
	private static final BookDaoImpl instance = new BookDaoImpl();
	
	public static BookDaoImpl getInstance() {
		return instance;
	}
	
	public BookDaoImpl() {}

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
			LogUtil.prnLog(pstmt);
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
				   + " book_price , lend_psb_cdt , total_le_cnt , lc_no, ml_no , regist_date , dsuse_cdt " 
				   + " from book;";
		List<Book> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					list.add(getBook(rs, false));
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
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBook(Book book) {
		StringBuilder sql = new StringBuilder("update book set ");
		if(book.getBookName() != null) sql.append("book_name = ?, ");
		if(book.getAuthrName() != null) sql.append("authr_name = ?, ");
		if(book.getTrnslrName() != null) sql.append("trnslr_name = ?, ");
		if(book.getPls() != null) sql.append("pls = ?, ");
		if(book.getPblicteYear() != null) sql.append("pblicte_year = ?, ");
		if(book.getBookPrice() != 0) sql.append("book_price = ?, ");
		if(book.getLendPsbCdt() != 0) sql.append("lend_psb_cdt = ?, ");
		if(book.getTotalLeCnt() != 0) sql.append("total_le_cnt = ?, ");
		if(book.getBookImg() != null) sql.append("book_img = ?, ");
		if(book.getLcNo() != null) sql.append("lc_no = ?, ");
		if(book.getMlNo() != null) sql.append("ml_no = ?, ");
		if(book.getRegistDate() != null) sql.append("regist_date = ?, ");
		if(book.getDsuseCdt() != 0) sql.append("dsuse_cdt = ?, ");
		sql.replace(sql.lastIndexOf(","), sql.length(), " ");
		sql.append("where book_code = ?");
		
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())){
			int argCnt = 1;
			if(book.getBookName() != null) pstmt.setString(argCnt++, book.getBookName());
			if(book.getAuthrName() != null) pstmt.setString(argCnt++, book.getAuthrName());
			if(book.getTrnslrName() != null) pstmt.setString(argCnt++, book.getTrnslrName());
			if(book.getPls() != null) pstmt.setInt(argCnt++, book.getPls().getPlsNo());
			if(book.getPblicteYear() != null) pstmt.setTimestamp(argCnt++, new Timestamp(book.getPblicteYear().getTime()));
			if(book.getBookPrice() != 0) pstmt.setInt(argCnt++, book.getBookPrice());
			if(book.getLendPsbCdt() != 0) pstmt.setInt(argCnt++, book.getLendPsbCdt());
			if(book.getTotalLeCnt() != 0) pstmt.setInt(argCnt++, book.getTotalLeCnt());
			if(book.getBookImg() != null) pstmt.setBytes(argCnt++, book.getBookImg());
			if(book.getLcNo() != null) pstmt.setInt(argCnt++, book.getLcNo().getLclasNo());
			if(book.getMlNo() != null) pstmt.setInt(argCnt++, book.getMlNo().getMlsfcNo());
			if(book.getRegistDate() != null) pstmt.setTimestamp(argCnt++, new Timestamp(book.getRegistDate().getTime()));
			if(book.getDsuseCdt() != 0) pstmt.setInt(argCnt++, book.getDsuseCdt());
			pstmt.setString(argCnt++, book.getBookCode());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBook(Book book) {
		String sql = "delete from book where book_code = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, book.getBookCode());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Book selectBookByName(Book book) {
		String sql = "select book_code , book_name , authr_name , trnslr_name , pls , pblicte_year , "
					+ "book_price , lend_psb_cdt , total_le_cnt , book_img , lc_no, ml_no , regist_date , dsuse_cdt " 
					+ "from book " 
					+ "where book_name = ?";
		
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, book.getBookName());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getBook(rs, true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selectBookByLastCode() {
		String sql = "select max(book_code) from book";
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if(rs.next()) {
				return rs.getString("max(book_code)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

