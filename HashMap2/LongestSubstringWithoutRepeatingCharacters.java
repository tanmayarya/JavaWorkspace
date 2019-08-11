package HashMap2;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
	 	 //Write your code here
	 	 	 int maxLen = 0;
	 	 	 HashSet<Character> hset = new HashSet<>();
	 	 	 int currBegin = 0;
	 	 	 for (int i = 0; i < s.length(); i++) {
	 	 	 	 char ch = s.charAt(i);
	 	 	 	 while (hset.contains(ch)) {
	 	 	 	 	 hset.remove(s.charAt(currBegin));
	 	 	 	 	 currBegin++;
	 	 	 	 }
	 	 	 	 hset.add(ch);
	 	 	 	 maxLen = Math.max(maxLen, (i - currBegin) + 1);
	 	 	 }
	 
	 	 	 return maxLen;
	 	 	 
	 	 }
	 	 //Don't make any changes here.
	 	 public static void main(String[] args) {
	 
	 	 	 Scanner s = new Scanner(System.in);
	 	 	 String str = s.next();
	 	 	 System.out.println(lengthOfLongestSubstring(str));
	 
	 	 }
	 
	 }
