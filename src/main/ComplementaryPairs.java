package main;

/**
 * Given a sorted array of unique integers A and an integer k, this program
 * prints every pair of integers in A whose sum equals k.
 * 
 * @author emmettgreenberg
 *
 */

public class ComplementaryPairs {
	
	private static int numPairs = 0;

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 10, 12, 14};
		int k = 17;
		System.out.println("k = " + k);
		StringBuffer allPairs = findPairs(a, k);
		System.out.println("Complementary Pairs:\n" + allPairs);
		System.out.println("Number of pairs: " + numPairs);
	}

	/**
	 * Given an sorted array of unique integers and an integer k, returns a sequence
	 * of all k-complementary pairs in the array
	 * 
	 * @param a
	 * @param k
	 * @return the string of k-complementary pairs
	 */
	public static StringBuffer findPairs(int[] a, int k) {
		// use a StringBuffer to store the pairs
		StringBuffer allPairs = new StringBuffer();
		// call recursive find pairs on each integer to find its complement
		for (int i = 0; i < a.length - 1; i++) {
			allPairs = recursiveFindPairs(a, k, i, i, a.length - 1, allPairs);
		}
		return allPairs;
	}

	/**
	 * Adds the k-complementary pair containing integer a[i] (if it exists) to the
	 * array to the string of pairs, and returns it
	 * 
	 * 
	 * @param a
	 * @param k
	 * @param i
	 * @param low
	 *            the first index to search
	 * @param high
	 *            the last index to search
	 * @param sb
	 *            the string representation of complementary pairs
	 * @return the updated string of complementary pairs
	 */
	private static StringBuffer recursiveFindPairs(int[] a, int k, int i, int low, int high, StringBuffer sb) {
		int mid = (low + high) / 2; // start search from the middle of the array
		if (low <= high) {
			if (a[i] + a[mid] == k) { // found complement for a[i]
				sb.append("a[" + i + "] = " + a[i] + ", a[" + mid + "] = " + a[mid] + "\n"); // add complementary pair
																								// to the string
				numPairs++;		// increase the number of pairs by 1
			}

			else if (a[i] + a[mid] > k) { // sum is too high
				recursiveFindPairs(a, k, i, low, mid - 1, sb); // recur down first half of array, up to index i, to find
																// complement for a[i]
			} else { // sum is too low
				recursiveFindPairs(a, k, i, mid + 1, high, sb); // recur on second half of array
			}
		}
		return sb;
	}

	/**
	 * @return the numPairs
	 */
	public static int getNumPairs() {
		return numPairs;
	}
}
