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

package user;

import java.util.List;
import java.util.Random;

import notice.Missing;
import notice.Retard;

/**
 * 
 * @author boinc
 */

public class Student implements Pepole {

  public static String EMAIL_DN_STUDENT = "student.univ-lille1.fr";

  static final String EMAIL_SEPARATOR = "@";

  private String firstName, lastName, userName, email, password;
  private char group;
  private List<Missing> missing;
  private List<Retard> retards;

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = this.generateEmail();
    this.password = this.generatePassword();
    this.userName = this.generateUserName();
  }

  public Student(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = this.generatePassword();
    this.userName = this.generateUserName();
  }

  public Student(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.userName = this.generateUserName();
  }

  private String generateEmail() {
    return (this.firstName + "." + this.lastName + EMAIL_SEPARATOR + EMAIL_DN_STUDENT)
        .toLowerCase();
  }

  @Override
  public void generateNewPassword() {
    this.password = this.generatePassword();
  }

  private String generatePassword() {
    char[] characters =
        "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890".toCharArray();
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      str.append(characters[new Random().nextInt(characters.length - 1)]);
    }
    return str.toString();
  }

  private String generateUserName() {
    if (this.lastName.length() - 1 > 7) {
      return this.lastName.substring(0, 7) + this.firstName.charAt(0);
    }
    return (this.lastName + this.firstName.charAt(0)).toLowerCase();
  }

  public List<Missing> getAllMissing() {
    return this.missing;
  }

  public List<Retard> getAllRetard() {
    return this.retards;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getFirstName() {
    return this.firstName;
  }

  @Override
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public char getGroup() {
    return this.group;
  }

  @Override
  public String getLastName() {
    return this.lastName;
  }

  public Missing getMissing(Missing m) {
    for (Missing mi : missing) {
      if (m.equals(mi)) {
        return mi;
      }
    }
    return null;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  public Retard getRetard(Retard r) {
    for (Retard retard : retards) {
      if (r.equals(retard)) {
        return retard;
      }
    }
    return null;
  }

  @Override
  public String getUserName() {
    return this.userName;
  }

  public void setGroup(String group) {
    this.group = group.charAt(0);
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

}
