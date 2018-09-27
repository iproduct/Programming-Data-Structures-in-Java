package btree;

public class PrintingVisitor<K,V> implements Visitor<K, V> {

	@Override
	public void visit(K key, V value) {
		System.out.printf("%d:%d, ", key, value);
	}

}
