package vnua.fita.credit;

import java.util.Scanner;

public class Lecturer extends Human {
	private String password;

	public Lecturer() {
	}

	public Lecturer(String code, String password) {
		super(code);
		this.password = password;

	}

	public Lecturer(String code, String password, String fullname) {
		super(code,fullname);
		this.password = password;
		

	}
	
	public Lecturer(String code, String password, String fullname,String address) {
		this(code, password,fullname);
		this.address = address;
	

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void enterInfo(Scanner sc) {
		System.out.println("Enter password");
		password = sc.nextLine();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
