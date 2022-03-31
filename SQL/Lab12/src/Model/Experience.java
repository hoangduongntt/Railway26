package Model;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee {
	private int expInYear;
	private String proSkill;

	public Experience(int id, String fullName, LocalDate birthDay, String phone, String email, EmployeeType type,
			List<Cetificate> cetificates, int expInYear, String proSkill) {
		super(id, fullName, birthDay, phone, email, type, cetificates);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Experience [ Id=" + getId() + ", FullName=" + getFullName() + ", BirthDay=" + getBirthDay() + ", Phone="
				+ getPhone() + ", Email=" + getEmail() + ", Type=" + getType() + ", EmemployeeCount="
				+ getEmemployeeCount() + ", Cetificates()=" + getCetificates() + ", expInYear=" + expInYear
				+ ", proSkill=" + proSkill + "]";
	}

}
