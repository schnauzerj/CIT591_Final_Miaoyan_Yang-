
public class Destroyer extends Ship {

	/**
	 * Initialize a Destroyer with length = 2 and 2 hits.
	 */
	public Destroyer() {
		this.length = 2;
		this.hit = new boolean[] { false, false };
	}

	/**
	 * Get the shipType of Destroyer.
	 * 
	 * @return "Destroyer", indicating that this is a Destroyer.
	 */
	public String getShipType() {
		return ("Destroyer");
	}
}
