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

import java.util.Random;


/**
 *
 * @author boinc
 */

public class Manager implements Pepole {

  public static String EMAIL_SEPARATOR = "@";
  public static String EMAIL_DN = "univ-lille1.fr";
  
  private String email;
  private String fristName;
  private String lastName;
  private int number;
  private String password;
  private int status = 0;
  private String userName;

  public Manager(String firstName, String lastName) {
    this.fristName = firstName;
    this.lastName = lastName;
    this.email = this.generateEmail();
    this.userName = this.generateUserName();
    this.password = this.generatePassword();
  }

  public Manager(String firstName, String lastName, String email) {
    this.fristName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.userName = this.generateUserName();
    this.password = this.generatePassword();
  }

  public Manager(String firstName, String lastName, String email, String password) {
    this.fristName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.userName = this.generateUserName();
  }

  private String generateEmail() {
    return this.fristName + "." + this.lastName + EMAIL_SEPARATOR + EMAIL_DN;
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
      return this.lastName.substring(0, 7) + this.fristName.charAt(0);
    }
    return (this.lastName + this.fristName.charAt(0)).toLowerCase();
  }

  @Override
  public String getEmail() {
    return this.email;
  }

  @Override
  public String getFirstName() {
    return this.fristName;
  }

  @Override
  public String getFullName() {
    return this.fristName + " " + this.lastName;
  }

  @Override
  public String getLastName() {
    return this.lastName;
  }

  @Override
  public int getNumber() {
    return this.number;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public int getStatus() {
    return this.status;
  }

  @Override
  public String getUserName() {
    return this.userName;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }
}
