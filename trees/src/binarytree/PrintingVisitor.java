package binarytree;

public class PrintingVisitor<T> implements Visitor<T> {

	@Override
	public void visit(T info) {
		System.out.printf("%s, ", info);
	}

}
