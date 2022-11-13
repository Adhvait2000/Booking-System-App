package MOBLIMA;

import java.util.Scanner;

public class ValidInputManager {

	/**
	 * @return int
	 */
	public static int GetInt() {
		boolean inputReceived = false;
		int input = -1;
		while (!inputReceived) {
			try {
				System.out.print("...Enter your choice:");
				Scanner scan = new Scanner(System.in);
				input = scan.nextInt();
				inputReceived = true;
			} catch (Exception e) {
				System.out.println("...Wrong input, please try again.");
			}
		}

		return input;
	}
}
