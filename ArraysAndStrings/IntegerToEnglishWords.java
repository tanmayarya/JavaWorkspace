package ArraysAndStrings;

import java.util.*;

public class IntegerToEnglishWords {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		System.out.println(numberToWords(num));
	}
	// -----------------------------------------------------
	// This is a functional problem. Do not modify main
	// This function takes as input an integer num
	// It should return required output.

	public static String numberToWords(int num) {
		if(num==0)
			return"Zero";
		String res = "";
		int j = 0;
		int val = num;
		String big[] = { "", "Thousand", "Million", "Billion" };
		while (val > 0) {
			res = cal(val % 1000) + " " + big[j] + " " + res;
			val /= 1000;
			j++;

		}

		return res;
	}

	public static String cal(int num) {
		String res = "";
		if (num == 0)
			return "";
		int val = num;
		String base[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String tens[] = { "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		if (val % 100 < 20) {
			res = base[val % 20];
		} else {
			res = "" + base[val % 10];
			res = tens[(val % 100) / 10] + " " + res;
		}
		val /= 100;
		if (val > 0)
			res = base[val / 100] + " " + "Hundred" + " " + res;
		

		return res;
	}

}
