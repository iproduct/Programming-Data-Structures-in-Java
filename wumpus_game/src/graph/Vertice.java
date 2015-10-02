package graph;

import java.util.Collection;

public interface Vertice<V extends Vertice<V>>{
	Collection<V> getOutVertices();
}
