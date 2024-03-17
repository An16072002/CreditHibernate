package vnua.fita.credit;

public class JavaSubject extends AbstractSubject implements CreditRule{
	private float attendanceMark;
	private float midExamMark;
	private float finalExamMark;

	public JavaSubject() {
	}
	
	public JavaSubject(float attendanceMark,float midExamMark,float finalExamMark) {
		this.attendanceMark = attendanceMark;
		this.finalExamMark = finalExamMark;
		this.midExamMark = midExamMark;
	}
	@Override
	public float calSubjectMark() {
		return (attendanceMark + midExamMark*3 + finalExamMark*6)/10;
	}
	 
	public String toString() {
		String s ="\n" + "Ma mon hoc: " + getSubjectCode()+ 
				"\n"+"Ten mon hoc: "+getSubjectName()+
				"\n"+"So tin chi: "+getCredit()
				+"\nDiem dang chu: "+calGrace()
				+"\nDiem dang so: "+calSubjectMark()
				+midExamMark+attendanceMark+finalExamMark
				;
		return s;
	}

	@Override
	public String calGrade() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
