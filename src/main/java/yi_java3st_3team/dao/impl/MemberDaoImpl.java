package yi_java3st_3team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.ds.MysqlDataSource;
import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.util.LogUtil;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();
	
	public MemberDaoImpl() {}
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	@Override
	public Member selectMemberByNo(Member member) {
		String sql = "select mber_id, mber_pass, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, lend_psb_cdt, join_dt, wdr_cdt from member where mber_id = ?";
		try (Connection con = MysqlDataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getMberId());
			LogUtil.prnLog(pstmt);
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
		String sql = "select * from member";
		List<Member> list =null;
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					list.add(getMember(rs, true));
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public int insertMember(Member member) {
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getMberId());
			pstmt.setString(2, member.getMberPass());
			pstmt.setString(3, member.getMberName());
			pstmt.setTimestamp(4, new Timestamp(member.getMberBrthdy().getTime()));
			pstmt.setInt(5, member.getMberZip().getZipCode());
			pstmt.setString(6, member.getMberBassAd());
			pstmt.setString(7, member.getMberDetailAd());
			pstmt.setString(8, member.getMberTel());
			if(member.getMberImg()!=null) {
				pstmt.setBytes(9, member.getMberImg());	
			}
			pstmt.setInt(10, member.getTotalLeCnt());
			pstmt.setInt(11, member.getLendBookCnt());
			pstmt.setInt(12, member.getGrade().getGradeNo());
			pstmt.setInt(13, member.getLendPsbCdt());
			pstmt.setTimestamp(14, new Timestamp(member.getJoinDt().getTime()));
			pstmt.setInt(15, member.getWdrCdt());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		StringBuffer sql = new StringBuffer("update member set "); //띄워쓰기 주의하자!
		if(member.getMberPass()!=null) sql.append("mber_pass=?, ");
		if(member.getMberName()!=null) sql.append("mber_name=?, ");
		if(member.getMberBrthdy()!=null) sql.append("mber_brthdy=?, ");
		if(member.getMberZip()!=null) sql.append("mber_zip=?, ");
		if(member.getMberBassAd()!=null) sql.append("mber_bass_ad=?, ");
		if(member.getMberDetailAd()!=null) sql.append("mber_detail_ad=?, ");
		if(member.getMberTel()!=null) sql.append("mber_tel=?, ");
		if(member.getMberImg()!=null) sql.append("mber_img=?, ");
		if(member.getTotalLeCnt()!=0) sql.append("total_le_cnt=?, ");
		if(member.getLendBookCnt()!=0) sql.append("lend_book_cnt=?, ");
		if(member.getGrade()!=null) sql.append("grade=?, ");
		if(member.getLendPsbCdt()!=0) sql.append("lend_psb_cdt=?, ");
		if(member.getJoinDt()!=null) sql.append("join_dt=?, ");
		if(member.getWdrCdt()!=0) sql.append("wdr_cdt=?, ");
		sql.replace(sql.lastIndexOf(","), sql.length(), " ");
		sql.append("where mber_id=?");
		
		return 0;
		
		pstmt.setString(1, member.getMberId());
		pstmt.setString(2, member.getMberPass());
		pstmt.setString(3, member.getMberName());
		pstmt.setTimestamp(4, new Timestamp(member.getMberBrthdy().getTime()));
		pstmt.setInt(5, member.getMberZip().getZipCode());
		pstmt.setString(6, member.getMberBassAd());
		pstmt.setString(7, member.getMberDetailAd());
		pstmt.setString(8, member.getMberTel());
		if(member.getMberImg()!=null) {
			pstmt.setBytes(9, member.getMberImg());	
		}
		pstmt.setInt(10, member.getTotalLeCnt());
		pstmt.setInt(11, member.getLendBookCnt());
		pstmt.setInt(12, member.getGrade().getGradeNo());
		pstmt.setInt(13, member.getLendPsbCdt());
		pstmt.setTimestamp(14, new Timestamp(member.getJoinDt().getTime()));
		pstmt.setInt(15, member.getWdrCdt());
	}

	@Override
	public int deleteMember(Member member) {
		
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
		Date joinDt= rs.getTimestamp("join_dt");
		int wdrCdt = rs.getInt("wdr_cdt");
		Member mber = new Member(mberId, mberPass, mberName, mberBrthdy, mberZip, mberBassAd, mberDetailAd, 
				mberTel, totalLeCnt, lendBookCnt, grade, lendPsbCdt, joinDt, wdrCdt);
		if(isImg) {
			byte[] mberImg = rs.getBytes("mber_img");
			mber.setMberImg(mberImg);
		}
		LogUtil.prnLog("getMember => " + mber);
		return mber;
	}

	@Override
	public Member findMemberId(Member member) {
		String sql = "select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , mber_detail_ad , mber_tel , total_le_cnt , "
					+ " lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt "  
					+ "	from member " 
					+ "	where mber_name = ? and mber_brthdy = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getMberName());
			pstmt.setTimestamp(2, new Timestamp(member.getMberBrthdy().getTime()));;
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
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
				+ " lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt "  
				+ "	from member " 
				+ "	where mber_id = ? and mber_name = ? and mber_brthdy = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getMberId());
			pstmt.setString(2, member.getMberName());
			pstmt.setTimestamp(3, new Timestamp(member.getMberBrthdy().getTime()));
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getMember(rs, false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
