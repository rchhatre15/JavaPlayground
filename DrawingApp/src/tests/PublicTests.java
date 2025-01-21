package tests;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import app.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PublicTests {
	@Test
	public void pub01GetRect1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		int maxRows = 6, maxCols = 9;
		char symbol = '*';

		String yourResults = DrawingApp.getRectangle(maxRows, maxCols, symbol);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub02GetRandColor1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		Random random = new Random(10);
		String yourResults = "";

		for (int i = 1; i <= 2; i++) {
			char color = DrawingApp.getRandomColor(random);
			yourResults += color;
		}

		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub03GetHorizBars1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int maxRows = 12, maxCols = 10, bars = 3;
		char color1 = 'R', color2 = 'G', color3 = 'B';

		String yourResults = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub04GetHorizBars2() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int maxRows = 12, maxCols = 10, bars = 4;
		char color1 = '*', color2 = '.', color3 = 'Y';

		String yourResults = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub05GetHorizBars3() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		// String expectedResultsFileName = testName + EXPECTED_RESULTS_EXT;
		int maxRows = 12, maxCols = 10, bars = 5;
		char color1 = '*', color2 = '.', color3 = 'Y';

		String yourResults = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub06GetHorizBars4() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int maxRows = 12, maxCols = 10, bars = 6;
		char color1 = '*', color2 = '.', color3 = 'Y';

		String yourResults = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub07GetVertBars1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int maxRows = 10, maxCols = 12, bars = 3;
		char color1 = 'R', color2 = 'G', color3 = 'B';

		String yourResults = DrawingApp.getVerticalBars(maxRows, maxCols, bars, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub08GetVertBars2() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int maxRows = 10, maxCols = 12, bars = 6;
		char color1 = 'R', color2 = 'G', color3 = 'B';

		String yourResults = DrawingApp.getVerticalBars(maxRows, maxCols, bars, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub09GetVertBars3() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int maxRows = 10, maxCols = 12, bars = 5;
		char color1 = 'R', color2 = 'G', color3 = 'B';

		String yourResults = DrawingApp.getVerticalBars(maxRows, maxCols, bars, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub10GetFlag1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int size = 9;
		char color1 = 'R', color2 = '.', color3 = 'Y';

		String yourResults = DrawingApp.getFlag(size, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub11GetFlag2() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int size = 4;
		char color1 = '*', color2 = 'B', color3 = 'G';

		String yourResults = DrawingApp.getFlag(size, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub12GetFlag3() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int size = 3;
		char color1 = '*', color2 = 'B', color3 = 'G';

		String yourResults = DrawingApp.getFlag(size, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}

	@Test
	public void pub13GetFlag4() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		int size = 15;
		char color1 = 'R', color2 = '*', color3 = '.';

		String yourResults = DrawingApp.getFlag(size, color1, color2, color3);
		assertTrue(TestingSupport.isResultCorrect(testName, yourResults, false));
	}
}