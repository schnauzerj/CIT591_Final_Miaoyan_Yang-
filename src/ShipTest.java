import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ShipTest {

	@Test
	void test1() {
		Ocean newOcean = new Ocean();
		Battleship testBattleship = new Battleship();
		testBattleship.placeShipAt(0, 0, false, newOcean);
		testBattleship.setBowColumn(0);
		testBattleship.setBowRow(0);
		testBattleship.setHorizontal(false);
		int bowR = testBattleship.getBowRow();
		assertEquals(bowR, 0);
		int bowC = testBattleship.getBowColumn();
		assertEquals(bowC, 0);
		boolean hori = testBattleship.isHorizontal();
		assertEquals(hori, false);
		boolean sunk = testBattleship.isSunk();
		assertEquals(sunk, false);
		boolean okPlaceShip1 = testBattleship.okToPlaceShipAt(9, 9, false, newOcean);
		assertEquals(okPlaceShip1, false);
		boolean okPlaceShip2 = testBattleship.okToPlaceShipAt(2, 2, false, newOcean);
		assertEquals(okPlaceShip2, true);
		boolean shootAt1 = testBattleship.shootAt(3, 3);
		assertEquals(shootAt1, false);
		boolean shootAt2 = testBattleship.shootAt(0, 0);
		assertEquals(shootAt2, true);
		String str = testBattleship.toString();
		assertEquals(str, "S");
	}

	@Test
	void test2() {
		Ocean newOcean = new Ocean();
		Battleship testBattleship = new Battleship();
		testBattleship.placeShipAt(0, 0, true, newOcean);
		testBattleship.setBowColumn(0);
		testBattleship.setBowRow(0);
		testBattleship.setHorizontal(true);
		int bowR = testBattleship.getBowRow();
		assertEquals(bowR, 0);
		int bowC = testBattleship.getBowColumn();
		assertEquals(bowC, 0);
		boolean hori = testBattleship.isHorizontal();
		assertEquals(hori, true);
		boolean sunk = testBattleship.isSunk();
		assertEquals(sunk, false);
		boolean okPlaceShip1 = testBattleship.okToPlaceShipAt(9, 9, true, newOcean);
		assertEquals(okPlaceShip1, false);
		boolean okPlaceShip2 = testBattleship.okToPlaceShipAt(2, 2, true, newOcean);
		assertEquals(okPlaceShip2, true);
		boolean shootAt1 = testBattleship.shootAt(0, 0);
		assertEquals(shootAt1, true);
		boolean shootAt2 = testBattleship.shootAt(0, 1);
		assertEquals(shootAt2, true);
		boolean shootAt3 = testBattleship.shootAt(0, 2);
		assertEquals(shootAt3, true);
		boolean shootAt4 = testBattleship.shootAt(0, 3);
		assertEquals(shootAt4, true);
		String str = testBattleship.toString();
		assertEquals(str, "x");
	}

}