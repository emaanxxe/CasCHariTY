package Beans;

public class Admin {

	private String ID;
	private String Email;
	private String Password;
	
	
	public Admin(String id ,String email ,String password) {
		this.ID=id;
		this.Email=email;
		this.Password=password;
	}
	
	public Admin() {
		super();
	}

	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}
	
}
