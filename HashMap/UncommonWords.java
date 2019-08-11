package HashMap;

import java.util.*;

public class UncommonWords {

	public static String[] uncommonFromSentences(String A, String B) {

		String a[] = A.split(" ");
		String b[] = B.split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < a.length; i++)
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);

		for (int i = 0; i < b.length; i++)
			map.put(b[i], map.getOrDefault(b[i], 0) + 1);

		ArrayList<String> ans = new ArrayList<>();

		map.forEach((k, v) -> {
			if (v == 1)
				ans.add(k);
		});

		String[] anss = new String[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			anss[i] = ans.get(i);
		}

		return anss;

	}

	// Don't make any changes here
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String A = s.nextLine();
		String B = s.nextLine();

		String ans[] = uncommonFromSentences(A, B);
		Arrays.sort(ans);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}
}