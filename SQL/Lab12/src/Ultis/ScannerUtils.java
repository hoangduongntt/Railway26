package Ultis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerUtils {
	static Scanner sc = new Scanner(System.in);

	public static int InputInt() {
		while (true) {
			try {
				int tempint = Integer.parseInt(sc.nextLine());
				if (tempint > 0) {
					return tempint;
				} else {
					System.err.println("Nhập sai, xin mời nhập lại !");
				}

			} catch (NumberFormatException e) {
				System.err.println("Nhập sai dữ liệu, xin mời nhập lại !");
			}

		}
	}

	public static Float InputFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.nextLine());

			} catch (NumberFormatException e) {
				System.err.println("Nhập sai dữ liệu, xin mời nhập lại !");
			}
		}
	}

	public static String InputString() {
		while (true) {
			String string = sc.nextLine();
			if (!string.isEmpty()) {
				return string;
			} else {
				System.err.println("Nhập sai, xin mời nhập lại !");
			}
		}
	}

	public static LocalDate InputLocaldate() throws ParseException {
		while (true) {
		try {
			System.out.println("Nhập vaò theo định dạng yyyy-MM-dd ");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String localdate = sc.nextLine();
				try {
					if (format.parse(localdate) != null) {
						LocalDate date = LocalDate.parse(localdate);
						return date;
					}
				} catch (ParseException e) {
					System.err.println("Nhập sai, xin mời nhập lại !");
				}
		} catch (Exception e) {
			System.err.println("Nhập sai, xin mời nhập lại !");
		}
	}
}

	public static String inputEmail() {
		while (true) {
			String email = ScannerUtils.InputString();
			if (email == null || !email.contains("@")) {
				System.err.println("Nhập sai định dạng, xin mời nhập lại (Email phải có @) !");
			} else {
				return email;
			}
		}
	}

	public static String inputPassWord() {
		while (true) {
			String passWord = ScannerUtils.InputString();
			if (passWord.length() < 6 || passWord.length() > 12) {
				System.err.println("Xin mời nhập lại (Độ dài PassWord từ 6-12) !");
				continue;
			}
			boolean checkKyTuVietHoa = false;
			for (int i = 0; i < passWord.length(); i++) {
				if (Character.isUpperCase(passWord.charAt(i)) == true) {
					checkKyTuVietHoa = true;
					break;
				}
			}
			if (checkKyTuVietHoa == true) {
				return passWord;
			} else {
				System.err.println("Nhập sai định dạng (Phải có chữ cái hoa đầu tiên) !");
			}
		}
	}

	public static String InputFullName() {
		String fullName = "";
		while (true) {
			System.out.println("Nhập vào Fullname");
			fullName = ScannerUtils.InputString();
			Pattern p = Pattern.compile("^[a-zA-Z\s]{0,50}$");

			if (p.matcher(fullName).find()) {
				break;
			} else {
				System.err.println("Nhập sai định dạng, mời nhập lại, (FullName chỉ chứa chữ !)");
			}
		}
		return fullName;
	}

	public static String InputPhoneNumber() {
		String number = "";
		while (true) {
			number = ScannerUtils.InputString();
			Pattern p = Pattern.compile("^[0-9]{9,12}$");
			if (!p.matcher(number).find()) {
				System.err.println("Nhập sai, mời nhập lại!  (Số điện thoại chỉ chứa số, độ dài từ 9-12)");
				continue;
			}
			if (number.charAt(0) == '0') {
				break;
			} else {
				System.err.println("Nhập sai, mời nhập lại!  (Số điện thoại phải bắt đầu bằng số 0 !)");
			}
		}
		return number;
	}

	public static int InputAge() {
		while (true) {
			try {
				int age = ScannerUtils.InputInt();
				if (age > 18 && age < 60) {
					return age;
				} else {
					System.err.println("Nhập sai, tuổi phải từ 18 - 60 ! ");
				}
			} catch (Exception e) {
				System.err.println("Nhập sai dữ liệu, mời nhập lại !");
			}
		}
	}

	public static void main(String[] args) throws ParseException {
		// inputEmail();
		// inputPassWord();
		// inputPhoneNumber();
		// InputFullName();
		// InputPhoneNumber();
		// InputAge();
		InputLocaldate();
	}
}