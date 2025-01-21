package system;

import app.DrawingApp;
import gui.BoardCell;

public class VerticalBars extends java.lang.Object implements Diagram {
	private int animationType;
	private char[][] board;

	// Constructor that initializes the animationType with the provided parameter
	// value and initializes the board with the diagram resulting from calling the
	// DrawingApp.getVerticalBars() method.
	public VerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3, int animationType) {
		this.animationType = animationType;
		this.board = BoardCell.getCharArray(DrawingApp.getVerticalBars(maxRows, maxCols, bars, color1, color2, color3));
	}

	// two-dimensional array of characters.

	public char[][] getBoard() {
		char[][] temp = this.board;
		return temp;
	}

	// Returns a two-dimensional array of characters representing the next animation
	// step. If the animationType is 1, the board instance variable will be updated
	// with by rotating the board to the left. 

	public char[][] nextAnimationStep() {
		if (this.animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(this.board);
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
