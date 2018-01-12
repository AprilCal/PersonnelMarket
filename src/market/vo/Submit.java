
package market.vo;

public class Submit {
	private int resumeId;
	private int enterpriseId;
	private int recruitmentId;
	private boolean readOrNot;
	private boolean deleted;
	private String state;
	
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public int getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public boolean isReadOrNot() {
		return readOrNot;
	}
	public void setReadOrNot(boolean readOrNot) {
		this.readOrNot = readOrNot;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
