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
		for (Professor p : Util.professors) {
			System.out.println(p.getId());
		}
		Login l = new Login();
	}
}
