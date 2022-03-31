package Model;

import java.time.LocalDate;
import java.util.List;

public class Employee {
	public static int COUNT = 0;
	private int id;
	private String fullName;
	private LocalDate birthDay;
	private  String Phone;
	private  String email;
	private EmployeeType type; 
	public enum EmployeeType {Experience, Fresher, Intern}; 
	private int ememployeeCount;
	private List<Cetificate> cetificates;
	public Employee(int id, String fullName, LocalDate birthDay, String phone, String email, EmployeeType type,
			List<Cetificate> cetificates) {
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay;
		Phone = phone;
		this.email = email;
		this.type = type;
		this.ememployeeCount = COUNT;
		this.cetificates = cetificates;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	public int getEmemployeeCount() {
		return ememployeeCount;
	}
	public void setEmemployeeCount(int ememployeeCount) {
		this.ememployeeCount = ememployeeCount;
	}
	public List<Cetificate> getCetificates() {
		return cetificates;
	}
	public void setCetificates(List<Cetificate> cetificates) {
		this.cetificates = cetificates;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", birthDay=" + birthDay + ", Phone=" + Phone
				+ ", email=" + email + ", type=" + type + ", ememployeeCount=" + ememployeeCount + ", cetificates="
				+ cetificates + "]";
	}
	
	
}
