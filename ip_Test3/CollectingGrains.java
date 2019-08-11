package ip_Test3;

import java.util.Scanner;
import java.util.Stack;

public class CollectingGrains {

	public static int countG(int a[]) {
		int count = 0;

		int lel[] = new int[a.length];
		int ler[] = new int[a.length];

		lel[0] = a[0];
		ler[a.length - 1] = a[a.length - 1];

		for (int i = 1; i < a.length; i++)
			lel[i] = Math.max(lel[i-1], a[i]);

		for (int i = a.length - 2; i >= 0; i--)
			ler[i] = Math.max(ler[i+1], a[i]);

		for (int i = 0; i < a.length; i++)
			count += Math.min(lel[i], ler[i]) - a[i];

		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		System.out.println(countG(a));
	}
}
