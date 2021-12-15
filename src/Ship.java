
public abstract class Ship extends Object {
	/**
	 * The column (0 to 9) which contains the bow (front) of the ship.
	 */
	protected int bowColumn;

	/**
	 * The row (0 to 9) which contains the bow (front) of the ship.
	 */
	protected int bowRow;

	/**
	 * hit is an array of four booleans telling whether that part of the ship has
	 * been hit.
	 */
	protected boolean[] hit;

	/**
	 * true if the ship occupies a single row, false otherwise.
	 */
	protected boolean horizontal;

	/**
	 * The number of tiles occupied by the ship.
	 */
	protected int length;

	/**
	 * Get the column of the bow (front) of the ship.
	 * 
	 * @return the column of the bow (front) of the ship
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}

	/**
	 * Get the row of the bow (front) of the ship.
	 * 
	 * @return the row of the bow (front) of the ship
	 */

	public int getBowRow() {
		return this.bowRow;
	}

	/**
	 * Get the length of the ship.
	 * 
	 * @return the length of the ship.
	 */

	public int getLength() {
		return this.length;
	}

	public abstract String getShipType();

	/**
	 * Get the direction of the ship.
	 * 
	 * @return {@literal true} if this boat is horizontal (facing left), and
	 *         {@literal false} otherwise.
	 */

	public boolean isHorizontal() {
		return this.horizontal;
	}

	/**
	 * Returns true if this ship has been sunk and false otherwise.
	 * 
	 * @return {@literal true} if every part of the ship has been hit, and
	 *         {@literal false} otherwise.
	 */
	public boolean isSunk() {
		for (int i = 0; i < this.hit.length; i++) {
			if (this.hit[i] == false) {
				return false;
			}
		}
		// if hit[] contains all true
		return true;
	}

	/**
	 * Determines whether or not this is represents a valid placement configuration
	 * for this Ship in this Ocean. Ship objects in an Ocean must not overlap other
	 * Ship objects or touch them vertically, horizontally, or diagonally.
	 * Additionally, the placement cannot be such that the Ship would extend beyond
	 * the extents of the 2D array in which it is placed. Calling this method should
	 * not actually change either the Ship or the provided Ocean.
	 * 
	 * @param row        the candidate row to place the ship
	 * @param column     the candidate column to place the ship
	 * @param horizontal whether or not to have the ship facing to the left
	 * @param ocean      the Ocean in which this ship might be placed
	 * @return {@literal true} if it is valid to place this ship of this length in
	 *         this location with this orientation, and {@literal false} otherwise.
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		int len = this.getLength();
		if (horizontal == true) {
			for (int i = -1; i <= len; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i < len && column + i > 9) { // the end of the ship doesn't go out of boundary
						return false;
					}
					if (row + j >= 0 && row + j <= 9 && column + i >= 0 && column + i <= 9) { // verify the boundary
						if (ocean.isOccupied(row + j, column + i)) {
							return false;
						}
					}

				}
			}
		} else if (horizontal == false) {
			for (int i = -1; i <= len; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i < len && row + i > 9) { // the end of the ship doesn't go out of boundary
						return false;
					}
					if (row + i >= 0 && row + i <= 9 && column + j >= 0 && column + j <= 9) {
						if (ocean.isOccupied(row + i, column + j)) {
							return false;
						}
					}

				}
			}
		}
		return true;
	}

	/**
	 * Puts the Ship in the Ocean. This will give values to the bowRow, bowColumn,
	 * and horizontal instance variables in the Ship. This should also place a
	 * reference to this Ship in each of the one or more locations (up to four) in
	 * the corresponding Ocean array this Ship is being placed in. Each of the
	 * references placed in the Ocean will be identical since it is not possible to
	 * refer to a "part" of a ship, only the whole ship.
	 * 
	 * @param row        the row to place the ship
	 * @param column     the column to place the ship
	 * @param horizontal whether or not to have the ship facing to the left
	 * @param ocean      the Ocean in which this ship might be placed
	 */

	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

		Ship[][] shipArray = ocean.getShipArray();
		int len = this.getLength();
		if (horizontal == true) {
			for (int i = 0; i < len; i++) {
				shipArray[row][column + i] = this;
			}
		} else {
			for (int i = 0; i < len; i++) {
				shipArray[row + i][column] = this;
			}
		}

	}

	/**
	 * Set bowColumn.
	 * 
	 * @param bowColumn the bowColumn to set
	 */

	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	/**
	 * Set bowRow.
	 * 
	 * @param bowRow the bowRow to set
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	/**
	 * Set horizontal.
	 * 
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * If a part of this ship occupies this coordinate, and if the ship hasn't been
	 * sunk, mark the part of the ship at that coordinate as "hit".
	 * 
	 * @param row    the row of the shot
	 * @param column the column of the shot
	 * @return {@literal true} if this ship hasn't been sunk and a part of this ship
	 *         occupies the given row and column, and {@literal false} otherwise.
	 */
	public boolean shootAt(int row, int column) {
		int bowC = this.getBowColumn();
		int bowR = this.getBowRow();
		int len = this.getLength();
		if (this.horizontal == true) {
			if ((bowR == row) && (column >= bowC) && (column <= bowC + len - 1)) {
				{
					// change the hit[] in the tile into "true"
					int gap = column - bowC;
					this.hit[gap] = true;
					return true;
				}

			}
		} else if (this.horizontal == false) {
			if ((bowC == column) && (row >= bowR) && (row <= bowR + len - 1)) {
				{
					int gap = row - bowR;
					this.hit[gap] = true;
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Returns a single character String to use in the Ocean's print method. This
	 * method should return "x" if the ship has been sunk, and "S" if it has not yet
	 * been sunk. This method can only be used to print out locations in the ocean
	 * that have been shot at; it should not be used to print locations that have
	 * not been the target of a shot yet.
	 * 
	 * @return "x" if this ship has been sunk, and "S" otherwise.
	 */

	public String toString() {
		if (this.isSunk() == true) {
			return ("x");
		} else {
			return ("S");
		}
	}

//	public boolean[] getHit() { // when a cell is hit
//		return this.hit;
//	}

}
