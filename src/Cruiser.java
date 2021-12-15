
public class Cruiser extends Ship {

	/**
	 * Initialize a Battleship with length = 3 and 3 hits.
	 */
	public Cruiser() {
		this.length = 3;
		this.hit = new boolean[] { false, false, false };
	}

	/**
	 * Get the shipType of Cruiser.
	 * 
	 * @return "Cruiser", indicating that this is a Cruiser.
	 */
	public String getShipType() {
		return ("Cruiser");
	}
}
