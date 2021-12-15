import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BattleshipTest {

	@Test
	void test() {
		Battleship battleship = new Battleship();
		String type = battleship.getShipType();
		assertEquals(type, "Battleship");

	}

}
