package tree.binaryTree;

import java.util.*;

import node.BinaryNode;

public class BinaryTreeByLinkedList implements BinaryTree {
	BinaryNode root;

	@Override
	public void createTree() {
		this.root = null;
	}

	public void insertValue(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root !");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		}
	}

	public int searchValue(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getValue() == value) {
				System.out.println("Value-" + value + " is found in Tree !");
				return -1;
			} else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}
		System.out.println("Value-" + value + " is not found in Tree !");
		return -1;
	}

	public void deleteValue(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}
		System.out.println("Did not find the node!!");
	}

	public void DeleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			} else if ((presentNode.getRight() == null)) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}
	}

	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
		return presentNode;
	}

	@Override
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	@Override
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	@Override
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}

	public void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}

	private void inOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrderTraversal(node.getRight());
	}

	private void preOrderTraversal(BinaryNode node) {
		if (node == null)
			return;
		System.out.print(node.getValue() + " ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}

	private void postOrderTraversal(BinaryNode node) {
		if (node == null)
			return;
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	public boolean isTreeFull() {
		return false;
	}

	public static void main(String[] args) {

		BinaryTreeByLinkedList tree = new BinaryTreeByLinkedList();

		System.out.println("Inserting 10 nodes to tree");
		for (int i = 1; i <= 10; i++)
			tree.insertValue(i * 10);

		System.out.println("\nLevel-order of tree:");
		tree.levelOrderTraversal();
		System.out.println();

		System.out.println("\nPre-order of tree:");
		tree.preOrderTraversal(tree.root);
		System.out.println();

		System.out.println("\nPost-order of tree:");
		tree.postOrderTraversal(tree.root);
		System.out.println();

		System.out.println("\nIn-order of tree:");
		tree.inOrderTraversal(tree.root);
		System.out.println();

		System.out.println("\nSearching node 50 in the tree...");
		tree.searchValue(50);

		System.out.println("\nSearching node 500 in the tree...");
		tree.searchValue(500);

		System.out.println("\nDeleting node having value-5 in the tree...");
		tree.deleteValue(5);

		System.out.println("\nDeleting node having value-50 in the tree...");
		tree.deleteValue(50);
		tree.levelOrderTraversal();

		System.out.println("\n\nDeleting node having value-10 in the tree...");
		tree.deleteValue(10);
		tree.levelOrderTraversal();

		System.out.println("\n\nDeleting node having value-80 in the tree...");
		tree.deleteValue(80);
		tree.levelOrderTraversal();

		System.out.println("Deleting the entire Tree");
		tree.deleteTree();

	}

}
