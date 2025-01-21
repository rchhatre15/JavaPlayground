package model;

/**
 * Represents the &lt;table&gt tag. A two dimensional array is used to keep
 * track of the Element objects of table.
 * 
 * @author UMCP
 *
 */
public class TableElement extends TagElement {
	private Element[][] items;
	private int rows;
	private int cols;

	// constructor
	public TableElement(int rows, int cols, String attributes) {
		super("table", true, null, attributes);
		this.rows = rows;
		this.cols = cols;
		items = new Element[rows][cols];
	}

	// adds Element to a specific index in items array
	public void addItem​(int rowIndex, int colIndex, Element item) {
		items[rowIndex][colIndex] = item;
	}

	// return the ratio used columns to total in item
	public double getTableUtilization() {
		int total = 0;
		int used = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				total++;
				if (items[r][c] != null) {
					used++;
				}
			}
		}
		return ((double) used) / total;
	}

	public String genHTML(int indentation) {
		String value = "";
		value += Utilities.spaces(indentation);
		value += getStartTag() + "\n   ";
		for (int r = 0; r < rows; r++) {
			value += "<tr>";
			for (int c = 0; c < cols; c++) {
				if (items[r][c] != null) {
					value += "<td>" + items[r][c].genHTML(0) + "</td>";
				} else {
					value += "<td>" + "</td>";
				}
			}
			value += "</tr>\n   ";
		}
		value += getEndTag();
		return value;
	}

}
