package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGraphImpl<V extends Vertice<V>> implements Graph<V>{
	private LinkedList<V> currentPath;
	private LinkedList<V> toBeVisitedVertices;
	private Collection<V> visitedVertices;
	
	@Override
	public List<V> getCurrentPath(){
		return currentPath;
	}
	
	@Override
	public Collection<V> getVisitedVertices(){
		return visitedVertices;
	}

	@Override
	public boolean hasEdge(V v1, V v2) {
		return v1.getOutVertices().contains(v2);
	}

	@Override
	public void depthFirstStart(V startVertice) {
		currentPath = new LinkedList<>();
		toBeVisitedVertices = new LinkedList<>();
		toBeVisitedVertices.add(startVertice);
		visitedVertices = new HashSet<>();
	}

	@Override
	public void depthFirstStep() {
		if (currentPath == null || visitedVertices == null || toBeVisitedVertices == null)
			throw new IllegalStateException(
				"Depth-first search not properly initialized. Call depthFirstStart() method first.");
		if(toBeVisitedVertices.size() > 0){
			V currentVertice = toBeVisitedVertices.removeLast();
			while(toBeVisitedVertices.size() > 0 && visitedVertices.contains(currentVertice))
				currentVertice = toBeVisitedVertices.removeLast(); // currentVertice visited
//			if(!visitedVertices.contains(currentVertice)){ // currentVertice not visited
			currentPath.addLast(currentVertice); // add to path
			visitedVertices.add(currentVertice); // add to already visited
			toBeVisitedVertices.addAll(currentVertice.getOutVertices());
//			}
		}		
	}


}
