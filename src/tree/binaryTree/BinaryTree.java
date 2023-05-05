package tree.binaryTree;

public interface BinaryTree {
	void createTree();
	boolean isTreeFull();
	void insertValue(int value);
	int searchValue(int value);
	void preOrderTraversal();
	void inOrderTraversal();
	void postOrderTraversal();
	void deleteValue(int value);
	void deleteTree();
}