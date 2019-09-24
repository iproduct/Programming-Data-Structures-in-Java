package model;

public class WordCount implements Comparable<WordCount> {
	public String word;
	public int count;
	
	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		WordCount other = (WordCount) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	@Override
	public int compareTo(WordCount o) {
		return word.compareToIgnoreCase(o.word);
	}
	@Override
	public String toString() {
		return "[" + word + ", " + count + "]";
	}
	
}
