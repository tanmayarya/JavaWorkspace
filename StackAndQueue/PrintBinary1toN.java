package StackAndQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintBinary1toN {

	public static class pair {
		int dec;
		String bin;

		public pair(int dec, String bin) {
			this.dec = dec;
			this.bin = bin;
		}
	}

	public static void getBinary(int n) {
		// write your code here
		ArrayList<pair> que = new ArrayList<pair>();
//		  pair p = new pair(1,"1");
		que.add(new pair(1, "1"));
		while (!que.isEmpty()) {
			pair a = que.remove(0);
			System.out.print(a.bin +" ");
			if (2 * a.dec <= n)
				que.add(new pair(2 * a.dec, a.bin + "0"));
			if (2 * a.dec + 1 <= n)
				que.add(new pair(2 * a.dec+1, a.bin + "1"));
		}

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		getBinary(n);

	}
}
