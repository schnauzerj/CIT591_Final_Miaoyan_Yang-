
public class Cruiser extends Ship {

	public Cruiser() {
		this.length = 3;
		this.hit = new boolean[] { false, false, false };
	}

	public String getShipType() {
		return ("Cruiser");
	}
}
