package HashMap;

import java.util.*;

public class CompleteTasks {

	public static void completeTask(int n, int m, int[] compl) {
		// Write your code here
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		int count = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 1; i <= n; i++)
			hs.add(i);
		for (int i = 0; i < m; i++)
			hs.remove(compl[i]);
		for (int i = 1; i <= n; i++) {
			if (hs.contains(i)) {
				if (count % 2 == 0)
					arr1.add(i);
				else
					arr2.add(i);
				count++;
			}
		}
		for (int num : arr1) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int num : arr2) {
			System.out.print(num + " ");
		}
//		 System.out.println(arr1);
//		 System.out.println(arr2);
	}

	// Don't make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}
}