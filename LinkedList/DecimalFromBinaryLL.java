package LinkedList;

import java.util.*;

public class DecimalFromBinaryLL {

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
  //you just need to complete this function
	 public static int countpair(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
		 int count = 0;
		 HashMap<Integer, Integer> fm = new HashMap<Integer, Integer>();
		 
		 for(int i=0;i<head1.size();) {
			 int key = head1.remove();
			 int val = 1;
			 if(fm.containsKey(key))
				 val=fm.get(key) + 1;
			 fm.put(key,val);
		 }
		 
		for(int i=0;i<head2.size();) {
			int key = head2.removeFirst();
			if(fm.containsKey(x-key)) {
				count += fm.get(x-key);
			}
		}
		 
		 
		 return count;
	 }
}
