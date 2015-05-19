/*
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package user;

import java.util.List;

public class Professor implements Pepole {

  private String email;
  private String fristName;
  private String lastName;
  private int number;
  private String password;
  private String userName;
  private int status = 1;
  private List<Character> listOfGroup;

  public Professor(String firstName, String lastName, String email) {
    this.fristName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.userName = this.generateUserName();
  }

  public Professor(String firstName, String lastName, String email, String password) {
    this.fristName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.userName = this.generateUserName();
  }

  private String generateUserName() {
    if (this.lastName.length() - 1 > 7) {
      return this.lastName.substring(0, 7) + this.fristName.charAt(0);
    }
    return this.lastName + this.fristName.charAt(0);
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
  public String getUserName() {
    return this.userName;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public int getStatus() {
    return this.status;
  }

  public List<Character> getListOfGroup() {
    return listOfGroup;
  }

  public void setOneGroup(char group) {
    this.listOfGroup.add(group);
  }

}