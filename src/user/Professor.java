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

import config.Constants;

/**
 *
 * @author boinc
 */
public class Professor implements Pepole {

  private String email;
  private String firstName;
  private String lastName;
  private List<Character> listOfGroup;
  private int number;
  private String password;
  private int status = 1;
  private String userName;

  public Professor(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = this.generateEmail();
    this.password = this.generatePassword();
    this.userName = this.generateUserName();
  }

  public Professor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = this.generatePassword();
    this.userName = this.generateUserName();
  }

  public Professor(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.userName = this.generateUserName();
  }

  private String generateEmail() {
    return this.firstName + "." + this.lastName + Constants.EMAIL_SEPARATOR + Constants.EMAIL_DN;
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

  @Override
  public String getEmail() {
    return this.email;
  }

  @Override
  public String getFirstName() {
    return this.firstName;
  }

  @Override
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  @Override
  public String getLastName() {
    return this.lastName;
  }

  public List<Character> getListOfGroup() {
    return listOfGroup;
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

  public void setOneGroup(char group) {
    this.listOfGroup.add(group);
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

}
