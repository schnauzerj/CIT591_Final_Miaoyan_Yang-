import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OceanTest {

	@Test
	void test() {
		Ocean newOcean = new Ocean();
		newOcean.placeAllShipsRandomly();
		int shotsFired = newOcean.getShotsFired();
		assertEquals(shotsFired, 0);
		int hitCount = newOcean.getHitCount();
		assertEquals(hitCount, 0);

		int shipSunk = newOcean.getShipsSunk();
		assertEquals(shipSunk, 0);
		boolean isGameOver = newOcean.isGameOver();
		assertEquals(isGameOver, false);

		newOcean.shootAt(0, 0);
		int shotsFired2 = newOcean.getShotsFired();
		assertEquals(shotsFired2, 1);

	}

}
