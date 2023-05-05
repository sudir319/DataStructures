package stack;

import java.util.Arrays;

public class StackByArray {

	int[] arr;
	int topOfStack;// keeps track of the cell which is last occupied in Array, this will help in
					// insertion/deletion

	public StackByArray(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Successfully created an empty Stack of Size: " + size);
	}

	public void push(int value) {
		// if array is full, show stack overflow error
		if (isFullStack()) {
			System.out.println("Stack overflow error!!");
		} else {
			arr[++topOfStack] = value;
			System.out.println("Successfully inserted " + value + " in the stack");
			printStack();
		}
	}

	public void pop() {
		// if array is empty, show stack underflow error
		if (isEmptyStack()) {
			System.out.println("Stack underflow error!!");
		} else {
			System.out.println("Poping value from Stack: " + arr[topOfStack] + "...");
			arr[topOfStack] = 0;
			topOfStack--;
			printStack();
		}
	}

	public boolean isEmptyStack() {
		// if top pointer is zero, the stack is empty
		if (topOfStack == -1)
			return true;
		else
			return false;
	}

	public boolean isFullStack() {
		if (topOfStack == arr.length - 1) {
			System.out.println("Stack is full !");
			return true;
		} else {
			return false;
		}
	}

	public void peekOperation() {
		if (!isEmptyStack())
			System.out.println("Top of Stack: " + arr[topOfStack]);
		else {
			System.out.println("The stack is empty!!");
		}
		System.out.println();
		System.out.println();
	}

	public void deleteStack() {
		arr = null;
		System.out.println("Stack is successfully deleted");
	}
	
	public void printStack() {
		System.out.println(Arrays.toString(this.arr));
	}

	public static void main(String[] args) {

		System.out.println("Creating a stack of size 5...");
		StackByArray stack = new StackByArray(5);

		System.out.println("Pushing 5 values in the Stack...");
		for (int i = 1; i <= 5; i++) {
			stack.push(i * 10);
		}

		System.out.println("Peeking value from stack");
		stack.peekOperation();

		System.out.println("Poping 5 values from the Stack...");
		for (int i = 0; i <= 5; i++) {
			stack.pop();
		}

		System.out.println("Deleting the Stack...");
		stack.deleteStack();

	}

}// end of class
