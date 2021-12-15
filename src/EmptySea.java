
public class EmptySea extends Ship {

	/**
	 * Initialize a EmptySea with length = 1 and 1 hit.
	 */
	public EmptySea() {
		this.length = 1;
		this.hit = new boolean[] { false };
	}

	/**
	 * Get the shipType of EmptySea.
	 * 
	 * @return "empty", indicating that this is a EmptySea.
	 */
	public String getShipType() {
		return ("empty");
	}

	@Override
	public boolean isSunk() {
		return false;
	}

	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}

	@Override
	public String toString() {
		return ("-");
	}

}
