package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yi_java3st_3team.dao.LargeClassificationDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.util.LogUtil;

public class LargeClassificationDaoImpl implements LargeClassificationDao {
	private static final LargeClassificationDaoImpl instace = new LargeClassificationDaoImpl();
	
	public static LargeClassificationDaoImpl getInstace() {
		return instace;
	}

	private LargeClassificationDaoImpl() {}

	@Override
	public LargeClassification selectLargeClassificationByNo(LargeClassification lclas) {
		String sql = "select lclas_no , lclas_name from large_classification where lclas_no = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, lclas.getLclasNo());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getLclas(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private LargeClassification getLclas(ResultSet rs) throws SQLException {
		int lclasNo = rs.getInt("lclas_no");
		String lclasName = rs.getString("lclas_name");
		return new LargeClassification(lclasNo, lclasName);
	}

	@Override
	public List<LargeClassification> selectLargeClassificationByAll() {
		String sql = "select lclas_no , lclas_name from large_classification";
		List<LargeClassification> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					list.add(getLclas(rs));
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertLargeClassification(LargeClassification lclas) {
		String sql = "insert into large_classification values (?, ?)";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, lclas.getLclasNo());
			pstmt.setString(2, lclas.getLclasName());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateLargeClassification(LargeClassification lclas) {
		String sql = "update large_classification set lclas_name = ? where lclas_no = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, lclas.getLclasName());
			pstmt.setInt(2, lclas.getLclasNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteLargeClassification(LargeClassification lclas) {
		String sql = "delete from large_classification where lclas_no = ?";
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, lclas.getLclasNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int selectLaseCode() {
		String sql = "select max(lclas_no) from large_classification";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				return pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
