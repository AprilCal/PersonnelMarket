package market.vo;

/**
 * 
 * create by AprilCal on 2018.1.11.
 *
 */
public class Recruitment {
	
	private int recruitmentId;
	private String title;
	//招聘的职业大类
	private String department;
	//招聘的岗位
	private String position;
	private String time;
	private int enterpriseId;
	private int salary_low;
	private int salary_high;
	private String experiment;
	private String positionDescription;
	private String province;
	private String city;
	private String techStack;
	private String positionRequirment;
	public String getTechStack() {
		return techStack;
	}
	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}
	public String getPositionRequirment() {
		return positionRequirment;
	}
	public void setPositionRequirment(String positionRequirment) {
		this.positionRequirment = positionRequirment;
	}
	private boolean deleted;
	public int getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public int getSalary_low() {
		return salary_low;
	}
	public void setSalary_low(int salary_low) {
		this.salary_low = salary_low;
	}
	public int getSalary_high() {
		return salary_high;
	}
	public void setSalary_high(int salary_high) {
		this.salary_high = salary_high;
	}
	public String getExperiment() {
		return experiment;
	}
	public void setExperiment(String experiment) {
		this.experiment = experiment;
	}
	public String getPositionDescription() {
		return positionDescription;
	}
	public void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		return "id:"+recruitmentId+"\n"+
				"title:"+title+"\n";
	}
}
