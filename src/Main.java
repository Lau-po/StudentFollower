import java.io.IOException;

import utils.Util;
import gui.Login;

public class Main {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    try {
      Util.findProfessors();
      Util.findStudents();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Login l = new Login();
  }
}
