package Model;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee{
	private String major;
	private String semester;
	private String universityName;

	public Intern(int id, String fullName, LocalDate birthDay, String phone, String email, EmployeeType type,
			List<Cetificate> cetificates, String major, String semester, String universityName) {
		super(id, fullName, birthDay, phone, email, type, cetificates);
		this.major = major;
		this.semester = semester;
		this.universityName = universityName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	@Override
	public String toString() {
		return "Intern [Id="
				+ getId() + ", FullName=" + getFullName() + ", BirthDay=" + getBirthDay() + ", Phone="
				+ getPhone() + ", Email=" + getEmail() + ", Type=" + getType() + ", EmemployeeCount="
				+ getEmemployeeCount() + ", Cetificates()=" + getCetificates() +", major=" + major + ", semester=" + semester + ", universityName=" + universityName +  "]";
	}
	
	
}
