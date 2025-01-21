package gui;

import app.DrawingApp;

/**
 * 
 * Illustrates how to graphically display a diagram
 * 
 * @author cmsc131
 *
 */
public class DisplayDiagramExample {
	public static void main(String[] args) {
		int size = 15;
		char color1 = 'R', color2 = '*', color3 = '.';

		String diagram = DrawingApp.getFlag(size, color1, color2, color3);
		int cellDimension = 8;
		DisplayUnit display = new DisplayUnit("Diagram's Display", cellDimension);
		display.renderDiagram(diagram);
	}
}