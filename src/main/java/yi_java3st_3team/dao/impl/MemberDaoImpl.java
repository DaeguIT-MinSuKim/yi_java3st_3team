package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	public MemberDaoImpl() {}

	@Override
	public Member selectMemberByNo(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> selectMemberByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member loginMember(Member member) {
		String sql = "select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , mber_detail_ad , mber_tel , total_le_cnt , " 
					+ "	   lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt  "  
					+ "	from member "
					+ "	where mber_id = ? and mber_pass = ?";
		
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, member.getMberId());
			pstmt.setString(2, member.getMberPass());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getMember(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		String mberId = rs.getString("mber_id");
		String mberPass = rs.getString("mber_pass");
		
		return new Member(mberId, mberPass);
	}

//	private Member getMember(ResultSet rs) throws SQLException {
//		String mberId = rs.getString("mber_id");
//		String mberPass = rs.getString("mber_pass");
//		String mberName = rs.getString("mber_name");
//		Date mberbirthday = rs.getTimestamp("mber_brthdy");
//		ZipCode mberZip = new ZipCode(rs.getInt("mber_zip"));
//		String mberBassAd = rs.getString("mber_bass_ad");
//		String mberDetailAd = rs.getString("columnIndex");
//		String mberTel = rs.getString("mber_tel");
//		int totalLeCnt = rs.getInt("total_le_cnt");
//		int lendBookCnt = rs.getInt("lend_book_cnt");
//		Grade grade = new Grade(rs.getInt("grade"));
//		int lendPsbCdt = rs.getInt("lend_psb_cdt");
//		Date joinDt = rs.getTimestamp("join_dt");
//		int wdrCdt = rs.getInt("wdr_cdt");
//		
//		return new Member(mberId, mberPass, mberName, mberbirthday, mberZip, mberBassAd, mberDetailAd, mberTel, totalLeCnt, lendBookCnt, grade, lendPsbCdt, joinDt, wdrCdt);
//	}

}
