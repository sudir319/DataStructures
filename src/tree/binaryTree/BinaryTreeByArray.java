package tree.binaryTree;

public class BinaryTreeByArray implements BinaryTree {
	int[] arr;
	int lastUsedIndex;

	public void createTree() {
		createTree(10);
	}
	
	public boolean isTreeFull() {
		if (arr.length - 1 == lastUsedIndex) {
			return true;
		} else {
			return false;
		}
	}

	public void insertValue(int value) {
		if (!isTreeFull()) {
			arr[lastUsedIndex + 1] = value;
			lastUsedIndex++;
			System.out.println("Successfully inserted " + value + " in the tree!");
		} else {
			System.out.println("Could not insert value in the Tree as it is full !");
		}
	}

	public void levelOrderTraversal() {
		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void preOrderTraversal() {
		preOrderTraversal(1);
	}

	public void postOrderTraversal() {
		postOrderTraversal(1);
	}

	public void inOrderTraversal() {
		inOrderTraversal(1);
	}

	public int searchValue(int value) {
		for (int i = 0; i <= lastUsedIndex; i++) {
			if (arr[i] == value) {
				System.out.print(value + " exists in the Tree! ");
				System.out.println("It is at the location: " + i);
				return i;
			}
		}
		System.out.println(value + " does not exists in Tree !");
		System.out.println();
		return -1;
	}

	public void deleteValue(int value) {
		int location = searchValue(value);
		if (location == -1) {
			return;
		} else {
			arr[location] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Successfully deleted " + value + " from the Tree !");
		}
	}

	public void deleteTree() {
		try {
			arr = null;
			System.out.println("Tree has been deleted successfully !");
		} catch (Exception e) {
			System.out.println("There was an error deleting the tree.");
		}
	}
	
	private void createTree(int size) {
		arr = new int[size + 1];
		this.lastUsedIndex = 0;
		System.out.println("Blank Tree of size " + size + " has been created !\n");
	}

	private void preOrderTraversal(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		System.out.print(arr[index] + " ");
		preOrderTraversal(index * 2);
		preOrderTraversal(index * 2 + 1);
	}

	private void postOrderTraversal(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		postOrderTraversal(index * 2);
		postOrderTraversal(index * 2 + 1);
		System.out.print(arr[index] + " ");
	}

	private void inOrderTraversal(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		inOrderTraversal(index * 2);
		System.out.print(arr[index] + " ");
		inOrderTraversal(index * 2 + 1);
	}

	public static void main(String[] args) {

		BinaryTreeByArray tree = new BinaryTreeByArray();

		System.out.println("Creating a blank Array to store Binary Tree...");
		tree.createTree(10);

		System.out.println("Inserting 10 values in the Tree...");
		for (int i = 1; i <= 10; i++) {
			tree.insertValue(i * 10);
		}

		System.out.println("\nLevel-order Traversal:");
		tree.levelOrderTraversal();

		System.out.println("\n\nPre-order Traversal:");
		tree.preOrderTraversal();

		System.out.println("\n\nPost-order Traversal:");
		tree.postOrderTraversal();

		System.out.println("\n\nIn-order Traversal:");
		tree.inOrderTraversal();

		System.out.println("\n\nSearching value 500 in the tree...");
		tree.searchValue(500);

		System.out.println("Searching value 40 in the tree...");
		tree.searchValue(40);

		System.out.println("\nDeleting node 500 from the tree...");
		tree.deleteValue(500);

		System.out.println("Deleting node 40 from the tree...");
		tree.deleteValue(40);

		System.out.println("\nLevel-order Traversal:");
		tree.levelOrderTraversal();

		System.out.println("\n\nDeleting the entire Tree...");
		tree.deleteTree();

	}

}