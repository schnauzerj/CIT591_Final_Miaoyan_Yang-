
public class Submarine extends Ship {

	/**
	 * Initialize a Submarine with length = 1 and 1 hit.
	 */
	public Submarine() {
		this.length = 1;
		this.hit = new boolean[] { false };
	}

	/**
	 * Get the shipType of Submarine.
	 * 
	 * @return "Submarine", indicating that this is a Submarine.
	 */
	public String getShipType() {
		return ("Submarine");
	}
}
