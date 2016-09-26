package stack;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ReversePolishNotationCalculator {
	Stack<Double> stack = new StackImpl<>();
	Pattern numberPattern = Pattern.compile("\\d+(\\.\\d+)?");
	Pattern operationPattern = Pattern.compile("[*+-/~]");
	
	public Double claculate(String expression){
		String[] parts = expression.split("\\s+");
		System.out.println(Arrays.toString(parts));
		
		//calculation
		for(int i = 0; i < parts.length; i++){
			
		}
		
		
		return null;
	}

	public static void main(String[] args) {
		ReversePolishNotationCalculator rpn = new ReversePolishNotationCalculator();
		rpn.claculate(" 5.12  1.37 2 + 4 * + 3 -");
	}

}
