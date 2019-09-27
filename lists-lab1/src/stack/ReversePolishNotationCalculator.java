package stack;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import queue.Queue;
import queue.QueueImpl;

public class ReversePolishNotationCalculator {
	Stack<Double> stack = new StackImpl<>();
	Queue<String> inputQueue = new QueueImpl<>();
	Queue<String> outputQueue = new QueueImpl<>();
	Stack<String> operatorStack = new StackImpl<>();
	Pattern numberPattern = Pattern.compile("\\d+(\\.\\d+)?");
	Pattern operationPattern = Pattern.compile("[*+-/~()]");

	public Double claculate(String expression) {
		String[] parts = expression.split("\\s+");
		System.out.println(Arrays.toString(parts));

		// calculation
		double a, b;
		for (int i = 0; i < parts.length; i++) {
			Matcher numberMatcher = numberPattern.matcher(parts[i]);
			Matcher operationMatcher = operationPattern.matcher(parts[i]);
			if (numberMatcher.matches()) {
				double number = Double.parseDouble(parts[i]);
				stack.push(number);
			} else if (operationMatcher.matches() && parts[i].length() == 1) {
				switch (parts[i]) {
				case "+":
					a = stack.pop();
					b = stack.pop();
					stack.push(b + a);
					break;
				case "-":
					a = stack.pop();
					b = stack.pop();
					stack.push(b - a);
					break;
				case "*":
					a = stack.pop();
					b = stack.pop();
					stack.push(b * a);
					break;
				case "/":
					a = stack.pop();
					b = stack.pop();
					stack.push(b / a);
					break;
				case "~":
					a = stack.pop();
					stack.push(-a);
					break;
				}
			}
		}
		return stack.pop();
	}

	public String transformToRPN(String expression) {
		String[] parts = expression.split("[\\s]+");
		System.out.println(Arrays.toString(parts));
		
		//put lexemas into input queue
		for(int i = 0; i < parts.length; i++){
			Matcher numberMatcher = numberPattern.matcher(parts[i]);
			Matcher operationMatcher = operationPattern.matcher(parts[i]);
			
			if( numberMatcher.matches()) {
				inputQueue.offer(parts[i]);
			} else if (operationMatcher.matches() && parts[i].length() == 1) {
				inputQueue.offer(parts[i]);
			}
		}
			
		// Shunting-yard algorithm (Dijkstra)
		while(!inputQueue.isEmpty()){
			String item = inputQueue.poll();
			Matcher numberMatcher = numberPattern.matcher(item);
			Matcher operationMatcher = operationPattern.matcher(item);
			if (numberMatcher.matches()) {
				outputQueue.offer(item);
			} else if(operationMatcher.matches()){
				if(item.equals("(") ) {
					operatorStack.push(item);
				} else if (item.equals(")") ) {
					String o2;
					while(!operatorStack.isEmpty() && 
							!(o2 = operatorStack.pop()).equals("(") ) { 
						outputQueue.offer(o2);
					}
				}else {
					String o1 = item, o2;
					if(!operatorStack.isEmpty() && !(o2 = operatorStack.top()).equals("(")) {
						if(comparePriority(o1, o2) <= 0) {
							outputQueue.offer(operatorStack.pop());
						}
					}
					operatorStack.push(o1);
				}
			}
		}
		
		// Drain remaining operators to output queue
		while(!operatorStack.isEmpty()) {
			outputQueue.offer(operatorStack.pop());
		}
		
		//Drain output queue to String result
		StringBuilder resultExpression = new StringBuilder();
		while(!outputQueue.isEmpty()) {
			resultExpression.append(outputQueue.poll()).append(" ");
		}
		
		return resultExpression.toString();
	}

	public static int comparePriority(String o1, String o2) {
		return getPriority(o1) - getPriority(o2);
	}

	private static int getPriority(String op) {
		String[] priorities = { "+-", "*/", "~" };
		int i = 0;
		while (i < priorities.length && priorities[i].indexOf(op) < 0) {
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		ReversePolishNotationCalculator rpn = new ReversePolishNotationCalculator();
		String rpnExpr = rpn.transformToRPN("5.25 + ( ( 1 + 2 ) * 4 ) - 3");
		System.out.println(rpnExpr);
		System.out.format("Result is: %10.2f", rpn.claculate(rpnExpr));
	}

}
