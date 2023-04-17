package physical.linkedlist;

public class LinkedList {
	
	private Node head;	
	
	private class Node {
		private int value;
		private Node nextNode;
		
		public Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public Node getNextNode() {
			return nextNode;
		}
	}
	
	private void insertNode(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = node;
		} else {
			Node lastNode = head;
			while (lastNode.getNextNode() != null) {
				lastNode = lastNode.getNextNode();
			}
			lastNode.nextNode = node;
		}
	}
	
	private boolean searchValue(int value) {
		Node lastNode = head;
		if (value == lastNode.getValue()) {
			return true;
		}
		while (lastNode.getNextNode() != null) {
			lastNode = lastNode.getNextNode();
			if (value == lastNode.getValue()) {
				return true;
			}			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertNode(10);
		ll.insertNode(20);
		ll.insertNode(30);
		ll.insertNode(40);
		ll.insertNode(50);
		System.out.println(ll.searchValue(60));
		System.out.println(ll);
	}
}