package physical.linkedlist;

public class CircularLinkedList {
	
	private Node head;
	private Node tail;
	
	private class Node {
		private int value;
		private Node nextNode;
		
		Node(int value) {
			this.value = value;
		}
		
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
		public Node getNextNode() {
			return nextNode;
		}
		
		@Override
		public String toString() {
			return this.value + "";
		}
	}
	
	private void insert(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = node;
		} else {
			Node lastNode = head;
			while (lastNode.getNextNode() != null) {
				lastNode = lastNode.getNextNode();
				if (lastNode.equals(tail)) {
					break;
				}
			}
			lastNode.setNextNode(node);
		}
		
		tail = node;
		tail.setNextNode(head);
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		
		cll.insert(10);
		cll.insert(20);
		cll.insert(30);
		cll.insert(40);
		cll.insert(50);
		
		System.out.println(cll.head);
		System.out.println(cll.tail);
		System.out.println("Done");
	}
}
