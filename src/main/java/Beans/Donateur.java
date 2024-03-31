package Beans;

public class Donateur {
	
	private String name;
	private String email;
	private String password;
	private String phone;
	private String adress;
	
	public Donateur(String n, String e, String pa, String ph ,String ad) {
		this.name=n;
		this.email=e;
		this.password=pa;
		this.phone=ph;
		this.adress=ad;
	}

	public Donateur(String e, String pa) {
		this.email=e;
		this.password=pa;
	}
	
	
	public Donateur() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
}
