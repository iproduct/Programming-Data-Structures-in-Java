package graph;

import java.util.Collection;
import java.util.List;

public interface Graph<V extends Vertice> {
	Collection<V> getVertices();
	boolean hasEdge(V v1, V v2);
	void depthFirstStart(V startVertice);
	void depthFirstStep();
	List<V> getCurrentPath();
	Collection<V> getVisitedVertices();
}
