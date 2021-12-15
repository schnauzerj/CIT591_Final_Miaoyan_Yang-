import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class BattleshipGameTest {

	@Test
	void test() {
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);

		String data = "10 2 12 2";
		InputStream stringData = new ByteArrayInputStream(data.getBytes());
		System.setIn(stringData);
		BattleshipGame game = new BattleshipGame();
		game.readRowCol();

		String printedContents = outputStream.toString();
		assertEquals(printedContents,
				"Please input the row number (0-9) you want to fire at.\n" + "Your input is out of the range 0-9.\n"
						+ "Please input the row number (0-9) you want to fire at.\n"
						+ "Please input the column number (0-9) you want to fire at.\n"
						+ "Your input is out of the range 0-9.\n"
						+ "Please input the column number (0-9) you want to fire at.");

	}

}
