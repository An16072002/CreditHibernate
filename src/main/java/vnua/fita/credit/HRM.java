package vnua.fita.credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HRM  {
	private List<Human> hrList;
	
	public HRM() {
		hrList = new ArrayList<Human>();
	}
	
	public void addHR(Human hm) {
		hrList.add(hm);
	}
	
	
	
	public void addHR(Scanner sc) {
		int i = 0;
		Human hm = null;
		
		do {
			System.out.println("Chon loai nhan su can nhap \n1:Sinh vien \n2:Giang Vien \n 3:Thoat ");
			i = sc.nextInt();sc.hasNextLine();
			if(i==1) {
				hm = new Student();
				
			}else if(i==2) {
				hm = new Lecturer();
				
			}
			hm.enterInfo(sc);
			hrList.add(hm);
		}while(i==1 ||i==2);
	}
	
	public void printHRList() {
		System.out.println("Danh sach nhan su :");
		for(Human p:hrList) {
			System.out.println(p.getCode() +"-"+p.getFullname());
		}
	}
	
	public void printStudentInfo() {
		System.out.println("\n Danh sach sinh vien : ");
		Student std = null;
		for(Human p: hrList) {
			if(p instanceof Student) {
				std = (Student)p;
				System.out.println("\n"+std.getFullname()+"\t"+std.getClass_());
			}
		}
	}
	
	public String searchHuman(String code) {
		System.out.println("Ket qua tim duoc: ");
		for(Human p: hrList) {
			if(code.equalsIgnoreCase(p.getCode())) {
				return p.toString();
			}
		}
		return null;
		
	}
	
	public void printLecturerInfo() {
		System.out.println("\n Danh sach giang vien : ");
		for(Human p: hrList) {
			if(p instanceof Lecturer) {
				System.out.println(p.toString());
			}
		}
	}
	
	public void initDemoData() {

	}
	
	public void initDemoData(Scanner sc) {
		
	}
	
	public static void main(String[] args) {
		Student t1 = new Student("651514","Nguyen Huu An","K65CNTTA","thon 6");
		Student t2 = new Student("652234","NguyenHuuBa","K65CNTP","xa 7");
		
		Lecturer l1 = new Lecturer("cntp08","P V H","Khoa","thon 7");
		Lecturer l2 = new Lecturer("cntp09","P V H","Hoa","thon 7");
		
		HRM hrm1 = new HRM();
		
		hrm1.addHR(t1);
		hrm1.addHR(l2);
		hrm1.addHR(t2);
		hrm1.addHR(l1);
		
		hrm1.printHRList();
		
		hrm1.printLecturerInfo();
		
		hrm1.printStudentInfo();
		
		System.out.println(hrm1.searchHuman("cntp08"));
	}
	
	public List<Human> getHrList() {
		return hrList;
	}
}
