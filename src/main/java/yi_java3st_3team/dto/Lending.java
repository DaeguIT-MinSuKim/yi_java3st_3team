package yi_java3st_3team.dto;

import java.util.Date;

public class Lending {
	private int lendRturnNo;
	private Member mberId;
	private Book bookCd;
	private Date lendDate;
	private Date rturnDueDate;
	private boolean rturnPsmCdt;
	private Date rturnDate;
	private boolean overdueCdt;
	private int overdueDate;

	public Lending() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lending(int lendRturnNo) {
		super();
		this.lendRturnNo = lendRturnNo;
	}

	public Lending(int lendRturnNo, Member mberId, Book bookCd, Date lendDate, Date rturnDueDate, boolean rturnPsmCdt,
			Date rturnDate, boolean overdueCdt, int overdueDate) {
		super();
		this.lendRturnNo = lendRturnNo;
		this.mberId = mberId;
		this.bookCd = bookCd;
		this.lendDate = lendDate;
		this.rturnDueDate = rturnDueDate;
		this.rturnPsmCdt = rturnPsmCdt;
		this.rturnDate = rturnDate;
		this.overdueCdt = overdueCdt;
		this.overdueDate = overdueDate;
	}

	public int getLendRturnNo() {
		return lendRturnNo;
	}

	public void setLendRturnNo(int lendRturnNo) {
		this.lendRturnNo = lendRturnNo;
	}

	public Member getMberId() {
		return mberId;
	}

	public void setMberId(Member mberId) {
		this.mberId = mberId;
	}

	public Book getBookCd() {
		return bookCd;
	}

	public void setBookCd(Book bookCd) {
		this.bookCd = bookCd;
	}

	public Date getLendDate() {
		return lendDate;
	}

	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}

	public Date getRturnDueDate() {
		return rturnDueDate;
	}

	public void setRturnDueDate(Date rturnDueDate) {
		this.rturnDueDate = rturnDueDate;
	}

	public boolean isRturnPsmCdt() {
		return rturnPsmCdt;
	}

	public void setRturnPsmCdt(boolean rturnPsmCdt) {
		this.rturnPsmCdt = rturnPsmCdt;
	}

	public Date getRturnDate() {
		return rturnDate;
	}

	public void setRturnDate(Date rturnDate) {
		this.rturnDate = rturnDate;
	}

	public boolean isOverdueCdt() {
		return overdueCdt;
	}

	public void setOverdueCdt(boolean overdueCdt) {
		this.overdueCdt = overdueCdt;
	}

	public int getOverdueDate() {
		return overdueDate;
	}

	public void setOverdueDate(int overdueDate) {
		this.overdueDate = overdueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCd == null) ? 0 : bookCd.hashCode());
		result = prime * result + ((lendDate == null) ? 0 : lendDate.hashCode());
		result = prime * result + lendRturnNo;
		result = prime * result + ((mberId == null) ? 0 : mberId.hashCode());
		result = prime * result + (overdueCdt ? 1231 : 1237);
		result = prime * result + overdueDate;
		result = prime * result + ((rturnDate == null) ? 0 : rturnDate.hashCode());
		result = prime * result + ((rturnDueDate == null) ? 0 : rturnDueDate.hashCode());
		result = prime * result + (rturnPsmCdt ? 1231 : 1237);
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
		Lending other = (Lending) obj;
		if (bookCd == null) {
			if (other.bookCd != null)
				return false;
		} else if (!bookCd.equals(other.bookCd))
			return false;
		if (lendDate == null) {
			if (other.lendDate != null)
				return false;
		} else if (!lendDate.equals(other.lendDate))
			return false;
		if (lendRturnNo != other.lendRturnNo)
			return false;
		if (mberId == null) {
			if (other.mberId != null)
				return false;
		} else if (!mberId.equals(other.mberId))
			return false;
		if (overdueCdt != other.overdueCdt)
			return false;
		if (overdueDate != other.overdueDate)
			return false;
		if (rturnDate == null) {
			if (other.rturnDate != null)
				return false;
		} else if (!rturnDate.equals(other.rturnDate))
			return false;
		if (rturnDueDate == null) {
			if (other.rturnDueDate != null)
				return false;
		} else if (!rturnDueDate.equals(other.rturnDueDate))
			return false;
		if (rturnPsmCdt != other.rturnPsmCdt)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lending [lendRturnNo=" + lendRturnNo + ", mberId=" + mberId + ", bookCd=" + bookCd + ", lendDate="
				+ lendDate + ", rturnDueDate=" + rturnDueDate + ", rturnPsmCdt=" + rturnPsmCdt + ", rturnDate="
				+ rturnDate + ", overdueCdt=" + overdueCdt + ", overdueDate=" + overdueDate + "]";
	}

}
