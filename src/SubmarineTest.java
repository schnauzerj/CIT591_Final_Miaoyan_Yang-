import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubmarineTest {

	@Test
	void test() {
		Submarine submarine = new Submarine();
		String type = submarine.getShipType();
		assertEquals(type, "Submarine");

	}
}
