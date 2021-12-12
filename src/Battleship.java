
public class Battleship extends Ship {
	public Battleship() {
		this.length = 4;
		this.hit = new boolean[] { false, false, false, false };
	}

	public String getShipType() {
		return ("Battleship");
	}
}
