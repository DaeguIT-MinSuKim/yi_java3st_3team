package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.util.LogUtil;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();

	public MemberDaoImpl() {
	}

	public static MemberDao getInstance() {
		return instance;
	}

	private String nowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String now = sdf.format(time);
		return now;
	}

	@Override
	public Member selectMemberByNo(Member member) {
		String sql = "select mber_id, mber_pass, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, lend_psb_cdt, join_dt, wdr_cdt from member where mber_id = ?";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getMberId());
//			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMember(rs, true);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> selectMemberByAll() {
		String sql = "select mber_id, mber_name, mber_brthdy, mber_bass_ad, mber_detail_ad, mber_tel, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt\r\n" + 
					  "from member";
		List<Member> list = null;
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			if (rs.next()) {
				list = new ArrayList<>();
				do {
					list.add(getMember(rs, false));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertMember(Member member) {
		String sql = "insert into member(mber_id, mber_pass,mber_name, mber_brthdy,mber_zip,mber_bass_ad,mber_detail_ad,mber_tel,mber_img,join_dt) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, member.getMberId());
			pstmt.setString(2, member.getMberPass());
			pstmt.setString(3, member.getMberName());
			pstmt.setTimestamp(4, new Timestamp(member.getMberBrthdy().getTime()));
			pstmt.setInt(5, member.getMberZip().getZipCode());
			pstmt.setString(6, member.getMberBassAd());
			pstmt.setString(7, member.getMberDetailAd());
			pstmt.setString(8, member.getMberTel());
			if (member.getMberImg() != null) {
				pstmt.setBytes(9, member.getMberImg());
			}
			pstmt.setString(10, nowTime());

//			pstmt.setInt(10, member.getTotalLeCnt());
//			pstmt.setInt(11, member.getLendBookCnt());
//			pstmt.setInt(12, member.getGrade().getGradeNo());
//			pstmt.setInt(13, member.getLendPsbCdt());
//			pstmt.setTimestamp(14, new Timestamp(member.getJoinDt().getTime()));
//			pstmt.setInt(15, member.getWdrCdt());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		StringBuffer sql = new StringBuffer("update member set "); // 띄워쓰기 주의하자!
		if (member.getMberPass() != null)
			sql.append("mber_pass=?, ");
		if (member.getMberName() != null)
			sql.append("mber_name=?, ");
		if (member.getMberBrthdy() != null)
			sql.append("mber_brthdy=?, ");
		if (member.getMberZip() != null)
			sql.append("mber_zip=?, ");
		if (member.getMberBassAd() != null)
			sql.append("mber_bass_ad=?, ");
		if (member.getMberDetailAd() != null)
			sql.append("mber_detail_ad=?, ");
		if (member.getMberTel() != null)
			sql.append("mber_tel=?, ");
		if (member.getMberImg() != null)
			sql.append("mber_img=?, ");
		if (member.getTotalLeCnt() != 0)
			sql.append("total_le_cnt=?, ");
		if (member.getLendBookCnt() != 0)
			sql.append("lend_book_cnt=?, ");
		if (member.getGrade() != null)
			sql.append("grade=?, ");
		if (member.getLendPsbCdt() != 0)
			sql.append("lend_psb_cdt=?, ");
		if (member.getJoinDt() != null)
			sql.append("join_dt=?, ");
		if (member.getWdrCdt() != 0)
			sql.append("wdr_cdt=?, ");
		sql.replace(sql.lastIndexOf(","), sql.length(), " ");
		sql.append("where mber_id=?");

		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())) {
			int argCnt = 1;

			if (member.getMberPass() != null)
				pstmt.setString(argCnt++, member.getMberPass());
			if (member.getMberName() != null)
				pstmt.setString(argCnt++, member.getMberName());
			if (member.getMberBrthdy() != null)
				pstmt.setTimestamp(argCnt++, new Timestamp(member.getMberBrthdy().getTime()));
			if (member.getMberZip() != null)
				pstmt.setInt(argCnt++, member.getMberZip().getZipCode());
			if (member.getMberBassAd() != null)
				pstmt.setString(argCnt++, member.getMberBassAd());
			if (member.getMberDetailAd() != null)
				pstmt.setString(argCnt++, member.getMberDetailAd());
			if (member.getMberTel() != null)
				pstmt.setString(argCnt++, member.getMberTel());
			if (member.getMberImg() != null)
				pstmt.setBytes(argCnt++, member.getMberImg());
			if (member.getTotalLeCnt() != 0)
				pstmt.setInt(argCnt++, member.getTotalLeCnt());
			if (member.getLendBookCnt() != 0)
				pstmt.setInt(argCnt++, member.getLendBookCnt());
			if (member.getGrade() != null)
				pstmt.setInt(argCnt++, member.getGrade().getGradeNo());
			if (member.getLendPsbCdt() != 0)
				pstmt.setInt(argCnt++, member.getLendPsbCdt());
			if (member.getJoinDt() != null)
				pstmt.setTimestamp(argCnt++, new Timestamp(member.getJoinDt().getTime()));
			if (member.getWdrCdt() != 0)
				pstmt.setInt(argCnt++, member.getWdrCdt());
			pstmt.setString(argCnt++, member.getMberId());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteMember(Member member) {
		String sql = "delete from member where mber_id=?";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, member.getMberId());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Member loginMember(Member member) {
		String sql = "select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , mber_detail_ad , mber_tel , total_le_cnt , "
				+ "	   lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt  " + "	from member "
				+ "	where mber_id = ? and mber_pass = ?";

		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, member.getMberId());
			pstmt.setString(2, member.getMberPass());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMember(rs, false);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Member getMember(ResultSet rs, boolean isImg) throws SQLException {
		String mberId = rs.getString("mber_id");
		String mberPass = rs.getString("mber_pass");
		String mberName = rs.getString("mber_name");
		Date mberBrthdy = rs.getTimestamp("mber_brthdy");
		ZipCode mberZip = new ZipCode(rs.getInt("mber_zip"));
		String mberBassAd = rs.getString("mber_bass_ad");
		String mberDetailAd = rs.getString("mber_detail_ad");
		String mberTel = rs.getString("mber_tel");
		int totalLeCnt = rs.getInt("total_le_cnt");
		int lendBookCnt = rs.getInt("lend_book_cnt");
		Grade grade = new Grade(rs.getInt("grade"));
		int lendPsbCdt = rs.getInt("lend_psb_cdt");
		Date joinDt = rs.getTimestamp("join_dt");
		int wdrCdt = rs.getInt("wdr_cdt");
		Member mber = new Member(mberId, mberPass, mberName, mberBrthdy, mberZip, mberBassAd, mberDetailAd, mberTel,
				totalLeCnt, lendBookCnt, grade, lendPsbCdt, joinDt, wdrCdt);
		if (isImg) {
			byte[] mberImg = rs.getBytes("mber_img");
			mber.setMberImg(mberImg);
		}
		LogUtil.prnLog("getMember => " + mber);
		return mber;
	}

	@Override
	public Member findMemberId(Member member) {
		String sql = "select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , mber_detail_ad , mber_tel , total_le_cnt , "
				+ " lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt " + "	from member "
				+ "	where mber_name = ? and mber_brthdy = ?";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, member.getMberName());
			pstmt.setTimestamp(2, new Timestamp(member.getMberBrthdy().getTime()));
			;
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMember(rs, false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member findMemberPw(Member member) {
		String sql = "select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , mber_detail_ad , mber_tel , total_le_cnt , "
				+ " lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt " + "	from member "
				+ "	where mber_id = ? and mber_name = ? and mber_brthdy = ?";
		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, member.getMberId());
			pstmt.setString(2, member.getMberName());
			pstmt.setTimestamp(3, new Timestamp(member.getMberBrthdy().getTime()));
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMember(rs, false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



//	public Member selectLendingMemberByNo(Member member) {
////		String sql = "select m.mber_id , m.mber_name , g.grad_name , m.lend_psb_cdt , (g.book_le_cnt - count(l.rturn_date)) as 'lend_book_cnt'\r\n"
////				+ "	from member m left join lending l on m.mber_id = l.mber_id left join grade g on m.grade = g.grade_no \r\n"
////				+ "	where m.mber_id = ? and l.rturn_date = '0000-00-00 00:00:00'";
//		String sql = "select mber_id, mber_pass, mber_name, mber_brthdy, mber_zip,mber_bass_ad,mber_detail_ad,mber_tel,mber_img,total_le_cnt,lend_book_cnt,grade ,lend_psb_cdt ,join_dt ,wdr_cdt ,od_cnt \r\n" + 
//				"	from member\r\n" + 
//				"	where mber_id = ?";
//		try (Connection con = MysqlDataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
//			pstmt.setString(1, member.getMberId());
//			LogUtil.prnLog(pstmt);
//			try (ResultSet rs = pstmt.executeQuery()) {
//				if (rs.next()) {
//					return getMember(rs, isImg);
//				}
//			}
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		return null;
//	}

//	private Member getMember(ResultSet rs) throws SQLException {
//		String mberId = rs.getString("mber_id");
//		String mberName = rs.getString("mber_name");
//		int lendPsbCdt = rs.getInt("lend_psb_cdt");
//		int lendBookCnt = rs.getInt("lend_book_cnt");
////		Grade grade = new Grade();
////		grade.setGradeName(rs.getString("grad_name"));
//		Grade grade = new Grade(rs.getInt("grade"));
//		Member mber = new Member(mberId, mberName, lendBookCnt, grade, lendPsbCdt);
//		LogUtil.prnLog("getMember => " + mber);
//		return mber;
//	}
}
