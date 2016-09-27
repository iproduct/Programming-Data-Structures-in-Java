package binarytree;

public class TestBinaryTree {

	public static void main(String[] args) {
		BTNode<Integer> root = new BTNode<>(null, 1);
		BTNode<Integer> rl = new BTNode<>(root, 2);
		root.left = rl;
		BTNode<Integer> rll = new BTNode<>(rl, 4);
		rl.left = rll;
		BTNode<Integer> rllr = new BTNode<>(rl, 8);
		rll.right = rllr;
		BTNode<Integer> rlr = new BTNode<>(rl, 5);
		rl.right = rlr;

		BTNode<Integer> rr = new BTNode<>(root, 3);
		root.right = rr;
		BTNode<Integer> rrl = new BTNode<>(rl, 6);
		rr.left = rrl;
		BTNode<Integer> rrr = new BTNode<>(rl, 7);
		rr.right = rrr;

		
		System.out.println("Tree internal size: " + root.size());
		System.out.println("Tree height: " + root.height());
		root.show();
		
		root.traverseBF(info -> System.out.println(info) );

	}

}
