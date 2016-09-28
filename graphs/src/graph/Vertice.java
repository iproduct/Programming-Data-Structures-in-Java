package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Vertice<T extends Comparable<T>> implements Comparable<Vertice<T>>{
	private T info;
	private List<Vertice<T>> descendants = new ArrayList<>();
	
	public Vertice() {}

	public Vertice(T info) {
		this.info = info;
	}
	
	public Vertice(T info, List<Vertice<T>> descendants) {
		this.info = info;
		this.descendants = descendants;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public List<Vertice<T>> getDescendants() {
		return descendants;
	}
	
	public void addDescendant(Vertice<T> newDescendant){
		int index = Collections.binarySearch(descendants, newDescendant);
		if(index >= 0) 
			descendants.set(index, newDescendant);
		else 
			descendants.add(-index - 1, newDescendant);
	}
	

	public void setDescendants(List<Vertice<T>> descendants) {
		this.descendants = descendants;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
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
		Vertice other = (Vertice) obj;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return info.toString();
	}

	@Override
	public int compareTo(Vertice<T> other) {
		return info.compareTo(other.getInfo());
	}
	
}
