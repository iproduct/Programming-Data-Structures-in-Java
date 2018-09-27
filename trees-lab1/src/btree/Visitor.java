package btree;

public interface Visitor<K,V> {
	
	void visit(K key, V value);

}
