package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class CompareTwoStringsAfterDeletion {

	public static boolean compareString(String S, String T) {
	 	 //write your code here
		 Stack<Character> a = new Stack<Character>();
		 Stack<Character> b = new Stack<Character>();
		 
		 for(int i=0;i<S.length();i++)
		 {
			 if(S.charAt(i)=='#')
				 a.pop();
			 else a.push(S.charAt(i));
		 }
		 for(int i=0;i<T.length();i++)
		 {
			 if(T.charAt(i)=='#')
				 b.pop();
			 else b.push(T.charAt(i));
		 }
		 if(a.size()!=b.size())
			 return false;
		 while(!a.isEmpty())
		 {
			 if(a.pop()!=b.pop())
				 return false;
		 }
		 if(!b.isEmpty())
			 return false;
		 
		 return true;
	 }

//Driver program
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 String s1 = scn.next();
	 	 String s2 = scn.next();

	 	 System.out.println(compareString(s1, s2));
	 }
}