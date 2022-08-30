package View;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Model.GoodStudent;
import Model.NormalStudent;
import Model.Student;
import Ultis.InvalidFullNameException;
import Ultis.InvalidOtherException;
import Ultis.InvalidPhoneNumberException;
import Ultis.ScannerUtils;

public class View {
	static List<Student> listStudent = new ArrayList<Student>();
	List<GoodStudent> goodStudents = new ArrayList<GoodStudent>();
	List<NormalStudent> normalStudents = new ArrayList<NormalStudent>();
	int numberRecruit;
	int numberGoodStudent;
	int numberNormalStudent;

	public void addStudent()
			throws InvalidFullNameException, ParseException, InvalidPhoneNumberException, InvalidOtherException {
		System.out.println("Enter number person to recruit : ");
		numberRecruit = ScannerUtils.InputNumber();
		while (true) {
			System.out.println("Enter number GoodStudent : ");
			numberGoodStudent = ScannerUtils.InputInt();
			if (numberGoodStudent != 0) {
				for (int i = 0; i < numberGoodStudent; i++) {
					System.out.println("Enter information of student number " + (i + 1) + " : ");
					System.out.println("Enter FullName : ");
					String fullName = ScannerUtils.InputFullName();
					System.out.println("Enter Birthday : ");
					LocalDate birthDay = ScannerUtils.InputLocaldate();
					System.out.println("Enter Gender : ");
					String gender = ScannerUtils.InputString();
					System.out.println("Enter PhoneNumber : ");
					String phoneNumber = ScannerUtils.InputPhoneNumber();
					System.out.println("Enter UniversityName : ");
					String universityName = ScannerUtils.InputString();
					System.out.println("Enter GradeLevel : ");
					String gradeLevel = ScannerUtils.InputString();
					System.out.println("Enter GPA : ");
					float gpa = ScannerUtils.InputFloat();
					System.out.println("Enter BestRewardName : ");
					String bestRewardName = ScannerUtils.InputString();
					GoodStudent goodStudent = new GoodStudent(fullName, birthDay, gender, phoneNumber, universityName,
							gradeLevel, gpa, bestRewardName);
					goodStudents.add(goodStudent);
				}
				System.out.println("Enter number NormalStudent : ");
				numberNormalStudent = ScannerUtils.InputInt();
				for (int i1 = 0; i1 < numberNormalStudent; i1++) {
					System.out.println("Enter information of student number " + (i1 + 1) + " : ");
					System.out.println("Enter FullName : ");
					String fullName1 = ScannerUtils.InputFullName();
					System.out.println("Enter Birthday : ");
					LocalDate birthDay1 = ScannerUtils.InputLocaldate();
					System.out.println("Enter Gender : ");
					String gender1 = ScannerUtils.InputString();
					System.out.println("Enter PhoneNumber : ");
					String phoneNumber1 = ScannerUtils.InputPhoneNumber();
					System.out.println("Enter UniversityName : ");
					String universityName1 = ScannerUtils.InputString();
					System.out.println("Enter GradeLevel : ");
					String gradeLvel1 = ScannerUtils.InputString();
					System.out.println("Enter EnglishScore : ");
					int englishScore1 = ScannerUtils.InputInt();
					System.out.println("Enter EntryTestScore : ");
					float entryTestScore1 = ScannerUtils.InputFloat();
					NormalStudent normalStudent = new NormalStudent(fullName1, birthDay1, gender1, phoneNumber1,
							universityName1, gradeLvel1, englishScore1, entryTestScore1);
					normalStudents.add(normalStudent);
				}
				break;
			} else {
				System.out.println("Enter number NormalStudent : ");
				numberNormalStudent = ScannerUtils.InputInt();
				for (int i = 0; i < numberNormalStudent; i++) {
					System.out.println("Enter information of student number " + (i + 1) + " : ");
					System.out.println("Enter FullName : ");
					String fullName = ScannerUtils.InputFullName();
					System.out.println("Enter Birthday : ");
					LocalDate birthDay = ScannerUtils.InputLocaldate();
					System.out.println("Enter Gender : ");
					String gender = ScannerUtils.InputString();
					System.out.println("Enter PhoneNumber : ");
					String phoneNumber = ScannerUtils.InputPhoneNumber();
					System.out.println("Enter UniversityName : ");
					String universityName = ScannerUtils.InputString();
					System.out.println("Enter GradeLevel : ");
					String gradeLvel = ScannerUtils.InputString();
					System.out.println("Enter EnglishScore : ");
					int englishScore = ScannerUtils.InputInt();
					System.out.println("Enter EntryTestScore : ");
					float entryTestScore = ScannerUtils.InputFloat();
					NormalStudent normalStudent = new NormalStudent(fullName, birthDay, gender, phoneNumber,
							universityName, gradeLvel, englishScore, entryTestScore);
					normalStudents.add(normalStudent);
				}
			}
			break;
		}
	}

	public void selectStudent() throws InvalidOtherException {
		List<GoodStudent> arrGood = goodStudents.stream()
				.sorted(Comparator.comparing(GoodStudent::getGpa).thenComparing(GoodStudent::getFullName, (s1, s2) -> {
					return s2.compareTo(s1);
				}).reversed()).collect(Collectors.toList());
		List<NormalStudent> arrNormal = normalStudents.stream()
				.sorted(Comparator.comparing(NormalStudent::getEntryTestScore)
						.thenComparing(NormalStudent::getEnglishScore)
						.thenComparing(NormalStudent::getFullName, (s1, s2) -> {
							return s2.compareTo(s1);
						}).reversed())
				.collect(Collectors.toList());
		System.out.println("List of Passed Candidate : ");
		if (numberRecruit <= numberGoodStudent) {
			List<GoodStudent> arr1 = arrGood.subList(0, numberRecruit);
			for (GoodStudent goodStudent : arr1) {
				System.out.println(goodStudent.toString());
			}
		} else if ((numberGoodStudent + numberNormalStudent) >= numberRecruit) {
			for (GoodStudent student : arrGood) {
				System.out.println(student.toString());
			}
			List<NormalStudent> arr2 = arrNormal.subList(0, numberRecruit - numberGoodStudent);
			for (NormalStudent normalStudent : arr2) {
				System.out.println(normalStudent.toString());
			}
		} else {
			throw new InvalidOtherException("Input files have unknow errors !!!");
		}
	}

	public void arrangeByFullName() {
		listStudent.addAll(goodStudents);
		listStudent.addAll(normalStudents);
		List<Student> listArrange = listStudent.stream().sorted(Comparator.comparing(Student::getFullName, (s1, s2) -> {
			return s2.compareTo(s1);
		}).thenComparing(Student::getPhoneNumber)).collect(Collectors.toList());
		for (Student st : listArrange) {
			System.out.println(st.toString());
		}
	}

}
