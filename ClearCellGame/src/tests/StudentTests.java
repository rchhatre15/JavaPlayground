package tests;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.BoardCell;
import model.ClearCellGame;
import model.Game;

/* The following directive executes tests in sorted order */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void gameOverTest() {
		Game game = new ClearCellGame(1, 1, null, 1);
		System.out.println(game.isGameOver());
		game.setBoardCell(0, 0, BoardCell.BLUE);
		System.out.println(game.isGameOver());
	}

	@Test
	public void GameSetMethodsTest() {
		Game game = new ClearCellGame(5, 5, null, 1);
		game.setRowWithColor(2, BoardCell.BLUE);
		System.out.println(getBoardStr(game));
		game.setColWithColor(0, BoardCell.RED);
		System.out.println(getBoardStr(game));
		game.setBoardWithColor(BoardCell.YELLOW);
		System.out.println(getBoardStr(game));
	}
	
	@Test
	public void processCellEasy() {
		Game game = new ClearCellGame(6, 5, null, 1);
		game.setBoardWithColor(BoardCell.GREEN);
		game.setRowWithColor(5, BoardCell.EMPTY);
		System.out.println(getBoardStr(game));
		game.processCell(2, 2);
		System.out.println(getBoardStr(game));
	}

	@Test
	public void processCellCollapse() {
		Game game = new ClearCellGame(10, 10, null, 1);
		game.setRowWithColor(3, BoardCell.BLUE);
		game.setRowWithColor(2, BoardCell.BLUE);
		game.setRowWithColor(1, BoardCell.BLUE);
		game.setRowWithColor(0, BoardCell.BLUE);
		game.setBoardCell(1, 0, BoardCell.YELLOW);
		System.out.println(getBoardStr(game));
		game.processCell(1, 5);
		System.out.println(getBoardStr(game));
	}

	@Test
	public void processCellEdges() {
		Game game = new ClearCellGame(10, 10, null, 1);
		game.setRowWithColor(3, BoardCell.BLUE);
		game.setRowWithColor(2, BoardCell.BLUE);
		game.setRowWithColor(1, BoardCell.BLUE);
		game.setRowWithColor(0, BoardCell.RED);
		game.setBoardCell(1, 4, BoardCell.YELLOW);
		System.out.println(getBoardStr(game));
		game.processCell(1, 0);
		System.out.println(getBoardStr(game));
	}
	
	@Test
	public void singleRow() {
		Game game = new ClearCellGame(2, 8, null, 1);
		game.setRowWithColor(0, BoardCell.RED);
		System.out.println(getBoardStr(game));
		game.processCell(0, 4);
		System.out.println(getBoardStr(game));
	}
	
	@Test
	public void singleCol() {
		Game game = new ClearCellGame(8, 1, null, 1);
		game.setColWithColor(0, BoardCell.RED);
		game.setBoardCell(7, 0, BoardCell.EMPTY);
		System.out.println(getBoardStr(game));
		game.processCell(4, 0);
		System.out.println(getBoardStr(game));
	}

	
	@Test
	public void zero() {
		Game game = new ClearCellGame(0, 0, null, 1);
		game.setBoardWithColor(BoardCell.GREEN);
		game.setRowWithColor(5, BoardCell.EMPTY);
		System.out.println(getBoardStr(game));
		game.processCell(2, 2);
		System.out.println(getBoardStr(game));
	}

	/* Support methods */
	private static String getBoardStr(Game game) {
		int maxRows = game.getMaxRows(), maxCols = game.getMaxCols();

		String answer = "Board(Rows: " + maxRows + ", Columns: " + maxCols + ")\n";
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				answer += game.getBoardCell(row, col).getName();
			}
			answer += "\n";
		}

		return answer;
	}
}
