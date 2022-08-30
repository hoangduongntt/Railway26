package com.backend;

import java.text.ParseException;

import Ultis.InvalidFullNameException;
import Ultis.InvalidOtherException;
import Ultis.InvalidPhoneNumberException;
import Ultis.ScannerUtils;
import View.View;

public class Controller {
	View program;

	public Controller() {
		program = new View();
	}

	public void run()
			throws InvalidFullNameException, ParseException, InvalidPhoneNumberException, InvalidOtherException {
		while (true) {
			System.out.println("Please choose function !");
			System.out.println("1. Add Student !");
			System.out.println("2. Select Student !");
			System.out.println("3. Arrage Student By FullName Ang Phone Number !");
			System.out.println("4. Exit !");
			int choose = ScannerUtils.InputInt();
			switch (choose) {
			case 1: {
				program.addStudent();
				break;
			}
			case 2: {
				program.selectStudent();
				break;
			}
			case 3: {
				program.arrangeByFullName();
				break;
			}
			case 4: {
				return;
			}
			}
		}
	}
}
