package HashMap;

import java.util.*;

public class DoubleArraypair {

	public static boolean canReorder(int[] a) {
		// Write your code here
		Arrays.sort(a);
		int zi = -1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			if (a[i] <= 0)
				zi = i;

		}
//		if (map.get(0) % 2 == 1)
//			return false;

		for (int i = zi + 1; i < a.length - 1; i++) {
			if (!map.containsKey(a[i])) {
				while (i + 1 < a.length && a[i] == a[i + 1])
					i++;
				continue;
			}
			if (!map.containsKey(2 * a[i]))
				return false;
			if (map.get(a[i]) > map.get(2 * a[i]))
				return false;
			else {
				int val = map.remove(a[i]);
				if (val == map.get(2 * a[i]))
					map.remove(2 * a[i]);
				else
					map.put(2 * a[i], map.get(2 * a[i]) - val);
			}

			while (i + 1 < a.length && a[i] == a[i + 1])
				i++;
		}
		if(zi==-1)
			return true;
		
		for (int i = zi; i >=0; i--) {
			if (!map.containsKey(a[i])) {
				while (i >0 && a[i] == a[i - 1])
					i--;
				continue;
			}
			if (!map.containsKey(2 * a[i]))
				return false;
			if (map.get(a[i]) > map.get(2 * a[i]))
				return false;
			else {
				int val = map.remove(a[i]);
				if (val == map.get(2 * a[i]))
					map.remove(2 * a[i]);
				else
					map.put(2 * a[i], map.get(2 * a[i]) - val);
			}

			while (i >0 && a[i] == a[i - 1])
				i--;
		}

		return true;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[sc.nextInt()];
		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextInt();
		System.out.println(canReorder(a));

	}

}
