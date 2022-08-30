package Model;

import java.time.LocalDate;

public class GoodStudent extends Student  {
	private float gpa;
	private String bestRewardName;

	public GoodStudent(String fullName, LocalDate doB, String gender, String phoneNumber, String universityName,
			String gradeLevel, float gpa, String bestRewardName) {
		super(fullName, doB, gender, phoneNumber, universityName, gradeLevel);
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}

	@Override
	public String toString() {
		return "GoodStudent [FullName=" + getFullName() + ", DoB=" + getDoB() + ", Gender=" + getGender()
				+ ", PhoneNumber=" + getPhoneNumber() + ", UniversityName=" + getUniversityName()
				+ ", GradeLevel=" + getGradeLevel() + ", gpa=" + gpa + ", bestRewardName=" + bestRewardName + "]";
	}
	
}
