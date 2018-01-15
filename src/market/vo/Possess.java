package market.vo;

/**
 * @author asus-
 *
 */
public class Possess {
	private int customerId;
	private int resumeId;
	private String resumeName;
	private boolean deleted;
	public void setDeleted(boolean deleted)
	{
		this.deleted=deleted;
	}
	public boolean isDeleted()
	{
		return deleted;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

}
