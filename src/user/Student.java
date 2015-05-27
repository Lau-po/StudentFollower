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

	private String firstName, lastName, userName, email, password;
	private char group;
	private List<Retard> retards;
	private List<Missing> missing;

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

	public Student(String firstName, String lastName, String email,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userName = this.generateUserName();
	}

	private String generateEmail() {
		return this.firstName + "." + this.lastName + Manager.EMAIL_SEPARATOR
				+ EMAIL_DN_STUDENT;
	}

	@Override
	public void generateNewPassword() {
		this.password = this.generatePassword();
	}

	private String generatePassword() {
		char[] characters = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890"
				.toCharArray();
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
