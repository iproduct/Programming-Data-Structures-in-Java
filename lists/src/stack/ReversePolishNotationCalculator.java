package stack;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotationCalculator {
	Stack<Double> stack = new StackImpl<>();
	Stack<String> operandStack = new StackImpl<>();
	Stack<String> operatorStack = new StackImpl<>();
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
		return stack.pop();
	}
	
	public String transformToRPN(String expression) {
		String[] parts = expression.split("[\\s(]+");
		System.out.println(Arrays.toString(parts));
		
		StringBuilder resultExpr = new StringBuilder();
		
		double a, b;
		for(int i = 0; i < parts.length; i++){
			Matcher numberMatcher = numberPattern.matcher(parts[i]);
			Matcher operationMatcher = operationPattern.matcher(parts[i]);
			if( numberMatcher.matches()) {
				operandStack.push(parts[i]);
			} else if (operationMatcher.matches() && parts[i].length() == 1) {
				operatorStack.push(parts[i]);
			} else if ( parts[i].equals(")") ){
				appendPostfix(resultExpr);
			}
		}
		
		while(!operatorStack.isEmpty()) {
			appendPostfix(resultExpr);
		}
		
		return operandStack.pop();
	}

	private void appendPostfix(StringBuilder resultExpr) {
		String a, b;
		String operator = operatorStack.pop();
		switch (operator) {
		case "+" :
		case "-" :
		case "*" :
		case "/" :
			a = operandStack.pop();
			b = operandStack.pop();
			operandStack.push(b + " " + a + " " + operator + " ");
			break;
		case "~" :
			a = operandStack.pop();
			operandStack.push(a + " " + operator + " ");
			break;
		}
	}

	public static void main(String[] args) {
		ReversePolishNotationCalculator rpn = new ReversePolishNotationCalculator();
		String rpnExpr = rpn.transformToRPN("5 + ((1 + 2 ) * 4 ) - 3");
		System.out.println(rpnExpr);
		System.out.format("Result is: %20.8f",
			rpn.claculate(rpnExpr)
		);
	}

}
