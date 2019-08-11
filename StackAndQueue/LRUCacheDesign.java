package StackAndQueue;

import java.util.*;

public class LRUCacheDesign {

	static class LRUCache {
		static int capacity;
		static int size;
		static HashMap<Integer, Integer> map;
		static ArrayList<Integer> list;

		public LRUCache(int N) {
			size = 0;
			capacity = N;
			map = new HashMap<Integer, Integer>();
			list = new ArrayList<Integer>();
		}

		/*
		 * Returns the value of the key x if present else returns -1
		 */
		public static int get(int x) {
			if (!map.containsKey(x))
				return -1;
			list.add(0, list.remove(list.indexOf(x)));
			return map.get(x);
//			Node node = map.get(x);
//			// remove node from LL
//			node.next.previous = node.previous;
//			node.previous.next = node.next;
//			// add node to first/head
//			node.next = head;
//			node.previous = null;
//			head = node;
//			return node.data;
		}

		/* Sets the key x with value y in the LRU cache */
		public static void set(int x, int y) {
			
				map.put(x, y);
				if(list.contains(x))
					list.remove(list.indexOf(x));
				else if(size==capacity){
					map.remove(list.remove(list.size()-1));
				}
				else size++;
				list.add(0, x);
					
			
			
		}
//			if (map.containsKey(x)) {
//				Node node = map.get(x);
//				node.data = y;
//				// remove node from LL
//				node.next.previous = node.previous;
//				node.previous.next = node.next;
//				// add node to first/head
//				node.next = head;
//				node.previous = null;
//				head = node;
//			} else {
//				Node node = new Node(y);
//				map.put(x, node);
//
//				if (size == 0) {
//					head = node;
//					tail = node;
//					size++;
//				} else if (size == capacity) {
//					Node temp = tail;
//					tail = tail.previous;
//					tail.next = null;
//					temp.previous = null;
//					node.next = head;
//					node.previous = null;
//					head = node;
//				} else {
//					node.next = head;
//					node.previous = null;
//					head = node;
//					size++;
//				}
//			}
//		}
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		int q = sc.nextInt();
		LRUCache lc = new LRUCache(capacity);
		for (int i = 0; i < q; i++) {
			String op = sc.next();
			if (op.equals("SET")) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				lc.set(x, y);
			} else if (op.equals("GET")) {
				int x = sc.nextInt();
				System.out.println(lc.get(x));
			}
		}

	}

}