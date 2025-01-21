package system;

public class CombineTopBottom extends java.lang.Object implements Diagram {
	private int animationType;
	private char[][] board;

	// Constructor that initializes the animationType with the provided parameter
	// value and initializes the board with the diagram resulting from calling
	// TwoDimArrayUtil.appendTopBottom() on the boards associated with the top and
	// bottom diagrams.

	public CombineTopBottom(Diagram top, Diagram bottom, int animationType) {
		if (top.getNumberCols() != bottom.getNumberCols()) {
			throw new IllegalArgumentException("cols not equal");
		} else {
			this.animationType = animationType;
			this.board = TwoDimArrayUtil.appendTopBottom​(top.getBoard(), bottom.getBoard());
		}
	}

	// Returns the board
	public char[][] getBoard() {
		char[][] temp = this.board;
		return temp;
	}

	// Returns a two-dimensional array of characters representing the next animation
	// step. If the animationType is 1, the board instance variable will be updated
	// by rotating the board one column to the left; if the animationType is 2, the
	// board instance variable will be updated by rotating the top row.

	public char[][] nextAnimationStep() {
		if (this.animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(this.board);
		}
		if (this.animationType == 2) {
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