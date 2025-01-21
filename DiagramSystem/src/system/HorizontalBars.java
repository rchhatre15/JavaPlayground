package system;

import app.DrawingApp;
import gui.BoardCell;

public class HorizontalBars extends java.lang.Object implements Diagram {
	private int animationType;
	private char[][] board;

	// Constructor that initializes the animationType with the provided parameter
	// value and initializes the board with the diagram resulting from calling the
	// DrawingApp.getHorizontalBars() method. 

	public HorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3,
			int animationType) {
		this.animationType = animationType;
		this.board = BoardCell
				.getCharArray(DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3));
	}

	// returns the board
	public char[][] getBoard() {
		char[][] temp = this.board;
		return temp;
	}

	// Returns a two-dimensional array of characters representing the next animation
	// step. If the animationType is 1, the board instance variable will be updated
	// with by rotating the top row.

	public char[][] nextAnimationStep() {
		if (this.animationType == 1) {
			TwoDimArrayUtil.rotateTopOneRow​(this.board);
		}
		return this.getBoard();
	}

	// Number of rows associated with the diagram.
	public int getNumberRows() {
		return board.length;
	}

	// Number of cols associated with the diagram.
	public int getNumberCols() {
		return board[0].length;
	}

}
