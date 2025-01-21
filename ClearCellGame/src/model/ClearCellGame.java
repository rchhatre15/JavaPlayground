package model;

import java.util.Random;

/**
 * This class extends GameModel and implements the logic of the clear cell game.
 * We define an empty cell as BoardCell.EMPTY. An empty row is defined as one
 * where every cell corresponds to BoardCell.EMPTY.
 * 
 * @author Department of Computer Science, UMCP
 */

public class ClearCellGame extends Game {
	private Random rand;
	private int strategy;
	private int score = 0;

	/**
	 * Defines a board with empty cells. It relies on the super class constructor to
	 * define the board. The random parameter is used for the generation of random
	 * cells. The strategy parameter defines which clearing cell strategy to use
	 * (for this project it will be 1). For fun, you can add your own strategy by
	 * using a value different that one.
	 * 
	 * @param maxRows
	 * @param maxCols
	 * @param random
	 * @param strategy
	 */
	public ClearCellGame(int maxRows, int maxCols, Random random, int strategy) {
		super(maxRows, maxCols);
		rand = random;
		this.strategy = strategy;
	}

	/**
	 * The game is over when the last board row (row with index board.length -1) is
	 * different from empty row.
	 */
	public boolean isGameOver() {
		for (int i = 0; i < board[board.length - 1].length; i++) {
			if (!board[board.length - 1][i].getName().equals(BoardCell.EMPTY.getName())) {
				return true;
			}
		}
		return false;
	}

	public int getScore() {
		return score;
	}

	/**
	 * This method will attempt to insert a row of random BoardCell objects if the
	 * last board row (row with index board.length -1) corresponds to the empty row;
	 * otherwise no operation will take place.
	 */
	public void nextAnimationStep() {
		if (!isGameOver()) {
			BoardCell[][] temp = new BoardCell[getMaxRows()][getMaxCols()];
			for (int r = 0; r < getMaxRows(); r++) {
				for (int c = 0; c < getMaxCols(); c++) {
					temp[r][c] = BoardCell.EMPTY;// RED, "R");
				}
			}

			for (int r = 1; r < getMaxRows(); r++) {
				for (int c = 0; c < getMaxCols(); c++) {
					temp[r][c] = board[r - strategy][c];
				}
			}
			for (int i = 0; i < board[0].length; i++) {
				temp[0][i] = BoardCell.getNonEmptyRandomBoardCell(rand);
			}
			board = temp;
		}
	}

	/**
	 * This method will turn to BoardCell.EMPTY the cell selected and any adjacent
	 * surrounding cells in the vertical, horizontal, and diagonal directions that
	 * have the same color. The clearing of adjacent cells will continue as long as
	 * cells have a color that corresponds to the selected cell. Notice that the
	 * clearing process does not clear every single cell that surrounds a cell
	 * selected (only those found in the vertical, horizontal or diagonal
	 * directions).
	 * 
	 * IMPORTANT: Clearing a cell adds one point to the game's score.<br />
	 * <br />
	 * 
	 * If after processing cells, any rows in the board are empty,those rows will
	 * collapse, moving non-empty rows upward. For example, if we have the following
	 * board (an * represents an empty cell):<br />
	 * <br />
	 * RRR<br />
	 * GGG<br />
	 * YYY<br />
	 * * * *<br/>
	 * <br />
	 * then processing each cell of the second row will generate the following
	 * board<br />
	 * <br />
	 * RRR<br />
	 * YYY<br />
	 * * * *<br/>
	 * * * *<br/>
	 * <br />
	 * IMPORTANT: If the game has ended no action will take place.
	 * 
	 * 
	 */
	public void processCell(int rowIndex, int colIndex) {
		if (rowIndex < getMaxRows() && colIndex < getMaxCols() && !isGameOver()
				&& !board[rowIndex][colIndex].getName().equals(BoardCell.EMPTY.getName())) {

			// bottom left
			if (rowIndex + 1 > getMaxRows() - 1 || colIndex - 1 < 0) {

			} else if (board[rowIndex + 1][colIndex - 1].getName().equals(board[rowIndex][colIndex].getName())) {
				processBottomLeft(rowIndex, colIndex);
			}
			// down
			if (rowIndex + 1 > getMaxRows() - 1) {

			} else if (board[rowIndex + 1][colIndex].getName().equals(board[rowIndex][colIndex].getName())) {
				processDown(rowIndex, colIndex);
			}
			// bottom right
			if (rowIndex + 1 > getMaxRows() - 1 || colIndex + 1 > getMaxCols() - 1) {

			} else if (board[rowIndex + 1][colIndex + 1].getName().equals(board[rowIndex][colIndex].getName())) {
				processBottomRight(rowIndex, colIndex);
			}

			// left
			if (colIndex - 1 < 0) {

			} else if (board[rowIndex][colIndex - 1].getName().equals(board[rowIndex][colIndex].getName())) {
				processLeft(rowIndex, colIndex);
			}
			// right
			if (colIndex + 1 > getMaxCols() - 1) {

			} else if (board[rowIndex][colIndex + 1].getName().equals(board[rowIndex][colIndex].getName())) {
				processRight(rowIndex, colIndex);
			}

			// top right
			if (rowIndex - 1 < 0 || colIndex + 1 > getMaxCols() - 1) {

			} else if (board[rowIndex - 1][colIndex + 1].getName().equals(board[rowIndex][colIndex].getName())) {
				processTopRight(rowIndex, colIndex);
			}
			// up
			if (rowIndex - 1 < 0) {

			} else if (board[rowIndex - 1][colIndex].getName().equals(board[rowIndex][colIndex].getName())) {
				processUp(rowIndex, colIndex);
			}
			// top left
			if (rowIndex - 1 < 0 || colIndex - 1 < 0) {

			} else if (board[rowIndex - 1][colIndex - 1].getName().equals(board[rowIndex][colIndex].getName())) {
				processTopLeft(rowIndex, colIndex);
			}

			board[rowIndex][colIndex] = BoardCell.EMPTY;
			score++;
			collapse();
		}
	}

	// method for collapsing the array
	private void collapse() {
		if (emptyRow() > 0) {
			for (int r = emptyRow(); r < getMaxRows() - 1; r++) {
				for (int c = 0; c < getMaxCols(); c++) {
					board[r][c] = board[r + 1][c];
				}
			}
		}
	}

	// return the row that is empty in array to ensure cells collapse properly.
	private int emptyRow() {
		for (int r = 0; r < getMaxRows(); r++) {
			for (int c = 0; c < getMaxCols(); c++) {
				if (!board[r][c].getName().equals(BoardCell.EMPTY.getName())) {
					c = getMaxCols() - 1;
				} else if (board[r][c].getName().equals(BoardCell.EMPTY.getName()) && c == getMaxCols() - 1) {
					return r;
				}
			}
		}
		return -1;
	}

	// private process methods to aid in processing adjacent cells. Use recursive
	// calls.
	private void processUp(int rowIndex, int colIndex) {
		if (!(rowIndex - 2 < 0)) {
			if (board[rowIndex - 1][colIndex].getName().equals(board[rowIndex - 2][colIndex].getName())) {
				processUp(rowIndex - 1, colIndex);
			}
		}
		board[rowIndex - 1][colIndex] = BoardCell.EMPTY;
		score++;

	}

	private void processDown(int rowIndex, int colIndex) {
		if (!(rowIndex + 2 > getMaxRows() - 1)) {
			if (board[rowIndex + 1][colIndex].getName().equals(board[rowIndex + 2][colIndex].getName())) {
				processDown(rowIndex + 1, colIndex);
			}
		}
		board[rowIndex + 1][colIndex] = BoardCell.EMPTY;
		score++;
	}

	private void processRight(int rowIndex, int colIndex) {
		if (!(colIndex + 2 > getMaxCols() - 1)) {
			if (board[rowIndex][colIndex + 1].getName().equals(board[rowIndex][colIndex + 2].getName())) {
				processRight(rowIndex, colIndex + 1);
			}
		}
		board[rowIndex][colIndex + 1] = BoardCell.EMPTY;
		score++;

	}

	private void processLeft(int rowIndex, int colIndex) {
		if (!(colIndex - 2 < 0)) {
			if (board[rowIndex][colIndex - 1].getName().equals(board[rowIndex][colIndex - 2].getName())) {
				processLeft(rowIndex, colIndex - 1);
			}
		}
		board[rowIndex][colIndex - 1] = BoardCell.EMPTY;
		score++;
	}

	private void processTopRight(int rowIndex, int colIndex) {
		if (!(rowIndex - 2 < 0 || colIndex + 2 > getMaxCols() - 1)) {
			if (board[rowIndex - 1][colIndex + 1].getName().equals(board[rowIndex - 2][colIndex + 2].getName())) {
				processTopRight(rowIndex - 1, colIndex + 1);
			}
		}
		board[rowIndex - 1][colIndex + 1] = BoardCell.EMPTY;
		score++;
	}

	private void processTopLeft(int rowIndex, int colIndex) {
		if (!(rowIndex - 2 < 0 || colIndex - 2 < 0)) {
			if (board[rowIndex - 1][colIndex - 1].getName().equals(board[rowIndex - 2][colIndex - 2].getName())) {
				processTopLeft(rowIndex - 1, colIndex - 1);
			}
		}
		board[rowIndex - 1][colIndex - 1] = BoardCell.EMPTY;
		score++;
	}

	private void processBottomRight(int rowIndex, int colIndex) {
		if (!(rowIndex + 2 > getMaxRows() - 1 || colIndex + 2 > getMaxCols() - 1)) {
			if (board[rowIndex + 1][colIndex + 1].getName().equals(board[rowIndex + 2][colIndex + 2].getName())) {
				processBottomRight(rowIndex + 1, colIndex + 1);
			}
		}
		board[rowIndex + 1][colIndex + 1] = BoardCell.EMPTY;
		score++;

	}

	private void processBottomLeft(int rowIndex, int colIndex) {
		if (!(rowIndex + 2 > getMaxRows() - 1 || colIndex - 2 < 0)) {
			if (board[rowIndex + 1][colIndex - 1].getName().equals(board[rowIndex + 2][colIndex - 2].getName())) {
				processBottomLeft(rowIndex + 1, colIndex - 1);
			}
		}
		board[rowIndex + 1][colIndex - 1] = BoardCell.EMPTY;
		score++;

	}

}