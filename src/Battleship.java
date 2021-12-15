
public class Battleship extends Ship {

	/**
	 * Initialize a Battleship with length = 4 and 4 hits.
	 */
	public Battleship() {
		this.length = 4;
		this.hit = new boolean[] { false, false, false, false };
	}

	/**
	 * Get the shipType of Battleship.
	 * 
	 * @return "Battleship", indicating that this is a Battleship.
	 */
	public String getShipType() {
		return ("Battleship");
	}
}
