package btree;

public class TestBSTree {

	public static void main(String[] args) {
		BSTree<Integer,String> bst = new BSTree<>();
//		bst.print();
		bst.insert(12,"twelve");
		bst.insert(3,"three");
		bst.insert(18,"eighteen");
		bst.insert(7,"seven");
		bst.insert(4,"four");
		bst.insert(24, "twenty four");
		
		bst.print();
		int key = 24;
		String found = bst.search(key);
		
		System.out.println((found == null) ? "not found"
				: key + ": " + found);

	}

}
