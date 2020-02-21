package yi_java3st_3team.dto;

import java.util.Date;

public class Member {
	private String mberId;
	private String mberPass;
	private String mberName;
	private Date mberbirthday;
	private ZipCode mberZip;
	private String mberBassAd;
	private String mberDetailAd;
	private String mberTel;
	private int totalLeCnt;
	private int lendBookCnt;
	private Grade grade;
	private int lendPsbCdt;
	private Date joinDt;
	private int wdrCdt;

	public Member() {
	}

	public Member(String mberId) {
		super();
		this.mberId = mberId;
	}

	public Member(String mberId, String mberPass) {
		super();
		this.mberId = mberId;
		this.mberPass = mberPass;
	}

	public Member(String mberId, String mberPass, String mberName, Date mberbirthday, ZipCode mberZip,
			String mberBassAd, String mberDetailAd, String mberTel, int totalLeCnt, int lendBookCnt, Grade grade,
			int lendPsbCdt, Date joinDt, int wdrCdt) {
		super();
		this.mberId = mberId;
		this.mberPass = mberPass;
		this.mberName = mberName;
		this.mberbirthday = mberbirthday;
		this.mberZip = mberZip;
		this.mberBassAd = mberBassAd;
		this.mberDetailAd = mberDetailAd;
		this.mberTel = mberTel;
		this.totalLeCnt = totalLeCnt;
		this.lendBookCnt = lendBookCnt;
		this.grade = grade;
		this.lendPsbCdt = lendPsbCdt;
		this.joinDt = joinDt;
		this.wdrCdt = wdrCdt;
	}

	public String getMberId() {
		return mberId;
	}

	public void setMberId(String mberId) {
		this.mberId = mberId;
	}

	public String getMberPass() {
		return mberPass;
	}

	public void setMberPass(String mberPass) {
		this.mberPass = mberPass;
	}

	public String getMberName() {
		return mberName;
	}

	public void setMberName(String mberName) {
		this.mberName = mberName;
	}

	public Date getMberbirthday() {
		return mberbirthday;
	}

	public void setMberbirthday(Date mberbirthday) {
		this.mberbirthday = mberbirthday;
	}

	public ZipCode getMberZip() {
		return mberZip;
	}

	public void setMberZip(ZipCode mberZip) {
		this.mberZip = mberZip;
	}

	public String getMberBassAd() {
		return mberBassAd;
	}

	public void setMberBassAd(String mberBassAd) {
		this.mberBassAd = mberBassAd;
	}

	public String getMberDetailAd() {
		return mberDetailAd;
	}

	public void setMberDetailAd(String mberDetailAd) {
		this.mberDetailAd = mberDetailAd;
	}

	public String getMberTel() {
		return mberTel;
	}

	public void setMberTel(String mberTel) {
		this.mberTel = mberTel;
	}

	public int getTotalLeCnt() {
		return totalLeCnt;
	}

	public void setTotalLeCnt(int totalLeCnt) {
		this.totalLeCnt = totalLeCnt;
	}

	public int getLendBookCnt() {
		return lendBookCnt;
	}

	public void setLendBookCnt(int lendBookCnt) {
		this.lendBookCnt = lendBookCnt;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getLendPsbCdt() {
		return lendPsbCdt;
	}

	public void setLendPsbCdt(int lendPsbCdt) {
		this.lendPsbCdt = lendPsbCdt;
	}

	public Date getJoinDt() {
		return joinDt;
	}

	public void setJoinDt(Date joinDt) {
		this.joinDt = joinDt;
	}

	public int getWdrCdt() {
		return wdrCdt;
	}

	public void setWdrCdt(int wdrCdt) {
		this.wdrCdt = wdrCdt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((joinDt == null) ? 0 : joinDt.hashCode());
		result = prime * result + lendBookCnt;
		result = prime * result + lendPsbCdt;
		result = prime * result + ((mberBassAd == null) ? 0 : mberBassAd.hashCode());
		result = prime * result + ((mberDetailAd == null) ? 0 : mberDetailAd.hashCode());
		result = prime * result + ((mberId == null) ? 0 : mberId.hashCode());
		result = prime * result + ((mberName == null) ? 0 : mberName.hashCode());
		result = prime * result + ((mberPass == null) ? 0 : mberPass.hashCode());
		result = prime * result + ((mberTel == null) ? 0 : mberTel.hashCode());
		result = prime * result + ((mberZip == null) ? 0 : mberZip.hashCode());
		result = prime * result + ((mberbirthday == null) ? 0 : mberbirthday.hashCode());
		result = prime * result + totalLeCnt;
		result = prime * result + wdrCdt;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (joinDt == null) {
			if (other.joinDt != null)
				return false;
		} else if (!joinDt.equals(other.joinDt))
			return false;
		if (lendBookCnt != other.lendBookCnt)
			return false;
		if (lendPsbCdt != other.lendPsbCdt)
			return false;
		if (mberBassAd == null) {
			if (other.mberBassAd != null)
				return false;
		} else if (!mberBassAd.equals(other.mberBassAd))
			return false;
		if (mberDetailAd == null) {
			if (other.mberDetailAd != null)
				return false;
		} else if (!mberDetailAd.equals(other.mberDetailAd))
			return false;
		if (mberId == null) {
			if (other.mberId != null)
				return false;
		} else if (!mberId.equals(other.mberId))
			return false;
		if (mberName == null) {
			if (other.mberName != null)
				return false;
		} else if (!mberName.equals(other.mberName))
			return false;
		if (mberPass == null) {
			if (other.mberPass != null)
				return false;
		} else if (!mberPass.equals(other.mberPass))
			return false;
		if (mberTel == null) {
			if (other.mberTel != null)
				return false;
		} else if (!mberTel.equals(other.mberTel))
			return false;
		if (mberZip == null) {
			if (other.mberZip != null)
				return false;
		} else if (!mberZip.equals(other.mberZip))
			return false;
		if (mberbirthday == null) {
			if (other.mberbirthday != null)
				return false;
		} else if (!mberbirthday.equals(other.mberbirthday))
			return false;
		if (totalLeCnt != other.totalLeCnt)
			return false;
		if (wdrCdt != other.wdrCdt)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Member [mberId=%s, mberPass=%s, mberName=%s, mberbirthday=%s, mberZip=%s, mberBassAd=%s, mberDetailAd=%s, mberTel=%s, totalLeCnt=%s, lendBookCnt=%s, grade=%s, lendPsbCdt=%s, joinDt=%s, wdrCdt=%s]",
				mberId, mberPass, mberName, mberbirthday, mberZip, mberBassAd, mberDetailAd, mberTel, totalLeCnt,
				lendBookCnt, grade, lendPsbCdt, joinDt, wdrCdt);
	}

}
