package HashMap;

import java.util.*;

public class EqualZeroOneAndTwo {

	public static void equal_012(String line) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int sum = 0;
		int n1 = 0, n2 = 0, n0 = 0;
		map.put("0#0", 1);
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '0')
				n0++;
			else if (c == '1')
				n1++;
			else
				n2++;
			String s = (n1 - n0) + "#" + (n2 - n1);
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
			sum += nCr(entry.getValue(), 2);

		}

		System.out.println(sum);
	}

	static int nCr(int n, int r) {
		return fact(n) / (fact(r) * fact(n - r));
	}

	// Returns factorial of n
	static int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		equal_012(sc.next());

	}

}
