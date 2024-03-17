package vnua.fita.credit;

public class OOPSubject extends AbstractSubject implements CreditRule {
	private float attendanceMark;
	private float midExamMark;
	private float finalExamMark;
	private float bonusExamMark;
	
	public OOPSubject(float attendanceMark,float midExamMark,float finalExamMark,float bonusExamMark) {
		this.attendanceMark = attendanceMark;
		this.finalExamMark = finalExamMark;
		this.midExamMark = midExamMark;
		this.bonusExamMark = bonusExamMark;
	}
	public float calSubjectMark() {
		return (attendanceMark + midExamMark*3 + finalExamMark*5+bonusExamMark)/10;
	}
	@Override
	public String calGrade() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
