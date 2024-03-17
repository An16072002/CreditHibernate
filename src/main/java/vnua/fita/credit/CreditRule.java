package vnua.fita.credit;

public  interface CreditRule {
	float LEVEL_F = 3.9f;
	float LEVEL_D = 4.9f;
	float LEVEL_DPLUS= 5.4f;
	float LEVEL_C = 6.4f;
	float LEVEL_CPLUS = 6.9f;
	float LEVEL_B = 7.4f;
	float LEVEL_BPLUS = 8.4f;
	float LEVEL_A = 10f;
	
	float calSubjectMark();
	String calGrade();
	float calConversionMark();
	String getSubjectCode();
	void setSubjectCode(String subjectCode);
	String getSubjectName();
	void setSubjectName(String subjectName);
	int getCredit();
	void setCredit(int credit);
	
	
	
	
}
