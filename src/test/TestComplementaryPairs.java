package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.ComplementaryPairs;

class TestComplementaryPairs {

	@Test
	void testEmptyArray() {
		int k = 20;
		int[] a = {};
		ComplementaryPairs.findPairs(a, k);
		assertEquals(0, ComplementaryPairs.getNumPairs());
	}
	
	@Test
	void testNoPairsArray() {
		int k = 100;
		int[] a = {1, 2, 3, 4, 5};
		ComplementaryPairs.findPairs(a, k);
		assertEquals(0, ComplementaryPairs.getNumPairs());
	}
	
	@Test
	void testArrayWithPairs() {
		int k = 18;
		int[] a = {4, 6, 12, 14};
		ComplementaryPairs.findPairs(a, k);
		assertEquals(2, ComplementaryPairs.getNumPairs());
	}

}
