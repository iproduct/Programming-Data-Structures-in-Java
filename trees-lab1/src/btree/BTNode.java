package btree;

public class BTNode<K extends Comparable<K>, V> {
	K key;
	V value;
	BTNode<K,V> left;
	BTNode<K,V> right;

	public BTNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public BTNode(K key, V value, BTNode<K, V> left, BTNode<K, V> rigth) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = rigth;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public BTNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(BTNode<K, V> left) {
		this.left = left;
	}

	public BTNode<K, V> getRight() {
		return right;
	}

	public void setRight(BTNode<K, V> rigth) {
		this.right = rigth;
	}
	
	public int size() {
		return (left != null? left.size(): 0)
			+ (right != null? right.size(): 0) 
			+ 1;
	}
	
	public int depth() {
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BTNode other = (BTNode) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(key).append(": ").append(value).append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		//leaves
		BTNode<Integer, Integer> l1 = new BTNode<>(1,1);
		BTNode<Integer, Integer> l4 = new BTNode<>(4,4);
		BTNode<Integer, Integer> l7 = new BTNode<>(7,7);
		BTNode<Integer, Integer> l13 = new BTNode<>(13,13);
		
		//branches
		BTNode<Integer, Integer> b6 = new BTNode<>(6,6,l4,l7);
		BTNode<Integer, Integer> b3 = new BTNode<>(3,3,l1,b6);
		BTNode<Integer, Integer> b14 = new BTNode<>(14,14,l13,null);
		BTNode<Integer, Integer> b10 = new BTNode<>(10,10,null,b14);
		
		//root
		BTNode<Integer, Integer> r8 = new BTNode<>(8,8,b3,b10);

		System.out.println(r8.size());
		System.out.println(r8.depth());

	}

}
