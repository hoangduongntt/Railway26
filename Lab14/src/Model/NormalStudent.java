package Model;

import java.time.LocalDate;

public class NormalStudent extends Student {
	private int englishScore;
	private float entryTestScore;
	public NormalStudent(String fullName, LocalDate doB, String gender, String phoneNumber, String universityName,
			String gradeLevel, int englishScore, float entryTestScore) {
		super(fullName, doB, gender, phoneNumber, universityName, gradeLevel);
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	public float getEntryTestScore() {
		return entryTestScore;
	}
	public void setEntryTestScore(float entryTestScore) {
		this.entryTestScore = entryTestScore;
	}
	@Override
	public String toString() {
		return "NormalStudent [FullName="
				+ getFullName() + ", DoB=" + getDoB() + ", Gender=" + getGender() + ", PhoneNumber="
				+ getPhoneNumber() + ", UniversityName=" + getUniversityName() + ", GradeLevel="
				+ getGradeLevel() +",  englishScore=" + englishScore + ", entryTestScore=" + entryTestScore + "]";
	}
	
}
