package vnua.fita.credit;

public abstract class AbstractSubject {
	private String subjectCode;
	private String subjectName;
	private int credit;
 abstract float calSubjectMark();
	
	//tinh diem dang chu
		public String calGrace() {
			String grace= null;
			float tg = calSubjectMark();
			if(tg>=0 && tg<=CreditRule.LEVEL_F) {
				grace = "F";
			}else if(tg<=CreditRule.LEVEL_D){
				grace = "D";
			}else if(tg<=CreditRule.LEVEL_DPLUS) {
				grace = "D+";
			}else if(tg<=CreditRule.LEVEL_C) {
				grace="C";
			}else if(tg<=CreditRule.LEVEL_CPLUS) {
				grace="C+";
			}else if(tg<CreditRule.LEVEL_B) {
				grace = "B";
			}else if (tg<=CreditRule.LEVEL_BPLUS) {
				grace = "B+";
			}else if (tg<=CreditRule.LEVEL_A) {
				grace = "A";
			}else {
				System.out.println("Diem sai co the khong nam trong thang 10");
			}
			return grace;
			
		};
		
		//Truyen tham so 
		public void Subject(String subjectCode,String subjectName,int credit) {
			this.subjectCode = subjectCode;
			this.subjectName = subjectName;
			this.credit = credit;
		}
		
		//quy doi diem sang he 4 tu diem so tong
		public float calConversionMark() {
			float cm = 0 ;
			float tg = calSubjectMark();
			if(tg>=0 && tg<=CreditRule.LEVEL_F) {
				cm = 0;
			}else if(tg<=CreditRule.LEVEL_D){
				cm = 1;
			}else if(tg<=CreditRule.LEVEL_DPLUS) {
				cm = 1.5f;
			}else if(tg<=CreditRule.LEVEL_C) {
				cm=2;
			}else if(tg<=CreditRule.LEVEL_CPLUS) {
				cm=2.5f;
			}else if(tg<CreditRule.LEVEL_B) {
				cm = 3;
			}else if (tg<=CreditRule.LEVEL_BPLUS) {
				cm = 3.5f;
			}else if (tg<=CreditRule.LEVEL_A) {
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
		
		public String toString() {
			String s ="\n" + "Ma mon hoc: " + subjectCode+ 
					"\n"+"Ten mon hoc: "+subjectName+
					"\n"+"So tin chi: "+credit
					+"\nDiem dang chu: "+calGrace()
					+"\nDiem dang so: "+calSubjectMark()
					;
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

		public int getCredit() {
			return credit;
		}
	
}
