package HashMap;

import java.util.*;

public class NoteBandi {
	public static void removeString(String str, String m, String n) {
		int print[] = new int[str.length()];

		for (int i = 0; i < str.length() - m.length() + 1; i++) {
			String s = str.substring(i, i + m.length());
			if (s.compareTo(m) == 0) {
				for (int j = i; j < i + m.length(); j++) {
					print[j] = 1;
				}
			}
		}

		for (int i = 0; i < str.length() - n.length() + 1; i++) {
			String s = str.substring(i, i + n.length());
			if (s.compareTo(n) == 0) {
				for (int j = i; j < i + n.length(); j++) {
					print[j] = 1;
				}
			}
		}
		boolean flag = false;
		for (int i = 0; i < print.length; i++) {
			if (print[i] != 1)
				System.out.print(str.charAt(i));
			flag = true;
		}
		if (!flag)
			System.out.println(-1);
	}

	// Dont make chsnges here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String m = sc.next();
		String n = sc.next();
		removeString(str, m, n);
	}

}
