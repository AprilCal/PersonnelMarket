package market.vo;

public class Customer {
	private int customerID;
	private String customerName;
	private String time;
	private String password;
	private String tel;
	private String mail;
	private int messageNum;
	private boolean deleted;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		return "id:"+customerID+"\n"+
				"name:"+customerName+"\n"+
				"time:"+time+"\n"+
				"password:"+password+"\n"+
				"tel:"+tel+"\n"+
				"mail:"+mail+"\n"+
				"messageNum:"+messageNum+"\n"+
				"deleted:"+deleted+"\n";
	}
}
