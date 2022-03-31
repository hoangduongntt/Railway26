package Model;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
	private LocalDate gradutionDate;
	private String gradutionRank;
	private String education;

	public Fresher(int id, String fullName, LocalDate birthDay, String phone, String email, EmployeeType type,
			List<Cetificate> cetificates, LocalDate gradutionDate, String gradutionRank, String education) {
		super(id, fullName, birthDay, phone, email, type, cetificates);
		this.gradutionDate = gradutionDate;
		this.gradutionRank = gradutionRank;
		this.education = education;
	}

	public LocalDate getGradutionDate() {
		return gradutionDate;
	}

	public void setGradutionDate(LocalDate gradutionDate) {
		this.gradutionDate = gradutionDate;
	}

	public String getGradutionRank() {
		return gradutionRank;
	}

	public void setGradutionRank(String gradutionRank) {
		this.gradutionRank = gradutionRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Fresher [Id=" + getId() + ", FullName=" + getFullName() + ", BirthDay=" + getBirthDay() + ", Phone="
				+ getPhone() + ", Email=" + getEmail() + ", Type=" + getType() + ", EmemployeeCount="
				+ getEmemployeeCount() + ", Cetificates=" + getCetificates() + ", gradutionDate=" + gradutionDate
				+ ", gradutionRank=" + gradutionRank + ", education=" + education + "]";
	}
}
