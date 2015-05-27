import java.util.Scanner;

import utils.Util;


public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String userName, password;
		do {
			System.out.println("### Login ###");
			System.out.print("Identifiant : ");
			userName = sc.nextLine();
			System.out.print("Mot de passe : ");
			password = sc.nextLine();
		} while(Util.isAllowedToConnect(userName, password));
		System.out.println("OK");
	}
}