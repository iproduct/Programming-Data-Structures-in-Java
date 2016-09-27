package binarytree;

import stack.Stack;
import stack.StackImpl;

class BTNode<T> {
	@SuppressWarnings("rawtypes")
	public static BTNode nil = new BTNode();
	
	BTNode<T> left;
	BTNode<T> right;
	BTNode<T> parent;
	T info;
	
	public BTNode() {
	}
	
	public BTNode(BTNode<T> parent) {
		this(null, null, parent, null);
	}
	
	@SuppressWarnings("unchecked")
	public BTNode(BTNode<T> parent, T info) { //create leaf
		this(nil, nil, parent, info);
	}
	
	public BTNode(BTNode<T> left, BTNode<T> right, BTNode<T> parent, T info) {
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.info = info;
	}

	public int size() {
		if (this == nil) return 0; //bottom
		return 1 + left.size() + right.size(); //recursion step
	}
	
	public int height() {
		if (this == nil) return 0; //bottom
		return 1 + Math.max(left.height(), right.height()); //recursion step
	}
	
	public void print(int h){
		for(int i = 0; i < 2*h; i++)
			System.out.print(" ");
		if(this == nil)
			System.out.print("*");
		else
			System.out.print(info);
		System.out.println();
	}
	
	public void show(int h){
		if(this == nil) //bottom
			print(h);
		else {         //step
			right.show(h+1);
			print(h);
			left.show(h+1);
		}		
	}
	
	public void traverseDF(Visitor<T> visitor) {		
		Stack<BTNode<T>> stack = new StackImpl<>();
	}
	
	public void show(){
		show(0);
	}

}

