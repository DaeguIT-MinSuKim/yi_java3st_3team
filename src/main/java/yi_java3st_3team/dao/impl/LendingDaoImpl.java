package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yi_java3st_3team.dao.LendingDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.util.LogUtil;

public class LendingDaoImpl implements LendingDao {
	private static final LendingDaoImpl instance = new LendingDaoImpl();

	public static LendingDaoImpl getInstance() {
		return instance;
	}

	private LendingDaoImpl() {
		super();
	}

	@Override
	public Lending selectLendingByNo(Lending lending) {
		String sql = "select lend_rturn_no , mber_id , book_cd , lend_date , rturn_due_date , rturn_psm_cdt , rturn_date , overdue_cdt ,overdue_date "
				+ "	from lending " + "	where lend_rturn_no = ? ";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, lending.getLendRturnNo());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getLending(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Lending getLending(ResultSet rs) throws SQLException {
		int lendRturnNo = rs.getInt("lend_rturn_no");
		Member mberId = new Member(rs.getString("mber_id"));
		Book bookCd = new Book(rs.getString("book_cd"));
		Date lendDate = rs.getTimestamp("lend_date");
		Date rturnDueDate = rs.getTimestamp("rturn_due_date");
		int rturnPsmCdt = rs.getInt("rturn_psm_cdt");
		Date rturnDate = rs.getTimestamp("rturn_date");
		int overdueCdt = rs.getInt("overdue_cdt");
		int overdueDate = rs.getInt("overdue_date");

		Lending lending = new Lending(lendRturnNo, mberId, bookCd, lendDate, rturnDueDate, rturnPsmCdt, rturnDate,
				overdueCdt, overdueDate);
		LogUtil.prnLog(lending);
		return lending;
	}

	@Override
	public List<Lending> selectLendingByAll() {
		String sql = "select lend_rturn_no , mber_id , book_cd , lend_date , rturn_due_date , rturn_psm_cdt , rturn_date , overdue_cdt ,overdue_date "
				+ "	from lending ";
		List<Lending> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			if (rs.next()) {
				list = new ArrayList<>();
				do {
					list.add(getLending(rs));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertLending(Lending lending) {
		String sql = "insert into lending(lend_rturn_no , mber_id , book_cd , lend_date , rturn_due_date , rturn_psm_cdt , rturn_date , overdue_cdt ,overdue_date) values"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, lending.getLendRturnNo());
			pstmt.setString(2, lending.getMberId().getMberId());
			pstmt.setString(3, lending.getBookCd().getBookCode());
			pstmt.setTimestamp(4, new Timestamp(lending.getLendDate().getTime()));
			pstmt.setTimestamp(5, new Timestamp(lending.getRturnDueDate().getTime()));
			pstmt.setInt(6, lending.getRturnPsmCdt());
			pstmt.setTimestamp(7, new Timestamp(lending.getRturnDate().getTime()));
			pstmt.setInt(8, lending.getOverdueCdt());
			pstmt.setInt(9, lending.getOverdueDate());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateLending(Lending lending) {
		StringBuilder sql = new StringBuilder("update lending set ");

		if (lending.getLendRturnNo() != 0) {
			sql.append("lend_rturn_no = ?, ");
		}
		if (lending.getMberId() != null) {
			sql.append("mber_id = ?, ");
		}
		if (lending.getBookCd() != null) {
			sql.append("book_cd = ?, ");
		}
		if (lending.getLendDate() != null) {
			sql.append("lend_date = ?, ");
		}
		if (lending.getRturnDueDate() != null) {
			sql.append("rturn_due_date = ?, ");
		}
		if (lending.getRturnPsmCdt() != 0) {
			sql.append("rturn_psm_cdt = ?, ");
		}
		if (lending.getRturnDate() != null) {
			sql.append("rturn_date = ?, ");
		}
		if (lending.getOverdueCdt() != 0) {
			sql.append("overdue_cdt = ?, ");
		}
		if (lending.getOverdueDate() != 0) {
			sql.append("overdue_date = ?, ");
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), " ");
		sql.append("where lend_rturn_no = ?");

		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())) {
			int argCnt = 1;

			if (lending.getMberId() != null)
				pstmt.setString(argCnt++, lending.getMberId().getMberId());
			if (lending.getBookCd() != null)
				pstmt.setString(argCnt++, lending.getBookCd().getBookCode());
			if (lending.getLendDate() != null)
				pstmt.setTimestamp(argCnt++, new Timestamp(lending.getLendDate().getTime()));
			if (lending.getRturnDueDate() != null)
				pstmt.setTimestamp(argCnt++, new Timestamp(lending.getRturnDueDate().getTime()));
			if (lending.getRturnPsmCdt() != 0)
				pstmt.setInt(argCnt++, lending.getRturnPsmCdt());
			if (lending.getRturnDate() != null)
				pstmt.setTimestamp(argCnt++, new Timestamp(lending.getRturnDate().getTime()));
			if (lending.getOverdueCdt() != 0)
				pstmt.setInt(argCnt++, lending.getOverdueCdt());
			if (lending.getOverdueDate() != 0)
				pstmt.setInt(argCnt++, lending.getOverdueDate());

			pstmt.setInt(argCnt++, lending.getLendRturnNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteLending(Lending lending) {
		String sql = "delete from lending where lend_rturn_no = ?";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, lending.getLendRturnNo());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
