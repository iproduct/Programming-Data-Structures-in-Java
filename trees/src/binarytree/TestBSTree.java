package binarytree;

public class TestBSTree {

	public static void main(String[] args) {
		BSTree<Integer> bst = new BSTree<>();
//		bst.print();
		bst.insert(12);
		bst.insert(3);
		bst.insert(18);
		bst.insert(7);
		bst.insert(4);
		bst.print();
		

	}

}
