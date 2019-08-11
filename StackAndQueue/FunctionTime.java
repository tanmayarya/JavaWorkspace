package StackAndQueue;

import java.util.*;

public class FunctionTime {

	static class StackItem {
		int fn;
		int st;
		int wt;

		public StackItem(int fn, int st, int wt) {
			this.fn = fn;
			this.st = st;
			this.wt = wt;
		}
	}

	public static int[] exclusiveTime(int n, List<String> logs) {
		// Write your code here
		int res[] = new int[n];
		Stack<StackItem> st = new Stack<StackItem>();
		for (int i = 0; i < logs.size(); i++) {
			String s = logs.get(i);
			if (s.contains("start")) {
				int digits = s.indexOf(':');
				int fid = Integer.parseInt(s.substring(0, digits));
				digits = s.lastIndexOf(':');
				int start = Integer.parseInt(s.substring(digits + 1, s.length()));
				st.push(new StackItem(fid, start, 0));
			} else {
				int digits = s.lastIndexOf(':');
				int end = Integer.parseInt(s.substring(digits + 1, s.length()));
				StackItem si = st.pop();
				res[si.fn] = end - si.st + 1 - si.wt;
				if (!st.isEmpty())
					st.peek().wt += end - si.st + 1;
			}

		}
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int L = sc.nextInt();
		List<String> logs = new ArrayList<>(L);
		for (int i = 0; i < L; i++) {
			logs.add(sc.next());
		}
		int[] res = exclusiveTime(n, logs);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
