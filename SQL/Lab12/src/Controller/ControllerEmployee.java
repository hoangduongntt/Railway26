package Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Model.Employee;
import Ultis.ScannerUtils;
import View.ViewEmployee;

public class ControllerEmployee {
	static List<Employee> listEmployee = new ArrayList<Employee>();
	ViewEmployee viewEmployee;

	public ControllerEmployee() {
		viewEmployee = new ViewEmployee();
	}

	public void start() throws ParseException {
		while (true) {
			System.out.println("Please choose function !");
			System.out.println("1. Add Employee !");
			System.out.println("2. Display Information of Employee !");
			System.out.println("3. Delete Employee By ID !");
			System.out.println("4. Find Employee By ID !");
			System.out.println("5. Find Employee By Type !");
			System.out.println("6. Exit !");
			int choose = ScannerUtils.InputInt();
			switch (choose) {
			case 1: {
				viewEmployee.addEmployeer();
				break;
			}
			case 2: {
				viewEmployee.disPlayInfor();
				break;
			}
			case 3: {
				viewEmployee.deleteById();
				break;
			}
			case 4: {
				viewEmployee.findById();
				break;
			}
			case 5: {
				viewEmployee.findByType();
				;
				break;
			}
			case 6: {
				return;
			}
			default:
				System.err.println("Choose is wrong, please check again!");
			}
		}
	}

}
