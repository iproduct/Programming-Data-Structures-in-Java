package lists;

public class ListElement<E> {
	private E value;
	private ListElement<E> next;
	public ListElement() {
	}
	public ListElement(E value, ListElement<E> next) {
		this.value = value;
		this.next = next;
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	public ListElement<E> getNext() {
		return next;
	}
	public void setNext(ListElement<E> next) {
		this.next = next;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ListElement other = (ListElement) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return value.toString();
	}
	
}
