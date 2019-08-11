package LinkedList;

import java.util.*;

public class CountPairHavingSumX {

	public static class Node {
	      int data;
	      Node next;
	  
	      Node(int key) {
	        data = key;
	        next = null;
	      }
	    }
	  
	    public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	  
	      int n1 = sc.nextInt();
	      Integer arr1[] = new Integer[n1];
	  
	      for (int i = 0; i < n1; i++)
	        arr1[i] = sc.nextInt();
	  
	      int n2 = sc.nextInt();
	      Integer arr2[] = new Integer[n2];
	  
	      for (int i = 0; i < n2; i++)
	        arr2[i] = sc.nextInt();
	  
	      LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
	      LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));
	  
	      int x = sc.nextInt();
	  
	      System.out.println(countpair(head1, head2, x));
	  
	    }
	  
	    public static int countpair(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
	      HashMap<Integer, Integer> n2list = new HashMap<>();
	      Iterator<Integer> itr1 = head1.iterator();
	      Iterator<Integer> itr2 = head2.iterator();
	  
	      while (itr1.hasNext()) {
	        int i = itr1.next();
	        n2list.put(i, n2list.getOrDefault(i, 0) + 1);
	      }
	      int count = 0;
	  
	      while (itr2.hasNext()) {
	        int i = x - itr2.next();
	        if (n2list.containsKey(i)) {
	          count += n2list.get(i);
	        }
	      }
	      return count;
	      // add your code here
	  
	    }
	  }