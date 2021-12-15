import java.util.Scanner;

public class BattleshipGame {

	/**
	 * The row (0 to 9) which contains the bow (front) of the ship.
	 */
	private int row;

	/**
	 * The column (0 to 9) which contains the bow (front) of the ship.
	 */
	private int column;

	/**
	 * Ask the player to input a row number and and a column number. If the input is
	 * not a valid integer from 0 to 9, prompt error and ask the player to input
	 * again.
	 */
	public void readRowCol() {

		boolean validRow = false;
		boolean validCol = false;
		Scanner scnr = new Scanner(System.in);

		while (!validRow) {
			System.out.println("Please input the row number (0-9) you want to fire at.");
			if (scnr.hasNextInt()) {
				this.row = scnr.nextInt();

				if (0 <= row && row <= 9) {
					validRow = true;
				} else {
					System.out.println("Your input is out of the range 0-9.");
				}
			} else {
				String temp = scnr.next();
				System.out.println("Input " + temp + " is not an integer number.");
			}
		}

		while (!validCol) {
			System.out.println("Please input the column number (0-9) you want to fire at.");
			if (scnr.hasNextInt()) {
				this.column = scnr.nextInt();

				if (0 <= column && column <= 9) {
					validCol = true;
				} else {
					System.out.println("Your input is out of the range 0-9.");
				}
			} else {
				String temp = scnr.next();
				System.out.println("Input " + temp + " is not an integer number.");
			}
		}

	}

	/**
	 * Ask the player's intention to start a new game. If the player inputs "Y"
	 * (yes), return true. If the player inputs "N" (no), return false.
	 * 
	 * @return {@literal true} if player wants to start a new game, and
	 *         {@literal false} otherwise.
	 * 
	 */
	public boolean newGame() {
		System.out.println("Do you want to play again? Enter 'Y' for Yes and 'N' for No.");
		Scanner scnr = new Scanner(System.in);
		while (true) {
			String answer = scnr.next();
			if (answer.equals("Y")) {
				System.out.println("Start a new game.");
				return true;
			} else if (answer.equals("N")) {
				System.out.println("Bye bye!");
				return false;
			} else {
				System.out.println("Invalid input. Please enter 'Y' or 'N'.");
			}
		}
	}

	/**
	 * Get the row number input by the user at this round
	 * 
	 * @return the row number input by the user at this round
	 * 
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Get the column number input by the user at this round
	 * 
	 * @return the column number input by the user at this round
	 * 
	 */

	public int getColumn() {
		return this.column;
	}

	public static void main(String[] args) {

		BattleshipGame game = new BattleshipGame();

		while (true) {
			Ocean newOcean = new Ocean();
			newOcean.placeAllShipsRandomly();
			// newOcean.print2();

			while (!newOcean.isGameOver()) {
				System.out.println("------The ocean------");
				newOcean.print();
				game.readRowCol();
				int row = game.getRow();
				int column = game.getColumn();
				if (newOcean.shootAt(row, column) == true) {
					Ship[][] arr = newOcean.getShipArray();
					Ship curNode = arr[row][column];

					// test section (please don't delete)
					// System.out.println("hitcount = " + newOcean.getHitCount());
					// System.out.println("shipsunk = " + newOcean.getShipsSunk());
					// System.out.println("shotsfired = " + newOcean.getShotsFired());

					if (curNode.isSunk()) {
						System.out.println("You just sunk a " + curNode.getShipType());
					} else {
						System.out.println("hit");
					}
				} else {

					System.out.println("miss");
				}
			}

			// When the user reaches the end of the game
			newOcean.print();
			System.out.println("Congratulations! You have sunk all the ships.");
			System.out.println("Shots required: " + newOcean.getShotsFired());

			// ask the user if want to play a new game
			if (game.newGame()) {
				continue;
			} else {
				break;
			}
		}

	}

}
