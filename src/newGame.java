import java.util.Scanner;

public class newGame {

	public static void main(String[] args) {
		boolean newStart = newGame();
		if (newStart == true) {
			System.out.println("true");
		} else if (newStart = false) {
			System.out.println("false");

		}
	}

	public static boolean newGame() {
		System.out.println("Do you want to play again? Enter 'Y' for Yes and 'N' for No.");
		Scanner scnr = new Scanner(System.in);
		while (true) {
			String answer = scnr.next();
			if (answer.equals("Y")) {
				System.out.println("Start a new game.");
				return true;
			} else if (answer.equals("N")) {
				return false;
			} else {
				System.out.println("Invalid input. Please enter 'Y' or 'N'.");
			}
		}
	}
}
