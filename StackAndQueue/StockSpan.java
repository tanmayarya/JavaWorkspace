package StackAndQueue;

import java.util.*;

public class StockSpan {

	static class StockSpanner {
		// Complete the functions
		Stack<Integer> st;
		ArrayList<Integer> prices;
		int count = 0;

		public StockSpanner() {
			st = new Stack<Integer>();
			prices = new ArrayList<Integer>();
		}

		public int next(int price) {
			int retVal =0;
			prices.add(price);
			while (!st.isEmpty() && price > prices.get(st.peek()))
				st.pop();
			if (st.isEmpty())
				retVal= 1;
			else retVal = count -st.peek();
			st.push(count);
			count++;
			
			return retVal;
		}

	}

	// Dont make chamnges here
	public static void main(String[] args) {
		StockSpanner ss = new StockSpanner();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(ss.next(sc.nextInt()));
		}
	}

}
