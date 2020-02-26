package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yi_java3st_3team.dao.MiddleClassificationDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.util.LogUtil;

public class MiddleClassificationDaoImpl implements MiddleClassificationDao {
	private static final MiddleClassificationDaoImpl instance = new MiddleClassificationDaoImpl();
	
	public static MiddleClassificationDaoImpl getInstance() {
		return instance;
	}
	
	public MiddleClassificationDaoImpl() {}

	@Override
	public MiddleClassification selectMiddleClassificationByNo(MiddleClassification mlsfc) {
		String sql = "select lclas_no , mlsfc_no , mlsfc_name from middle_classification "
					+ "where lclas_no = ? and mlsfc_no = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, mlsfc.getLclasNo().getLclasNo());
			pstmt.setInt(2, mlsfc.getMlsfcNo());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getMlsfc(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private MiddleClassification getMlsfc(ResultSet rs) throws SQLException {
		LargeClassification lclasNo = new LargeClassification(rs.getInt("lclas_no"));
		int mlsfcNo = rs.getInt("mlsfc_no");
		String mlsfcName = rs.getString("mlsfc_name");
		
		return new MiddleClassification(lclasNo, mlsfcNo, mlsfcName);
	}

	@Override
	public List<MiddleClassification> selectMiddleClassificationByAll() {
		String sql = "select lclas_no , mlsfc_no , mlsfc_name from middle_classification";
		List<MiddleClassification> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				list = new ArrayList<>();
				while(rs.next()) {
					list.add(getMlsfc(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertMiddleClassification(MiddleClassification mlsfc) {
		String sql = "insert into middle_classification values(?, ?, ?)";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, mlsfc.getLclasNo().getLclasNo());
			pstmt.setInt(2, mlsfc.getMlsfcNo());
			pstmt.setString(3, mlsfc.getMlsfcName());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMiddleClassification(MiddleClassification mlsfc) {
		String sql = "update middle_classification set mlsfc_name = ? where lclas_no = ? and mlsfc_no = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, mlsfc.getMlsfcName());
			pstmt.setInt(2, mlsfc.getLclasNo().getLclasNo());
			pstmt.setInt(3, mlsfc.getMlsfcNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMiddleClassification(MiddleClassification mlsfc) {
		String sql = "delete from middle_classification where lclas_no = ? and mlsfc_no = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, mlsfc.getLclasNo().getLclasNo());
			pstmt.setInt(2, mlsfc.getMlsfcNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}