package yi_java3st_3team.dto;

public class Email {
	private String hostName;
	private String portNum;
	private String userId;
	private String userPass;
	private String sendId;
	private String sendSubject;
	private String sendContext;
	
	public Email() {
		
	}
	
	public Email(String hostName, String portNum, String userId, String userPass) {
		this.hostName = hostName;
		this.portNum = portNum;
		this.userId = userId;
		this.userPass = userPass;
	}

	public Email(String hostName, String portNum, String userId, String userPass, String sendId, String sendSubject,
			String sendContext) {
		this.hostName = hostName;
		this.portNum = portNum;
		this.userId = userId;
		this.userPass = userPass;
		this.sendId = sendId;
		this.sendSubject = sendSubject;
		this.sendContext = sendContext;
	}

	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getPortNum() {
		return portNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getSendSubject() {
		return sendSubject;
	}
	public void setSendSubject(String sendSubject) {
		this.sendSubject = sendSubject;
	}
	public String getSendContext() {
		return sendContext;
	}
	public void setSendContext(String sendContext) {
		this.sendContext = sendContext;
	}
}
