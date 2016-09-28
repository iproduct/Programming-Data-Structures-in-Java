package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Graph<T extends Comparable<T>> {
	private List<Vertice<T>> vertices = new ArrayList<>();
	
	public Graph() {}

	public Graph(List<Vertice<T>> vertices) {
		this.vertices = vertices;
	}
	
	public void addVerice(Vertice<T> newVertice){
		int index = Collections.binarySearch(vertices, newVertice);
		if(index >= 0) 
			vertices.set(index, newVertice);
		else 
			vertices.add(-index - 1, newVertice);
	}

	public void addEdge(T from, T to){
		Vertice<T> fromVertice = vertices.get(
				Collections.binarySearch(vertices, new Vertice<>(from)));
		Vertice<T> toVertice =  vertices.get(
				Collections.binarySearch(vertices, new Vertice<>(to)));
		fromVertice.addDescendant(toVertice);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Vertice<T> v : vertices) {
			sb.append(v).append(" -> ")
				.append(v.getDescendants()).append("\n");
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		Graph<String> g = new Graph<>();
		for(char c = 'D'; c >= 'A'; c--) {
			g.addVerice(new Vertice<>(""+ c));
		}
		g.addEdge("A", "D");
		g.addEdge("A", "B");
		g.addEdge("C", "B");
		g.addEdge("B", "D");
		g.addEdge("D", "A");
		g.addEdge("A", "C");
		g.addEdge("C", "A");
		
		
		System.out.println(g);
		

	}

}
