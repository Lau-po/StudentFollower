/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */

package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import user.Pepole;
import user.Professor;
import user.Student;
import classes.Group;

import com.opencsv.CSVReader;

/**
 * @author boinc
 * 
 *         Utility methods for the application
 */

public class Util {

  private final static String COMMENT_CHAR = "#";

  public static List<Group> groups = new ArrayList<Group>();
  private final static String PROFESSOR_FILE_NAME = "professors.csv";

  public static List<Professor> professors = new ArrayList<Professor>();
  private final static String RESOURCES_PATH = "src/resources/";

  public static Scanner sc = new Scanner(System.in);
  private final static char SEPARATOR = ';';
  private final static String STUDENT_FILE_NAME = "students.csv";
  public static List<Student> students = new ArrayList<Student>();

  public static void buildGroups() {
    groups.add(new Group('A'));
    groups.add(new Group('B'));
    groups.add(new Group('C'));
    groups.add(new Group('D'));

    for (Group group : groups) {
      for (Professor p : professors) {
        p.addGroup(group);
      }
    }
  }

  private static List<String[]> findPepole(String FileName) {
    File file = new File(RESOURCES_PATH + FileName);
    List<String[]> data = new ArrayList<String[]>();
    try {
      FileReader fileReader = new FileReader(file);
      CSVReader csvReader = new CSVReader(fileReader, SEPARATOR);
      String[] nextLine = null;
      while ((nextLine = csvReader.readNext()) != null) {
        int size = nextLine.length;
        if (size == 0) {
          continue;
        }
        String start = nextLine[0].trim();
        if (start.length() == 0 && size == 1) {
          continue;
        }
        if (start.startsWith(COMMENT_CHAR)) {
          continue;
        }
        data.add(nextLine);
      }
      csvReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }

  public static void findProfessors() throws IOException {
    List<String[]> data = Util.findPepole(PROFESSOR_FILE_NAME);
    for (String[] oneData : data) {
      String id = oneData[0];
      String firstName = oneData[1];
      String lastName = oneData[2];
      String email, password;
      try {
        email = oneData[3];
      } catch (Exception e) {
        email = "";
      }
      try {
        password = oneData[4];
      } catch (Exception e) {
        password = "";
      }
      if (email.isEmpty() && password.isEmpty()) {
        Util.professors.add(new Professor(Integer.parseInt(id), firstName, lastName));
      } else if (!email.isEmpty() && password.isEmpty()) {
        Util.professors.add(new Professor(Integer.parseInt(id), firstName, lastName, email));
      } else {
        Util.professors.add(new Professor(Integer.parseInt(id), firstName, lastName, email,
            password));
      }
    }
  }

  public static void findStudents() throws IOException {
    List<String[]> data = Util.findPepole(STUDENT_FILE_NAME);
    for (String[] oneData : data) {
      String firstName = oneData[0];
      String lastName = oneData[1];
      String email, password;
      try {
        email = oneData[2];
      } catch (Exception e) {
        email = "";
      }
      try {
        password = oneData[3];
      } catch (Exception e) {
        password = "";
      }
      if (email.isEmpty() & password.isEmpty()) {
        Util.students.add(new Student(firstName, lastName));
      } else if (!email.isEmpty() & password.isEmpty()) {
        Util.students.add(new Student(firstName, lastName, email));
      } else {
        Util.students.add(new Student(firstName, lastName, email, password));
      }
    }
  }

  public static String getLostPasswordByEmail(String email) {
    List<Pepole> users = new ArrayList<Pepole>();
    users.addAll(Util.professors);
    for (Pepole pepole : users) {
      if (pepole.getEmail() == email) {
        return pepole.getPassword();
      }
    }
    return null;
  }

  public static boolean isAllowedToConnect(String userName, String password) {
    List<Pepole> allowedUsers = new ArrayList<Pepole>();
    allowedUsers.addAll(Util.professors);
    for (Pepole pepole : allowedUsers) {
      if (pepole.getUserName().equals(userName)) {
        return pepole.getPassword().equals(password);
      }
    }
    return false;
  }

  public static String getResourcesPath() {
    return RESOURCES_PATH;
  }
}
