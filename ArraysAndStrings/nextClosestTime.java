package ArraysAndStrings;

import java.util.*;

public class nextClosestTime {

	public static String nextClosestTime(String t) {

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < t.length(); i++) {
			if (Character.isDigit(t.charAt(i)))
				set.add(t.charAt(i) - '0');
		}

		String s[] = t.split(":");
		int h = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int time = h * 60 + m;

		for (int i = 1; i <= 1440; i++) {
			time = (time + i) % 1440;
			h = time / 60;
			m = time % 60;
			if (set.contains(h / 10) && set.contains(h % 10) && set.contains(m / 10) && set.contains(m % 10))
				return h + ":" + m;
		}

		return "";
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String time = sc.next();
		System.out.println(nextClosestTime(time));

	}
}
