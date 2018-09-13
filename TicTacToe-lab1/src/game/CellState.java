package game;

public enum CellState {
	EMPTY, X, O;
	
	public String toString() {
		if(name().equals("EMPTY")) return " ";
		return name();
	}
	
    public static void main(String[] args) {
    	for(CellState state: CellState.values()) {
    		System.out.println(state + ": " + state.ordinal());
    	}
    }
}
