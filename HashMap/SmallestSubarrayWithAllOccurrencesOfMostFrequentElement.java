package HashMap;

import java.util.*;

public class SmallestSubarrayWithAllOccurrencesOfMostFrequentElement {

	public static void subarrAllOcc(int[] a) {
		int maxf = 0;
		int maxel = 0;
		HashMap<Integer, Integer> fmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			fmap.put(a[i], fmap.getOrDefault(a[i], 0) + 1);
			if (maxf < fmap.get(a[i])) {
				maxf = fmap.get(a[i]);
				maxel = a[i];
			}
		}
		
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		subarrAllOcc(arr);
	}
}
