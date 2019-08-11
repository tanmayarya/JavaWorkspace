package HashMap;

import java.util.*;

public class SchoolAssembly {

	public static void minTransfer(int[] heights) {
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 1;
		for (int i = 0; i < heights.length; i++) {
			map.put(heights[i], map.getOrDefault(heights[i] - 1, 0) + 1);
			max = Math.max(max, map.get(heights[i]));
		}
		System.out.println(heights.length - max);
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = scn.nextInt();
		}
		minTransfer(heights);
	}

}
