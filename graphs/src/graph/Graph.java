package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Predicate;

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
	
	public Vertice<T> getVerice(T name){
		return vertices.get(
				Collections.binarySearch(vertices, new Vertice<>(name)));
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

	public List<Vertice<T>> bfSearch(T startVertice, Predicate<T> found) {
		Queue<LinkedList<Vertice<T>>> queue = new LinkedList<>();
		Set<Vertice<T>> visited = new HashSet<>();
		LinkedList<Vertice<T>> initialPath = new LinkedList<>();
		initialPath.add(getVerice(startVertice));
		queue.offer(initialPath);
		
		while(!queue.isEmpty()){
			LinkedList<Vertice<T>> path = queue.poll();
			Vertice<T> last = path.getLast();
			if(found.test(last.getInfo()))
				return path;
			List<Vertice<T>> descendants = last.getDescendants();
			for(Vertice<T> v: descendants) {
				if(!visited.contains(v)) {
					LinkedList<Vertice<T>> newPath = new LinkedList<>(path);
					newPath.addLast(v);
					queue.offer(newPath);
				}
			}
		}
	
		return null;
	}
	
	public static void main(String[] args) {
		Graph<String> g = new Graph<>();
		for(char c = 'A'; c <= 'D'; c++) {
			g.addVerice(new Vertice<>(""+ c));
		}
		g.addEdge("A", "C");
		g.addEdge("C", "A");
		g.addEdge("C", "B");
		g.addEdge("B", "D");
		g.addEdge("D", "A");
		g.addEdge("C", "D");

		System.out.println(g);
		
		System.out.println(g.bfSearch("A", name -> name.equals("D")));

	}

}
