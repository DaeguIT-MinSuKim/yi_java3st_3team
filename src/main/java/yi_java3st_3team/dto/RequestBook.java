package yi_java3st_3team.dto;

import java.util.Date;

public class RequestBook {
	private int requestBookNo;
	private Member requestMbId;
	private String requestBookName;
	private String requestBookAuthor;
	private String requestBookTrnslr;
	private String requestBookPls;
	private Date requestDate;
	private boolean WhCdt;

	public RequestBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestBook(int requestBookNo) {
		super();
		this.requestBookNo = requestBookNo;
	}

	public RequestBook(int requestBookNo, Member requestMbId, String requestBookName, String requestBookAuthor,
			String requestBookTrnslr, String requestBookPls, Date requestDate, boolean whCdt) {
		super();
		this.requestBookNo = requestBookNo;
		this.requestMbId = requestMbId;
		this.requestBookName = requestBookName;
		this.requestBookAuthor = requestBookAuthor;
		this.requestBookTrnslr = requestBookTrnslr;
		this.requestBookPls = requestBookPls;
		this.requestDate = requestDate;
		WhCdt = whCdt;
	}

	public int getRequestBookNo() {
		return requestBookNo;
	}

	public void setRequestBookNo(int requestBookNo) {
		this.requestBookNo = requestBookNo;
	}

	public Member getRequestMbId() {
		return requestMbId;
	}

	public void setRequestMbId(Member requestMbId) {
		this.requestMbId = requestMbId;
	}

	public String getRequestBookName() {
		return requestBookName;
	}

	public void setRequestBookName(String requestBookName) {
		this.requestBookName = requestBookName;
	}

	public String getRequestBookAuthor() {
		return requestBookAuthor;
	}

	public void setRequestBookAuthor(String requestBookAuthor) {
		this.requestBookAuthor = requestBookAuthor;
	}

	public String getRequestBookTrnslr() {
		return requestBookTrnslr;
	}

	public void setRequestBookTrnslr(String requestBookTrnslr) {
		this.requestBookTrnslr = requestBookTrnslr;
	}

	public String getRequestBookPls() {
		return requestBookPls;
	}

	public void setRequestBookPls(String requestBookPls) {
		this.requestBookPls = requestBookPls;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public boolean isWhCdt() {
		return WhCdt;
	}

	public void setWhCdt(boolean whCdt) {
		WhCdt = whCdt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (WhCdt ? 1231 : 1237);
		result = prime * result + ((requestBookAuthor == null) ? 0 : requestBookAuthor.hashCode());
		result = prime * result + ((requestBookName == null) ? 0 : requestBookName.hashCode());
		result = prime * result + requestBookNo;
		result = prime * result + ((requestBookPls == null) ? 0 : requestBookPls.hashCode());
		result = prime * result + ((requestBookTrnslr == null) ? 0 : requestBookTrnslr.hashCode());
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + ((requestMbId == null) ? 0 : requestMbId.hashCode());
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
		RequestBook other = (RequestBook) obj;
		if (WhCdt != other.WhCdt)
			return false;
		if (requestBookAuthor == null) {
			if (other.requestBookAuthor != null)
				return false;
		} else if (!requestBookAuthor.equals(other.requestBookAuthor))
			return false;
		if (requestBookName == null) {
			if (other.requestBookName != null)
				return false;
		} else if (!requestBookName.equals(other.requestBookName))
			return false;
		if (requestBookNo != other.requestBookNo)
			return false;
		if (requestBookPls == null) {
			if (other.requestBookPls != null)
				return false;
		} else if (!requestBookPls.equals(other.requestBookPls))
			return false;
		if (requestBookTrnslr == null) {
			if (other.requestBookTrnslr != null)
				return false;
		} else if (!requestBookTrnslr.equals(other.requestBookTrnslr))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestMbId == null) {
			if (other.requestMbId != null)
				return false;
		} else if (!requestMbId.equals(other.requestMbId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestBook [requestBookNo=" + requestBookNo + ", requestMbId=" + requestMbId + ", requestBookName="
				+ requestBookName + ", requestBookAuthor=" + requestBookAuthor + ", requestBookTrnslr="
				+ requestBookTrnslr + ", requestBookPls=" + requestBookPls + ", requestDate=" + requestDate + ", WhCdt="
				+ WhCdt + "]";
	}

}
