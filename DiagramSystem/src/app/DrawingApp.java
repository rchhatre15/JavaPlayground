package app;

import java.util.Random;

public class DrawingApp {
	/*
	 * For every method remove the line with "throw ..." and implement the method.
	 * We are using "throw..." so your code does not display any compilation errors
	 * when you import the zip file. Also, if you don't implement a method you will
	 * see a white square (instead of green) in the submit server
	 */
	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		String rectangle = "";
		// returns null if maxRows or maxCols is less than 1
		if (maxRows < 1 || maxCols < 1) {
			return null;
		} else { // returns a rectangle with the specified color
			for (int r = 0; r < maxRows; r++) {
				for (int c = 0; c < maxCols; c++) {
					rectangle += symbol;
				}
				// ensures there is not an extra line
				if (r < maxRows - 1) {
					rectangle += "\n";
				}
			}
			return rectangle;
		}
	}

	public static String getFlag(int size, char color1, char color2, char color3) {
		String flag = "";
		int rows = size * 2;
		int cols = size * 5;
		// returns null is size input is less than 3
		if (size < 3) {
			return null;
		} else {
			for (int r = 0; r < rows; r++) {
				// adds values for first and last rows
				if (r == 0 || r == rows - 1) {
					flag += color1;
					for (int c = 1; c < cols; c++) {
						flag += color2;
					}
					// adds values for middle rows
				} else if (r == size || r == size - 1) {
					for (int c = 0; c < size; c++) {
						flag += color1;
					}
					for (int c = size; c < cols; c++) {
						flag += color2;
					}
					// adds values for rows before middle
				} else if (r < size) {
					for (int c = 0; c < r + 1; c++) {
						flag += color1;
					}
					for (int c = r + 1; c < cols; c++) {
						flag += color3;
					}
					// adds values for rows after the middles
				} else {
					for (int c = 0; c < size - (r - size); c++) {
						flag += color1;
					}
					for (int c = size - (r - size); c < cols; c++) {
						flag += color3;
					}
				}
				// ensures there is not an extra line
				if (r < rows - 1) {
					flag += "\n";
				}
			}
			return flag;
		}
	}

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		String value = "";
		int horBar = maxRows / bars;
		int count = 0;
		// returns null if horBar is < 1 or if any color inputs are invalid
		if (horBar < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		} else { // returns a rectangle with the specified color with as many
					// horizontal bars as necessary
			for (int r = 0; r < maxRows - (maxRows % bars); r++) {
				for (int c = 0; c < maxCols; c++) {
					// validates which color to use
					if (count / horBar == 0) {
						value += color1;
					} else if (count / horBar == 1) {
						value += color2;
					} else {
						value += color3;
					}
				}
				// ensures the correct colors are printed
				if (count == horBar * 3 - 1) {
					count = 0;
				} else {
					count++;
				}
				// ensures there is not an extra line
				if (r < maxRows - (maxRows % bars) - 1) {
					value += "\n";
				}
			}

			return value;
		}
	}

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		String value = "";
		int verBar = maxCols / bars;
		int count = 0;
		// returns null if verBar is < 1 or if any color inputs are invalid
		if (verBar < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		} else { // returns a rectangle with the specified color with as many
					// vertical bars as necessary
			for (int r = 0; r < maxRows; r++) {
				for (int c = 0; c < maxCols - (maxCols % bars); c++) {
					// ensures the right colors are printed
					if (count / verBar == 0) {
						value += color1;
					} else if (count / verBar == 1) {
						value += color2;
					} else {
						value += color3;
					}
					// ensures the right colors are printed
					if (count == verBar * 3 - 1) {
						count = 0;
					} else {
						count++;
					}
				}
				// ensures there is not an extra line
				if (r < maxRows - 1) {
					value += "\n";
				}
				// ensures the right colors are printed
				count = 0;
			}

			return value;
		}
	}

	public static char getRandomColor(Random random) {
		char letter = ' ';

		// randomly return R G B Y * or .
		int number = random.nextInt(6);
		if (number == 0) {
			letter = 'R';
		}
		if (number == 1) {
			letter = 'G';
		}
		if (number == 2) {
			letter = 'B';
		}
		if (number == 3) {
			letter = 'Y';
		}
		if (number == 4) {
			letter = '*';
		}
		if (number == 5) {
			letter = '.';
		}
		return letter;
	}

	private static boolean isValidColor(char color) {
		// input represents if the char equals R G B Y * or .
		boolean input = color == 'R' || color == 'G' || color == 'B' || color == 'Y' || color == '*' || color == '.';
		// returns the value of input
		return input;
	}

}
