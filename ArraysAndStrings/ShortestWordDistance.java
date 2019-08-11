package ArraysAndStrings;

import java.util.*;

public class ShortestWordDistance {

	public static int shortestWordDistance(String[] words, String word1, String word2) {

		int len = Integer.MAX_VALUE;
		int w1 = Integer.MAX_VALUE;
		int w2 = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i]))
				w1 = i;
			else if (word2.equals(words[i]))
				w2 = i;
			len = Math.min(len, Math.abs(w1 - w2));
		}
		return len;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
		}
		String word1 = sc.next(), word2 = sc.next();
		System.out.println(shortestWordDistance(words, word1, word2));
	}

}
