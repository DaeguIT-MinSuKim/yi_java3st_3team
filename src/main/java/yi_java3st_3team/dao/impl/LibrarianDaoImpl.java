package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import yi_java3st_3team.dao.LibrarianDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.util.LogUtil;

public class LibrarianDaoImpl implements LibrarianDao {
	private static final LibrarianDaoImpl instance = new LibrarianDaoImpl();

	public LibrarianDaoImpl() {
	}

	public static LibrarianDaoImpl getInstance() {
		return instance;
	}

	@Override
	public Librarian selectLibrarianByNo(Librarian lib) {
		String sql = "select lb_id, lb_pass, lb_name ,lb_birthday ,lb_zip ,lb_bass_ad ,lb_detail_ad ,lb_tel ,title ,join_date ,work_cdt"
				+ "from librarian" + "where lb_id = ?";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			LogUtil.prnLog(pstmt);
			pstmt.setString(1, lib.getLbId());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getLibrarian(rs);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	private Librarian getLibrarian(ResultSet rs) throws SQLException {
		String lbId = rs.getString("lb_id");
		String lbPass = rs.getString("lb_pass");
		String lbName = rs.getString("lb_name");
		Date lbBirthDay = rs.getTimestamp("lb_birthday");
		ZipCode lbZip = new ZipCode(rs.getInt("lb_zip"));
		String lbBassAd = rs.getString("lb_bass_ad");
		String lbDetailAd = rs.getString("lb_detail_ad");
		String lbTel = rs.getString("lb_tel");
		Title title = new Title(rs.getInt("title"));
		Date joinDate = rs.getTimestamp("join_date");
		boolean workCdt = rs.getInt("work_cdt") == 0 ? false : true;
		
		return new Librarian(lbId, lbPass, lbName, lbBirthDay, lbZip, lbBassAd, lbDetailAd, lbTel, title, joinDate, workCdt);
	}

	@Override
	public List<Librarian> selectLibrarianByAll() {
		return null;
	}

	@Override
	public int insertLibrarian(Librarian lib) {
		return 0;
	}

	@Override
	public int updateLibrarian(Librarian lib) {
		return 0;
	}

	@Override
	public int deleteLibrarian(Librarian lib) {
		return 0;
	}

	@Override
	public Librarian loginLibrarian(Librarian lib) {
		String sql = "select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, "
				+ "lb_tel, title, join_date, work_cdt "
				+ "from librarian "
				+ "where lb_id = ? and lb_pass = ?";
		
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, lib.getLbId());
			pstmt.setString(2, lib.getLbPass());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getLibrarian(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
