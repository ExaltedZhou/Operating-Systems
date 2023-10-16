/*
Name: Zhou, Albert
Email: azhou2@lsu.edu
Project: PA-2 
Instructor: Feng Chen
Class: cs4103-sp23
Login ID: cs410388
 */

public class circularList<E> {
	private Node rear;
	private int length;
	public circularList() {
		rear=null;
		length=0;
	}
	private class Node {
		public E data;
		public Node next;
	}
	public int size() {
		return length;
	}
	public void add(E d) {
		Node newNode = new Node();
		newNode.data = d;
		if(length==0) 
			newNode.next=newNode;
		else {
			Node head = rear.next;
			newNode.next = head;
			rear.next = newNode;
		}
		length++;
		rear = newNode;
	}
	public E front() throws Exception {
		if(length==0) 
			throw new Exception("error empty list");
		Node head = rear.next;
		return head.data;
	}
	public void rotateClockwise() {
		Node head = rear.next;
		rear = head;
	}
}








