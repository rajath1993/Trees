package problemsOnTrees;

import java.util.Stack;

public class BinaryPathSum {

	public static void main(String[] args) {
		Node root = new Node(12);
		root.right = new Node(1);
	    root.left = new Node(7);
	    root.left.left = new Node(9);
	    root.right.left = new Node(10);
	    root.right.right = new Node(5);
	    
	    int sum = 23;
	    boolean res = findPathSum(root,sum);
	    System.out.println(res);
	    
	}

	static boolean findPathSum(Node root,int sum) {
		if (root == null) return false;
		/*
		 * two stacks - one to hold tree node, one more to hold corresponding difference sum.
		 * 
		 * */
		Stack<Node> node_stack = new Stack<>();
		Stack<Integer> sum_stack = new Stack<>();
		
		node_stack.push(root);
		sum_stack.push(sum-root.val);
		
		while(node_stack.empty()!=true) {
			Node curr_node = node_stack.pop();
			int curr_sum = sum_stack.pop();
			
			if(curr_node.left==null && curr_node.right==null && curr_sum==0) return true;
			
			if(curr_node.left!=null) {
				node_stack.push(curr_node.left);
				sum_stack.push(curr_sum-curr_node.left.val);
			}
			
			if(curr_node.right!=null) {
				node_stack.push(curr_node.right);
				sum_stack.push(curr_sum-curr_node.right.val);
			}
		}
		
		return false;
	}
}
