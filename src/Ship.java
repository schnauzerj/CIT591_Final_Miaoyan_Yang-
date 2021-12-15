
public abstract class Ship extends Object {
	protected int bowColumn;
	protected int bowRow;
	protected boolean[] hit;
	protected boolean horizontal;
	protected int length;

	public int getBowColumn() {
		return this.bowColumn;
	}

	public int getBowRow() {
		return this.bowRow;
	}

	public int getLength() {
		return this.length;
	}

	public abstract String getShipType();

	public boolean isHorizontal() {
		return this.horizontal;
	}

	public boolean isSunk() {
		for (int i = 0; i < this.hit.length; i++) {
			if (this.hit[i] == false) {
				return false;
			}
		}
		// if hit[] contains all true
		return true;
	}

	// Determines whether or not this is represents a valid placement configuration
	// for this Ship in this Ocean. Ship objects in an Ocean must not overlap other
	// Ship objects or touch them vertically, horizontally, or diagonally.
	// Additionally, the placement cannot be such that the Ship would extend beyond
	// the extents of the 2D array in which it is placed. Calling this method should
	// not actually change either the Ship or the provided Ocean.

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

	// Puts the Ship in the Ocean. This will give values to the bowRow, bowColumn,
	// and horizontal instance variables in the Ship. This should also place a
	// reference to this Ship in each of the one or more locations (up to four) in
	// the corresponding Ocean array this Ship is being placed in. Each of the
	// references placed in the Ocean will be identical since it is not possible to
	// refer to a "part" of a ship, only the whole ship.
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

	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	// If a part of this ship occupies this coordinate, and
	// if the ship hasn't been sunk, mark the part of the ship at that coordinate as
	// "hit".
	public boolean shootAt(int row, int column) {
		int bowC = this.getBowColumn();
		int bowR = this.getBowRow();
		int len = this.getLength();
		if (this.horizontal == true) {
			if ((bowR == row) && (column >= bowC) && (column <= bowC + len - 1)) {
//				if (this.isSunk() == false) 
				{
					// change the hit[] in the tile into "true"
					int gap = column - bowC;
					this.hit[gap] = true;
					return true;
				}

			}
		} else if (this.horizontal == false) {
			if ((bowC == column) && (row >= bowR) && (row <= bowR + len - 1)) {
//				if (this.isSunk() == false) 
				{
					int gap = row - bowR;
					this.hit[gap] = true;
					return true;
				}
			}
		}
		return false;

	}

	// Returns a single character String to use in the Ocean's print method.
	// This method should return "x" if the ship has been sunk, and "S" if it has
	// not yet been sunk.
	// This method can only be used to print out locations in the ocean that have
	// been shot at;
	// it should not be used to print locations that have not been the target of a
	// shot yet.

	public String toString() { // when a cell is hit
		if (this.isSunk() == true) {
			return ("x");
		} else {
			return ("S");
		}
	}

	public boolean[] getHit() { // when a cell is hit
		return this.hit;
	}

}
