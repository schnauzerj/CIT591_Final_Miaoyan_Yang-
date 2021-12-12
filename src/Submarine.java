
public class Submarine extends Ship {
	public Submarine() {
		this.length = 1;
		this.hit = new boolean[] { false };
	}

	public String getShipType() {
		return ("Submarine");
	}
}
