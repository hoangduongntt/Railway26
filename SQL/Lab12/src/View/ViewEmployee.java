package View;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Cetificate;
import Model.Employee;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import Model.Employee.EmployeeType;
import Ultis.ScannerUtils;

public class ViewEmployee {
	static List<Employee> listEmployee = new ArrayList<Employee>();
	public  void addEmployeer() throws ParseException {
		while (true) {
			System.out.println("Choose Employee you want to add : 1. Experience, 2. Fresher, 3. Intern , 4. Exit");
			int choose = ScannerUtils.InputInt();
			switch (choose) {
			case 1: {
				System.out.println("Enter ID : ");
				int id = ScannerUtils.InputInt();
				System.out.println("Enter FullName : ");
				String fullName = ScannerUtils.InputFullName();
				System.out.println("Enter Birthday : ");
				LocalDate birthDay = ScannerUtils.InputLocaldate();
				System.out.println("Enter Phone : ");
				String phone = ScannerUtils.InputPhoneNumber();
				System.out.println("Enter Email : ");
				String email = ScannerUtils.inputEmail();
				EmployeeType type = null;
				System.out.println("Choose Employeer Type : 1. Experience, 2. Fresher, 3. Intern ");
				int flag = ScannerUtils.InputInt();
				switch (flag) {
				case 1: {
					type = EmployeeType.Experience;
					break;
				}
				case 2: {
					type = EmployeeType.Fresher;
					break;
				}
				case 3: {
					type = EmployeeType.Intern;
					break;
				}
				default:
					System.err.println("Choose is wrong, please check again !");

				}
				System.out.println("Enter Number Certificate: ");
				int numberCertificate = ScannerUtils.InputInt();
				List<Cetificate> cetificates = new ArrayList<Cetificate>();
				for (int i = 0; i < numberCertificate; i++) {
					System.out.println("Certificate Number " + (i + 1) + " : ");
					System.out.println("Enter CertificateID : ");
					int certificateId = ScannerUtils.InputInt();
					System.out.println("Enter CertificateName : ");
					String certificateName = ScannerUtils.InputString();
					System.out.println("Enter CertificateRank : ");
					String certificatedRank = ScannerUtils.InputString();
					System.out.println("Enter CertificateDate : ");
					LocalDate certificatedDate = ScannerUtils.InputLocaldate();
					Cetificate cetificate = new Cetificate(certificateId, certificateName, certificatedRank,
							certificatedDate);
					cetificates.add(cetificate);
				}
				System.out.println("Enter Experience Year : ");
				int expInYear = ScannerUtils.InputInt();
				System.out.println("Enter Experience ProSkill : ");
				String proSkill = ScannerUtils.InputString();
				Experience experience = new Experience(id, fullName, birthDay, phone, email, type, cetificates,
						expInYear, proSkill);
				listEmployee.add(experience);
				break;
			}
			case 3: {
				System.out.println("Enter ID : ");
				int id = ScannerUtils.InputInt();
				System.out.println("Enter FullName : ");
				String fullName = ScannerUtils.InputFullName();
				System.out.println("Enter Birthday : ");
				LocalDate birthDay = ScannerUtils.InputLocaldate();
				System.out.println("Enter Phone : ");
				String phone = ScannerUtils.InputPhoneNumber();
				System.out.println("Enter Email : ");
				String email = ScannerUtils.inputEmail();
				EmployeeType type = null;
				System.out.println("Choose Employeer Type : 1. Experience, 2. Fresher, 3. Intern ");
				int flag = ScannerUtils.InputInt();
				switch (flag) {
				case 1: {
					type = EmployeeType.Experience;
					break;
				}
				case 2: {
					type = EmployeeType.Fresher;
					break;
				}
				case 3: {
					type = EmployeeType.Intern;
					break;
				}
				default:
					System.err.println("Choose is wrong, please check again !");

				}
				System.out.println("Enter Number Certificate: ");
				int numberCertificate = ScannerUtils.InputInt();
				List<Cetificate> cetificates = new ArrayList<Cetificate>();
				for (int i = 0; i < numberCertificate; i++) {
					System.out.println("Certificate Number " + (i + 1) + " : ");
					System.out.println("Enter CertificateID : ");
					int certificateId = ScannerUtils.InputInt();
					System.out.println("Enter CertificateName : ");
					String certificateName = ScannerUtils.InputString();
					System.out.println("Enter CertificateRank : ");
					String certificatedRank = ScannerUtils.InputString();
					System.out.println("Enter CertificateDate : ");
					LocalDate certificatedDate = ScannerUtils.InputLocaldate();
					Cetificate cetificate = new Cetificate(certificateId, certificateName, certificatedRank,
							certificatedDate);
					cetificates.add(cetificate);
				}
				System.out.println("Enter Major : ");
				String major = ScannerUtils.InputString();
				System.out.println("Enter Semester : ");
				String semester = ScannerUtils.InputString();
				System.out.println("Enter University Name : ");
				String universityName = ScannerUtils.InputString();
				Intern intern = new Intern(id, fullName, birthDay, phone, email, type, cetificates, major, semester,
						universityName);
				listEmployee.add(intern);
				break;
			}
			case 2: {
				System.out.println("Enter ID : ");
				int id = ScannerUtils.InputInt();
				System.out.println("Enter FullName : ");
				String fullName = ScannerUtils.InputFullName();
				System.out.println("Enter Birthday : ");
				LocalDate birthDay = ScannerUtils.InputLocaldate();
				System.out.println("Enter Phone : ");
				String phone = ScannerUtils.InputPhoneNumber();
				System.out.println("Enter Email : ");
				String email = ScannerUtils.inputEmail();
				EmployeeType type = null;
				System.out.println("Choose Employeer Type : 1. Experience, 2. Fresher, 3. Intern ");
				int flag = ScannerUtils.InputInt();
				switch (flag) {
				case 1: {
					type = EmployeeType.Experience;
					break;
				}
				case 2: {
					type = EmployeeType.Fresher;
					break;
				}
				case 3: {
					type = EmployeeType.Intern;
					break;
				}
				default:
					System.err.println("Choose is wrong, please check again !");

				}
				System.out.println("Enter Number Certificate: ");
				int numberCertificate = ScannerUtils.InputInt();
				List<Cetificate> cetificates = new ArrayList<Cetificate>();
				for (int i = 0; i < numberCertificate; i++) {
					System.out.println("Certificate Number " + (i + 1) + " : ");
					System.out.println("Enter CertificateID : ");
					int certificateId = ScannerUtils.InputInt();
					System.out.println("Enter CertificateName : ");
					String certificateName = ScannerUtils.InputString();
					System.out.println("Enter CertificateRank : ");
					String certificatedRank = ScannerUtils.InputString();
					System.out.println("Enter CertificateDate : ");
					LocalDate certificatedDate = ScannerUtils.InputLocaldate();
					Cetificate cetificate = new Cetificate(certificateId, certificateName, certificatedRank,
							certificatedDate);
					cetificates.add(cetificate);
				}
				System.out.println("Enter Graduation Date : ");
				LocalDate graduationDate = ScannerUtils.InputLocaldate();
				System.out.println("Enter Graduation Rank : ");
				String rank = ScannerUtils.InputString();
				System.out.println("Enter Education : ");
				String education = ScannerUtils.InputString();
				Fresher fresher = new Fresher(id, fullName, birthDay, phone, email, type, cetificates, graduationDate,
						rank, education);
				listEmployee.add(fresher);
				break;
			}
			case 4:
				return;
			default:
				System.out.println("Choose is wrong, please check again !");
			}
		}
	}

	public  void disPlayInfor() {
		for (Employee employee : listEmployee) {
			System.out.println(employee.toString());
		}

	}

	public static Employee getId(int id) {
		while (true) {
			for (Employee employee : listEmployee) {
				if (employee.getId() == id) {
					return employee;
				}
			}
			return null;
		}
	}

	public  void findById() {
		while (true) {
			System.out.println("Enter Input ID : ");
			int inputId = ScannerUtils.InputInt();
			Employee employee = getId(inputId);
			if (employee != null) {
				System.out.println(employee.toString());
				break;
			} else {
				System.err.println("Find not ID, please check again !");
			}
		}
	}

	public  void deleteById() {
		while (true) {
			System.out.println("Enter Input ID : ");
			int inputId = ScannerUtils.InputInt();
			Employee employee = getId(inputId);
			if (employee != null) {
				listEmployee.remove(employee);
				disPlayInfor();
				break;
			} else {
				System.err.println("Find not ID, please check again !");
			}
		}
	}
	public  void findByType() {
		while (true) {
			System.out.println("Please choose Type : 1. Experience, 2. Fresher, 3.Intern , 4.Exit");
			int flag = ScannerUtils.InputInt();
			switch (flag) {
			case 1: {
				for (Employee employee2 : listEmployee) {
					if (employee2 instanceof Experience) {
						System.out.println(employee2.toString());
					}
				}
				break;
			}
			case 2: {
				for (Employee employee2 : listEmployee) {
					if (employee2 instanceof Fresher) {
						System.out.println(employee2.toString());
					}
				}
				break;
			}
			case 3: {
				for (Employee employee2 : listEmployee) {
					if (employee2 instanceof Intern) {
						System.out.println(employee2.toString());
					}
				}
				break;
			}
			case 4: 
				return;
			default:
				System.err.println("Choose wrong, please chooswe again !");
			}
		}
	}

}
