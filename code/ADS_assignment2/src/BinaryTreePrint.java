import java.util.ArrayList;

public class BinaryTreePrint   {
	
	BinaryTreeNode<Integer> root;

	/*
	 * This method requires that there is a class BinaryTreeNode 
	 * and that the field "root" is initialized 
	 * as well as methods to set and get nodes and values:
	 * E getElement() // return the element stored in the node
	 * (integers can be used directly used due to javas autoboxing unboxing
	 * BinaryTreeNode getLeftChild()) // return a reference to leftChild 
	 * BinaryTreeNode getRightChild()) // return a reference to rightChild
	 * 
	 * The tree must be created elsewhere (possible in a Main or Test class).
	 */

	public void printTree(BinaryTreeNode root) {
		ArrayList<BinaryTreeNode> parent = new ArrayList<BinaryTreeNode>();
		parent.add(root);
		printT(parent, 64);
	}

	private void printT(ArrayList<BinaryTreeNode> parent, int left) {
		ArrayList<BinaryTreeNode> children = new ArrayList<BinaryTreeNode>();
		BinaryTreeNode<Integer> current;
		boolean moreNodes = false;
		boolean firstNode = true;
		BinaryTreeNode<Integer> dummy = new BinaryTreeNode(0);

		int dist = 0;
		System.out.println();
		System.out.println();

		while (!parent.isEmpty()) {
			current = parent.remove(0);

			if (firstNode) {
				printSpace(left);
				if (current.getElement() != 0)
					System.out.print(current.getElement());
				dist = 2 * left;
				firstNode = false;

				if (current.getElement() != 0) {
					if (current.getLeftChild() != null) {
						children.add(current.getLeftChild());
						moreNodes = true;
					} else
						children.add(dummy);
					if (current.getRightChild() != null) {
						children.add(current.getRightChild());
						moreNodes = true;
					} else
						children.add(dummy);
				} else {
					children.add(dummy);
					children.add(dummy);
				}
			} else {
				if (current.getElement() != 0) {
					printSpace(dist - 1);
					System.out.print(current.getElement());
					if (current.getLeftChild() != null) {
						children.add(current.getLeftChild());
						moreNodes = true;
					} else
						children.add(dummy);
					if (current.getRightChild() != null) {
						children.add(current.getRightChild());
						moreNodes = true;
					} else
						children.add(dummy);
				} else {
					printSpace(dist - 1);
					System.out.print(" ");
					children.add(dummy);
					children.add(dummy);
				}
			}
		}

		if (moreNodes)
			printT(children, left / 2);

	}

	private void printSpace(int pos) {
		for (int i = 0; i < pos; i++)
			System.out.print(" ");

	}

	
}
