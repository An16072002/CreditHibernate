package vnua.fita.credit;

import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public class Human {
	@Id
	@Column(name="Ten")
	protected String fullname;
	@Transient
	protected String address;
	@Column(name="MaSV")
	private String code;
	
	public Human() {
		//code mac dinh
		this.code = "xxxxx";
	}
	
	public Human(String code) {
		this.code = code;
	}
	
	public Human(String code,String fullname) {
		this(code);
		this.fullname = fullname;
	}
	
	public Human(String code,String fullname, String address){
		this(code, fullname);
		this.address = address;
	}
	
	public void enterInfo(Scanner sc) {
		System.out.println("Nhap vao ho va ten :\t");
		this.fullname = sc.nextLine();
		System.out.println("Nhap vao dia chi :\t");
		this.address = sc.nextLine();
		System.out.println("Nhap vao msv:\t");
		this.code = sc.nextLine();
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String toString() {
		return "\nFullname: "+fullname+
				"\nAddress: "+address+
				"\nCode: "+code;
	}
	
	

}
