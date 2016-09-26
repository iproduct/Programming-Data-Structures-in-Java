package stack;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotationCalculator {
	Stack<Double> stack = new StackImpl<>();
	Pattern numberPattern = Pattern.compile("\\d+(\\.\\d+)?");
	Pattern operationPattern = Pattern.compile("[*+-/~]");
	
	public Double claculate(String expression){
		String[] parts = expression.split("\\s+");
		System.out.println(Arrays.toString(parts));
		
		//calculation
		double a, b;
		for(int i = 0; i < parts.length; i++){
			Matcher numberMatcher = numberPattern.matcher(parts[i]);
			Matcher operationMatcher = operationPattern.matcher(parts[i]);
			if( numberMatcher.matches()) {
				double number = Double.parseDouble(parts[i]);
				stack.push(number);
			} else if (operationMatcher.matches() && parts[i].length() == 1) {
				switch (parts[i]) {
				case "+" :
					a = stack.pop();
					b = stack.pop();
					stack.push(b + a);
					break;
				case "-" :
					a = stack.pop();
					b = stack.pop();
					stack.push(b - a);
					break;
				case "*" :
					a = stack.pop();
					b = stack.pop();
					stack.push(b * a);
					break;
				case "/" :
					a = stack.pop();
					b = stack.pop();
					stack.push(b / a);
					break;
				case "~" :
					a = stack.pop();
					stack.push(-a);
					break;
				}
			}
		}
		
		
		return null;
	}

	public static void main(String[] args) {
		ReversePolishNotationCalculator rpn = new ReversePolishNotationCalculator();
		rpn.claculate(" 5.12  1.37 2 + 4 * + 3 -");
	}

}
