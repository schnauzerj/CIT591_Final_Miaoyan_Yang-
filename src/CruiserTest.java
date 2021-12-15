import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CruiserTest {

	@Test
	void test() {
		Cruiser cruiser = new Cruiser();
		String type = cruiser.getShipType();
		assertEquals(type, "Cruiser");

	}
}
