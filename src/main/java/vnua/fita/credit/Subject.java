package vnua.fita.credit;

import java.util.Scanner;

public class Subject {
	
	//test
	public static void main(String[] args) {
		Subject test = new Subject();
		
		test.setAttendanceMark(2);
		test.setMidExamMark(3);
		test.setFinalExamMark(4);
		
		float a= test.calSubjectMark();
		System.out.println("diem so :"+a);
		
		//diem chu
		String b= test.calGrace();
		System.out.println("\ndiem chu:"+b);
		
		//quy soi sang he 4
		float c = test.calConversionMark();
		System.out.println(c);
		
		float d = test.calConversionMark(test.calGrace());
		System.out.println(d);
		
		//dua ra man hinh tat ca tt
		test.subjectCode = "TH123";
		test.subjectName = "THCS";
		test.credit = 3;
		
		String f= test.toString();
		System.out.println(f);
	}
	
	
	
	private String subjectCode;
	private String subjectName;
	private int credit;
	private float attendanceMark;
	private float midExamMark;
	private float finalExamMark;
	private float bonusExamMark;
	
	//khoi tao doi tuong co va khong truyen tham so
	//khong truyen tham so
	public Subject() {
	}
	
	//Truyen tham so 
	public Subject(String subjectCode,String subjectName,int credit) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}
	
	//quy doi diem sang he 4 tu diem so tong
	public float calConversionMark() {
		float cm = 0 ;
		float tg = calSubjectMark();
		if(tg>=0 && tg<=3.9) {
			cm = 0;
		}else if(tg<=4.9){
			cm = 1;
		}else if(tg<=5.4) {
			cm = 1.5f;
		}else if(tg<=6.4) {
			cm=2;
		}else if(tg<=6.9) {
			cm=2.5f;
		}else if(tg<7.4) {
			cm = 3;
		}else if (tg<=8.4) {
			cm = 3.5f;
		}else if (tg<=10) {
			cm = 4;
		}else {
			System.out.println("Diem sai co the khong nam trong thang 10");
		}
		return cm;
	};
	
	//quy doi diem sang sang he 4 tu diem chu 
	public float calConversionMark(String grade) {
		float cm =0;
		switch (grade) {
		case "F": 
			cm = 0;
			break;
		case "D": 
			cm = 1;
			break;
		case "D+": 
			cm = 1.5f;
			break;
		case "C": 
			cm = 2;
			break;
		case "C+": 
			cm = 2.5f;
			break;
		case "B": 
			cm = 3;
			break;
		case "B+": 
			cm = 3.5F;
			break;
		case "A": 
			cm = 4;
			break;
		}
		
		return cm;
	};
	
	//tinh diem dang chu
	public String calGrace() {
		String grace= null;
		float tg = calSubjectMark();
		if(tg>=0 && tg<=3.9) {
			grace = "F";
		}else if(tg<=4.9){
			grace = "D";
		}else if(tg<=5.4) {
			grace = "D+";
		}else if(tg<=6.4) {
			grace="C";
		}else if(tg<=6.9) {
			grace="C+";
		}else if(tg<7.4) {
			grace = "B";
		}else if (tg<=8.4) {
			grace = "B+";
		}else if (tg<=10) {
			grace = "A";
		}else {
			System.out.println("Diem sai co the khong nam trong thang 10");
		}
		return grace;
		
	};
	
	//tinh diem mon hoc
	public float calSubjectMark() {
		return (attendanceMark + midExamMark*3 + finalExamMark*6)/10;
	}
	
	//dua ra credit 
	public int getCredit() {
		return credit;
	}
	
	//dua vao va kiem tra diem chuyen can nhap vao bang set ????
	public void setAttendanceMark(float attendanceMark) {
		if(attendanceMark>=0 && attendanceMark<=10 ) {
			this.attendanceMark = attendanceMark;
		}else {
			System.out.println("Diem dau vao bi sai ");
			//dung truong trinh ngay lap tuc
			System.exit(0);
		}
	}
	
	//................diem cuoi ki 
	
	public void setFinalExamMark(float finalExamMark) {
		if(finalExamMark>=0 && finalExamMark<=10 ) {
			this.finalExamMark = finalExamMark;
		}else {
			System.out.println("Diem dau vao bi sai ");
			System.exit(0);
		}
	}
	
	//................diem giua ki 
	public void setMidExamMark(float midExamMark) {
		if(midExamMark>=0 && midExamMark<=10 ) {
			this.midExamMark = midExamMark;
		}else {
			System.out.println("Diem dau vao bi sai ");
			System.exit(0);
		}
	}
	
	//
	public void setBonusExamMark(float bonusExamMark) {
		this.bonusExamMark = bonusExamMark;
	}
	//dua ra day du thong tin
	public String toString() {
		String s ="\n" + "Ma mon hoc: " + subjectCode+ 
				"\n"+"Ten mon hoc: "+subjectName+
				"\n"+"So tin chi: "+credit
				+"\nDiem dang chu: "+calGrace()
				+"\nDiem dang so: "+calConversionMark();
		return s;
	}
	
	public String getSubjectCode() {
		return subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectCode(String mmh) {
		this.subjectCode = mmh;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}
