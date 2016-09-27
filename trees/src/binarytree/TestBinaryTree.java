package binarytree;

public class TestBinaryTree {

	public static void main(String[] args) {
		BTNode<Integer> root = new BTNode<>(null, 1);
		BTNode<Integer> rl = new BTNode<>(root, 2);
		root.left = rl;
		BTNode<Integer> rr = new BTNode<>(root, 3);
		root.right = rr;
		System.out.println("Tree internal size: " + root.size());
	}

}