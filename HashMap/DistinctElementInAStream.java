package HashMap;

import java.util.*;
import java.io.*;

public class DistinctElementInAStream {

	public static void print(String[] arr) throws IOException {
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			char a[] = arr[i].toCharArray();
			int n = a[2] - '0';
			if (a[0] == 'A') {
				map.put(n, map.getOrDefault(n, 0) + 1);
			} else if (map.containsKey(n)) {
				if (map.get(n) == 1)
					map.remove(n);
				else
					map.put(n, map.get(n) - 1);
			}

			System.out.println(map.size());
		}
	}

	// Don't make any changes here
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		print(arr);

	}

}
