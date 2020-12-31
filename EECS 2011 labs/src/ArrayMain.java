/***********************************
* EECS2011 - Assignment 3
* File name: ArrayMain.java
* Author: U. T. Nguyen
************************************/

public class ArrayMain {

   public static void main(String[] args) {
	ArrayDeque q = new ArrayDeque();
	q.insertFirst(120);
	q.insertFirst(15);
	q.printDeque();
	System.out.println("first=" + q.getFirst());
	System.out.println("last=" + q.getLast());
	q.insertLast(401);
	q.printDeque();
	q.insertLast(65);
	q.insertLast(37);
	q.printDeque();
	System.out.println("first=" + q.getFirst());
	System.out.println("last=" + q.getLast());
	System.out.println("remove first=" + q.removeFirst());
	q.printDeque();
	System.out.println("remove last=" + q.removeLast());
	System.out.println("remove last=" + q.removeLast());
	q.printDeque();
        System.out.println("remove first=" + q.removeFirst());
        System.out.println("remove first=" + q.removeFirst());
	// q is now empty.

 	int i, k;
	for( i = 1; i <= 100; i ++ )
	   q.insertFirst(i);
	   q.printDeque();  // 100 elements in q

	for( i = 1; i <= 99; i++ )
	   k = q.removeFirst();
        q.printDeque();  // one element left
   }
}

