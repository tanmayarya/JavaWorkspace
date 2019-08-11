package HashMap2;

import java.util.*;

public class EquivalentSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(val(arr));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array
	// It should return an integer value.
	public static int val(int[] a) {

		int count = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++)
			set.add(a[i]);

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, j = 0; i < a.length && j < a.length;) {
			while (map.size() != set.size()) {
				map.put(a[j], map.getOrDefault(a[j], 0) + 1);
				j++;
				if (j == a.length)
					break;
			}

			while (map.size() == set.size()) {
				count += a.length - j + 1;
				if (map.get(a[i]) == 1)
					map.remove(a[i]);
				else
					map.put(a[i], map.get(a[i]) - 1);
				i++;
			}
		}

		return count;
	}
}
