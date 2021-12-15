import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmptySeaTest {

	@Test
	void test() {
		EmptySea emptysea = new EmptySea();
		String type = emptysea.getShipType();
		assertEquals(type, "empty");
		boolean isSunk = emptysea.isSunk();
		assertEquals(isSunk, false);
		boolean shootAt = emptysea.shootAt(0, 0);
		assertEquals(shootAt, false);
		String toString = emptysea.toString();
		assertEquals(toString, "-");
	}

}
