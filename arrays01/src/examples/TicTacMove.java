package examples;

public enum TicTacMove { 
	EMPTY, X, O;

	@Override
	public String toString() {
		if(this == EMPTY){
			return " ";
		} else {
			return super.toString();
		}
	} 
	
}
