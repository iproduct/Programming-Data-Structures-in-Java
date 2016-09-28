package binarytree;

public class TestBSTree {

	public static void main(String[] args) {
		BSTree<Integer,Integer> bst = new BSTree<>();
//		bst.print();
		bst.insert(new Entry<>(12,12));
		bst.insert(new Entry<>(3,3));
		bst.insert(new Entry<>(18,18));
		bst.insert(new Entry<>(7,7));
		bst.insert(new Entry<>(4,4));
		bst.print();
		

	}

}
