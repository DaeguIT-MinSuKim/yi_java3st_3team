package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import yi_java3st_3team.dao.RecommendationDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.dto.PublishingCompany;
import yi_java3st_3team.dto.Recommendation;
import yi_java3st_3team.util.LogUtil;

public class RecommendationDaoImpl implements RecommendationDao {
	private static final RecommendationDaoImpl instance = new RecommendationDaoImpl();
	
	public static RecommendationDao getInstance() {
		return instance;
	}

	@Override
	public Recommendation selectRecommendationByLastNo() {
		String sql = "select r.recom_book_no , r.book_code , r.book_cont , "
					+ "lc.lclas_no , lc.lclas_name , ml.mlsfc_no , ml.mlsfc_name , " 
					+ "b.authr_name , b.trnslr_name , b.book_name , pls.pls_no , pls.pls_name , b.book_img, b.pblicte_year " 
					+ " from recommendation r join book b on b.book_code = r.book_code  \r\n" 
					+ "		join large_classification lc on b.lc_no = lc.lclas_no \r\n" 
					+ "		join middle_classification ml on b.ml_no = ml.mlsfc_no and b.lc_no = ml.lclas_no \r\n" 
					+ "		join publishing_company pls on b.pls = pls.pls_no \r\n" 
					+ "	order by r.recom_book_no desc limit 1";
		
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				return getRecommendation(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Recommendation selectRecommendationByBookCode(Recommendation recommend) {
		String sql = "select r.recom_book_no , r.book_code , r.book_cont , "
				+ "lc.lclas_no , lc.lclas_name , ml.mlsfc_no , ml.mlsfc_name , " 
				+ "b.authr_name , b.trnslr_name , b.book_name , pls.pls_no , pls.pls_name , b.book_img, b.pblicte_year " 
				+ " from recommendation r join book b on b.book_code = r.book_code  \r\n" 
				+ "		join large_classification lc on b.lc_no = lc.lclas_no \r\n" 
				+ "		join middle_classification ml on b.ml_no = ml.mlsfc_no and b.lc_no = ml.lclas_no \r\n" 
				+ "		join publishing_company pls on b.pls = pls.pls_no \r\n" 
				+ "	where r.book_code = ?";
		
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, recommend.getBookCode().getBookCode());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getRecommendation(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Recommendation getRecommendation(ResultSet rs) throws SQLException {
		Book bookCode = new Book(rs.getString("book_code"));
		bookCode.setLcNo(new LargeClassification(rs.getInt("lclas_no"), rs.getString("lclas_name")));
		bookCode.setMlNo(new MiddleClassification(bookCode.getLcNo() ,rs.getInt("mlsfc_no"), rs.getString("mlsfc_name")));
		bookCode.setAuthrName(rs.getString("authr_name"));
		bookCode.setTrnslrName(rs.getString("trnslr_name"));
		bookCode.setBookName(rs.getString("book_name"));
		bookCode.setPls(new PublishingCompany(rs.getInt("pls_no"), rs.getString("pls_name")));
		bookCode.setBookImg(rs.getBytes("book_img"));
		bookCode.setPblicteYear(rs.getTimestamp("b.pblicte_year"));
		
		int recomBookNo = rs.getInt("recom_book_no");
		String bookCont = rs.getString("book_cont");
		return new Recommendation(recomBookNo, bookCode, bookCont);
	}

	@Override
	public int insertRecommendation(Recommendation recommend) {
		String sql = "insert into recommendation(book_code, book_cont) values (?, ?)";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, recommend.getBookCode().getBookCode());
			pstmt.setString(2, recommend.getBookCont());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateRecommendation(Recommendation recommend) {
		String sql = "update recommendation set book_cont = ? where book_code = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, recommend.getBookCont());
			pstmt.setString(2, recommend.getBookCode().getBookCode());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteRecommendation(Recommendation recommend) {
		String sql = "delete from recommendation where book_code = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, recommend.getBookCode().getBookCode());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
