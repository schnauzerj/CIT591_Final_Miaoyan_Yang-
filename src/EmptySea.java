
public class EmptySea extends Ship {
	public EmptySea() {
		this.length = 1;
		this.hit = new boolean[] { false };
	}

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
