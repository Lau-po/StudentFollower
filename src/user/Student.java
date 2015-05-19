package user;

import java.util.List;

import notice.Missing;
import notice.Retard;

public class Student implements Pepole {

  private String email;
  private String fristName;
  private String lastName;
  private int number;
  private String password;
  private String userName;
  private int status = 2;
  private char group;
  private List<Retard> retards;
  private List<Missing> missing;

  public Student(String firstName, String lastName, String email) {
    this.fristName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.userName = this.generateUserName();
  }

  public Student(String firstName, String lastName, String email, String password) {
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
  
  public List<Missing> getAllMissing() {
    return this.missing;
  }
  
  public Missing getMissing(Missing m) {
    for (Missing missing : missing) {
      if (m.equals(missing)) {
        return missing;
      }
    }
    return null;
  }
  
  public List<Retard> getAllRetard() {
    return this.retards;
  }
  
  public Retard getRetard(Retard r) {
    for (Retard retard : retards) {
      if (r.equals(retard)) {
        return retard;
      }
    }
    return null;
  }
  
  public char getGroup() {
    return this.group;
  }
  
  public void setGroup(String group) {
    this.group = group.charAt(0);
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

}
