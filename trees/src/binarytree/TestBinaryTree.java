package binarytree;

public class TestBinaryTree {

	public static void main(String[] args) {
		BTNode<Integer> root = new BTNode<>(null);
		BTNode<Integer> rl = new BTNode<>(root);
		root.left = rl;
		BTNode<Integer> rr = new BTNode<>(root);
		root.right = rr;
	}

}
