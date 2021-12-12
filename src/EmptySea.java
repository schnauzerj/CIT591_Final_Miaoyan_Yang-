
public class EmptySea extends Ship {
	public EmptySea() {
		this.length = 1;
		this.hit = new boolean[] { false };
	}

	public String getShipType() {
		return ("EmptySea");
	}

}
