package StackAndQueue;

import java.util.*;

public class FreequencyStack {
	private static class FreqStack {
		// Write your code
		static int fm = 1;
		static HashMap<Integer, Integer> fmap;
		static HashMap<Integer, Stack<Integer>> fstacks;

		public FreqStack() {
			fmap = new HashMap<Integer, Integer>();
			fstacks = new HashMap<Integer, Stack<Integer>>();
		}

		public static void push(int x) {
			int f = 1;
			if (fmap.containsKey(x)) {
				f = fmap.get(x);
				f++;
				fm = Math.max(f, fm);
			}
			fmap.put(x, f);
			if (fstacks.containsKey(f)) {
				fstacks.get(f).push(x);
			} else {
				Stack<Integer> st = new Stack<Integer>();
				st.push(x);
				fstacks.put(f, st);
			}
		}

		public static int pop() {

			int num = fstacks.get(fm).pop();
			while (fm != 1 && fstacks.get(fm).isEmpty())
				fm--;
			int f = fmap.get(num);
			if (f == 1)
				fmap.remove(num);
			else
				fmap.put(num, f - 1);

			return num;
		}
	}

	public static void main(String[] args) {
		FreqStack fq = new FreqStack();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		while (i != n) {
			int q = sc.nextInt();
			if (q == 1) {
				i++;
				fq.push(sc.nextInt());
			} else if (q == 2)
				System.out.println(fq.pop());
			i++;
		}
	}

}