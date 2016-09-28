package binarytree;

public class TestBSTree {

	public static void main(String[] args) {
		BSTree<Integer,String> bst = new BSTree<>();
//		bst.print();
		bst.insert(new Entry<>(12,"twelve"));
		bst.insert(new Entry<>(3,"three"));
		bst.insert(new Entry<>(18,"eighteen"));
		bst.insert(new Entry<>(7,"seven"));
		bst.insert(new Entry<>(4,"four"));
		
		bst.print();
		
		Entry<Integer, String> found = bst.search(7);
		
		System.out.println((found == null) ? "not found"
				: found.getKey() + ": " + found.getValue());

	}

}
