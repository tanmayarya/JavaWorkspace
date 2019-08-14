package Tree;

import java.util.*;

public class BinaryTreeKLevelSum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		String str = s.next();
		System.out.println(getSumAtk(str, l));
	}

	public static int getSumAtk(String s, int l) {
		int sum = 0;
		int cl = -1, num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') 
				cl++;
				
			 else if (c == ')')
				cl--;
			else {
				num = 0;
				while (s.charAt(i) != ')' && s.charAt(i) != '(') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				if (cl == l)
					sum += num;
				i--;
			}

		}

		return sum;
	}

}