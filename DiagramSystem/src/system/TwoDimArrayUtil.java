package system;

/**
 * This class provides a set of utility methods that process two-dimensional
 * arrays.
 * 
 * @author cmsc132, UMCP
 *
 */
public class TwoDimArrayUtil extends java.lang.Object {
	// Returns true if the array is a ragged array and false otherwise.
	public static boolean isRagged​(char[][] array) {
		int len = array[0].length;
		for (int i = 1; i < array.length; i++) {
			if (array[i].length != len) {
				return true;
			}
		}
		return false;
	}

	// Rotates the array by shifting rows one position up (second row will become
	// the first row, third row will become the second row, etc.). The first row
	// will become the last row. No processing takes place if the
	// array only has one row. Throws error if array is null or Ragged

	public static void rotateTopOneRow​(char[][] array) {
		if (array == null || isRagged​(array)) {
			throw new IllegalArgumentException("invalid param");
		}
		if (array.length > 1) {
			for (int col = 0; col < array[0].length; col++) {
				char temp = array[0][col];
				for (int row = 0; row < array.length; row++) {
					if (row == array.length - 1) {
						array[row][col] = temp;
					} else {
						array[row][col] = array[row + 1][col];
					}
				}
			}
		}

	}

	// Rotates the array by shifting columns one position to the left (second column
	// will become the first column, third column will become the second column,
	// etc.). The first column will become the last column. No
	// processing takes place if the array only has one column. Throws error if
	// array is null or Ragged

	public static void rotateLeftOneColumn​(char[][] array) {
		if (array == null || isRagged​(array)) {
			throw new IllegalArgumentException("invalid param");
		}
		if (array[0].length > 1) {
			for (int row = 0; row < array.length; row++) {
				char temp = array[row][0];
				for (int col = 0; col < array[row].length; col++) {
					if (col == array[row].length - 1) {
						array[row][array[row].length - 1] = temp;
					} else {
						array[row][col] = array[row][col + 1];
					}
				}
			}
		}
	}

	// Returns a new two-dimensional array of characters where elements from the top
	// array appear first, follow by elements from the bottom array. The arrays do
	// not need to have the same number of rows or columns.

	public static char[][] appendTopBottom​(char[][] top, char[][] bottom) {

		char[][] arr = new char[top.length + bottom.length][];
		for (int row = 0; row < top.length; row++) {
			arr[row] = new char[top[row].length];
			for (int col = 0; col < top[row].length; col++) {
				arr[row][col] = top[row][col];
			}
		}
		for (int row = 0; row < bottom.length; row++) {
			arr[row + top.length] = new char[bottom[row].length];
			for (int col = 0; col < bottom[row].length; col++) {
				arr[row + top.length][col] = bottom[row][col];
			}
		}

		return arr;

	}

	// Returns a new two-dimensional array of characters where rows with the same
	// index in the left and right arrays have been combined (row from right array
	// appended to corresponding row from left array). The arrays do not need to
	// have the same number of rows or columns.

	public static char[][] appendLeftRight​(char[][] left, char[][] right) {
		int larger = left.length > right.length ? left.length : right.length;
		char[][] arr = new char[larger][];
		for (int row = 0; row < larger; row++) {
			if (row < left.length && row < right.length) {
				arr[row] = new char[left[row].length + right[row].length];
				for (int col = 0; col < left[row].length; col++) {
					arr[row][col] = left[row][col];
				}
				for (int col = 0; col < right[row].length; col++) {
					arr[row][col + left[row].length] = right[row][col];
				}
				// fills in the remaining indexes in the 2d array
			} else if (row < left.length) {
				arr[row] = new char[left[row].length];
				for (int col = 0; col < left[row].length; col++) {
					arr[row][col] = left[row][col];
				}
			} else if (row < right.length) {
				arr[row] = new char[right[row].length];
				for (int col = 0; col < right[row].length; col++) {
					arr[row][col] = right[row][col];
				}
			}
		}

		return arr;
	}

}