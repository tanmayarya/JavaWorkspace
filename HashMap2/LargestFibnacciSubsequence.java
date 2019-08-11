package HashMap2;

import java.io.*;
import java.util.*;

public class LargestFibnacciSubsequence {
	public static void solve(int[] arr) {
		// Write your code here
		HashSet<Integer> set = new HashSet<Integer>();
		int a = 0, b = 1;
		while (a <= 1000) {
			set.add(a);
			int t = a;
			a = b;
			b += t;
		}
		for(int i=0;i<arr.length;i++) 
		{
			if(set.contains(arr[i]))
				System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		solve(num);
	}

}
