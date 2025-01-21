package app;

import app.DrawingApp;

public class DebugDriver {

	public static void main(String[] args) {
		int maxRows = 6, maxCols = 9;
		char symbol = '*';

		int totalEntries = maxRows * maxCols;
		System.out.println("Total Entries: " + totalEntries);

		String result = DrawingApp.getRectangle(maxRows, maxCols, symbol);
		System.out.println(result);
	}
}