package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import system.TwoDimArrayUtil;

public class StudentTests {

	@Test
	public void isRaggedtest() {
		char[][] arr1 = { { '@', '@', '@', '@' }, { '@', '@', '@' } };
		assertEquals(TwoDimArrayUtil.isRagged​(arr1), true);
	}

	@Test
	public void rotateTopOneRowTest() {
		char[][] arr1 = { { '@', '@', '@', '@' }, { 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' } };
		char[][] arr2 = { { 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' }, { '@', '@', '@', '@' } };
		TwoDimArrayUtil.rotateTopOneRow​(arr1);
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {
				System.out.println(arr1[row][col]);
				System.out.println(arr2[row][col]);
				assertFalse(arr1[row][col] != arr2[row][col]);
			}
		}
	}

	@Test
	public void rotateLeftTest() {
		char[][] arr1 = { { 'a', 'b', 'c', 'd' }, { 'a', 'b', 'c', 'd' }, { 'a', 'b', 'c', 'd' } };
		char[][] arr2 = { { 'b', 'c', 'd', 'a' }, { 'b', 'c', 'd', 'a' }, { 'b', 'c', 'd', 'a' } };

		TwoDimArrayUtil.rotateLeftOneColumn​(arr1);
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {
				System.out.println(arr1[row][col]);
				System.out.println(arr2[row][col]);
				assertFalse(arr1[row][col] != arr2[row][col]);
			}
		}
	}

	@Test
	public void topBottomTest() {
		char[][] arr1 = { { '@', '@', '@', '@' }, { 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' } };
		char[][] arr2 = { { 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' }, { '@', '@', '@', '@' } };
		char[][] arr3 = { { '@', '@', '@', '@' }, { 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' },
				{ 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' }, { '@', '@', '@', '@' } };
		char[][] arr4 = TwoDimArrayUtil.appendTopBottom​(arr1, arr2);
		for (int row = 0; row < arr4.length; row++) {
			for (int col = 0; col < arr4[row].length; col++) {
				System.out.println(arr4[row][col]);
				System.out.println(arr3[row][col]);
				assertFalse(arr4[row][col] != arr3[row][col]);
			}
		}
	}

	@Test
	public void leftRightTest() {
		char[][] arr1 = { { '@', '@', '@', '@' }, { 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' }, };
		char[][] arr2 = { { 'd', 'd', 'd', 'd' }, { 'k', 'k', 'k', 'k' }, { '@', '@', '@', '@' } };
		char[][] arr3 = { { '@', '@', '@', '@', 'd', 'd', 'd', 'd' }, { 'd', 'd', 'd', 'd', 'k', 'k', 'k', 'k' },
				{ 'k', 'k', 'k', 'k', '@', '@', '@', '@' } };
		char[][] arr4 = TwoDimArrayUtil.appendLeftRight​(arr1, arr2);
		for (int row = 0; row < arr4.length; row++) {
			for (int col = 0; col < arr4[row].length; col++) {
				System.out.println(arr4[row][col]);
				System.out.println(arr3[row][col]);
				assertFalse(arr4[row][col] != arr3[row][col]);
			}
		}
	}

}
