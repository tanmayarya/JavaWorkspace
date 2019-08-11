package StackAndQueue;

import java.util.*;

public class DecodeStringAtIndex {

	public static String decodeIndex(String s, int k) {
		int size = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				size *= s.charAt(i) - '0';
			else
				size++;
		}

		for (int i = s.length()-1; i >= 0; --i) {
              char c = s.charAt(i);
               if(size!=0)
              k %= size;
              if (k == 0 && Character.isLetter(c))
                  return Character.toString(c);

              if (Character.isDigit(c))
                  size /= c - '0';
              else
                  size--;
          }
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();
		System.out.println(decodeIndex(s, k));
	}
}