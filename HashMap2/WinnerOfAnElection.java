package HashMap2;

import java.util.*;
import java.util.Map.Entry;

public class WinnerOfAnElection {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = scn.next();
		}
		String res = func(str);
		System.out.print(res);
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written
	// This function takes as input an array of string
	// It should return name of winning candidate

	public static String func(String[] a) {

		String s = "";
		int maxf = 0;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			if (map.get(a[i]) > maxf) {
				maxf = map.get(a[i]);
				s = a[i];
			}
		}

		return s;
	}
}