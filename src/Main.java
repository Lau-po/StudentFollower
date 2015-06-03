import java.io.IOException;

import user.Professor;
import utils.Util;
import gui.Login;

public class Main {
	public static void main(String[] args) {
		try {
			Util.findProfessors();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Login l = new Login();
	}
}
