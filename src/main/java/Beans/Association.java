package Beans;

public class Association {

	private String AssID;
	private String AssName;
	private String AssEmail;
	private String AssPassword;
	private String AssPhone;
	private String AssAdress;
	
	public Association (String id,String n, String e, String pa, String ph ,String ad) {
		this.AssAdress=id;
		this.AssName=n;
		this.AssEmail=e;
		this.AssPassword=pa;
		this.AssPhone=ph;
		this.AssAdress=ad;
	}
	
	public Association (String id,String n, String e, String pa) {
		this.AssID=id;
		this.AssName=n;
		this.AssEmail=e;
		this.AssPassword=pa;
	}
	

	public Association() {
		super();
	}

	public String getAssID() {
		return AssID;
	}

	public void setAssID(String assID) {
		AssID = assID;
	}

	public String getAssName() {
		return AssName;
	}

	public void setAssName(String assName) {
		AssName = assName;
	}

	public String getAssEmail() {
		return AssEmail;
	}

	public void setAssEmail(String assEmail) {
		AssEmail = assEmail;
	}

	public String getAssPassword() {
		return AssPassword;
	}

	public void setAssPassword(String assPassword) {
		AssPassword = assPassword;
	}

	public String getAssPhone() {
		return AssPhone;
	}

	public void setAssPhone(String assPhone) {
		AssPhone = assPhone;
	}

	public String getAssAdress() {
		return AssAdress;
	}

	public void setAssAdress(String assAdress) {
		AssAdress = assAdress;
	}
	
	

}
