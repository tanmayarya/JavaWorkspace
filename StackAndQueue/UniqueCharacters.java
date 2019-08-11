package StackAndQueue;

import java.util.*;

public class UniqueCharacters {

	public static void uniqueChar(char[] str) {
		HashMap<Character, Integer> fmap = new HashMap<Character, Integer>();
		ArrayList<Character> q = new ArrayList<Character>();
		for (int i = 0; i < str.length; i++) {
			if (fmap.containsKey(str[i]))
				fmap.replace(str[i], fmap.get(str[i]) + 1);
			else {
				fmap.put(str[i], 1);
				q.add(str[i]);
			}

			while (!q.isEmpty() && fmap.get(q.get(0)) != 1)
				q.remove(0);


			if (q.isEmpty())
				System.out.print(-1 + " ");
			else
				System.out.print(q.get(0) + " ");
		}
	}

	// Dont make changes here
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char ch[] = new char[n];

		for (int i = 0; i < n; i++) {
			ch[i] = sc.next().charAt(0);

		}
		uniqueChar(ch);

	}

}