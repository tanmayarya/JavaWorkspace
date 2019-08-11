package HashMap2;

import java.util.*;

public class CountOfSubstringContainingKOnes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int K = scn.nextInt();

		System.out.println(countOfSubstringWithKOnes(s, K));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input a string and an integer k.
	// It should return required integer value.

	 static int countOfSubstringWithKOnes(String s, int K) 
     { 
         int N = s.length(); 
         int res = 0; 
         int countOfOne = 0; 
         HashMap<Integer, Integer> freq=new HashMap<>(); 
       
         freq.put(0, 1);
       
         for (int i = 0; i < N; i++) { 
       
             countOfOne += (s.charAt(i) - '0'); 
             if (countOfOne >= K) { 
             	 if(freq.containsKey(countOfOne - K)){
                 res += freq.get(countOfOne - K); 
             	 }
             	 else{
             	 	 res+=0;
             	 }
             } 
       
             freq.put(countOfOne, freq.getOrDefault(countOfOne, 0)+1);
         } 
           
         return res; 
     } 

}
