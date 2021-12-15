import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class BattleshipGameTest {

	@Test
	void test1() {
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);

		String data = "10 2 12 2";
		InputStream stringData = new ByteArrayInputStream(data.getBytes());
		System.setIn(stringData);
		BattleshipGame game = new BattleshipGame();
		game.readRowCol();

		String printedContents = outputStream.toString();
		String[] split = printedContents.split("\n", 0);
		System.out.println(split[0]);
		assertEquals(split[0].charAt(0), 'P');
		assertEquals(split[0].charAt(1), 'l');
		assertEquals(split[1].charAt(0), 'Y');
		assertEquals(split[1].charAt(1), 'o');
		assertEquals(game.getRow(), 2);
		assertEquals(game.getColumn(), 2);

	}

	@Test
	void test2() {
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);

		String data = "s 9 a 9";
		InputStream stringData = new ByteArrayInputStream(data.getBytes());
		System.setIn(stringData);
		BattleshipGame game = new BattleshipGame();
		game.readRowCol();

		String printedContents = outputStream.toString();
		String[] split = printedContents.split("\n", 0);
//		assertEquals(split[0], "Please input the row number (0-9) you want to fire at.");
//		assertEquals(split[1], "Input s is not an integer number.");
		assertEquals(split[0].charAt(0), 'P');
		assertEquals(split[0].charAt(1), 'l');
		assertEquals(split[1].charAt(0), 'I');
		assertEquals(split[1].charAt(1), 'n');

	}

	@Test
	void test3() {
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);

		String data = "Y";
		InputStream stringData = new ByteArrayInputStream(data.getBytes());
		System.setIn(stringData);

		BattleshipGame game = new BattleshipGame();
		game.newGame();

		String printedContents = outputStream.toString();
		String[] split = printedContents.split("\n", 0);
//		assertEquals(split[0], "Do you want to play again? Enter 'Y' for Yes and 'N' for No.");
//		assertEquals(split[1], "Start a new game.");
		assertEquals(split[0].charAt(0), 'D');
		assertEquals(split[0].charAt(1), 'o');
		assertEquals(split[1].charAt(0), 'S');
		assertEquals(split[1].charAt(1), 't');

	}

	@Test
	void test4() {
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);

		String data = "N";
		InputStream stringData = new ByteArrayInputStream(data.getBytes());
		System.setIn(stringData);

		BattleshipGame game = new BattleshipGame();
		game.newGame();

	}

	@Test
	void test5() {
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);

		String data = "A Y";
		InputStream stringData = new ByteArrayInputStream(data.getBytes());
		System.setIn(stringData);

		BattleshipGame game1 = new BattleshipGame();
		game1.newGame();

		String printedContents = outputStream.toString();
		String[] split = printedContents.split("\n", 0);
//		assertEquals(split[0], "Do you want to play again? Enter 'Y' for Yes and 'N' for No.");
//		assertEquals(split[1], "Invalid input. Please enter 'Y' or 'N'.");
		assertEquals(split[0].charAt(0), 'D');
		assertEquals(split[0].charAt(1), 'o');
		assertEquals(split[1].charAt(0), 'I');
		assertEquals(split[1].charAt(1), 'n');

	}
}
