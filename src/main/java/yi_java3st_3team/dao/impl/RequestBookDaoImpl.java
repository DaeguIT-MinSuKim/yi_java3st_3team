package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yi_java3st_3team.dao.RequestBookDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.RequestBook;
import yi_java3st_3team.util.LogUtil;

public class RequestBookDaoImpl implements RequestBookDao {
	private static final RequestBookDaoImpl instance = new RequestBookDaoImpl();
	
	public static RequestBookDaoImpl getInstance() {
		return instance;
	}
	
	private RequestBookDaoImpl() {}

	@Override
	public List<RequestBook> selectRequestBookByDate(RequestBook rb) {
		String sql = "select reqst_book_no , reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , " 
					+ "reqst_mb_id , reqst_date , wh_cdt " 
					+ " from request_book " 
					+ "	where year(reqst_date) = ? and month(reqst_date) = ?";
		List<RequestBook> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, new Timestamp(rb.getRequestDate().getTime()).toString().substring(0, 4));;
			pstmt.setString(2, new Timestamp(rb.getRequestDate().getTime()).toString().substring(5, 7));
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					list = new ArrayList<>();
					do {
						list.add(getRequestBook(rs));
					} while(rs.next());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private RequestBook getRequestBook(ResultSet rs) throws SQLException {
		int requestBookNo = rs.getInt("reqst_book_no");
		Member requestMbId = new Member(rs.getString("reqst_mb_id"));
		String requestBookName = rs.getString("reqst_book_name");
		String requestBookAuthor = rs.getString("reqst_book_author");
		String requestBookTrnslr = rs.getString("reqst_book_trnslr");
		String requestBookPls = rs.getString("request_book_pls");
		Date requestDate = rs.getTimestamp("reqst_date");
		int whCdt = rs.getInt("wh_cdt");
		
		return new RequestBook(requestBookNo, requestMbId, requestBookName, requestBookAuthor, requestBookTrnslr, 
								requestBookPls, requestDate, whCdt);
	}

	@Override
	public List<RequestBook> selectRequestBookByAll() {
		String sql = "select reqst_book_no , reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , " 
					+ "reqst_mb_id , reqst_date , wh_cdt " 
					+ "	from request_book ";
		List<RequestBook> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				list = new ArrayList<>();
				do {					
					list.add(getRequestBook(rs));
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<RequestBook> selectRequestBookById(RequestBook rb) {
		String sql = "select reqst_book_no , reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , " 
					+ "reqst_mb_id , reqst_date , wh_cdt \r\n" 
					+ "	from request_book\r\n" 
					+ "	where reqst_mb_id = ?";
		List<RequestBook> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, rb.getRequestMbId().getMberId());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					list = new ArrayList<>();
					do {						
						list.add(getRequestBook(rs));
					} while(rs.next());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertRequestBook(RequestBook rb) {
		String sql = "insert into request_book"
					+ "(reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt)\r\n" 
					+ "	values (?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, rb.getRequestBookName());
			pstmt.setString(2, rb.getRequestBookAuthor());
			pstmt.setString(3, rb.getRequestBookTrnslr());
			pstmt.setString(4, rb.getRequestBookPls());
			pstmt.setString(5, rb.getRequestMbId().getMberId());
			pstmt.setTimestamp(6, new Timestamp(rb.getRequestDate().getTime()));
			pstmt.setInt(7, rb.getWhCdt());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateRequestBook(RequestBook rb) {
		StringBuilder sql = new StringBuilder("update request_book set ");
		if(rb.getRequestMbId() != null) sql.append("reqst_mb_id = ?, ");
		if(rb.getRequestBookName() != null) sql.append("reqst_book_name = ?, ");
		if(rb.getRequestBookAuthor() != null) sql.append("reqst_book_author = ?, ");
		if(rb.getRequestBookTrnslr() != null) sql.append("reqst_book_trnslr = ?, ");
		if(rb.getRequestBookPls() != null) sql.append("request_book_pls = ?, ");
		if(rb.getRequestDate() != null) sql.append("reqst_date = ?, ");
		if(rb.getWhCdt() != 0) sql.append("wh_cdt = ?, ");
		sql.replace(sql.lastIndexOf(","), sql.length(), " ");
		sql.append("where reqst_book_no = ?");
		
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())) {
			int argCnt = 1;
			
			if(rb.getRequestMbId() != null) pstmt.setString(argCnt++, rb.getRequestMbId().getMberId());;
			if(rb.getRequestBookName() != null) pstmt.setString(argCnt++, rb.getRequestBookName());;
			if(rb.getRequestBookAuthor() != null) pstmt.setString(argCnt++, rb.getRequestBookAuthor());;
			if(rb.getRequestBookTrnslr() != null) pstmt.setString(argCnt++, rb.getRequestBookTrnslr());;
			if(rb.getRequestBookPls() != null) pstmt.setString(argCnt++, rb.getRequestBookPls());;
			if(rb.getRequestDate() != null) pstmt.setTimestamp(argCnt++, new Timestamp(rb.getRequestDate().getTime()));;
			if(rb.getWhCdt() != 0) pstmt.setInt(argCnt++, rb.getWhCdt());;
			pstmt.setInt(argCnt++, rb.getRequestBookNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteRequestBook(RequestBook rb) {
		String sql = "delete from request_book where reqst_book_no = ?";
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, rb.getRequestBookNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
