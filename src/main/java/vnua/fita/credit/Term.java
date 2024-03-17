package vnua.fita.credit;

import java.util.ArrayList;
import java.util.List;

public class Term {
	private String termCode;
	private List<Subject> subjectList;
	
	public Term(String termCode) {
		this.termCode = termCode;
		subjectList = new ArrayList<Subject>();
	}
	
	public int getSumOfCredit() {
		int sum = 0;
		for(Subject sub: subjectList) {
			sum += sub.getCredit();
		}
		return sum;
	}
	
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	
	public void editSubject(Subject subject) {
		for(int i=0;i<subjectList.size();i++) {
			if(subject.getSubjectCode().equals(subjectList.get(i).getSubjectCode())) {
				subjectList.set(i, subject);
			}
		}
	}
	public boolean removeSubject(String subjectCode) {
		for(Subject sub: subjectList) {
			if(subjectCode.equals(sub.getSubjectCode())) {
				subjectList.remove(sub);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuffer a = new StringBuffer();
		String b = null;
		for(Subject sub: subjectList) {
			b+=a.append("\n"+sub.getSubjectCode()+" "+sub.getSubjectName()+" "+sub.getCredit());
		}
		return "\n"+b;
	}
	
	public float calTermAverageMark() {
		float tu = 0;
		float mau = 0;
		// Duyet qua danh sach mon hoc
		for(Subject sub: subjectList) {
			tu = tu + sub.getCredit()*sub.calConversionMark();
			mau += sub.getCredit();
		}
		return tu/mau;
	}

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}
}
