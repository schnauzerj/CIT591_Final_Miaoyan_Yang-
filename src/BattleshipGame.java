import java.util.Scanner;

public class BattleshipGame {

	public static int row;
	public static int column;

	public static void readRowCol() {

		Scanner scnr = new Scanner(System.in);
		boolean validRow = false;
		boolean validCol = false;

		while (!validRow) {
			System.out.println("Please input the row number (0-9) you want to fire at.");
			if (scnr.hasNextInt()) {
				row = Integer.parseInt(scnr.nextLine());
				if (0 <= row && row <= 9) {
					validRow = true;
				} else {
					System.out.println("Your input is out of the range 0-9.");
				}
			} else {
				System.out.println("Input is not a integer number.");
			}
		}

		while (!validCol) {
			System.out.println("Please input the column number (0-9) you want to fire at.");
			if (scnr.hasNextInt()) {
				column = Integer.parseInt(scnr.nextLine());
				if (0 <= column && column <= 9) {
					validCol = true;
				} else {
					System.out.println("Your input is out of the range 0-9.");
				}
			} else {
				System.out.println("Input is not a integer number.");
			}
		}

	}

	public static void main(String[] args) {

		System.out.println("The ocean is as follows:");

		Ocean newOcean = new Ocean();

		newOcean.placeAllShipsRandomly();
		newOcean.print2();

		while (!newOcean.isGameOver()) {
			System.out.println("The ocean is as follows:");
			newOcean.print();
			readRowCol();

			if (newOcean.shootAt(row, column) == true) {
				Ship[][] arr = newOcean.getShipArray();
				Ship curNode = arr[row][column];

//				System.out.println(curNode.getShipType());
//				System.out.println("isHorizontal " + curNode.isHorizontal());
//				System.out.println(curNode.isSunk());
//				System.out.println(newOcean.getHitCount());
//				for (int i = 0; i <= curNode.getLength() - 1; i++) {
//					System.out.println(curNode.getHit()[i]);
//				}

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
		System.out.println("Shots required: " + newOcean.getHitCount());
	}

//	public void printFinalResult() {
//
//	}
}
