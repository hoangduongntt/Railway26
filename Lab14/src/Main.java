import java.text.ParseException;

import com.backend.Controller;

import Ultis.InvalidFullNameException;
import Ultis.InvalidOtherException;
import Ultis.InvalidPhoneNumberException;

public class Main {
	public static void main(String[] args)
			throws InvalidFullNameException, ParseException, InvalidPhoneNumberException, InvalidOtherException {
		Controller controller = new Controller();
		controller.run();
	}
}
