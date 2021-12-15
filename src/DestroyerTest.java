import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DestroyerTest {

	@Test
	void test() {
		Destroyer destroyer = new Destroyer();
		String type = destroyer.getShipType();
		assertEquals(type, "Destroyer");

	}

}
