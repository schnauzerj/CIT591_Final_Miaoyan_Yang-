
public class Destroyer extends Ship {
	public Destroyer() {
		this.length = 2;
		this.hit = new boolean[] { false, false };
	}

	public String getShipType() {
		return ("Destroyer");
	}
}
