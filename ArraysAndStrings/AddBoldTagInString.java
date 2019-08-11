package ArraysAndStrings;

import java.lang.reflect.Array;
import java.util.*;

public class AddBoldTagInString {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int n = scn.nextInt();
		String[] dict = new String[n];
		for (int i = 0; i < n; i++) {
			dict[i] = scn.next();
		}
		System.out.println(addBoldTag(s, dict));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array of strings and a string
	// It should return required output.
	public static String addBoldTag(String s, String[] dict) {
		String res = "";
		boolean a[] = new boolean[s.length()];
		ArrayList<Integer> list;

		for (int i = 0; i < dict.length; i++) {
			if (dict.length > s.length())
				continue;
			list = KMPSearch(dict[i], s);
			while (!list.isEmpty()) {
				int idx = list.remove(0);
				for (int j = idx; j < idx + dict[i].length(); j++)
					a[j] = true;
			}
		}
		String start = "<b>";
		String end = "</b>";
		res += s.charAt(0);
		for (int i = 1; i < a.length; i++) {
			if (a[i] && !a[i - 1])
				res += start;
			else if (!a[i] && a[i - 1])
				res += end;
			res += s.charAt(i);
		}

		if (a[0])
			res = start + res;
		if (a[a.length - 1])
			res += end;

		return res;
	}

	public static ArrayList<Integer> KMPSearch(String pat, String txt) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int M = pat.length();
		int N = txt.length();

		int lps[] = new int[M];
		int j = 0;

		computeLPSArray(pat, M, lps);

		int i = 0;
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				list.add(i - j);
				j = lps[j - 1];
			}

			else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		return list;
	}

	public static void computeLPSArray(String pat, int M, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				if (len != 0) {
					len = lps[len - 1];
				} else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}
}
