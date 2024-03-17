package vnua.fita.credit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name="SINHVIEN")
public class Student extends Human{
	@Column(name = "MaLop")
	private String class_;
	//private List<Subject> subjectList = new ArrayList<Subject>();
	@Transient
	private Map<String, Term> termList = new HashMap<String, Term>();
	
	
	public Student() {
		
	}
	
	public Student(String code, String fullname, String address, String class_) {
		super(code, fullname, address);
		this.class_ = class_;
	}
	
	public void addTerm(Term term) {
		termList.put(term.getTermCode(), term);
	}
	
	public void addSubject(String termCode, Subject subject) {
		Term term = termList.get(termCode);
		term.addSubject(subject);
	}
	
	public boolean removeSubject(String termCode, String subjectCode) {
		return termList.get(termCode).removeSubject(subjectCode);
	}
	
		
	// Tinh tổng số tín chỉ tích lũy qua các kỳ
	public int getSumOfCredit() {
		int sum = 0;
		// Duyệt qua map
		for(Term term: termList.values()) {
			sum+= term.getSumOfCredit();
		}
		return sum;
	}
	
	// Không được sửa mã môn học
	public void editSubject(String termCode, Subject subject) {
		termList.get(termCode).editSubject(subject);
	}
	
	@Override
	public void enterInfo(Scanner sc) {
		// Goi lai phuong thuc nay trong lop cha de nhap ma code va fullname
		super.enterInfo(sc);
		
		// Nhap them thong tin lớp họchọc
		System.out.print("Nhap lop hoc: ");
		class_ = sc.nextLine();
	}
	
	@Override
	public String toString() {
		return super.toString() + "-" + class_;
	}
	
	

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		Student std = new Student("669030","Nguyen Duc Nam", "Ha Noi", "K66CNTTA");
		Student std1 = new Student("651514","Nguyen Huu An", "HCM", "K65CNTTA");
		Student std2 = new Student("653041","Nguyen Van Tung", "Lai chau", "K65CNTTA");
		
		// Tạo kỳ 1
			// Tạo một số môn học để add vàovào
		Subject sj = new Subject("TH001","THCS",3);
		Subject sj1 = new Subject("TH002","THCS2",3);
		Subject sj2 = new Subject("TH003","THCS3",3);
			
		Term  ter = new Term("2021-2022");
		 ter.addSubject(sj);
		 ter.addSubject(sj1);
		 ter.addSubject(sj2);
		 
		// Tạo kỳ 2
		// Tạo một số môn học để add vào kỳ 2
		Subject sj3 = new Subject("TH004","THCS4",1);
		Subject sj4 = new Subject("TH005","CTDLGT",2);
 
			 Term ter2 = new Term("2022-2023");
			 ter2.addSubject(sj3);
			 ter2.addSubject(sj4);
		
			 
		// Thêm các kỳ vào cho đối tượng sinh viên
		std.addTerm(ter);
		std.addTerm(ter2);
		std1.addTerm(ter2);
			 
		// In thông tin các kỳ học, môn học trong mỗi kỳ
		System.out.println(ter.toString());
		System.out.println(std.getSumOfCredit());
		
		
		// Thử thêm các phương thức xóa môn học, sửa môn học
		System.out.println("Chon phuong thuc muon lam: \t1Them\tXoa\tSua");
		int n = sc.nextInt();sc.nextLine();
		if(n==1)
		{
		System.out.println("\tNhap vao ki hoc muon sua: ");
		String t = sc.nextLine();sc.nextLine();
		System.out.println("\tNhap vao ki hoc muon sua: ");
		std.editSubject(t, sj4);
		}
		
		*/
		JavaSubject jv1 = new JavaSubject(2,3,4);
		jv1.setCredit(4);
		jv1.setSubjectCode("th007");
		jv1.setSubjectName("java");
		System.out.println(jv1);
		
		OOPSubject oop1 = new OOPSubject(2,3,4,6);
		oop1.setCredit(4);
		oop1.setSubjectCode("th001");
		oop1.setSubjectName("LTHDT");
		System.out.println(oop1);
		 
	}

	public  Map<String, Term>getTermList() {
		// TODO Auto-generated method stub
		return termList;
	}
}
