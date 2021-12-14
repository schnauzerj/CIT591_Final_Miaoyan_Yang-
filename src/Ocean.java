
/**
 * This class manages the game state by keeping track of what entity is
 * contained in each position on the game board.
 * 
 * @author harry
 *
 */
import java.util.Random;

public class Ocean implements OceanInterface {

	/**
	 * A 10x10 2D array of Ships, which can be used to quickly determine which ship
	 * is in any given location.
	 */
	protected Ship[][] ships;

	/**
	 * The total number of shots fired by the user
	 */
	protected int shotsFired;

	/**
	 * The number of times a shot hit a ship. If the user shoots the same part of a
	 * ship more than once, every hit is counted, even though the additional "hits"
	 * don't do the user any good.
	 */
	protected int hitCount;

	/**
	 * The number of ships totally sunk.
	 * 
	 */
	protected int shipsSunk;

	protected int[][] grid;

	/**
	 * Creates an "empty" ocean, filling every space in the <code>ships</code> array
	 * with EmptySea objects. Should also initialize the other instance variables
	 * appropriately.
	 */
	public Ocean() {
		this.ships = new Ship[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.ships[i][j] = new EmptySea();
			}
		}
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		this.grid = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = 0;
			}
		}
	}

	/**
	 * Place all ten ships randomly on the (initially empty) ocean. Larger ships
	 * must be placed before smaller ones to avoid cases where it may be impossible
	 * to place the larger ships.
	 * 
	 * @see java.util.Random
	 */
	public void placeAllShipsRandomly() {

		int putCount = 0;
		Random random = new Random();
		while (putCount < 1) {
			Battleship battleship = new Battleship();
			int row = (int) (random.nextDouble() * 10);
			int col = (int) (random.nextDouble() * 10);
			boolean isHorizontal;
			if (random.nextDouble() <= 0.5) {
				isHorizontal = true;
			} else {
				isHorizontal = false;
			}
			if (battleship.okToPlaceShipAt(row, col, isHorizontal, this)) {
//				System.out.println("Battleship " + row + " " + col);
				battleship.setBowRow(row);
				battleship.setBowColumn(col);
				battleship.setHorizontal(isHorizontal);

				battleship.placeShipAt(row, col, isHorizontal, this);
				putCount += 1;
			}
		}

		while (putCount <= 2) {
			Cruiser cruiser = new Cruiser();
			int row = (int) (random.nextDouble() * 10);
			int col = (int) (random.nextDouble() * 10);
			boolean isHorizontal;
			if (random.nextDouble() <= 0.5) {
				isHorizontal = true;
			} else {
				isHorizontal = false;
			}
			if (cruiser.okToPlaceShipAt(row, col, isHorizontal, this)) {
				cruiser.setBowRow(row);
				cruiser.setBowColumn(col);
				cruiser.setHorizontal(isHorizontal);

				cruiser.placeShipAt(row, col, isHorizontal, this);
				putCount += 1;
			}
		}

		while (putCount <= 5) {
			Destroyer destroyer = new Destroyer();
			int row = (int) (random.nextDouble() * 10);
			int col = (int) (random.nextDouble() * 10);
			boolean isHorizontal;
			if (random.nextDouble() <= 0.5) {
				isHorizontal = true;
			} else {
				isHorizontal = false;
			}
			if (destroyer.okToPlaceShipAt(row, col, isHorizontal, this)) {
//				System.out.println("Destroyer " + row + " " + col);
				destroyer.setBowRow(row);
				destroyer.setBowColumn(col);
				destroyer.setHorizontal(isHorizontal);

				destroyer.placeShipAt(row, col, isHorizontal, this);
				putCount += 1;
			}
		}

		while (putCount <= 9) {
			Submarine submarine = new Submarine();

			int row = (int) (random.nextDouble() * 10);
			int col = (int) (random.nextDouble() * 10);
			boolean isHorizontal;
			if (random.nextDouble() <= 0.5) {
				isHorizontal = true;
			} else {
				isHorizontal = false;
			}
			if (submarine.okToPlaceShipAt(row, col, isHorizontal, this)) {
//				System.out.println("Submarine " + row + " " + col);
				submarine.setBowRow(row);
				submarine.setBowColumn(col);
				submarine.setHorizontal(isHorizontal);

				submarine.placeShipAt(row, col, isHorizontal, this);
				putCount += 1;
			}
		}

	}

	/**
	 * Checks if this coordinate is not empty; that is, if this coordinate does not
	 * contain an EmptySea reference.
	 * 
	 * @param row    the row (0 to 9) in which to check for a floating ship
	 * @param column the column (0 to 9) in which to check for a floating ship
	 * @return {@literal true} if the given location contains a ship, and
	 *         {@literal false} otherwise.
	 */
	public boolean isOccupied(int row, int column) {
		String type = this.ships[row][column].getShipType();
		if (type == "empty") {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Fires a shot at this coordinate. This will update the number of shots that
	 * have been fired (and potentially the number of hits, as well). If a location
	 * contains a real, not sunk ship, this method should return {@literal true}
	 * every time the user shoots at that location. If the ship has been sunk,
	 * additional shots at this location should return {@literal false}.
	 * 
	 * @param row    the row (0 to 9) in which to shoot
	 * @param column the column (0 to 9) in which to shoot
	 * @return {@literal true} if the given location contains an afloat ship (not an
	 *         EmptySea), {@literal false} if it does not.
	 */
	public boolean shootAt(int row, int column) {
		shotsFired += 1;
		Ship curNode = this.ships[row][column];
		grid[row][column] = 1; // mark this tile as 1: has been fired
		if (curNode.getShipType() != "empty" && curNode.isSunk() == false) {
			curNode.shootAt(row, column);
			hitCount += 1;
			if (curNode.isSunk() == true) {
				this.shipsSunk += 1;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the number of shots fired in this game.
	 */
	public int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * @return the number of hits recorded in this game.
	 */
	public int getHitCount() {
		return this.hitCount;
	}

	/**
	 * @return the number of ships sunk in this game.
	 */
	public int getShipsSunk() {
		return this.shipsSunk;
	}

	/**
	 * @return {@literal true} if all ships have been sunk, otherwise
	 *         {@literal false}.
	 */
	public boolean isGameOver() {
		if (this.shipsSunk == 10) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Provides access to the grid of ships in this Ocean. The methods in the Ship
	 * class that take an Ocean parameter must be able to read and even modify the
	 * contents of this array. While it is generally undesirable to allow methods in
	 * one class to directly access instancce variables in another class, in this
	 * case there is no clear and elegant alternatives.
	 * 
	 * @return the 10x10 array of ships.
	 */
	public Ship[][] getShipArray() {
		return this.ships;
	}

	/**
	 * Prints the ocean. To aid the user, row numbers should be displayed along the
	 * left edge of the array, and column numbers should be displayed along the top.
	 * Numbers should be 0 to 9, not 1 to 10. The top left corner square should be
	 * 0, 0.
	 * <ul>
	 * <li>Use 'S' to indicate a location that you have fired upon and hit a (real)
	 * ship</li>
	 * <li>'-' to indicate a location that you have fired upon and found nothing
	 * there</li>
	 * <li>'x' to indicate a location containing a sunken ship</li>
	 * <li>'.' (a period) to indicate a location that you have never fired
	 * upon.</li>
	 * </ul>
	 * 
	 * This is the only method in Ocean that has any printing capability, and it
	 * should never be called from within the Ocean class except for the purposes of
	 * debugging.
	 * 
	 */
	public void print() {
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i <= 9; i++) {
			System.out.print(i + " ");
			for (int j = 0; j <= 9; j++) {
				if (grid[i][j] == 0) {
					System.out.print(". ");
				} else {
					System.out.print(this.ships[i][j].toString() + " ");
				}
			}
			System.out.print("\n");
		}

	}

	public void print2() {
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i <= 9; i++) {
			System.out.print(i + " ");
			for (int j = 0; j <= 9; j++) {

				System.out.print(this.ships[i][j].toString() + " ");

			}
			System.out.print("\n");
		}

	}

}
