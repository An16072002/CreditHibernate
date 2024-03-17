package vnua.fita.credit;

import java.util.ArrayList;
import java.util.List;

public class Term2 {
	private String termCode;
	private List<AbstractSubject> AbstractSubjectList;
	
	public Term2(String termCode) {
		this.termCode = termCode;
		AbstractSubjectList = new ArrayList<AbstractSubject>();
	}
	
	public int getSumOfCredit() {
		int sum = 0;
		for(AbstractSubject sub: AbstractSubjectList) {
			sum += sub.getCredit();
		}
		return sum;
	}
	
	public void addAbstractSubject(AbstractSubject AbstractSubject) {
		AbstractSubjectList.add(AbstractSubject);
	}
	
	public void editAbstractSubject(AbstractSubject AbstractSubject) {
		for(int i=0;i<AbstractSubjectList.size();i++) {
			if(AbstractSubject.getSubjectCode().equals(AbstractSubjectList.get(i).getSubjectCode())) {
				AbstractSubjectList.set(i, AbstractSubject);
			}
		}
	}
	public boolean removeAbstractSubject(String AbstractSubjectCode) {
		for(AbstractSubject sub: AbstractSubjectList) {
			if(AbstractSubjectCode.equals(sub.getSubjectCode())) {
				AbstractSubjectList.remove(sub);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuffer a = new StringBuffer();
		String b = null;
		for(AbstractSubject sub: AbstractSubjectList) {
			b+=a.append("\n"+sub.getSubjectCode()+" "+sub.getSubjectName()+" "+sub.getCredit());
		}
		return "\n"+b;
	}
	
	public float calTermAverageMark() {
		float tu = 0;
		float mau = 0;
		// Duyet qua danh sach mon hoc
		for(AbstractSubject sub: AbstractSubjectList) {
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
